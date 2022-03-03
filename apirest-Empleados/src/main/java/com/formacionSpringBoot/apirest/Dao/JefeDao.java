package com.formacionSpringBoot.apirest.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formacionSpringBoot.apirest.entity.Jefe;


@Repository
public interface JefeDao extends CrudRepository<Jefe, Long> {

}
