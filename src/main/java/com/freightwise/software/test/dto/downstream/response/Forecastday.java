package com.freightwise.software.test.dto.downstream.response;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Forecastday{
  private String date;
  private int date_epoch;
  private Day day;
  private Astro astro;
  private ArrayList<Hour> hour;
}
