package com.formacionSpringBoot.apirest.service;

import java.util.List;

import com.formacionSpringBoot.apirest.entity.Departamento;


public interface DepartamentoService {

	public List<Departamento> findAll();
	public Departamento findById(Long idDepartamento);	
	public Departamento save(Departamento departamento);
	public void delete(Long idDepartamento);
	//public Departamento deleteConRetorno(Long iDepartamento);
	
}
