package com.jocdaus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jocdaus.models.Roll;

@Repository
public interface RollRepository extends JpaRepository<Roll, Integer> {

}
