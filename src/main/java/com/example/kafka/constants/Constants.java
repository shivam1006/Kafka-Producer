package com.example.kafka.constants;

public class Constants {
	
	
	 /*
     * API Paths
     */
    public static final String PRODUCER_PATH = "/kafka/producer";
    
    /*
     * Exceptions
     */
    public static final String HEADER_EXCEPTION = " header is mandatory";
    public static final String ELEMENT_EXCEPTION = " field is mandatory";
    public static final String ARRAY_EXCEPTION = " array is mandatory";
    public static final String QUERY_PARAM_EXCEPTION = " queryparam is mandatory";
    public static final String PATH_PARAM_EXCEPTION = " pathparam is mandatory";
    public static final String ARRAY_ELEMENT_EXCEPTION = " array element is mandatory";
    public static final String BODY_EXCEPTION = "Request Payload is mandatory or invalid";

    /*
     * Error Codes
     */
    public static final String ERROR_CODE_3104 = "3104";
    public static final String ERROR_CODE_1001 = "1001";
    public static final String ERROR_CODE_1002 = "1002";
    public static final String ERROR_CODE_5014 = "5014";
    public static final String ERROR_CODE_5022 = "5022";
    public static final String ERROR_CODE_5029 = "5029";
    public static final String ERROR_CODE_5089 = "5089";
    public static final String ERROR_CODE_3001 = "3001";
    public static final String ERROR_CODE_3002 = "3002";
    public static final String ERROR_CODE_3004 = "3004";
    public static final String ERROR_CODE_3005 = "3005";
    public static final String ERROR_CODE_3006 = "3006";
    public static final String ERROR_CODE_3007 = "3007";
    public static final String ERROR_CODE_DEFAULT = "DEFAULT";

	public static final String MESSAGE = null;


	public static final String BOOTSTRAP_SERVERS = "127.0.0.1:9092";
	public static final String TOPIC_NAME = "firsttopic";
	public static final String GROUP_ID = "myfirstapp";

	
	/*
	 * RequestBody for Producer
	 * 
	 */
	public static final String ID = "id";
	public static final String CATEGORY = "category";
	public static final String NAME = "name";

	

	
   

}
