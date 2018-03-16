package com.example.spring.basic03;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class CustomBeanPostProcessor implements BeanPostProcessor{

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException{
		System.out.println("(5) 초기화 전에 빈에 대한 처리를 실행 :" + beanName);
		return bean;
	}
	
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException{
		System.out.println("(5) 초기화 후에 빈에 대한 처리를 실행 :" + beanName);
		return bean;
	}
}
