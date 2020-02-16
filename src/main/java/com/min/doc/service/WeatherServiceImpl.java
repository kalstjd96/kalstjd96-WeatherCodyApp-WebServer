package com.min.doc.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.doc.mapper.WeatherMapper;
import com.min.doc.model.WeatherVO;

@Service
public class WeatherServiceImpl implements WeatherService{

	@Autowired //@Inject 
	private WeatherMapper weatherMapper;
		
	@Override
	public List<WeatherVO> weatherDao(String weathervo) {

		return weatherMapper.weatherDao(weathervo);
	}
	
	

}
