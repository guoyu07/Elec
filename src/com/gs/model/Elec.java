package com.gs.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author GaoShen
 * @packageName com.gs.model
 */
@Entity
@Table(name = "elec")
@org.hibernate.annotations.Proxy(lazy = false)
public class Elec {
	private int year;
	private int month;
	private int day;
	private int date;
	private int elecnum;
	private int used;
	private int inputelec;

	public int getInputelec() {
		return inputelec;
	}

	public void setInputelec(int inputelec) {
		this.inputelec = inputelec;
	}

	public int getUsed() {
		return used;
	}

	public void setUsed(int used) {
		this.used = used;
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

	@Id
	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getElecnum() {
		return elecnum;
	}

	public void setElecnum(int elecnum) {
		this.elecnum = elecnum;
	}

	@Override
	public String toString() {
		String re;
		re = getDate() + "  " + getElecnum();
		return re;
	}
}
