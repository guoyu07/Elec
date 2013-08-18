package com.gs.util;

import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.net.SMTPAppender;

public class LogToMail {
	static Logger logger = Logger.getLogger(LogToMail.class);
	SMTPAppender appender = new SMTPAppender();
	private MyDate m;

	public LogToMail() {
		try {
			appender.setSMTPUsername("gsh199449");
			appender.setSMTPPassword("computer");
			appender.setTo("gsh199449@126.com");
			appender.setFrom("gsh199449@126.com");
			// SMTP·þÎñÆ÷ smtp.163.com
			appender.setThreshold(Level.ALL);
			appender.setSMTPHost("smtp.126.com");
			appender.setSMTPPort(25);
			appender.setLocationInfo(true);
			appender.setSubject("Log From Elec   " + new Date().toLocaleString());
			appender.setLayout(new PatternLayout());
			appender.activateOptions();
			logger.addAppender(appender);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Printing ERROR Statements", e);
		}
	}

	public void error(Exception e) {
		logger.error(e.getMessage());
	}
	public void info(String s){
		logger.error(s);
	}
	
	public void mail(){
		JavaMail jm = new JavaMail();
		jm.doSendHtmlEmail("head", "HW", "63388@qq.com");
	}
}
