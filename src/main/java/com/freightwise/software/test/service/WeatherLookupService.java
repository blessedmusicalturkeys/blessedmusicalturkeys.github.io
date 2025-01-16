package com.freightwise.software.test.service;

import com.freightwise.software.test.constants.AppConstants;
import com.freightwise.software.test.dto.downstream.response.WeatherInfo;
import com.freightwise.software.test.exception.ApiException;
import com.freightwise.software.test.exception.BadZipProvidedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class WeatherLookupService {
  private static final String URL = "http://api.weatherapi.com/v1/forecast.json?key={apiKey}&q={zipCode}&days=1&aqi=no&alerts=no";

  public static WeatherInfo getWeatherInfoByZipCode(String zipCode) throws ApiException {
    log.info("Querying API for zipCode: [{}]", zipCode);
    RestTemplate restTemplate = new RestTemplate();

    try {
      ResponseEntity<WeatherInfo> response = restTemplate.getForEntity(
          URL
              .replace("{apiKey}", AppConstants.WEATHER_MAP_API_KEY)
              .replace("{zipCode}", zipCode),
          WeatherInfo.class);
      if (!response.getStatusCode().is2xxSuccessful()) {//is not successful
        throw new ApiException(
            "API returned status code " + response.getStatusCode().value() + " for Zip Code: ["
                + zipCode + "]");
      }

      return response.getBody();
    } catch (HttpClientErrorException e) {
      if (e.getMessage().contains("code\":1006")) { //better handing here for a less brittle solution
        throw new BadZipProvidedException("Error while calling weather API: " + e.getMessage());
      } else {
        throw new ApiException("Error while calling weather API: " + e.getMessage());
      }
    }
  }
}
