package myServelet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexOptions;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.postingshighlight.PostingsHighlighter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class WSDMSearch {
	static String indexDir_content = "D:/Eclipse/EclipseWorkspace/Search_Engine/files/WSDM/index_content";
	static String indexDir_title = "D:/Eclipse/EclipseWorkspace/Search_Engine/files/WSDM/index_title";
	static String indexDir_author = "D:/Eclipse/EclipseWorkspace/Search_Engine/files/WSDM/index_author";
	static String indexDir_abstract = "D:/Eclipse/EclipseWorkspace/Search_Engine/files/WSDM/index_abstract";
	static String filesDir_content = "D:/Eclipse/EclipseWorkspace/Search_Engine/files/WSDM/fset_content";
	static Analyzer textAnalyzer;
	static int len = 0;
	//len是一共搜索多少条

	public static void main(String[] args) {
		String content;
		try {
			content = clickTitle("2009_Measuring the Similarity between Implicit Semantic");
			System.out.println(content);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		
//		String result[][];
//		try {
//			result = t.search_content("Tom");
//			for (int i = 0; i < len; i++) {
//				System.out.println(result[i][0]);
//				System.out.println(result[i][1]);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	
	public static String[][] servlet(String type,String content){
		String [][]con = null;
		if(type.equals("1")) {
			try {
				con = search_content(content);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(type.equals("3")) {
			try {
				con = search_abstract(content);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(type.equals("4")) {
			try {
				con = search_author(content);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(type.equals("5")) {
			try {
				con = search_title(content);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return con;
		
	}
	
	public static String[][] search_content(String search) throws Exception {
		//在所有的全文中搜索
		IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(indexDir_content)));
		IndexSearcher is = new IndexSearcher(reader);
		textAnalyzer = new SimpleAnalyzer();

		PostingsHighlighter highlighter = new PostingsHighlighter(); // 高亮显示对象

		QueryParser parser = new QueryParser("contents", textAnalyzer);
		Query query = parser.parse(search);

		TopDocs docs = is.search(query, 60);

		String highlights[] = highlighter.highlight("contents", query, is, docs, 3);

		ScoreDoc[] sdoc = docs.scoreDocs;
		Document doc;
		
		len = highlights.length;
		String[][] result = new String[len][2]; 


		for (int i = 0; i < highlights.length; i++) {
			doc = is.doc(sdoc[i].doc);
			String name = doc.get("path");
			int len_name = name.length();
			name = name.substring(0,len_name-4);
			name = name.replace("<b>", "<font color=\"red\">");
			name = name.replace("</b>", "</font>");
			highlights[i] = highlights[i].replace("<b>", "<font color=\"red\">");
			highlights[i] = highlights[i].replace("</b>", "</font>");
			result[i][0] = name;
			result[i][1] = highlights[i];
		}
		
		return result;
	}
	
	
	
	
	public static String[][] search_title(String search) throws Exception {
		//在所有的标题中搜索
		IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(indexDir_title)));
		IndexSearcher is = new IndexSearcher(reader);
		textAnalyzer = new SimpleAnalyzer();

		PostingsHighlighter highlighter = new PostingsHighlighter(); // 高亮显示对象

		QueryParser parser = new QueryParser("contents", textAnalyzer);
		Query query = parser.parse(search);

		TopDocs docs = is.search(query, 60);

		String highlights[] = highlighter.highlight("contents", query, is, docs, 6);

		ScoreDoc[] sdoc = docs.scoreDocs;
		Document doc;
		
		String[][] result = new String[highlights.length][2]; 


		for (int i = 0; i < highlights.length; i++) {
			doc = is.doc(sdoc[i].doc);
			String name = doc.get("path");
			int len_name = name.length();
			name = name.substring(0,len_name-4);
			name = name.replace("<b>", "<font color=\"red\">");
			name = name.replace("</b>", "</font>");
			highlights[i] = highlights[i].replace("<b>", "<font color=\"red\">");
			highlights[i] = highlights[i].replace("</b>", "</font>");
			result[i][0] = name;
			result[i][1] = highlights[i];
		}
		
		return result;
	}
	
	
	
	public static String[][] search_author(String search) throws Exception {
		//在所有的作者中搜索
		IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(indexDir_author)));
		IndexSearcher is = new IndexSearcher(reader);
		textAnalyzer = new SimpleAnalyzer();

		PostingsHighlighter highlighter = new PostingsHighlighter(); // 高亮显示对象

		QueryParser parser = new QueryParser("contents", textAnalyzer);
		Query query = parser.parse(search);

		TopDocs docs = is.search(query, 60);

		String highlights[] = highlighter.highlight("contents", query, is, docs, 6);

		ScoreDoc[] sdoc = docs.scoreDocs;
		Document doc;
		
		String[][] result = new String[highlights.length][2]; 


		for (int i = 0; i < highlights.length; i++) {
			doc = is.doc(sdoc[i].doc);
			String name = doc.get("path");
			int len_name = name.length();
			name = name.substring(0,len_name-4);
			name = name.replace("<b>", "<font color=\"red\">");
			name = name.replace("</b>", "</font>");
			highlights[i] = highlights[i].replace("<b>", "<font color=\"red\">");
			highlights[i] = highlights[i].replace("</b>", "</font>");
			result[i][0] = name;
			result[i][1] = highlights[i];
		}
		
		return result;
	}
	
	
	public static String[][] search_abstract(String search) throws Exception {
		//在所有的摘要中搜索
		IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(indexDir_abstract)));
		IndexSearcher is = new IndexSearcher(reader);
		textAnalyzer = new SimpleAnalyzer();

		PostingsHighlighter highlighter = new PostingsHighlighter(); // 高亮显示对象

		QueryParser parser = new QueryParser("contents", textAnalyzer);
		Query query = parser.parse(search);

		TopDocs docs = is.search(query, 60);

		String highlights[] = highlighter.highlight("contents", query, is, docs, 6);

		ScoreDoc[] sdoc = docs.scoreDocs;
		Document doc;
		
		String[][] result = new String[highlights.length][2]; 


		for (int i = 0; i < highlights.length; i++) {
			doc = is.doc(sdoc[i].doc);
			String name = doc.get("path");
			int len_name = name.length();
			name = name.substring(0,len_name-4);
			name = name.replace("<b>", "<font color=\"red\">");
			name = name.replace("</b>", "</font>");
			highlights[i] = highlights[i].replace("<b>", "<font color=\"red\">");
			highlights[i] = highlights[i].replace("</b>", "</font>");
			result[i][0] = name;
			result[i][1] = highlights[i];
		}
		
		return result;
	}


	public static String clickTitle(String title) throws Exception {
		// 点击标题，返回这篇标题的文章的内容
//		File fdir = new File(filesDir_content);
//		String[] flist = fdir.list(); // 检索不了子文件夹，所以filesDir文件夹中没有子文件夹
//		String content = "";
//		
//		for(int i=0;i<flist.length;i++) {
//			int len_file = flist[i].length();
//			flist[i] = flist[i].substring(0,len_file-4);
//			if(flist[i].equals(title)) {
//				File file = new File(filesDir_content + flist[i]);
//				content = readTxt(file);
//				break;
//			}
//		}
		
		
		
		File file = new File(filesDir_content+"/"+title+".txt");
		String content = readTxt(file);
		
		if(content == null) {
			File file1 = new File(filesDir_content+"/"+title+" .txt");
			content = readTxt(file1);
			if(content == null) {
				File file2 = new File(filesDir_content+"/"+title+"  .txt");
				content = readTxt(file2);
				if(content == null) {
					content = "Can't read the file!!";
				}	
			}
		}
		
		return content;
		
		
	}
	
	public static String readTxt(File file) throws Exception {
		//读取txt文件，并返回给content字符串
		//用于上面的clickTitle调用
		String content = "";
		try {
			FileInputStream in = new FileInputStream(file);
			// size 为字串的长度 ，这里一次性读完
			int size = in.available();
			byte[] buffer = new byte[size];
			in.read(buffer);
			in.close();
			content = new String(buffer, "GB2312");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		}
		return content;
	}


}

