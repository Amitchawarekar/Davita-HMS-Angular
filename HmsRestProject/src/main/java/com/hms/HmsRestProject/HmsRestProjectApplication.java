package com.hms.HmsRestProject;

import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HmsRestProjectApplication {

//	private Logger logger = LoggerFactory.getLogger(HmsRestProjectApplication.class);

	public static void main(String[] args) {
		
		BasicConfigurator.configure();
		SpringApplication.run(HmsRestProjectApplication.class, args);
	}

}
