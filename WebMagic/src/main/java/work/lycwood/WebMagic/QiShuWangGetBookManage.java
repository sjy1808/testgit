package work.lycwood.WebMagic;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale.Category;

import javax.net.ssl.HttpsURLConnection;

import org.apache.bcel.generic.NEW;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.Downloader;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

public class QiShuWangGetBookManage implements PageProcessor {

	private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
							/*.addHeader("Accept-Ranges", "bytes")
							.addHeader("Content-Length", "532903")
							.addHeader("Date", "Fri, 11 Jan 2019 10:09:25 GMT")
							.addHeader("ETag", "\"040e68981a3ce1:e469f\"")
							.addHeader("Last-Modified", "Wed, 28 Aug 2013 00:00:00 GMT")
							.addHeader("Server", "Microsoft-IIS/6.0")
							.addHeader("X-Powered-By", "ASP.NET");*/
	/*
	 * http://www.netbian.com/
Accept-Ranges: bytes
Content-Length: 532903
Content-Type: image/jpeg
Date: Fri, 11 Jan 2019 10:09:25 GMT
ETag: "040e68981a3ce1:e469f"
Last-Modified: Wed, 28 Aug 2013 00:00:00 GMT
Server: Microsoft-IIS/6.0
X-Powered-By: ASP.NET	  
	 */

	private static String category;
	@Override
	public Site getSite() {
		return site;
	}
	@Override
	public void process(Page page) {
		String url = "https://www.qisuu.la";
		Html html = page.getHtml();

		// 获取书籍封面图片的url
		Selectable image = html.xpath("//div[@class=\"detail_pic\"]");
		String imgUrl = image.xpath("//img/@src").get();
		// System.out.println(url+imgUrl);
		// 获取书籍信息的整个div块
		Selectable message = html.xpath("//div[@class=\"detail_right\"]");
		// 选择出书籍名
		String name = message.xpath("//h1/text()").get();
		// 选择出书籍大小
		String sizeMes = message.xpath("//ul/li[2]/text()").get();
		String size = sizeMes.substring(sizeMes.indexOf("大小") + 3, sizeMes.length());
		// 选择出书籍状态
		String statusMes = message.xpath("//ul/li[5]/text()").get();
		String status = statusMes.substring(statusMes.indexOf("状态") + 3, statusMes.length());
		// 选择出书籍作者
		String authorMes = message.xpath("//ul/li[6]/text()").get();
		String author = authorMes.substring(authorMes.indexOf("作者") + 3, authorMes.length());
		// 选择出书籍简介
		String summary = html.xpath("//div[@class=\"showInfo\"][2]/p/text()").get();
		// 选择出书籍下载地址
		String downUrlMes = html.xpath("//div[@class=\"showDown\"]/ul/li[3]").get();
		String downUrl = downUrlMes.substring(downUrlMes.indexOf("https://dzs.qisuu.la/"),
				downUrlMes.indexOf("txt'") + 3);
		
		sql(name, author, category, status, summary, size);
		try {
			save(url+imgUrl, downUrl, name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(name + size + status + author);

		System.out.println(summary);

		System.out.println(downUrl);

		/*
		 * // String list = html.xpath("//div[@class=\"listBox\"]/li").get();
		 * 
		 * Selectable abc = html.xpath("//div[@class=\"listBox\"]//li");
		 * List<Selectable> nodes = abc.nodes();
		 * 
		 * for (Selectable se : nodes) {
		 * 
		 * String url = se.xpath("//a/@href").get(); //
		 * System.out.println("书名:"+se.xpath("//a/text()").get());
		 * System.out.println("链接:" + "https://www.qisuu.la" + url); File file = new
		 * File("L:/images/bookurls.txt"); FileWriter fWriter = null; try { fWriter =
		 * new FileWriter(file, true); fWriter.write("https://www.qisuu.la" + url);
		 * fWriter.write("\n"); } catch (IOException e) { e.printStackTrace(); } finally
		 * { try { fWriter.close(); } catch (IOException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); } } System.out.println(); } //
		 * System.out.println(list);
		 */
	}

	public static void main(String[] args) {
		
		category = "名著杂志";
		QiShuWangGetBookManage my = new QiShuWangGetBookManage();
		String url = "https://www.qisuu.la/Shtml4585.html";
		// for (int i = 1; i < 13; i++) {
		Spider.create(my).addUrl(url).thread(1).run();

		// }

	}

	public void sql(String name, String author, String category, String status, String summary, String size) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql:///library_v1", "root", "");
			String sql = "insert into books values(null,?,?,?,?,?,?,null,null,null,null)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, category);
			ps.setString(3, author);
			ps.setString(4, status);
			ps.setString(5, summary);
			ps.setString(6, size);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				ps.close();
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void save(String imgUrl,String downUrl,String name)throws Exception {
		imgUrl = "http://www.uutxtw.com/all.html";
		System.out.println(imgUrl);
		URL url = new URL(imgUrl);
		CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
		
		HttpGet httpGet = new HttpGet("http://www.uutxtw.com/all.html");
		/*httpGet.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*//*;q=0.8");
		httpGet.setHeader("Accept-Encoding", "gzip, deflate");
		httpGet.setHeader("Accept-Language", "zh-CN,zh;q=0.9");
		httpGet.setHeader("Cache-Control", "max-age=0");
		httpGet.setHeader("Connection", "keep-alive");
		httpGet.setHeader("Host", "bizhi.zhuoku.com");
		httpGet.setHeader("Save-Data", "on");*/
		//httpGet.setHeader("Referer", "http://www.zhuoku.com/zhuomianbizhi/jingxuan-jingxuanyitu/20150727144649(1).htm");
		/*httpGet.setHeader("Upgrade-Insecure-Requests", "1");
		httpGet.setHeader("User-Agent", 
				"Mozilla/5.0 (Windows NT 6.1; WOW64); AppleWebKit/537.36 "
				+ "(KHTML, like Gecko); Chrome/71.0.3578.98 Safari/537.36");*/
		
		CloseableHttpResponse response = closeableHttpClient.execute(httpGet);
		HttpEntity entity = response.getEntity();
		System.out.println();
		InputStream in = entity.getContent();
		
		
		
		//DataInputStream dataInputStream = new DataInputStream(url.openStream());
		//URLConnection con = url.openConnection();
		/*HttpsURLConnection httpsConn = (HttpsURLConnection)url.openConnection();
		InputStream is = httpsConn.getInputStream();*/
        /*//设置请求超时为5s
        con.setConnectTimeout(5*1000);
        // 输入流
        InputStream is = con.getInputStream();*/
		//HttpURLConnection conn = (HttpURLConnection) serverUrl.openConnection(); 
		//InputStream inImg = url.openStream();
		BufferedInputStream input = new BufferedInputStream(in);
		FileOutputStream fileOutputStream = new FileOutputStream(new File("L:/images/bookimgs/"+name+
							imgUrl.substring(imgUrl.lastIndexOf("."), imgUrl.length())));
		byte[] b = new byte[1024];
		int read ;
		while((read = input.read(b, 0, b.length))!=-1) {
			fileOutputStream.write(b, 0, read);
			//System.out.println(new String(b,"iso8859-1"));
		}
		fileOutputStream.flush();
		fileOutputStream.close();
		input.close();
		//inImg.close();
		
			/*bufferedReader = new BufferedReader(new InputStreamReader(inImg));
			fileWriter = new FileWriter(new File("L:/images/books/"+name+
					downUrl.substring(downUrl.lastIndexOf("."), downUrl.length())));*/
			
			
		
	}
}
