	package com.example.spring.basic01;

public class Receiver {

	private int sendTime;
	private Sender sender;
	private String message; 
	
	public Receiver() {
	}
	
	public Receiver(String period) {
		this.sendTime = Integer.parseInt(period);
		this.message = "String Type : " + period;
		
	}
	
	public Receiver(int period) {
		this(period, null);
		this.message = "Integer Type : " + period;
	}

	public Receiver(int period, Sender sender) {
		this.sendTime = period;
		this.sender = sender;
	}

	
	public int getSendTime() {
		return sendTime;
	}

	public void setSendTime(int time) {
		this.sendTime = time;
	}

	public Sender getSender() {
		return sender;
	}

	//@Required
	public void setSender(Sender sender) {
		this.sender = sender;
	}
	
	public String getMessage() {
		return message;
	}
	
}