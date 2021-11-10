package com.jocdaus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jocdaus.repositories.RollRepository;

@Service
public class RollService {
	@Autowired
	RollRepository db;
}
