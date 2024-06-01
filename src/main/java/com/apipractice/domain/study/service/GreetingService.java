package com.apipractice.domain.study.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
	public String greet(String param) {
		return "Hello, World" + " " + param;
	}
}
