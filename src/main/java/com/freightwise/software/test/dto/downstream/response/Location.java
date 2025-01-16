package com.freightwise.software.test.dto.downstream.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location{
  private String name;
  private String region;
  private String country;
  private double lat;
  private double lon;
  private String tz_id;
  private int localtime_epoch;
  private String localtime;
}
