package com.tedu.lucene;

import java.io.File;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class LuceneTest {

	@Test
	public void createIndex() throws Exception{
		//1.指定保存索引的文件夹
		File file=new File("./index");
		Directory directory=FSDirectory.open(file);
		
		//2.指定中文分词框架,IKAnalyzer是中国人开发的
		Analyzer analyzer=new IKAnalyzer();
		//3.设置配置信息
		IndexWriterConfig config=new IndexWriterConfig(Version.LUCENE_4_10_2, analyzer);
		//4.创建写索引对象(包含outputStream)
		IndexWriter indexWriter = new IndexWriter(directory, config);
		//5.添加的数据脚document
		Document document = new Document();
		//6.document中包含field,设置一行数据中的每个属性
		document.add(new LongField("id", 15648315, Store.YES));
		document.add(new StringField("title", "的会计师费is的开发商垫付", Store.YES));
		document.add(new TextField("sellPoint","的近似", Store.YES));
		document.add(new LongField("price", 4585145, Store.YES));
		//7.写索引
		indexWriter.addDocument(document);
		//8.关闭写对象
		indexWriter.close();
	}
	@Test
	public void seracher() throws Exception{
		//1,指定保存数据的文件夹
		Directory directory = FSDirectory.open(new File("./index"));
		//2,创建读对象
		IndexReader indexReader=IndexReader.open(directory);
		//3,创建检索对象
		IndexSearcher indexSearcher = new IndexSearcher(indexReader);
		//4,指定查询关键字
		Query query = new TermQuery(new Term("sellPoint", "love"));
		//Query query = new TermQuery(new Term("sellPoint", "小米"));
		//5,执行查询
		//查询  results 表示最顶端的20条记录数
		TopDocs docs  = indexSearcher.search(query, 20);
		//访问总数
		System.out.println("数据访问的总数:"+docs.totalHits);
		//6遍历查询结果
//scoreDocs 
//scoreDoc是个docuement
//scoreDoc是对document封装 例子 list,arrayList,linkedList
//score成绩
		for ( ScoreDoc scoreDoc : docs.scoreDocs) {
			System.out.println("获取文章的得分:"+scoreDoc.score);  //分数越高 越靠前
				int index = scoreDoc.doc; //获取索引值
				//获取文章内容     
				Document document = indexSearcher.doc(index);
				//输出文章内容
				System.out.println("标题:"+document.get("title"));
				System.out.println("卖点:"+document.get("sellPoint"));
				System.out.println("价格:"+document.get("price"));
				System.out.println("id为:"+document.get("id"));	
		}
		//7,关闭资源
		directory.close();
	}

}
