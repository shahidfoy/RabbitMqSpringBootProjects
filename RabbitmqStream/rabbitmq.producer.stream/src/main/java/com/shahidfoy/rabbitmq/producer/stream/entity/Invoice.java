package com.shahidfoy.rabbitmq.producer.stream.entity;

public class Invoice {

    public enum Status {
        CREATED, APPROVED, PAID, REJECTED
    }

    private String invoiceNumber;
    private Status status;
    private int amount;

    public Invoice() {}

    public Invoice(String invoiceNumber, Status status, int amount) {
        this.invoiceNumber = invoiceNumber;
        this.status = status;
        this.amount = amount;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceNumber='" + invoiceNumber + '\'' +
                ", status=" + status +
                ", amount=" + amount +
                '}';
    }
}
