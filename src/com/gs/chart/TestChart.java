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
                           "Dian Fei", // 图表标题
                           "Ri Qi", // 目录轴的显示标签
                           "Dang Tian Dian Liang", // 数值轴的显示标签
                            dataset, // 数据集
                            PlotOrientation.VERTICAL, // 图表方向：水平、垂直
                            true,  // 是否显示图例(对于简单的柱状图必须是 false)
                            true, // 是否生成工具
                            false  // 是否生成 URL 链接
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
    * 获取一个演示用的简单数据集对象
    * @return 
    */ 
    private static CategoryDataset getDataSet() { 
        DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
        dataset.addValue(100, null, "苹果"); 
        dataset.addValue(200, null, "梨子"); 
        dataset.addValue(300, null, "葡萄"); 
        dataset.addValue(400, null, "香蕉"); 
        dataset.addValue(500, null, "荔枝"); 
        return dataset; 
    } 
    /** 
    * 获取一个演示用的组合数据集对象
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