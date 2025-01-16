package com.freightwise.software.test.dto.downstream.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Astro{
  private String sunrise;
  private String sunset;
  private String moonrise;
  private String moonset;
  private String moon_phase;
  private int moon_illumination;
  private int is_moon_up;
  private int is_sun_up;
}

