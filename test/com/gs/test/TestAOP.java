package com.gs.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gs.action.ElecAction;

public class TestAOP {

	@Test
	public void test() throws IOException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"beans.xml");

		ElecAction e = (ElecAction) ctx.getBean("elecAction");
		e.index();
	}

}
