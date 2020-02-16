package com.min.doc.service;

import java.util.List;

import com.min.doc.model.*;

public interface WeatherService {
	
	List<WeatherVO> weatherDao(String weather);
}
