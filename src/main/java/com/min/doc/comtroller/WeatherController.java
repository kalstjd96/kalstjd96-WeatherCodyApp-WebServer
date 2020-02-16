package com.min.doc.comtroller;

import java.util.List;

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

import com.google.gson.Gson;
import com.min.doc.model.WeatherVO;
import com.min.doc.service.WeatherService;

@RequestMapping("/weather")
@Controller
public class WeatherController {
	
	@Autowired
	private WeatherService service;
	
	@RequestMapping(value = "/weather", produces = "application/json; charset=utf8")
	@ResponseBody
	public String Weather(HttpServletRequest request) throws Exception{

				
		//String weather= request.getParameter("weather");
		//System.out.println(weather);
		String weather = "MNO";
		List<WeatherVO> memberList = service.weatherDao(weather);
		
		Gson gson = new Gson();
		String gson1String = gson.toJson(memberList);
		System.out.println(gson1String);
		
		return "gson1String";
	}
}
