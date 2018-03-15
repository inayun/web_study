package com.example.spring.basic02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Sample02 {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("basic02/sample02.xml");
		
		String s1 = (String)factory.getBean("name1");
		String s2 = (String)factory.getBean("name2");
		String s3 = (String)factory.getBean("name3");
		String s4 = (String)factory.getBean("name4");
		String s5 = (String)factory.getBean("namex1");
		String s6 = (String)factory.getBean("namex2");
		
		System.out.println((s1 == s2));
		System.out.println((s2 == s3));
		System.out.println((s3 == s4));
		System.out.println((s4 == s5));
		System.out.println((s5 == s6));
		
				
	}
}
