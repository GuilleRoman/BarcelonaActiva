package com.jocdaus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.jocdaus.models.Roll;
import com.jocdaus.repositories.RollRepository;
import com.jocdaus.repositories.RollRepositoryMongo;

@Service
public class RollService {
	@Autowired
	RollRepository db;
	@Autowired
    RollRepositoryMongo db1;
    
	public List<Roll> getRollsByPlayerId(Integer id) {
		return db.getRollsByPlayerId(id);
		// TODO Auto-generated method stub
		
	}

	public void save(Roll roll) {
		// TODO Auto-generated method stub
		db.save(roll);
	}

	
	public int countTimesRolled(int id) {
		// TODO Auto-generated method stub
		return db.countTimesRolled(id);
	}
}
