package com.example.spring.basic01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Sample03 {

	public static void main(String[] args) {
		
		String[] configLocations = {"basic01/sample03.xml"};
		
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocations);
		
		Receiver receiver =  (Receiver)context.getBean("receiver");
		
		System.out.println("send.time:" + receiver.getSendTime());
		System.out.println("Message is : " + receiver.getMessage());
	}
}
