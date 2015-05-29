package com.krishnan.balaji.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import com.krishnan.balaji.utils.DrawEvent;


public class Circle implements Shape,ApplicationEventPublisherAware {
	final static Logger logger = LoggerFactory.getLogger(Circle.class);
	private Point center;
	private int radius;
	private ApplicationEventPublisher publisher;

	public String draw() {
		publisher.publishEvent(new DrawEvent(this,"draw circle event"));
		return "drawing a circle with radius "+ radius + " and center " + center;
	}

	public Point getCenter() {
		return center;
	}

	@Resource
	public void setCenter(Point center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public double circumference() {
		return Math.PI*2*radius*radius;
	}
	
	@PostConstruct
	public void initialize(){
		logger.info("@postconstruct method of circle called");
	}
	
	@PreDestroy
	public void destroy(){
		logger.info("@predestroy method of circle called");
	}


	public void setApplicationEventPublisher(ApplicationEventPublisher arg0) {
		this.publisher=arg0;
		
	}

}
