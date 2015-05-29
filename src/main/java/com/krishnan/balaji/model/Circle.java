package com.krishnan.balaji.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Circle implements Shape {
	final static Logger logger = LoggerFactory.getLogger(Circle.class);
	private Point center;
	private int radius;

	public String draw() {
		return "drawing a circle with radius "+ radius + " and center " + center;
	}

	public Point getCenter() {
		return center;
	}

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

}
