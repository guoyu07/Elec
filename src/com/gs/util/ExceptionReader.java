package com.gs.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Date;

public class ExceptionReader {
	public String s;
	private String temp;
	private MyDate m = new MyDate();
	private ExceptionToFile ef = new ExceptionToFile();
	private File file;
	private File logFile;

	public ExceptionReader() {
		try {
			File file = new File(m.getDate() + ".log");
			logFile = new File(file.getAbsoluteFile().getParentFile().getParentFile()+"\\webapps\\Elec\\logs\\"+m.getDate() + ".log");
			s = s + "File Name : " + logFile.getName() + "<br>";
		} catch (Exception e1) {
			ef.print(e1);
			e1.printStackTrace();
		}
		try {
			FileReader fr = new FileReader(logFile);
			BufferedReader br = new BufferedReader(fr);
			while ((temp = br.readLine()) != null) {
				s = s + temp + "\n";
			}

		} catch (FileNotFoundException e) {
			ef.print(e);
			e.printStackTrace();
		} catch (IOException e) {
			ef.print(e);
			e.printStackTrace();
		}
	}
	
	public String read(int date){
		String re = new String();
		try {
			file = new File("..\\webapps\\Elec\\logs\\Elec"
					+ date + ".log");
			re = re + "File Name : " + file.getName() + "<br>";
		} catch (Exception e1) {
			ef.print(e1);
			e1.printStackTrace();
		}
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			while ((temp = br.readLine()) != null) {
				re = re + temp + "\n";
			}

		} catch (FileNotFoundException e) {
			ef.print(e);
			e.printStackTrace();
		} catch (IOException e) {
			ef.print(e);
			e.printStackTrace();
		}
		return re;
	}

}
