package com.krishnan.balaji.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPP implements BeanFactoryPostProcessor{

	final static Logger logger = LoggerFactory.getLogger(MyBeanFactoryPP.class);
	
	public void postProcessBeanFactory(ConfigurableListableBeanFactory arg0)
			throws BeansException {
		logger.info("MyBeanFactoryPP called");
	}

}
