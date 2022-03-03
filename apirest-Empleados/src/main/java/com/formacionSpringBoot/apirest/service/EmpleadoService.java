package com.formacionSpringBoot.apirest.service;

import java.util.List;

import com.formacionSpringBoot.apirest.entity.Empleado;


public interface EmpleadoService {
	public List<Empleado> findAll();
	public Empleado findById(Long idEmpleado);	
	public Empleado save(Empleado empleado);
	public void delete(Long idEmpleado);
	//public Empleado deleteConRetorno(Long idEmpleado);
}
