package com.dolphinevents.eventservice.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class EventsServiceApplication {
	private static Logger LOG = LoggerFactory.getLogger(EventsServiceApplication.class);

	public static void main(String[] args) {
		LOG.info("Starting application from " + EventsServiceApplication.class.getName() + ".main");
		SpringApplication.run(EventsServiceApplication.class, args);
	}

}

