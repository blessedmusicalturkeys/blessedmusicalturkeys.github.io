package com.freightwise.software.test.dto.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherInfoResponse {
  private String temperatureFahrenheit;
  private Integer humidity;
  private Double latitude;
  private Double longitude;
  //extensible properties from here
}
