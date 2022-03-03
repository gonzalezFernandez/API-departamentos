package com.formacionSpringBoot.apirest.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formacionSpringBoot.apirest.entity.Empleado;


@Repository
public interface EmpleadoDao extends CrudRepository<Empleado, Long> {

}
