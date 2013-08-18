package com.gs.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestJavaMail {

	@Test
	public void test() {
		JavaMail jm= new JavaMail();
		jm.doSendHtmlEmail("Hello", "HW", "63388@qq.com");
	}

}
