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
		 * ����Directory����IndexReader����IndexReader����IndexSearcher����������Query
		 * ����parse������Ҫ���������ݸ���Searcher����������TopDocs���ĵ�����TopDocs��ȡSocoreDocs����
		 * ����Searcher��SocoreDocs��ȡ�����Document�������Document�����ȡ��Ҫ��ֵ�ر�Reader
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
				System.out.println("����:" + d.get("date") + "����:"
						+ d.get("elecnum") + "����:" + d.get("used"));
				result = "����:" + d.get("date") + "\n����:"
						+ d.get("elecnum") + "\n����:" + d.get("used");
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
