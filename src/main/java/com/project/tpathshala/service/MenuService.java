package com.project.tpathshala.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.project.tpathshala.model.ManuList;
import com.project.tpathshala.payload.MenuResponse;

@Service
public interface MenuService {
	public List<MenuResponse> getAllMenuItems();
}
