package com.dessert.sys.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 员工信息封装实体类
 * @author Administrator
 *
 */
public class SysEmployee implements Serializable {

	private static final long serialVersionUID = 4450445557950855787L;
	/**员工表id*/
	private int id;
	/**性别*/
	private String gender;
	/**名字*/
	private String name;
	/**年龄*/
	private int age;
	/**职位*/
	private String role;
	/**电话*/
	private String phone;
	/**e-mail邮箱*/
	private String email;
	/**入职时间*/
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String hiredate;
	/**住址*/
	private String adress;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	@Override
	public String toString() {
		return "SysEmployee [id=" + id + ", gender=" + gender + ", name=" + name + ", age=" + age + ", role=" + role
				+ ", phone=" + phone + ", email=" + email + ", hiredate=" + hiredate + ", adress=" + adress + "]";
	}
	
}
