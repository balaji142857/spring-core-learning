package com.krishnan.balaji.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class DisplayBeanNamePostProcessor implements BeanPostProcessor{
	final static Logger logger = LoggerFactory.getLogger(DisplayBeanNamePostProcessor.class);
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		logger.info("bean "+beanName +" initialized");
		return bean;
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		logger.info("bean "+beanName +" before initialization");
		return bean;
	}

}
