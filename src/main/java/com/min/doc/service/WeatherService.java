package com.min.doc.service;

import java.util.List;

import com.min.doc.dto.WeatherVO;


public interface WeatherService {
	
	WeatherVO weatherDao(String tem, String hum);

	//public WeatherVO weatherDao(String tem, String hum);

	
}
