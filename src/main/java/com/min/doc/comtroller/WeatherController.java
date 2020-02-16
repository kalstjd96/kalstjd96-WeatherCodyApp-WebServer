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
		
		//�̴� jackson ���̺귯���� �̿��ϴ� �����ν� java Object�� JSON���� ��ȯ�ϰų� JSON�� java Object�� ��ȯ�ϴµ� ����� �� �ִ� ���̺귯��
		//List<WeatherVO> memberList = service.weatherDao(weather);
		
		if(weatherVO == null) {
			result.put("top", "no");
			System.out.println("�ǻ��� ����.");
		}else {
			result = oMapper.convertValue(weatherVO, Map.class);
			System.out.println("������");
		}
		return result;
		//Gson gson = new Gson();
	//	String gson1String = gson.toJson(memberList);
		//System.out.println(gson1String);
		
		//return "gson1String";
	}
}
