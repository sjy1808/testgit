package com.jt.jsoup.pojo;

import javax.persistence.Id;
import javax.persistence.Table;

@Table //表示表名与对象名称一致
public class Course {
	@Id
	private Integer courseId;
	private String courseName;
	private String courseUrl;
	private String courseType;  //课程类型
	private Integer courseNumber;  //学生学习的数量
	private String courseImage;  //图片的地址
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseUrl() {
		return courseUrl;
	}
	public void setCourseUrl(String courseUrl) {
		this.courseUrl = courseUrl;
	}
	public String getCourseType() {
		return courseType;
	}
	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}
	
	public Integer getCourseNumber() {
		return courseNumber;
	}
	public void setCourseNumber(Integer courseNumber) {
		this.courseNumber = courseNumber;
	}
	public String getCourseImage() {
		return courseImage;
	}
	public void setCourseImage(String courseImage) {
		this.courseImage = courseImage;
	}
	
	
	
}
