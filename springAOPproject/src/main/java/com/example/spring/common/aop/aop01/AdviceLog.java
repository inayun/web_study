package com.example.spring.common.aop.aop01;

import java.util.HashMap;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class AdviceLog {

	private static final Logger logger = LoggerFactory.getLogger(AdviceLog.class);
	
	//이 함수를 적용하는데 어느 위치내에서 할 것인지
	@Around("within(com.example.spring..*)") //..은 0개 이상을 의미
	public Object processTime(ProceedingJoinPoint joinPoint) throws Throwable {
		
		String targetFun = joinPoint.getSignature().toLongString(); //함수명을 알수있음
		logger.info(targetFun + "start!");
		
		long startTime = System.currentTimeMillis();
		
		try {
			Object obj = joinPoint.proceed(); //호출되는 함수가 실행됨
			return obj;
		}finally {
			long endTime = System.currentTimeMillis();
			logger.info(targetFun + "finish");
			logger.info("실행경과 : " + (endTime - startTime));
			
		}
		
	}
	
	@Before("within(com.example.spring..service..*)")
	public void before(JoinPoint joinPoint) {
		
		Signature method = joinPoint.getSignature(); //함수정보
		String methodName = method.getName(); //함수이름
		
		logger.info("함수명 : " + methodName);
		Object params[] = joinPoint.getArgs(); //파라미터 정보

		//파라미터 타입이 HashMap인것만 뽑기
		for(Object param : params) {
			if(param instanceof HashMap) {
				HashMap<String, Object> map = (HashMap)param; 
				
				for(String key : map.keySet()) {
					logger.info("key : " + key + " , value : " + map.get(key));
				}
			}
		}
		
	}
	
	
	
}
