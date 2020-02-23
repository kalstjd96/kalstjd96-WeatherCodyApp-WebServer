package com.min.doc.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.min.doc.dto.WeatherVO;


@Repository
public class WeatherDAOImpl implements WeatherDAO {

	 @Inject
	 private SqlSession sqlSession;  //sqlSession의 주입을 받아서 WeatherMapper.xml에 등록한 쿼리문을 실행한다.

	 private static final String Namespace ="com.sample.mapper.WeatherMapper";

	 @Override
	public WeatherVO weatherDao(String tem, String hum) { //데이터값이 여러개 존재하기 때문에 list로 받아 리턴 
		// TODO Auto-generated method stub
		return sqlSession.selectOne(Namespace+".weatherDao");
	}

}
