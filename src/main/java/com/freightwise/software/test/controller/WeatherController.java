package com.freightwise.software.test.controller;

import com.freightwise.software.test.dto.api.response.WeatherInfoResponse;
import com.freightwise.software.test.dto.downstream.response.WeatherInfo;
import com.freightwise.software.test.exception.ApiException;
import com.freightwise.software.test.exception.BadZipProvidedException;
import com.freightwise.software.test.mapper.WeatherInfoMapper;
import com.freightwise.software.test.service.WeatherLookupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class WeatherController {

  @GetMapping("/software-test")
  public ResponseEntity<?> getWeather(@RequestParam String zipCode) {
    log.info("Gathering weather information for zipCode: [{}]", zipCode);

    //Cognitive complexity is getting a little high with the branches and exceptions...
    // would handle better in a work ticket
    try {
      if (zipCode == null || zipCode.isEmpty()) {//proper validation here
        return ResponseEntity.badRequest().body("Zip code cannot be empty");
      }
      WeatherInfo weatherInfo = WeatherLookupService.getWeatherInfoByZipCode(zipCode);
      WeatherInfoResponse response = WeatherInfoMapper.INSTANCE.weatherInfoToWeatherInfoResponseDto(weatherInfo);
      return ResponseEntity.ok(response);
    } catch (ApiException e) {
      log.error("Something bad happened: [{}]", e.getMessage(), e);
      //Here we would handle this exception gracefully, returning an approved message back to the
      // user but logging a proper statement for true observability here in the app.
      // Moreover, if we got to the point where we need to handle a plethora of exceptions,
      // this could be broken out into handler class for both reuse
      // and better maintainability than n-number of catch clauses.
      return ResponseEntity.badRequest().body(e.getMessage());
    } catch (BadZipProvidedException e) {
      log.error("Invalid Zip Code Provided: [{}]", zipCode, e);
      return ResponseEntity.badRequest().body("The provided Zip Code [" + zipCode + "] is invalid");
    }
  }
}
