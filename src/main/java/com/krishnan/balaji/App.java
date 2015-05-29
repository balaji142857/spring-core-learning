package com.krishnan.balaji;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.krishnan.balaji.model.Circle;
import com.krishnan.balaji.model.Point;
import com.krishnan.balaji.model.Shape;
import com.krishnan.balaji.model.Triangle;

public class App {
	final static Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		
		logger.info("Initializing Spring application context.");
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"/context.xml");
		context.registerShutdownHook();
		Greeter greetings = (Greeter) context.getBean("greeter");
		logger.info("message='" + greetings.getMessage() + "'");
		tryScopes(context);
		/*Since the beans that have registered for lifecycle methods are
		singleton, it is not required to explicitly obtain the bean to invoke
		those methods*/
		// tryLifeCycleMethods(context);
		logger.info("Attempting to draw a circle");
		Shape circle = context.getBean("circle", Circle.class);
		logger.info(circle.draw());
		logger.info("circle cirumference is "+circle.circumference());
		logger.info("Attempting to draw a triangle");
		Shape triangle =  context.getBean("triangle",Triangle.class);
		logger.info(triangle.draw());
		logger.info("triangle circumference is " + triangle.circumference());
		logger.info("Attempting to close application context");
		context.close();

	}

	
	private static void tryScopes(AbstractApplicationContext context) {
		// point is defined as prototype in context
		logger.info("loading prototype scoped point bean");
		Point pointOne = context.getBean("point", Point.class);
		Point pointTwo = context.getBean("point", Point.class);
		logger.info("pointOne: " + pointOne.toString());
		logger.info("pointTwo: " + pointTwo.toString());
		logger.info("Updating pointOne's x value to 120");
		pointOne.setX(120);
		logger.info("pointOne: " + pointOne.toString());
		logger.info("pointTwo: " + pointTwo.toString());

		// somePoint is defined as singleton(default) inside context
		logger.info("loading singleton scoped point bean");
		Point pointThree = context.getBean("somePoint", Point.class);
		Point pointFour = context.getBean("somePoint", Point.class);
		logger.info("pointThree: " + pointThree.toString());
		logger.info("pointFour: " + pointFour.toString());
		logger.info("Updating pointThree's x value to 120");
		pointThree.setX(120);
		logger.info("pointThree: " + pointThree.toString());
		logger.info("pointFour: " + pointFour.toString());
	}
}