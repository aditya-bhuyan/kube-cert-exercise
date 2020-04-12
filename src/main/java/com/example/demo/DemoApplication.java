package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

@SpringBootApplication
@RestController
public class DemoApplication {
	private static Logger log = Logger.getLogger(DemoApplication.class.getName());
	private static FileHandler handler = null;


	public DemoApplication(@Value("${LOGFILE:app1.log}") String logFile){

		try {
			handler = new FileHandler(logFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.addHandler(handler);

	}

	@GetMapping("/")
	public String index(){
		log.info("LOG Message Added at "+new Date().toString());
		return "WELCOME TO KUBERNETES";
	}

	@GetMapping("/name")
	public String getName(@Value("${NAME}") String name){
		return name;
	}

	@GetMapping("/password")
	public String getPassword(@Value("${PASSWORD}") String password){
		return password;
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
