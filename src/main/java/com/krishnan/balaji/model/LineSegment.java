package com.krishnan.balaji.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class LineSegment implements InitializingBean, DisposableBean {
	final static Logger logger = LoggerFactory.getLogger(LineSegment.class);
	private Point pointA;
	private Point pointB;

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}


	public void afterPropertiesSet() throws Exception {
		logger.info("LineSetment afterPropertiesSet() called");
	}

	public void setUp() {
		logger.info("LineSetment setUp() called");
	}

	/**
	 * Destroy method is not called for beans of scope prototype. This is
	 * because the context doesn't keep track of the prototype scope objects (if
	 * it does, it will cause a memory leak as spring doesn't know when to
	 * dispose it).
	 */
	public void tearDown() {
		logger.info("LineSetment tearDown() called");
	}

	public void destroy() throws Exception {
		logger.info("LineSegment destroy() called.");
	}
}