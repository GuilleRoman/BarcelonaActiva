package com.jocdaus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jocdaus.repositories.GameRepository;

@Service
public class GameService {
	@Autowired
	GameRepository db;
}
