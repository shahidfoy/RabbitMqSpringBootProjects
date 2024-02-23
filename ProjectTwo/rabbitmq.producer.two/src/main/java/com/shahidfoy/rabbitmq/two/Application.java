package com.shahidfoy.rabbitmq.two;

import com.shahidfoy.rabbitmq.two.entity.DummyMessage;
import com.shahidfoy.rabbitmq.two.entity.InvoiceCancelledMessage;
import com.shahidfoy.rabbitmq.two.entity.InvoiceCreatedMessage;
import com.shahidfoy.rabbitmq.two.entity.InvoicePaidMessage;
import com.shahidfoy.rabbitmq.two.producer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private DummyProducer dummyProducer;

	@Autowired
	private MultiplePrefetchProducer multiplePrefetchProducer;

	@Autowired
	InvoiceProducer invoiceProducer;

	@Autowired
	SingleActiveProducer singleActiveProducer;

	@Autowired
	ReliableProducer reliableProducer;

	@Autowired
	AnotherDummyProducer anotherDummyProducer;

	@Autowired
	StreamHelloProducer streamHelloProducer;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

//		var dummyMessage = new DummyMessage("Content", 1);
//		dummyProducer.sendDummy(dummyMessage);

//		for (int i = 0; i < 500; i++) {
//			var dummyMessage = new DummyMessage("Content", i);
//			dummyProducer.sendDummy(dummyMessage);
////			TimeUnit.SECONDS.sleep(1);
//		}


//		multiplePrefetchProducer.simulateTransaction();
//		multiplePrefetchProducer.simulateScheduler();
//		System.out.println("All data sent");


//		var randomInvoiceNumber = "INT-" + ThreadLocalRandom.current().nextInt(100, 200);
//		var invoiceCreatedMessage = new InvoiceCreatedMessage(155.75, LocalDate.now(), "USD", randomInvoiceNumber);
//		invoiceProducer.sendInvoiceCreated(invoiceCreatedMessage);
//
//		randomInvoiceNumber = "INV-" + ThreadLocalRandom.current().nextInt(200, 300);
//		var randomPaymentNumber = "PAY-" + ThreadLocalRandom.current().nextInt(1000, 2000);
//		var invoicePaidMessage = new InvoicePaidMessage(randomInvoiceNumber, LocalDate.now(), randomPaymentNumber);
//		invoiceProducer.sendInvoicePaid(invoicePaidMessage);
//
//		randomInvoiceNumber = "INV-" + ThreadLocalRandom.current().nextInt(300, 400);
//		var invoiceCancelledMessage = new InvoiceCancelledMessage(LocalDate.now(), randomInvoiceNumber, "Invoice cancelled");
//		invoiceProducer.sendInvoiceCancelled(invoiceCancelledMessage);


//		singleActiveProducer.sendDummy();


//		var dummyMessage = new DummyMessage("Dummy content", 1);
//
//		System.out.println("----------------------------------");
//		System.out.println("Calling sendDummyToInvalidExchange()");
//		reliableProducer.sendDummyToInvalidExchange(dummyMessage);
//
//		TimeUnit.SECONDS.sleep(2);
//
//		System.out.println("----------------------------------");
//		System.out.println("Calling sendDummyWithInvalidRoutingKey()");
//		reliableProducer.sendDummyWithInvalidRoutingKey(dummyMessage);


//		for (int i = 0; i < 10; i++) {
//			var invoiceNumber = "INV-" + i;
//			var invoiceCancelledMessage = new InvoiceCancelledMessage(LocalDate.now(), invoiceNumber, "Invoice cancelled " + i);
//			invoiceProducer.sendInvoiceCancelled(invoiceCancelledMessage);
//		}

//		var message = new DummyMessage("Just a dummy", 1);
//		anotherDummyProducer.sendDummy(message);

		for (int i = 0; i < 3; i++) {
			var str = "Hello Stream XXXX " + i;
//			streamHelloProducer.sendHello(str);
			streamHelloProducer.sendHelloUsingExchange(str);
		}
	}
}
