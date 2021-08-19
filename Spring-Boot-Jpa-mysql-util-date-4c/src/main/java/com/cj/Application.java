package com.cj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Logging: Step 1
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Entity class validations
@SpringBootApplication
public class Application {
	
	//Logging: Step 2
	private static final Logger LOGGER=LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		//Logging: Step 3
        LOGGER.info("This is Test logggggggggggggggggggggg");
        
        //Step 4
        //In properties file
        //logging.level.com.cj=TRACE
        //ERROR, WARN, INFO, DEBUG, or TRACE as logging level. 
        //By default, logging level is set to INFO. It means that code>DEBUG and 
        //TRACE messages are not visible

        //Step 5 //add below line in application.properties file
        //logging.file=F:\\removeme\\application.log
	}

}
