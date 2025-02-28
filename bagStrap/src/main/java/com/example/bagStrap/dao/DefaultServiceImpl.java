package com.example.bagStrap.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bagStrap.mapper.DefaultMapper;
import com.example.bagStrap.model.Item;


@Service
public class DefaultServiceImpl implements DefaultService{

	@Autowired
	DefaultMapper defaultMapper;


	@Override
	public HashMap<String, Object> searchItem(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		
		try {
			List<Item> list = defaultMapper.searchItem(map);
			List<Item> codeList = defaultMapper.searchCodes(map);
			
			resultMap.put("result", true);
			resultMap.put("message", "성공~");
			resultMap.put("list", list);
			resultMap.put("codeList", codeList);
			
		} catch(Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}


		
		return resultMap;
	}

	
}
