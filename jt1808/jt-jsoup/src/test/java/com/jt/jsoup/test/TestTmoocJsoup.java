package com.jt.jsoup.test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jt.jsoup.mapper.CourseMapper;
import com.jt.jsoup.pojo.Course;


public class TestTmoocJsoup {

	
	private CourseMapper courseMapper;
	
	@Before
	public void init(){
		ApplicationContext context=new ClassPathXmlApplicationContext("/spring/applicationContext.xml");
		courseMapper=context.getBean(CourseMapper.class);
	}
	
	@Test
	public void test01() throws Exception{
		//1.定义目标的网址
		String url="http://www.tmooc.cn";
		
		//2.定位目标元素html标签num-box-lty
		
		//3.爬取数据
		Elements elements=Jsoup.connect(url).get().select(".num-box-lty");
		Elements h3Ele=elements.select("h3");
		int courserNum=Integer.parseInt(h3Ele.get(0).text());
		System.out.println(courserNum+"个课程");
		int teacherNum=Integer.parseInt(h3Ele.get(1).text());
		System.out.println(teacherNum+"个老师");
		int studentNum=Integer.parseInt(h3Ele.get(2).text().replace(",", ""));
		System.out.println(studentNum+"名学生");
		
	}
	
	//获取课程的方向/课程的名称/课程的url/课程的图片信息/课程的学习人数
	@Test
	public void test02() throws IOException{
		//1.定位网址
		String url="http://www.tmooc.cn";
		//2.确定元素的位置 class="md-com-list"
		//3.爬取数据
		Elements lists=Jsoup.connect(url).get().select(".md-com-list");
		//4.获取直播课的list集合
		Element zhiboList=lists.get(0);
		//获取课程类型
		String courseType=zhiboList.select(".md-hd").select("span").text();
		//获取列表li元素
		Elements liEle=zhiboList.select("li");
		for (Element LiElement : liEle) {
			//获取网络url
			String courseUrl=LiElement.select(".hd-pic").select("a").attr("href");
			String courseImage=LiElement.select(".hd-pic").select("img").attr("src");
			//获取课程信息元素
			Elements divEles=LiElement.select(".bd-word").select(".bgcolor-fff");
			String courseName=divEles.get(0).select("a").text();
			String courseNumStr=divEles.get(0).select("span").get(1).text();
			int courseNum=Integer.parseInt(courseNumStr.substring(0, courseNumStr.lastIndexOf("人")).replace(",", ""));
			
			Course courseDB=new Course();
			courseDB.setCourseType(courseType);
			courseDB.setCourseName(courseName);
			courseDB.setCourseUrl(courseUrl);
			courseDB.setCourseNumber(courseNum);
			courseDB.setCourseImage(courseImage);
			courseMapper.insert(courseDB);
			
		}
		
		
	}
}
