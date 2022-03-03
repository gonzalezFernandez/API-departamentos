package com.projecto.java.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projecto.java.entity.Compra;

@Repository
public interface CompraRepository extends CrudRepository<Compra, Long> {

}
