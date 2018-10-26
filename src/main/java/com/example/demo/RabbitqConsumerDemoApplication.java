package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class RabbitqConsumerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitqConsumerDemoApplication.class, args);
	}
	
	@RabbitListener(queues = "spring-boot") //@RabbitListener to create a listener endpoint
	public void process(String message) {
		System.out.println(">>> " + message);
	}

	@Bean
	public Queue queue(){					//The queue() method returns an queue with durability set to false
		return new Queue("spring-boot", false);
	}
	
	@RabbitListener(queues = "spring-boot-mule") //@RabbitListener to create a listener endpoint
	public void process1(String message) {
		System.out.println(">>> " + message);
	}

	@Bean
	public Queue queue1(){					//The queue() method returns an queue with durability set to false
		return new Queue("spring-boot-mule", false);
	}


}
