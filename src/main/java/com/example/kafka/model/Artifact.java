package com.example.kafka.model;

import java.io.Serializable;
import java.util.Map;

import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;

public class Artifact implements Serializable, Serializer {

	private int id;
    private String name;
    private String category;
    
    public Artifact(){
    	
    }

    public Artifact(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category; 
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

	
	
	public void configure(Map configs, boolean isKey) {

    }

	
    public byte[] serialize(String topic, Object data) {
        return new byte[0];
    }

    public byte[] serialize(String topic, Headers headers, Object data) {
        return new byte[0];
    }

    public void close() {

    }
	

}
