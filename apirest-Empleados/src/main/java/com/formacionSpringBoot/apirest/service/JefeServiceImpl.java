package com.formacionSpringBoot.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.formacionSpringBoot.apirest.Dao.JefeDao;
import com.formacionSpringBoot.apirest.entity.Jefe;

public class JefeServiceImpl implements JefeService{
	
	@Autowired
	private JefeDao repositorio;

	@Override
	@Transactional(readOnly=true)
	public List<Jefe> findAll() {
		return (List<Jefe>) repositorio.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Jefe findById(Long idJefe) {
		return repositorio.findById(idJefe).orElse(null);
	}

	@Override
	public Jefe save(Jefe jefe) {
		return repositorio.save(jefe);
	}

	@Override
	public void delete(Long idJefe) {
		repositorio.deleteById(idJefe);
		
	}

}
