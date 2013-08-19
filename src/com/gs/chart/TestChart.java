package com.gs.chart;

import java.io.*; 
import org.jfree.data.*; 
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.*; 
import org.jfree.chart.plot.*; 


/**
 * @author GaoShen
 * @packageName com.gs.chart
 */
public class TestChart { 
    public static void main(String[] args) throws IOException{ 
        CategoryDataset dataset = getDataSet2(); 
        JFreeChart chart = ChartFactory.createLineChart( 
                           "Dian Fei", // ͼ�����
                           "Ri Qi", // Ŀ¼�����ʾ��ǩ
                           "Dang Tian Dian Liang", // ��ֵ�����ʾ��ǩ
                            dataset, // ���ݼ�
                            PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ
                            true,  // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������ false)
                            true, // �Ƿ����ɹ���
                            false  // �Ƿ����� URL ����
                            ); 
                           
        FileOutputStream fos_jpg = null; 
        try { 
            fos_jpg = new FileOutputStream("D:\\fruit.jpg"); 
            ChartUtilities.writeChartAsJPEG(fos_jpg,1.0f,chart,500,400,null); 
        } finally { 
            try { 
                fos_jpg.close(); 
            } catch (Exception e) {} 
            System.out.println("OK!");
        } 
    } 
    /** 
    * ��ȡһ����ʾ�õļ����ݼ�����
    * @return 
    */ 
    private static CategoryDataset getDataSet() { 
        DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
        dataset.addValue(100, null, "ƻ��"); 
        dataset.addValue(200, null, "����"); 
        dataset.addValue(300, null, "����"); 
        dataset.addValue(400, null, "�㽶"); 
        dataset.addValue(500, null, "��֦"); 
        return dataset; 
    } 
    /** 
    * ��ȡһ����ʾ�õ�������ݼ�����
    * @return 
    */ 
    private static CategoryDataset getDataSet2() { 
        DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
        dataset.addValue(1, "Apple","20130705" ); 
        dataset.addValue(2, "Apple","20130706" ); 
        dataset.addValue(300,"Apple", "20130707"); 
        dataset.addValue(4, "Apple","20130708"); 
        dataset.addValue(5, "Apple","20130709"); 
        return dataset; 
    } 
} 