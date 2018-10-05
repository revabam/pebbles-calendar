package com.revature.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

/**
 * This is a Class where a Spring Aop advice executes before or after the methods 
 * in the services and controller is called/executed. 
 * @author obosanosa-igiebor Batch: 1806-spark, Trainer: Steven Kelsey
 *
 */

@Aspect
@Configuration
public class CalendarLogging {

private Logger logger = Logger.getLogger(this.getClass());
	
	// This executes after the methods in the service class
	@After("execution( * com.revature.services.*.*(..))")
	public void logExecutionTime(JoinPoint joinPoint) throws Throwable {
		System.out.println("Current Directory = " + System.getProperty("user.dir"));
		System.out.println("NOW LOGGING");
		logger.info("Used  services " + joinPoint);
		logger.error("Error!");
		logger.debug("Now Debugging...");
	}
	
	//This executed before the methods in the curriculum controller
		@Before("execution( * com.revature.controllers.CalendarController.*(..))")
		public void logCurriculum(JoinPoint joinPoint) throws Throwable{
			logger.info("Calendar endpoints hit" + joinPoint);
			logger.error("Error!");
			logger.debug("Now Debugging...");
	}
}
