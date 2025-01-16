package com.freightwise.software.test.dto.downstream.response;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Forecast{
  private ArrayList<Forecastday> forecastday;
}
