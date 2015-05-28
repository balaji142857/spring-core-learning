package com.krishnan.balaji;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.krishnan.balaji.model.Point;

public class App 
{
	 final static Logger logger = LoggerFactory.getLogger(App.class);
	 
    public static void main( String[] args )
    {
    	 logger.info("Initializing Spring context.");
         AbstractApplicationContext context = new ClassPathXmlApplicationContext("/context.xml");
         Greeter greetings = (Greeter) context.getBean("greeter");
         logger.info("message='" + greetings.getMessage() + "'");
         tryScopes(context);
         
         context.close();
         logger.info("Application context closed");
    }

	private static void tryScopes(AbstractApplicationContext context) {
		//point is defined as prototype in context
		logger.info("loading prototype scoped point bean");
		Point pointOne = context.getBean("point",Point.class);
        Point pointTwo = context.getBean("point",Point.class);
        logger.info("pointOne: " + pointOne.toString());
        logger.info("pointTwo: " + pointTwo.toString());
        logger.info("Updating pointOne's x value to 120");
        pointOne.setX(120);
        logger.info("pointOne: " + pointOne.toString());
        logger.info("pointTwo: " + pointTwo.toString());

        //somePoint is defined as singleton(default) inside context
        logger.info("loading singleton scoped point bean");
        Point pointThree = context.getBean("somePoint",Point.class);
        Point pointFour = context.getBean("somePoint",Point.class);
        logger.info("pointThree: " + pointThree.toString());
        logger.info("pointFour: " + pointFour.toString());
        logger.info("Updating pointThree's x value to 120");
        pointThree.setX(120);
        logger.info("pointThree: " + pointThree.toString());
        logger.info("pointFour: " + pointFour.toString());        
	}
}
