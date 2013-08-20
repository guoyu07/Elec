package com.gs.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Date;

import org.apache.commons.io.monitor.FileEntry;

public class ExceptionToFile {
	private PrintStream ps;
	private MyDate m = new MyDate();

	public ExceptionToFile() {
		File file = new File(m.getDate() + ".log");
		System.out.println(file.getAbsoluteFile().getParentFile());

		File logFile = new File(file.getAbsoluteFile().getParentFile().getParentFile()+"\\webapps\\Elec\\logs\\"+m.getDate() + ".log");
		System.out.println("WRITE"+logFile.getAbsolutePath());
		/*File file = new File("..\\webapps\\Elec\\logs\\" + m.getDate() + ".log");*/
		OutputStream out = null;
		try {
			out = new FileOutputStream(logFile, true);
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
