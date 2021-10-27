package com.tiendas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tiendas.models.Tienda;
@Repository
public interface TiendasRepository extends CrudRepository<Tienda, Integer>{

}
