package com.course.rabbitmq.producer;

import java.time.LocalDate;

import com.course.rabbitmq.producer.entity.Picture;
import com.course.rabbitmq.producer.producer.SpringPictureProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.course.rabbitmq.producer.entity.Employee;
import com.course.rabbitmq.producer.producer.SpringEmployeeJsonProducer;

//@EnableScheduling
@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@Autowired
//	private SpringEmployeeJsonProducer producer;

//	@Autowired
//	private SpringPictureProducer springPictureProducer;

	@Autowired
	private SpringEmployeeJsonProducer springEmployeeJsonProducer;

	@Override
	public void run(String... args) throws Exception {
//		var emp = new Employee("emp-spring", null, LocalDate.now());

//		producer.sendMessage(emp);

// springPictureProducer
//		var picture = new Picture();
//		picture.setName("Spring picture");
//		picture.setSize(9500);
//		picture.setSource("web");
//		picture.setType("jpg");
//
//		springPictureProducer.sendMessage(picture);


		var emp = new Employee("emp-spring", null, LocalDate.now());
		springEmployeeJsonProducer.sendMessage(emp);
	}

}
