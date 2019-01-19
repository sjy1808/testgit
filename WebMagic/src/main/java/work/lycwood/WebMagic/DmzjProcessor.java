package work.lycwood.WebMagic;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.proxy.Proxy;
import us.codecraft.webmagic.proxy.SimpleProxyProvider;
import us.codecraft.webmagic.samples.scheduler.ZipCodePageProcessor;
import us.codecraft.webmagic.scheduler.FileCacheQueueScheduler;
import us.codecraft.webmagic.scheduler.PriorityScheduler;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.scheduler.Scheduler;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

public class DmzjProcessor implements PageProcessor {
	int myid = 0;
	int size = 10;
	// 抓取网站的相关配置，可以包括编码、抓取间隔1s、重试次数等
	private Site site = Site.me().setRetryTimes(3).setSleepTime(6000);
	

	@Override
	public Site getSite() {
		return site;
	}

	@Override
	public void process(Page page) {
		String mag = page.getHtml().css("body").get();
		System.out.println(mag);
		
	
	}

	public static void main(String[] args) throws Exception {
		
		System.getProperties().setProperty("proxySet", "true");

        // 设置代理服务器IP地址
        System.getProperties().setProperty("http.proxyHost","175.25.26.184");

        // 设置代理服务器IP端口
        System.getProperties().setProperty("http.proxyPort","10800");
		
		Proxy proxy1 = new Proxy("119.101.112.224",9999);
		Proxy proxy2 = new Proxy("119.101.116.141",9999);
		Proxy proxy3 = new Proxy("119.101.115.52",9999);
		List<Proxy> list = new ArrayList<>();
		list.add(proxy1);
		list.add(proxy2);
		list.add(proxy3);
		SimpleProxyProvider sProvider = new SimpleProxyProvider(list);
		DmzjProcessor my = new DmzjProcessor();

				Spider.create(my).addUrl("http://www.tedu.cn/").thread(1).run();

	}

	
	
	
	
}
