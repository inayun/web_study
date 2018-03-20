package com.example.spring.beantest;

import org.springframework.stereotype.Component;

@Component

//@Component,  @Service 둘중에 하나 사용가능
//@Component : vo 객체 (set , get)
//@Service : business 로직


public class SmsSender {

	boolean value=true;


	public SmsSender(){}

	public SmsSender(boolean value){
		this.value = value;
	}

	public boolean isValue(){
		return value;
	}

	public void setValue(boolean value){
		this.value= value;
	}

}
