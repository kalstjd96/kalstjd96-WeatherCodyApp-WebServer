package com.min.doc.dao;

import java.util.List;

import com.min.doc.dto.WeatherVO;


public interface WeatherDAO {

	WeatherVO weatherDao(String tem, String hum);

	//public WeatherVO weatherDao(String tem, String hum);


}
