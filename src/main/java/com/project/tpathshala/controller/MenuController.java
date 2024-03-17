package com.project.tpathshala.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.tpathshala.model.ManuList;
import com.project.tpathshala.payload.LeadRequest;
import com.project.tpathshala.payload.MenuResponse;
import com.project.tpathshala.service.MenuService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/menu")
public class MenuController {
	@Autowired
	MenuService menuService;
	
	@GetMapping("/list")
	public ResponseEntity<?> createUser(@Valid @RequestBody LeadRequest leadRequest){
		
		List<MenuResponse> menulist = menuService.getAllMenuItems();
		
		return ResponseEntity.status(HttpStatus.OK).body(menulist);
	}
}
