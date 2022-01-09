package com.example.kafka.util;

import java.util.Map;

import org.omg.CORBA.portable.ApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.example.kafka.constants.Constants;
import com.example.kafka.exceptions.ExceptionObjFactory;

@Component
public class Validator {
    private static final Logger logger = LoggerFactory.getLogger(Validator.class);

    @Autowired
    ExceptionObjFactory expObjFactory;

    public void isValidInputHeader(Object input, String header) throws Exception {
	if (input == null || ObjectUtils.isEmpty(input)) {
	    logger.error(header + Constants.HEADER_EXCEPTION);
	    throw expObjFactory.createNewAppexception(Constants.ERROR_CODE_3002, header + Constants.HEADER_EXCEPTION);
	}
    }

    public void isValidInputField(Object input, String field) throws Exception {
	if (input == null || ObjectUtils.isEmpty(input)) {
	    logger.error(field + Constants.ELEMENT_EXCEPTION);
	    throw expObjFactory.createNewAppexception(Constants.ERROR_CODE_3002, field + Constants.ELEMENT_EXCEPTION);
	}
    }

    public void isValidInputQueryParam(Object input, String queryparam) throws Exception {
	if (input == null || ObjectUtils.isEmpty(input)) {
	    logger.error(queryparam + Constants.QUERY_PARAM_EXCEPTION);
	    throw expObjFactory.createNewAppexception(Constants.ERROR_CODE_3002,
		    queryparam + Constants.QUERY_PARAM_EXCEPTION);
	}
    }

    public void isValidInputPathParam(Object input, String pathparam) throws Exception {
	if (input == null || ObjectUtils.isEmpty(input)) {
	    logger.error(pathparam + Constants.PATH_PARAM_EXCEPTION);
	    throw expObjFactory.createNewAppexception(Constants.ERROR_CODE_3002,
		    pathparam + Constants.PATH_PARAM_EXCEPTION);
	}
    }

    public void isValidInputArray(Object input, String array) throws Exception {
	if (input == null || ObjectUtils.isEmpty(input)) {
	    logger.error(array + Constants.ARRAY_EXCEPTION);
	    throw expObjFactory.createNewAppexception(Constants.ERROR_CODE_3002, array + Constants.ARRAY_EXCEPTION);
	}

    }

    public void isValidInputArrayField(Object input, String array) throws Exception {
	if (input == null || ObjectUtils.isEmpty(input)) {
	    logger.error(array + Constants.ARRAY_ELEMENT_EXCEPTION);
	    throw expObjFactory.createNewAppexception(Constants.ERROR_CODE_3002,
		    array + Constants.ARRAY_ELEMENT_EXCEPTION);
	}
    }

    public void isValidInputBody(Map<String, Object> input) throws Exception {
	if (input == null || ObjectUtils.isEmpty(input) || input.keySet().contains("")) {
	    logger.error(Constants.BODY_EXCEPTION);
	    throw expObjFactory.createNewAppexception(Constants.ERROR_CODE_3002, Constants.BODY_EXCEPTION);
	}
    }
}
