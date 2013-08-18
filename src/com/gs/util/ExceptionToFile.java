package com.gs.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Date;

public class ExceptionToFile {
	private PrintStream ps;
	private MyDate m = new MyDate();

	public ExceptionToFile() {
		File file = new File("..\\webapps\\Elec\\logs\\" + m.getDate() + ".log");
		OutputStream out = null;
		try {
			out = new FileOutputStream(file, true);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ps = new PrintStream(out);

	}

	public void print(Exception e) {
		ps.print("\n\n");
		ps.print("<br>"+new Date().toLocaleString()
				+ "++++++++++++++++++++++++++++++++++++++++++++++++++ <br>");
		e.printStackTrace(ps);
	}
}
