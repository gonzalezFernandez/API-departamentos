package com.formacionSpringBoot.apirest.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formacionSpringBoot.apirest.entity.Departamento;

@Repository
public interface DepartamentoDao extends CrudRepository<Departamento, Long> {

}