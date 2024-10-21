package com.tiem.spring_scheduling_tasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringSchedulingTasksApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSchedulingTasksApplication.class, args);
	}

}
