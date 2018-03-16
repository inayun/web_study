package com.example.spring.basic03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Sample02 {

	public static void main(String[] args) {
		ApplicationContext factory;
		factory = new ClassPathXmlApplicationContext("basic03/sample02.xml");
		BeanLife bean = (BeanLife)factory.getBean("beanLife");
		bean.sayHello();

	}

}
