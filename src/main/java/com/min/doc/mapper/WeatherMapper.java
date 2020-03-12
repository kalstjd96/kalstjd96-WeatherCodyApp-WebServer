package com.min.doc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.min.doc.dto.WeatherVO;

@Mapper
public interface WeatherMapper {
	
	static final Logger logger = LoggerFactory.getLogger(WeatherMapper.class);

	//WeatherVO weatherDao(String tem, String hum);
	List<WeatherVO> weatherDao(@Param("tem")String tem);
	//public WeatherVO weatherDao(String tem, String hum);



}
