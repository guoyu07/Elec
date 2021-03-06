package com.gs.lucene;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.wltea.analyzer.lucene.IKAnalyzer;

/**
 * @author GaoShen
 * @packageName com.gs.Lucene
 */
public class Searcher {

	private String indexField = "D:\\Lucene\\indexes\\databaseIndexes";

	/**
	 * @param queryString
	 */

	public String search(String queryString) {
		/*
		 * 创建Directory创建IndexReader根据IndexReader创建IndexSearcher创建搜索的Query
		 * 创建parse来创建要搜索的内容根据Searcher搜索并返回TopDocs的文档根据TopDocs获取SocoreDocs对象
		 * 根据Searcher和SocoreDocs获取具体的Document对象根据Document对象获取需要的值关闭Reader
		 */
		String result = new String();
		try {
			File path = new File(indexField);
			Directory directory = FSDirectory.open(path);
			IndexReader reader = IndexReader.open(directory);
			IndexSearcher seacher = new IndexSearcher(reader);
			/*Query q = new TermQuery(new Term("date", queryString));*/
			QueryParser query = new QueryParser(Version.LUCENE_35, "date", new StandardAnalyzer(Version.LUCENE_35));
			Query q = query.parse(queryString);
			TopDocs td = seacher.search(q, 10);
			ScoreDoc[] sds = td.scoreDocs;
			for (ScoreDoc sd : sds) {
				Document d = seacher.doc(sd.doc);
				System.out.println("日期:" + d.get("date") + "电量:"
						+ d.get("elecnum") + "用量:" + d.get("used"));
				result = "日期:" + d.get("date") + "\n电量:"
						+ d.get("elecnum") + "\n用量:" + d.get("used");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}
