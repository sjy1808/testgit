package work.lycwood.ipproxy;


import java.util.ArrayList;
import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.proxy.Proxy;
import us.codecraft.webmagic.proxy.SimpleProxyProvider;

public class Test01 implements PageProcessor{
	
	private Site site = new Site().me().setSleepTime(3000).setRetryTimes(5);
	
	public static void main(String[] args) {
		
		Proxy proxy01 = new Proxy("119.29.55.7", 9999);
		Proxy proxy02 = new Proxy("119.101.113.200", 9999);
		Proxy proxy03 = new Proxy("119.101.112.211", 9999);
		Proxy proxy04 = new Proxy("119.101.117.72", 9999);
		Proxy proxy05 = new Proxy("119.101.113.173", 9999);
		List<Proxy> proxies = new ArrayList<>();
		//proxies.add(proxy01);
		proxies.add(proxy02);
		proxies.add(proxy03);
		proxies.add(proxy04);
		proxies.add(proxy05);
		//SimpleProxyProvider proxyProvider = SimpleProxyProvider.from(new Proxy("119.29.55.7", 9999), new Proxy("119.101.117.72", 9999));  
		SimpleProxyProvider provider = new SimpleProxyProvider(proxies);
		HttpClientDownloader downloader = new HttpClientDownloader();
		downloader.setProxyProvider(provider);
		
		Spider.create(new Test01()).addUrl("http://2018.ip138.com/ic.asp")
									.addUrl("https://www.ip.cn/")
									.setDownloader(downloader)
									.thread(1).run();
		
		
	}
	
	
	@Override
	public void process(Page page) {
		String ip = page.getHtml().xpath("/html/body/center/text()").toString();
		System.out.println(ip);
		String ip1 = page.getHtml().xpath("//*[@id=\"result\"]/div/p[1]/text()").toString();
		System.out.println(ip1);
	}

	@Override
	public Site getSite() {
		
		return site;
	}

	

}
