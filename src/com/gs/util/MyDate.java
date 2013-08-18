package com.gs.util;

import java.util.Calendar;

import org.springframework.stereotype.Component;

import com.gs.exception.DontHaveThatDayException;

@Component("myDate")
public class MyDate {
	private int year;
	private int month;
	private int day;
	private int date;
	private Calendar c = Calendar.getInstance();

	public MyDate() {
		this.year = c.get(Calendar.YEAR);
		this.month = c.get(Calendar.MONTH) + 1;
		this.day = c.get(Calendar.DATE);
		if (month >= 10 && day >= 10)
			this.date = Integer.parseInt((c.get(Calendar.YEAR) + ""
					+ (c.get(Calendar.MONTH) + 1) + c.get(Calendar.DATE))
					.toString());
		else if (month < 10 && day >= 10)
			this.date = Integer.parseInt((c.get(Calendar.YEAR) + "0"
					+ (c.get(Calendar.MONTH) + 1) + c.get(Calendar.DATE))
					.toString());
		else if (month < 10 && day < 10)
			this.date = Integer.parseInt((c.get(Calendar.YEAR) + "0"
					+ (c.get(Calendar.MONTH) + 1) + "0" + c.get(Calendar.DATE))
					.toString());
		else if (month >= 10 && day < 10)
			this.date = Integer.parseInt((c.get(Calendar.YEAR)
					+ (c.get(Calendar.MONTH) + 1) + "0" + c.get(Calendar.DATE))
					.toString());

	}

	public MyDate(int date) throws Exception {
		this.date = date;
		Integer d = new Integer(date);
		int year, month, day;
		year = Integer.parseInt(d.toString().substring(0, 4));
		month = Integer.parseInt(d.toString().substring(4, 6));
		day = Integer.parseInt(d.toString().substring(6, 8));
		this.setYear(year);
		this.setMonth(month);
		this.setDay(day);
		if (!this.isCorrect())
			throw new Exception();
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public String toString() {
		return "Year = " + this.year + "month = " + this.month + "day = "
				+ this.day;
	}

	public boolean isCorrect() {
		boolean correct = false;
		if (month > 12 || month < 1)
			return false;
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
				|| month == 10 || month == 12) {
			if (day >= 1 && day <= 31) {
				correct = true;
			}
		} else if (day >= 1 && day <= 30)
			correct = true;
		return correct;
	}

	public MyDate getBefore() throws Exception { // 一旦跨年会产生问题！！！！
		MyDate m = new MyDate(date);
		if (this.day == 1 && this.month != 1) {
			if (month == 1 || month == 3 || month == 5 || month == 7
					|| month == 8 || month == 10 || month == 12) {
				m.setYear(year);
				m.setMonth(month - 1);
				m.setDay(31);
				m.setDate(makeDate(m.getYear(),m.getMonth(),m.getDay()));
			} else {
				m.setYear(year);
				m.setMonth(month - 1);
				m.setDay(30);
				m.setDate(makeDate(m.getYear(),m.getMonth(),m.getDay()));
			}

		} else if (this.day != 1 && this.month != 1) {
			m.setYear(year);
			m.setMonth(month);
			m.setDay(day - 1);
			m.setDate(makeDate(m.getYear(),m.getMonth(),m.getDay()));
		} else if (this.day == 1 && this.month == 1) {
			m.setYear(year - 1);
			m.setMonth(12);
			m.setDay(31);
			m.setDate(makeDate(m.getYear(),m.getMonth(),m.getDay()));
		}
		return m;
	}

	public int makeDate(int year, int month, int day) {
		int da = 0;
		if (month >= 10 && day >= 10)
			da = Integer.parseInt((year + "" + (month) + day).toString());
		else if (month < 10 && day >= 10)
			da = Integer.parseInt((year + "0" + (month) + day).toString());
		else if (month < 10 && day < 10)
			da = Integer
					.parseInt((year + "0" + (month) + "0" + day).toString());
		else if (month >= 10 && day < 10)
			da = Integer.parseInt((year + (month) + "0" + day).toString());
		return da;
	}
}
