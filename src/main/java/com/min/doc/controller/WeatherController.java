package com.min.doc.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
/*
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;*/
import com.min.doc.dto.WeatherVO;
import com.min.doc.service.WeatherService;

@Controller
public class WeatherController {
	
	@Inject
	//@Autowired
	private WeatherService service;
	
	
	
	@RequestMapping(value = "/weather", produces = "application/json; charset=utf8")
	@ResponseBody
	public String Weather(HttpServletRequest request, String json){
			

		String tem = "0";
		tem= request.getParameter("tem");
		
		//String hum= request.getParameter("Humidity");
		
		System.out.println("가져온 값 ="+tem);
		
		//System.out.println(hum);
		
		/*
		 * List<WeatherVO> weatherList = null; try { weatherList =
		 * service.weatherDao(tem, hum); System.out.println(weatherList); } catch
		 * (Exception e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		List<WeatherVO> weatherList2 = service.weatherDao(tem);
		//WeatherVO weatherVO = service.weatherDao(tem,hum);
		
		System.out.println(weatherList2);
		Gson gson = new Gson();
		
		String msg= gson.toJson(weatherList2);
		System.out.println(msg);
		
		return msg;
	}
}
