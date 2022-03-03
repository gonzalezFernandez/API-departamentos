package com.projecto.java.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projecto.java.entity.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
