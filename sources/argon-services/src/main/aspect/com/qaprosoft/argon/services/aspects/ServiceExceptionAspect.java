package com.qaprosoft.argon.services.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qaprosoft.argon.services.exceptions.ServiceException;

@Aspect
public class ServiceExceptionAspect
{
	private static final Logger logger = LoggerFactory.getLogger(ServiceExceptionAspect.class);

	@AfterThrowing(pointcut = "execution(public * com.qaprosoft.argon.services.services..*.*(..) throws com.qaprosoft.argon.services.exceptions.ServiceException)", throwing = "e")
	public void rethrowException(JoinPoint joinPoint, Exception e) throws ServiceException
	{
		logger.error("Got exception when calling [{}]", joinPoint.getSignature().toString(), e);

		if (e instanceof ServiceException)
		{
			throw (ServiceException) e;
		} else
		{
			throw new ServiceException(e);
		}
	}
}
