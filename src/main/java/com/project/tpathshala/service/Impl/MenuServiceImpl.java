package com.project.tpathshala.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.tpathshala.model.ManuList;
import com.project.tpathshala.payload.MenuResponse;
import com.project.tpathshala.repository.MenuListRepository;
import com.project.tpathshala.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService{
	 	@Autowired
	    private MenuListRepository manuListRepository;
	 	
	 	 public List<MenuResponse> getAllMenuItems() {
	 		
	 		List<MenuResponse> menuResList = new ArrayList<>();
	         List<Map<String, Object>> allMenuItems = manuListRepository.getAllMenuList();
	         
	         for(Map<String, Object> data: allMenuItems) {
	        	 MenuResponse menuRes = new MenuResponse();
	        	 if(data.get("icon") != null) {
	        		 menuRes.setIcon(data.get("icon").toString());
	        	 }
	        	 menuRes.setId(Long.parseLong(data.get("manu_list_id").toString()));
	        	 menuRes.setName(data.get("name").toString());
	        	 menuRes.setParent(Long.parseLong(data.get("parent_id").toString()));
	        	 if(data.get("url_key") != null) {
	        		 menuRes.setUrlKey(data.get("url_key").toString());
	        	 }
	        	 
	        	 menuResList.add(menuRes);
	         }
	         
	         return menuResList;
	     }

}
