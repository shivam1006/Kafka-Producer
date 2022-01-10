package com.example.kafka.service;


import com.example.kafka.model.ValidateResponse;

public interface Consumer {

	public ValidateResponse consume(String topic) throws Exception;
	

}
