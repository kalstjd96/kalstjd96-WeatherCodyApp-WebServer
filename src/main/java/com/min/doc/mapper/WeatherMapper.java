package com.min.doc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.min.doc.model.WeatherVO;

@Mapper
public interface WeatherMapper {

	//List<WeatherVO> weatherDao(String weathervo);

	WeatherVO weatherDao(@Param("weather")String weather);
}
