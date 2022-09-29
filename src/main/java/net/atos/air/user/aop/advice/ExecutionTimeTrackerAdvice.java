package net.atos.air.user.aop.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.atos.air.user.dto.UserDetailsdto;
@Aspect
@Component
public class ExecutionTimeTrackerAdvice {
	
	Logger log =LoggerFactory.getLogger(ExecutionTimeTrackerAdvice.class);
	
	@Around("@annotation(net.atos.air.user.aop.advice.TrackExecutionTime)")
	public Object executionTimeAndAgrument(ProceedingJoinPoint point) throws Throwable {
		long startTime = System.currentTimeMillis();
		log.info("IN AOP LOGGER");
		for (Object arg : point.getArgs()) {
			if (arg instanceof UserDetailsdto) {
				UserDetailsdto obj = (UserDetailsdto) arg;
				log.info(" Request Value of UserDetailsdto :: "+new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(obj));
			}
		}
		Object object = point.proceed();
		if(object!=null) {
			log.info(" Response Value UserDetails:: "+new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(object));
		}
		long endtime = System.currentTimeMillis();
		log.info("Time taken for Execution is : " + (endtime - startTime) + "ms");
		return object;
	}

}
