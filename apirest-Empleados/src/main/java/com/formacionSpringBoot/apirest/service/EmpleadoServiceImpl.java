package com.formacionSpringBoot.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionSpringBoot.apirest.Dao.EmpleadoDao;
import com.formacionSpringBoot.apirest.entity.Empleado;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

	@Autowired
	private EmpleadoDao repositorio;
	
	@Override
	@Transactional(readOnly=true)
	public List<Empleado> findAll() {
		return (List<Empleado>) repositorio.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Empleado findById(Long idEmpleado) {
		return repositorio.findById(idEmpleado).orElse(null);
	}

	@Override
	@Transactional
	public Empleado save(Empleado empleado) {
		return repositorio.save(empleado);
	}

	@Override
	@Transactional
	public void delete(Long idEmpleado) {
		repositorio.deleteById(idEmpleado);
		
	}

}
