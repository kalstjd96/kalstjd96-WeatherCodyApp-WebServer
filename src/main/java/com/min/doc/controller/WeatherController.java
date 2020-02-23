package com.min.doc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
/*
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;*/
import com.min.doc.dto.WeatherVO;
import com.min.doc.service.WeatherService;

@Controller
public class WeatherController {
	
	@Inject
	private WeatherService service;
	
	
	
	@RequestMapping(value = "/weather")//, produces = "application/json; charset=utf8")
	@ResponseBody
	public Map<String, String> Weather(HttpServletRequest request){
				
		String tem= request.getParameter("Temperature");
		String hum= request.getParameter("Humidity");
		
		System.out.println(tem);
		//List<WeatherVO> weatherList = service.weatherDao(tem, hum);
		
		WeatherVO weatherVO = service.weatherDao(tem,hum);
		System.out.println(weatherVO.getMno());
		Map<String, String> result = new HashMap<String, String>();
		
		ObjectMapper oMapper = new ObjectMapper();
		
		if(weatherVO == null) {
			result.put("mno", "no");
			System.out.println("등록된 의상이 없음 ");
		}else {
			
			result = oMapper.convertValue(weatherVO, Map.class);
			System.out.println("test Success");
		}
		return result;
	}
}
