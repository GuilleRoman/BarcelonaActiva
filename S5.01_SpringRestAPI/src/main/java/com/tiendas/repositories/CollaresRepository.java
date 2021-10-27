package com.tiendas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tiendas.models.Collar;
@Repository
public interface CollaresRepository extends CrudRepository<Collar, Integer> {

}
