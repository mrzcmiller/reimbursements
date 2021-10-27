package com.revature.reimbursements.log;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import com.revature.reimbursements.application.Application;

public class Logging {
	final Logger log = LogManager.getLogger(Application.class);
	ConsoleAppender consoleAppender = new ConsoleAppender();
	
	public Logging(ConsoleAppender consoleAppender) {
		super();
		this.consoleAppender = consoleAppender;
		getLogging();
	}

	public void getLogging() {
		consoleAppender.setThreshold(Level.INFO);
		consoleAppender.setLayout(new PatternLayout("%d [%p]: [%c[%C(1)] %m%n"));
		consoleAppender.activateOptions();
		Logger.getRootLogger().addAppender(consoleAppender);
	}
	
	
}
