package com.gs.util;

import org.springframework.stereotype.Component;

@Component
public class TestWithMain {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		MyDate m=  new MyDate(20130712);
		m.getDay();
		System.out.println(m.getMonth());
		
	}

}
