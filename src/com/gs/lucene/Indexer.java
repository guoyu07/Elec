package com.gs.lucene;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.NumericField;
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
			List<Elec> list = elecservice.getElecs();
			for (int i = 0; i < list.size(); i++) {
				Elec elec = (Elec) list.get(i);
				doc = new Document();
				doc.add(new NumericField("elecnum",Field.Store.YES, true).setIntValue(elec.getElecnum()));
				doc.add(new NumericField("used",Field.Store.YES, true).setIntValue(elec.getUsed()));
				doc.add(new NumericField("date",Field.Store.YES, true).setIntValue(elec.getDate()));
				writer.addDocument(doc);
			}
			writer.close();
		} catch (CorruptIndexException e) {
			e.printStackTrace();
		} catch (LockObtainFailedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
