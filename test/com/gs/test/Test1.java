package com.gs.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gs.DAO.ElecDAO;
import com.gs.chart.MakeChart;
import com.gs.exception.DontHaveThatDayException;
import com.gs.lucene.Indexer;
import com.gs.lucene.Searcher;
import com.gs.model.Elec;
import com.gs.service.ElecService;
import com.gs.util.ExceptionReader;
import com.gs.util.ExceptionToFile;
import com.gs.util.LogToMail;
import com.gs.util.MailReporter;
import com.gs.util.MyDate;

public class Test1 {

	private List<Elec> elecs;

	@Test
	public void test() throws IOException {
		MakeChart m = new MakeChart();
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"beans.xml");
		ElecDAO ed = (ElecDAO) ctx.getBean("elecDAO");
		elecs = ed.search(7);
		//m.make(elecs);
	}

	@Test
	public void testSearch() throws IOException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"beans.xml");
		ElecDAO ed = (ElecDAO) ctx.getBean("elecDAO");
		System.out.println(ed.search(7));
		/*
		 * Elec e1 = new Elec(); e1.setElecnum(10); e1.setDay(0);
		 * e1.setMonth(0); e1.setYear(0); e1.setDate(0); ed.save(e1);
		 */
	}

	@Test
	public void testSave() throws IOException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"beans.xml");
		ElecDAO ed = (ElecDAO) ctx.getBean("elecDAO");
		Elec e1 = new Elec();
		e1.setMonth(7);
		e1.setYear(2013);
		e1.setDay(31);
		e1.setDate(20130731);
		e1.setElecnum(15);
			ed.save(e1);
	}

	@Test
	public void testre() throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"beans.xml");
		ElecService es = (ElecService) ctx.getBean("elecService");
		ElecDAO ed = (ElecDAO) ctx.getBean("elecDAO");
		Elec e = es.getBefore(20130512);
	//	e.setUsed(3);
		//ed.checkElecWithDate(20130714);
		System.out.println(e.getDate());

	}
	
	@Test
	public void testlog(){
		LogToMail log = new LogToMail();
		log.info("hfksflnalknasfnaln");
	}
	
	@Test
	public void testMylog() {
		Logger log;
		log = Logger.getLogger("mylog");
		log.error("erroe!");
		log.info("info");
		log.debug("de");
	}
	@Test
	public void testReport(){
		MailReporter mr = new MailReporter();
		mr.reportExceptionByDate(20130728);
	}
	
	@Test
	public void testExReader(){
		ExceptionReader er = new ExceptionReader();
		
	}
	
	@Test
	public void testdown(){
		DownloadWebPage d = new DownloadWebPage();
		d.down();
		
	}
	
	@Test
	public void testLucene(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"beans.xml");
		Indexer i = (Indexer) ctx.getBean("indexer");
		i.index();
		
	}
	
	@Test
	public void testSearcher(){
		Searcher s = new Searcher();
		s.search("20130820");
	}
	
	@Test
	public void test2File(){
		ExceptionToFile etf = new ExceptionToFile();
		etf.print(new Exception("Hello World!"));
	}
}
