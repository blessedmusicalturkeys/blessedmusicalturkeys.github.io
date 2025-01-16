package com.freightwise.software.test.mapper;

import com.freightwise.software.test.dto.api.response.WeatherInfoResponse;
import com.freightwise.software.test.dto.downstream.response.Current;
import com.freightwise.software.test.dto.downstream.response.Location;
import com.freightwise.software.test.dto.downstream.response.WeatherInfo;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-15T21:08:47-0600",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.11 (Oracle Corporation)"
)
@Component
public class WeatherInfoMapperImpl implements WeatherInfoMapper {

    @Override
    public WeatherInfoResponse weatherInfoToWeatherInfoResponseDto(WeatherInfo weatherInfo) {
        if ( weatherInfo == null ) {
            return null;
        }

        WeatherInfoResponse weatherInfoResponse = new WeatherInfoResponse();

        weatherInfoResponse.setLatitude( weatherInfoLocationLat( weatherInfo ) );
        weatherInfoResponse.setLongitude( weatherInfoLocationLon( weatherInfo ) );
        Double temp_f = weatherInfoCurrentTemp_f( weatherInfo );
        if ( temp_f != null ) {
            weatherInfoResponse.setTemperatureFahrenheit( String.valueOf( temp_f ) );
        }
        weatherInfoResponse.setHumidity( weatherInfoCurrentHumidity( weatherInfo ) );

        return weatherInfoResponse;
    }

    private Double weatherInfoLocationLat(WeatherInfo weatherInfo) {
        Location location = weatherInfo.getLocation();
        if ( location == null ) {
            return null;
        }
        return location.getLat();
    }

    private Double weatherInfoLocationLon(WeatherInfo weatherInfo) {
        Location location = weatherInfo.getLocation();
        if ( location == null ) {
            return null;
        }
        return location.getLon();
    }

    private Double weatherInfoCurrentTemp_f(WeatherInfo weatherInfo) {
        Current current = weatherInfo.getCurrent();
        if ( current == null ) {
            return null;
        }
        return current.getTemp_f();
    }

    private Integer weatherInfoCurrentHumidity(WeatherInfo weatherInfo) {
        Current current = weatherInfo.getCurrent();
        if ( current == null ) {
            return null;
        }
        return current.getHumidity();
    }
}
