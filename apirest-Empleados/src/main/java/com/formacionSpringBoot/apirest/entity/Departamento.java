package com.formacionSpringBoot.apirest.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="departamentos")
public class Departamento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDepartamento;
	
	private String nombre;
	
	private String ubicacion;
	
//	@OneToMany
//	@JoinColumn(name = "idEmpleado")
//	private Empleado empleado;
//	
//	@OneToMany
//	@JoinColumn(name = "idJefe")
//	private Jefe jefe;

	//Getters and Setters
	
	public Long getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Long idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

//	public Empleado getEmpleado() {
//		return empleado;
//	}
//
//	public void setEmpleado(Empleado empleado) {
//		this.empleado = empleado;
//	}
//
//	public Jefe getJefe() {
//		return jefe;
//	}
//
//	public void setJefe(Jefe jefe) {
//		this.jefe = jefe;
//	}
	
	

}
