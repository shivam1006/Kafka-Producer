package com.example.kafka.service;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.kafka.constants.Constants;
import com.example.kafka.model.Artifact;
import com.example.kafka.model.ValidateResponse;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class ProducerImpl implements Producer{

	
  final Logger logger = LoggerFactory.getLogger(ProducerImpl.class);
  
 
	
	@Override
	public ValidateResponse send(String topic_name , Artifact request) throws Exception {
		// TODO Auto-generated meValidateResponsethod stub
		ValidateResponse resp = new ValidateResponse();
		
		
	        // create Producer properties
	        Properties properties = new Properties();
	        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, Constants.BOOTSTRAP_SERVERS);
	        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
	        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

	        
	        ObjectMapper mapper = new ObjectMapper();
	        
	        String jsonStr = mapper.writeValueAsString(request);
	        
	        // create the producer
	        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);


	        for (int i=0; i<10; i++ ) {
	            // create a producer record
	            ProducerRecord<String, String> record =
	                    new ProducerRecord<String, String>(topic_name, jsonStr);

	            // send data - asynchronous
	            producer.send(record, new Callback() {
	                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
	                    // executes every time a record is successfully sent or an exception is thrown
	                    if (e == null) {
	                    	resp.setMessage("Request has been Published Successfuly to Kafka topic "+ topic_name);
	                        // the record was successfully sent
	                        logger.info("Received new metadata. \n" +
	                                "Topic:" + recordMetadata.topic() + "\n" +
	                                "Partition: " + recordMetadata.partition() + "\n" +
	                                "Offset: " + recordMetadata.offset() + "\n" +
	                                "Timestamp: " + recordMetadata.timestamp());
	                    } else {
	                        logger.error("Error while producing", e);
	                    }
	                }
	            });
	        }

	        // flush data
	        producer.flush();
	        // flush and close producer
	        producer.close();
	        
	        
	        return resp;

	    }
	
	
	
	    
	}

	
	

