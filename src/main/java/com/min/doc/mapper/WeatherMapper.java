package com.min.doc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.min.doc.model.WeatherVO;

@Mapper
public interface WeatherMapper {

	List<WeatherVO> weatherDao(String weathervo);
	}
