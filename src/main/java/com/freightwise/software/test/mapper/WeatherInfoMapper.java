package com.freightwise.software.test.mapper;

import com.freightwise.software.test.dto.api.response.WeatherInfoResponse;
import com.freightwise.software.test.dto.downstream.response.WeatherInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WeatherInfoMapper {
  WeatherInfoMapper INSTANCE = Mappers.getMapper(WeatherInfoMapper.class);

  @Mapping(source = "weatherInfo.location.lat", target = "latitude")
  @Mapping(source = "weatherInfo.location.lon", target = "longitude")
  @Mapping(source = "weatherInfo.current.temp_f", target = "temperatureFahrenheit")
  @Mapping(source = "weatherInfo.current.humidity", target = "humidity")
  WeatherInfoResponse weatherInfoToWeatherInfoResponseDto(WeatherInfo weatherInfo);
}
