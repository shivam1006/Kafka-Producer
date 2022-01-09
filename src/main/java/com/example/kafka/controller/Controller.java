package com.example.kafka.controller;

import java.time.LocalDate;

import org.omg.CORBA.portable.ApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.constants.Constants;
import com.example.kafka.model.Artifact;
import com.example.kafka.model.ValidateResponse;
import com.example.kafka.service.Producer;
import com.example.kafka.util.Validator;

import io.swagger.annotations.ApiOperation;

/***
 * 
 * @author shivampandita
 *
 */

@RestController
public class Controller {
	
	 private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private Validator validator;
    
    @Autowired
    private Producer producer;
   
    
    
    
	/***
	 * 
	 * Request mapping for returning whether the guest can check in to the hotel
	 * 
	 */

	 @PostMapping(value = Constants.PRODUCER_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
	    @ApiOperation(value = "Kafka Producer")
	    public ResponseEntity<ValidateResponse> ProducerKafka(@RequestBody Artifact request)
		    throws Exception {

	    logger.info("Entering ReleaseTrackerController ==> validateReleaseItemDetails method");
	    
	    
	    
			validator.isValidInputField(request.getId(), Constants.ID);
			validator.isValidInputField(request.getCategory(), Constants.CATEGORY);
			validator.isValidInputField(request.getName(), Constants.NAME);
	
			ValidateResponse respnse = new ValidateResponse();
			respnse = producer.send(Constants.TOPIC_NAME ,request);

		return ResponseEntity.status(HttpStatus.OK).body(respnse);
	    }
	    
	    
	
	

}
