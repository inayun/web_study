package com.example.spring.basic01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Sample01 {

	public static void main(String[] args) {
		
		String[] configLocations = {"basic01/sample01.xml"};
		
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocations);
		
		Receiver receiver =  (Receiver)context.getBean("receiver");
		
		System.out.println("send.time:" + receiver.getSendTime());
		System.out.println("send.time:" + receiver.getSender().isSender());
	}
}
