package com.formacionSpringBoot.apirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formacionSpringBoot.apirest.Dao.DepartamentoDao;

@RestController
@RequestMapping("/api")
public class DepartamentoController {
	
	@Autowired 
	private DepartamentoDao servicio;
	

}
