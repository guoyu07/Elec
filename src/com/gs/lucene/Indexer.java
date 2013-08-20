package com.gs.lucene;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.LockObtainFailedException;
import org.apache.lucene.util.Version;
import org.springframework.stereotype.Component;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.gs.model.Elec;
import com.gs.service.ElecService;

/**
 * @author GaoShen
 * @packageName com.gs.Lucene
 */
@Component("indexer")
public class Indexer {

	private String indexField = "D:\\Lucene\\indexes\\databaseIndexes";
	private String encoding = "GB2312";
	private ElecService elecservice;

	/**
	 * @return the elecservice
	 */
	public ElecService getElecservice() {
		return elecservice;
	}

	/**
	 * @param elecservice
	 *            the elecservice to set
	 */
	@Resource
	public void setElecservice(ElecService elecservice) {
		this.elecservice = elecservice;
	}

	/**
	 * @auth GaoShen
	 */
	public void index() {
		try {
			Directory directory = FSDirectory.open(new File(indexField));
			IndexWriterConfig conf = new IndexWriterConfig(Version.LUCENE_35,
					new IKAnalyzer());
			IndexWriter writer = new IndexWriter(directory, conf);
			Document doc;
			List list = elecservice.getElecs();
			Iterator<Elec> it = list.iterator();
			for (int i = 0; i < list.size(); i++) {
				// System.out.println(file.getName());
				Elec elec = (Elec) list.get(i);
				doc = new Document();
				doc.add(new Field("elecnum", String.valueOf(elec.getElecnum()),
						Field.Store.YES, Field.Index.ANALYZED));
				doc.add(new Field("used", String.valueOf(elec.getUsed()),
						Field.Store.YES, Field.Index.NOT_ANALYZED));
				doc.add(new Field("date", String.valueOf(elec.getDate()),
						Field.Store.YES, Field.Index.NOT_ANALYZED));
				writer.addDocument(doc);
			}
			writer.close();
			// 为Document锟斤拷锟紽iled锟斤拷锟斤拷
			// 通锟斤拷IndexWriter锟斤拷锟斤拷牡锟斤拷锟斤拷锟斤拷锟�
		} catch (CorruptIndexException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LockObtainFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
