package com.gs.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gs.DAO.ElecDAO;
import com.gs.model.Elec;

public class Export2Excel {
	public static String fileToBeWrite = "D:\\test.xls";
	public static ElecDAO dao;
	public static List<Elec> elecs;

	public static void main(String[] args) {
		try {
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet();
			get();
			elecs = dao.getElecs();
			HSSFRow row = sheet.createRow(0);
			row.createCell(0).setCellValue("日期");
			row.createCell(1).setCellValue("當天電量");
			row.createCell(2).setCellValue("充值");
			row.createCell(3).setCellValue("使用");
			for (int j = 0; j < elecs.size(); j++) {
				Elec e = elecs.get(j);
				System.out.println(e);
				row = sheet.createRow(j+1);
				row.createCell(0).setCellValue(e.getDate());
				row.createCell(1).setCellValue(e.getElecnum());
				row.createCell(2).setCellValue(e.getInputelec());
				row.createCell(3).setCellValue(e.getUsed());
			}
			FileOutputStream fileOut = new FileOutputStream(fileToBeWrite);
			workbook.write(fileOut);
			fileOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	public static void get() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"beans.xml");
		dao = (ElecDAO) ctx.getBean("elecDAO");
	}

}
