package com.gs.util;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;
//@Aspect
@Component
public class LogInterceptor  {
	/*@Around("execution ( public * *(..))")
	public Object log(ProceedingJoinPoint pjp){
		
		Object obj = null;
		try {
			System.out.println(pjp.getTarget().toString()+"+++++++++++Start!");
			obj = pjp.proceed();
		} catch (Throwable e) {
			System.out.println("===========Throws");
			JavaMail jm = new JavaMail();
			jm.doSendHtmlEmail("add", "sdad", "63388@qq.con");
			e.printStackTrace();
		}
		return obj;
		
	}
	*/
	
}
