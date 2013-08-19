package com.gs.chart;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.stereotype.Component;

import com.gs.model.Elec;
/**
 * @author GaoShen
 * @packageName com.gs.chart
 */
@Component("makeChart")
public class MakeChart {
	private List<Elec> elecs;
	private Elec e;

	public List<Elec> getElecs() {
		return elecs;
	}

	public void setElecs(List<Elec> elecs) {
		this.elecs = elecs;
	}

	public CategoryDataset getDataSet() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		Iterator<Elec> iter = elecs.iterator();
		for (;iter.hasNext();) {
			e = iter.next();
			Integer day = e.getDay();
			dataset.addValue((double)e.getUsed(), "Apple", day.toString());
		}
		return dataset;
	}
	
	public void make(List<Elec> elecs) throws Exception{
			setElecs(elecs);
	        JFreeChart chart;
			try {
				chart = ChartFactory.createLineChart("Yong Dian Liang", // 图表标题
						"Ri Qi", // 目录轴的显示标签
						"Dang Tian Yong Liang", // 数值轴的显示标签
						getDataSet(), // 数据集
						PlotOrientation.VERTICAL, // 图表方向：水平、垂直
						false, // 是否显示图例(对于简单的柱状图必须是 false)
						false, // 是否生成工具
						false // 是否生成 URL 链接
						);
			} catch (Exception e) {
				throw e;
			} 
	                           
	        FileOutputStream fos_jpg = null; 
	        try { 
	            fos_jpg = new FileOutputStream("..\\webapps\\Elec\\image\\chart3333.jpg"); 
	           System.out.println("============"+fos_jpg.getChannel());
	            ChartUtilities.writeChartAsJPEG(fos_jpg,1.0f,chart,500,400,null); 
	        } finally { 
	            try { 
	                fos_jpg.close(); 
	            } catch (Exception e) {
	            	throw e;
	            } 
	            System.out.println("OK!");
	        } 
	}
}
