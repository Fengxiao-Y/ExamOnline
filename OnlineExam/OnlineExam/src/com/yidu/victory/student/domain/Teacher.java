package com.yidu.victory.student.domain;

import java.io.Serializable;
/**
 * teacher��ʵ����
 * @author Administrator
 *
 */

public class Teacher implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -481192156719272854L;
	
	//����  ����
	private String tid;
	//��ʦ����
	private String tname;
	//��ʦ�Ա�
	private String sex;
	//��ʦ����
	private int age;
	//��ϵ�绰
	private String phone;
	//QQ����
	private int penguin;
	//��ͥסַ
	private String address;
	//��ʦ��ְ���
	private String situation; 
	//Ĭ�Ϲ��췽��
	public Teacher() {
		super();
	}
	
	
	//�������Ĺ��췽��
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

	// ����setter��getter
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
