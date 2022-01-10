package com.example.kafka.service;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.kafka.constants.Constants;
import com.example.kafka.model.ValidateResponse;
import com.fasterxml.jackson.databind.ObjectMapper;



@Service
public class ConsumerImpl implements Consumer{

	
  final Logger logger = LoggerFactory.getLogger(ConsumerImpl.class);
  
 
	
	@Override
	public ValidateResponse consume(String topic) throws Exception {
		// TODO Auto-generated meValidateResponsethod stub
		
 
	        
	        Logger logger = LoggerFactory.getLogger(ConsumerImpl.class.getName());

	      

	        // create consumer configs
	        Properties properties = new Properties();
	        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, Constants.BOOTSTRAP_SERVERS);
	        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
	        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
	        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, Constants.GROUP_ID);
	        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

	        // create consumer
	        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);

	        // subscribe consumer to our topic(s)
	        consumer.subscribe(Arrays.asList(topic));
             
	        
	        
	        // poll for new data
	        while(true){
	            ConsumerRecords<String, String> records =
	                    consumer.poll(Duration.ofMillis(100)); // new in Kafka 2.0.0

	            for (ConsumerRecord<String, String> record : records){
	                logger.info("Key: " + record.key() + ", Value: " + record.value());
	                logger.info("Partition: " + record.partition() + ", Offset:" + record.offset());
	            }
	        

	        }
	        
	        
	        
	      
	        
	        
	        
	}
}
	        
	        
	        
	        
	        

	    
	  
    
	
	
	
	    
	

	
	

