package com.shahidfoy.rabbitmq.producer.stream;

import com.shahidfoy.rabbitmq.producer.stream.entity.Invoice;
import com.shahidfoy.rabbitmq.producer.stream.producer.StreamInvoiceProducer;
import com.shahidfoy.rabbitmq.producer.stream.producer.StreamNumberProducer;
import com.shahidfoy.rabbitmq.producer.stream.producer.SuperStreamInvoiceProducer;
import com.shahidfoy.rabbitmq.producer.stream.producer.SuperStreamNumberProducer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class Application implements CommandLineRunner {

//	@Autowired
//	private StreamNumberProducer streamNumberProducer;
//
//	@Autowired
//	private SuperStreamNumberProducer superStreamNumberProducer;

//	@Autowired
//	private StreamInvoiceProducer streamInvoiceProducer;

	@Autowired
	private SuperStreamInvoiceProducer superStreamInvoiceProducer;

	@Autowired
	private RabbitTemplate dummyRabbitTemplate;


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		streamNumberProducer.sendNumbers(0, 10_000);

//		superStreamNumberProducer.sendNumberUsingRabbitTemplate(0, 10);
//		superStreamNumberProducer.sendNumberUsingRabbitStreamTemplate(10, 20);

//		for (int i = 0; i < 10; i++) {
//			var invoice = new Invoice("INV-" + i, Invoice.Status.CREATED, ThreadLocalRandom.current().nextInt(100, 1000));
//
//			if (i % 2 == 0) {
//				streamInvoiceProducer.sendInvoiceUsingRabbitTemplate(invoice);
//			} else {
//				streamInvoiceProducer.sendInvoiceUsingRabbitStreamTemplate(invoice);
//			}
//
//			TimeUnit.MICROSECONDS.sleep(100);
//		}
//		System.out.println("All invoices sent");


		dummyRabbitTemplate.convertAndSend("Test");
		for (int i = 0; i < 10; i++) {
			var invoiceAmount = ThreadLocalRandom.current().nextInt(100, 1000);
			var invoiceCrated = new Invoice("INV-" + i, Invoice.Status.CREATED, invoiceAmount);
			var invoiceApproved = new Invoice("INV-" + i, Invoice.Status.APPROVED, invoiceAmount);

			superStreamInvoiceProducer.sendInvoiceUsingRabbitStreamTemplate(invoiceCrated);
			superStreamInvoiceProducer.sendInvoiceUsingRabbitStreamTemplate(invoiceApproved);
		}

		System.out.println("all invoices sent");
	}
}
