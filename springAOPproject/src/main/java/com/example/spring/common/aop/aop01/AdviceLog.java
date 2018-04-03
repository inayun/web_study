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
	
	/*@Before("within(com.example.spring..service..*)")*/
	@Before("execution (* com.example.spring.service.*Service.le*(..)) ")
	
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
	
	
/*	
	execution

	* : 모든 것
	.. : 0개 이상

	execution( "[접근지정자][리턴타입][적용클래스명][적용함수명](파라미터)")
	접근지정자(생략가능) : public protected private

	*/
	//execution 을 쓰면 세세하게 접근이 가능함
	//@Before("execution (* com.example.spring.service.*Service.le*(..)) ");
	
	
	
	// com.example.spring 패키지와 하위 패키지 모든 함수에서 적용될 수 있게 execution 처리
/*	@Before("execution (* com.example.spring..*.*(..) ");*/
	
	
	/*
	


	//lecture07Sample 함수를 실행하는 execution 처리
	execution("void com.example.spring.service.lecture07Sample(..)")
	execution("* lecture*(..)")
	execution("* lec(*)" )


	//파라미터 2개 받는데 첫번째 파라미터 타입은 String인 경우
	execution("* lec*(String, *)")

	//파라미터는 1개 이상이고 첫번째 파라미터 타입은 String인 경우
	execution("* lec*(String, ..)")
	
	//2개 이상
	 execution(" * lec*(String, *, ..)")
	 
	
	
	
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
