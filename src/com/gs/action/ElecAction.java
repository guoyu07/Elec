package com.gs.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.gs.chart.MakeChart;
import com.gs.exception.DontHaveThatDayException;
import com.gs.lucene.Searcher;
import com.gs.model.Elec;
import com.gs.service.ElecService;
import com.gs.test.DownloadWebPage;
import com.gs.util.ExceptionReader;
import com.gs.util.ExceptionToFile;
import com.gs.util.JavaMail;
import com.gs.util.LogToMail;
import com.gs.util.MailReporter;
import com.gs.util.MyDate;
import com.gs.util.MyLogger;

@Component("elecAction")
@Scope("prototype")
public class ElecAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware, SessionAware {
	private Elec current;
	private int date;
	private int day;
	private Elec elec;
	private int elecnum;
	private List<Elec> elecs;
	private ElecService ElecService;
	private int month;
	private MyDate myDate;
	private String tips;
	private String warning;
	private int year;
	private int inputelec;
	private JavaMail jm = new JavaMail();
	private Logger log  = Logger.getLogger("mylogger");
	/*private ExceptionToFile ef = new ExceptionToFile();*/
	private ExceptionReader er = new ExceptionReader();
	private int used;
	private static String MAILADDR = "63388@qq.com";
	private HttpServletRequest httpServletRequest;
	private String result;
	
	public int getInputelec() {
		return inputelec;
	}

	public void setInputelec(int inputelec) {
		this.inputelec = inputelec;
	}

	public String delete() {
		if (ElecService.delete(date))
			return SUCCESS;
		else
			return "fail";
	}

	public Elec getCurrent() {
		return current;
	}

	public int getDate() {
		return date;
	}

	public int getDay() {
		return day;
	}

	public Elec getElec() {
		return elec;
	}

	public int getElecnum() {
		return elecnum;
	}

	public List<Elec> getElecs() {
		return elecs;
	}

	public ElecService getElecService() {
		return ElecService;
	}

	public int getMonth() {
		return month;
	}

	public MyDate getMyDate() {
		return myDate;
	}

	public String getTips() {
		return tips;
	}

	public String getWarning() {
		return warning;
	}

	public int getYear() {
		return year;
	}

	public String index() throws IOException {
		report();
		return SUCCESS;
	}

	public String list() {
		this.elecs = ElecService.getElecs();
		return "list";
	}

	public String makeChart() throws IOException {
		System.out.println("=================" + month);
		MakeChart m = new MakeChart();
		try {
			elecs = ElecService.search(month);
			m.make(ElecService.search(month));
		} catch (Exception e) {
			//ef.print(e);
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}

	public String regist() throws Exception {
		try {
			elec = new Elec();
			elec.setDay(myDate.getDay());
			elec.setElecnum(elecnum);
			elec.setMonth(myDate.getMonth());
			elec.setYear(myDate.getYear());
			elec.setDate(myDate.getDate());
			elec.setInputelec(inputelec);
			used = 0;
			Elec be = ElecService.getBefore(myDate.getDate());
			if (elecnum < be.getElecnum()) {
				used = be.getElecnum() - elecnum; // 一般情況，或者先讀數后充值
			} else {
				System.out.println("fefore use");
				used = be.getElecnum() - (elecnum - inputelec); // 先充值后度數
				System.out.println("after use");
			}
			elec.setUsed(used);
			ElecService.save(elec);
		} catch (org.hibernate.exception.ConstraintViolationException e) {
			return "havedone";
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			return "havedone";
		}
		jm.doSendHtmlEmail("今日电量已输入", "Today elecnum = " + elecnum
				+ "  used = " + used + "  input = " + inputelec, MAILADDR);
		return SUCCESS;
	}

	public String registPast() throws Exception {
		try {
			System.out.println("==================" + elecnum);
			elec = new Elec();
			elec.setDate(date);
			elec.setElecnum(elecnum);
			MyDate m = new MyDate(date);
			if (!m.isCorrect()) {
				return "donthaveday";
			}
			elec.setDay(m.getDay());
			elec.setMonth(m.getMonth());
			elec.setYear(m.getYear());

			try {
				ElecService.save(elec);
			} catch (Exception e) {
				throw e;
			}
		} catch (org.hibernate.exception.ConstraintViolationException e) {
			return "havedone";
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			return "havedone";
		}
		return SUCCESS;
	}

	public String search() {
		try {
			/*elec = ElecService.loadElec(date);*/
			Searcher searcher = new Searcher();
			result = searcher.search(String.valueOf(date));
			
		} catch (Exception e) {
			return "fail";
		}
		return SUCCESS;
	}
	
	public String tips() {
		MyDate m = new MyDate();
		current = ElecService.getCurrent();
		tips = "截止到" + current.getYear() + "年" + current.getMonth() + "月"
				+ current.getDay() + "日，剩余电量为：" + current.getElecnum();
		if (current.getElecnum() < 100)
			warning = "当前可用电量已不足100，请及时充值！";
		DownloadWebPage d = new DownloadWebPage();
		d.down();
		return SUCCESS;
	}
	

	public void report() {
		jm.doSendHtmlEmail("Elec客户端已登录！",
				"Elec客户端已登录！登录时间为：" + new Date().toLocaleString() + "<br>"
						+ "<br><br><br>Exception Report<br>" + er.s, MAILADDR);
	}
	
	public String reportByDate(){
		MailReporter mr = new MailReporter();
		myDate = new MyDate();
		mr.reportExceptionByDate(myDate.getDate());
		return SUCCESS;
	}
	public void setCurrent(Elec current) {
		this.current = current;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public void setElec(Elec elec) {
		this.elec = elec;
	}

	public void setElecnum(int elecnum) {
		this.elecnum = elecnum;
	}

	public void setElecs(List<Elec> elecs) {
		this.elecs = elecs;
	}

	@Resource
	public void setElecService(ElecService ElecService) {
		this.ElecService = ElecService;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	@Resource
	public void setMyDate(MyDate myDate) {
		this.myDate = myDate;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.httpServletRequest = arg0;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {

	}

	@Override
	public void setSession(Map<String, Object> arg0) {

	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	public void setWarning(String warning) {
		this.warning = warning;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String update() {
		try {
			elec = ElecService.loadElec(date);
		} catch (Exception e) {
			return "fail";
		}
		return "update";
	}

	public String updateDo() {
		try {
			Elec e = new Elec();
			e.setDate(0);
			e.setDay(0);
			e.setElecnum(elecnum);
			e.setMonth(0);
			e.setYear(0);
			ElecService.update(e);
		} catch (Exception e) {
			e.printStackTrace();
			 return "fail";
		}
		return "success";
	}

}
