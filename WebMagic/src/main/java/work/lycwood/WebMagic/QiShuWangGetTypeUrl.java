package work.lycwood.WebMagic;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

public class QiShuWangGetTypeUrl implements PageProcessor {

	private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

	@Override
	public Site getSite() {
		return site;
	}

	@Override
	public void process(Page page) {

		Html html = page.getHtml();

		// String list = html.xpath("//div[@class=\"listBox\"]/li").get();

		Selectable abc = html.xpath("//div[@class=\"listBox\"]//li");
		List<Selectable> nodes = abc.nodes();

		for (Selectable se : nodes) {

			String url = se.xpath("//a/@href").get();
			// System.out.println("书名:"+se.xpath("//a/text()").get());
			System.out.println("链接:" + "https://www.qisuu.la" + url);
			File file = new File("L:/images/名著杂志.txt");
			FileWriter fWriter = null;
			try {
				fWriter = new FileWriter(file, true);
				fWriter.write("https://www.qisuu.la" + url);
				fWriter.write("\n");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					fWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println();
		}
		// System.out.println(list);

	}

	public static void main(String[] args) {

		QiShuWangGetTypeUrl my = new QiShuWangGetTypeUrl();
		String url = "https://www.qisuu.la/soft/sort010/index_";
		for (int i = 1; i < 11; i++) {
			Spider.create(my).addUrl(url + i + ".html").thread(10).start();

		}

	}

}
