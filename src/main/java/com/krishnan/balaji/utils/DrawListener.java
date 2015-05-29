package com.krishnan.balaji.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DrawListener implements ApplicationListener<DrawEvent> {
	static final Logger logger = LoggerFactory.getLogger(DrawListener.class);

	public void onApplicationEvent(DrawEvent arg0) {
		logger.info("Draw Listener: " + arg0.toString());
	}

}
