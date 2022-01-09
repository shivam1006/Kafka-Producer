package com.example.kafka.service;


import com.example.kafka.model.Artifact;
import com.example.kafka.model.ValidateResponse;

public interface Producer {

	public ValidateResponse send(String topic_name , Artifact request) throws Exception;
	

}
