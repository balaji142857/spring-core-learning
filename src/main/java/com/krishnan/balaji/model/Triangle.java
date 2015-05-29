package com.krishnan.balaji.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

public class Triangle implements Shape {

	private Point a, b, c;
	static final Logger logger = LoggerFactory.getLogger(Triangle.class);

	public String draw() {
		return "Drawing a triangle with vertices at " + a + ", " + b
				+ ", " + c;
	}

	public Point getA() {
		return a;
	}

	@Required
	public void setA(Point a) {
		this.a = a;
	}

	public Point getB() {
		return b;
	}

	@Required
	public void setB(Point b) {
		this.b = b;
	}

	public Point getC() {
		return c;
	}

	@Autowired
	public void setC(Point c) {
		this.c = c;
	}

	public double circumference() {
		// TODO use spring to obtain beans
		LineSegment ab = new LineSegment();
		ab.setPointA(a);
		ab.setPointB(b);
		LineSegment bc = new LineSegment();
		bc.setPointA(b);
		bc.setPointB(c);
		LineSegment ca = new LineSegment();
		ca.setPointA(c);
		ca.setPointB(a);
		return ab.length() + bc.length() + ca.length();
	}

}
