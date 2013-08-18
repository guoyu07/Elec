package com.gs.util;

public class MailReporter {
	private ExceptionReader er = new ExceptionReader();
	private JavaMail jm = new JavaMail();
	private static String MAILADDR = "63388@qq.com";
	public void reportExceptionByDate(int date){
		jm.doSendHtmlEmail("Exception Report", er.read(date),MAILADDR );
	}
	public void reportMsg(String s){
		jm.doSendHtmlEmail("Report", s,MAILADDR );
	}
}
