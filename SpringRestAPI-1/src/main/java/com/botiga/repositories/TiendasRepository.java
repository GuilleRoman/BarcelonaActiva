package com.botiga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.botiga.models.Tienda;

public interface TiendasRepository extends JpaRepository<Tienda, Integer> {

}
