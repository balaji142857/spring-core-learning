package com.krishnan.balaji;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
	 final static Logger logger = LoggerFactory.getLogger(App.class);
	 
    public static void main( String[] args )
    {
    	 logger.info("Initializing Spring context.");
         
         ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/context.xml");
         
         logger.info("Spring context initialized.");

         Greeter greetings = (Greeter) applicationContext.getBean("greeter");

         logger.info("message='" + greetings.getMessage() + "'");
    }
}
