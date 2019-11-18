package com.yidu.victory.student.domain;

import java.io.Serializable;
/**
 * teacher的实体类
 * @author Administrator
 *
 */

public class Teacher implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -481192156719272854L;
	
	//工号  主键
	private String tid;
	//教师姓名
	private String tname;
	//教师性别
	private String sex;
	//教师年龄
	private int age;
	//联系电话
	private String phone;
	//QQ号码
	private int penguin;
	//家庭住址
	private String address;
	//教师在职情况
	private String situation; 
	//默认构造方法
	public Teacher() {
		super();
	}
	
	
	//带参数的构造方法
	public Teacher(String tid, String tname, String sex, int age, String phone, int penguin, String address,
			String situation) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.sex = sex;
		this.age = age;
		this.phone = phone;
		this.penguin = penguin;
		this.address = address;
		this.situation = situation;
	}

	// 生成setter和getter
	public String getTid() {
		return tid;
	}


	public void setTid(String tid) {
		this.tid = tid;
	}


	public String getTname() {
		return tname;
	}


	public void setTname(String tname) {
		this.tname = tname;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public int getPenguin() {
		return penguin;
	}


	public void setPenguin(int penguin) {
		this.penguin = penguin;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getSituation() {
		return situation;
	}


	public void setSituation(String situation) {
		this.situation = situation;
	}
	
	
	
	

	
	
	
	
	
	
	
}
