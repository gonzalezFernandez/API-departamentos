package com.formacionSpringBoot.apirest.service;

import java.util.List;

import com.formacionSpringBoot.apirest.entity.Jefe;


public interface JefeService {

	public List<Jefe> findAll();
	public Jefe findById(Long idJefe);	
	public Jefe save(Jefe jefe);
	public void delete(Long idJefe);
	//public Jefe deleteConRetorno(Long idJefe);
	
}
