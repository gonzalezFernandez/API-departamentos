package com.formacionSpringBoot.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionSpringBoot.apirest.Dao.DepartamentoDao;
import com.formacionSpringBoot.apirest.entity.Departamento;

@Service
public class DepartamentoServiceImpl implements DepartamentoService{

	@Autowired
	private DepartamentoDao repositorio;
	
	@Override
	@Transactional(readOnly=true)
	public List<Departamento> findAll() {
		
		return (List<Departamento>) repositorio.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Departamento findById(Long idDepartamento) {
		return repositorio.findById(idDepartamento).orElse(null);
	}

	@Override
	@Transactional
	public Departamento save(Departamento departamento) {
		return repositorio.save(departamento);
	}

	@Override
	@Transactional
	public void delete(Long idDepartamento) {
		repositorio.deleteById(idDepartamento);
		
	}

//	@Override
//	public Departamento deleteConRetorno(Long iDepartamento) {
//		Departamento d = repositorio.findById(iDepartamento).get();
//		repositorio.deleteById(iDepartamento);
//		return d;
//	}

}
