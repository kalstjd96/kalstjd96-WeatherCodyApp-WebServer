package com.min.doc.comtroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public Map<String, String> Weather(HttpServletRequest request){

				
		String weather= request.getParameter("Temperature");
		System.out.println(weather);
		
		WeatherVO weatherVO = service.weatherDao(weather);
		
		Map<String, String> result = new HashMap<String, String>();
		ObjectMapper oMapper = new ObjectMapper();
		
		//이는 jackson 라이브러리를 이용하는 것으로써 java Object를 JSON으로 변환하거나 JSON을 java Object로 변환하는데 사용할 수 있는 라이브러리
		//List<WeatherVO> memberList = service.weatherDao(weather);
		
		if(weatherVO == null) {
			result.put("top", "no");
			System.out.println("의상이 없다.");
		}else {
			result = oMapper.convertValue(weatherVO, Map.class);
			System.out.println("성공적");
		}
		return result;
		//Gson gson = new Gson();
	//	String gson1String = gson.toJson(memberList);
		//System.out.println(gson1String);
		
		//return "gson1String";
	}
}
