package com.gs.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Writer;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;

public class DownloadWebPage {
	public String down() {
		String r = new String();
		HttpClient hc = new HttpClient();
		GetMethod get = new GetMethod("http://news.qq.com");
		try {
			int code = hc.executeMethod(get);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			hc.executeMethod(get);
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		try {
			r = get.getResponseBodyAsString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		get.releaseConnection();
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("..\\webapps\\Elec\\news.htm"));
			bw.write(r);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return r;
	}
}
