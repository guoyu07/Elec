package com.gs.util;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.gs.action.ElecAction;
import com.gs.chart.MakeChart;
@Component
public class TestAOP {

	@Test
	public void test() throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"beans.xml");

		ElecAction e = (ElecAction)ctx.getBean("elecAction");
		e.makeChart();
	}

}
