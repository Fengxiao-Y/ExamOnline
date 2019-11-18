package com.yidu.victory.student.domain;

import java.io.Serializable;

import com.yidu.victory.student.dao.Impl.SquadDaoImpl;
/**
 * Student表实体类
 * @author tang
 *
 */
public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5248050023420434776L;
	//学号，主键
	private String sid;
	//学生姓名
	private String sname;
	//性别
	private String sex;
	//年龄
	private int age;
	//班级id
	private Squad sqid;
	//密码
	private String passwords;
	//注册时间
	private String register;
	//身份证号码
	private String identitycard;
	//学生电话号码
	private String phone;
	//监护人姓名
	private String guardian;
	//监护人关系
	private String guardianwith;
	//监护人电话
	private String guardianphone;
	//地址
	private String address;
	//学生情况
	private String situation;
	/**
	 * 空的构造方法
	 */
	public Student() {
		super();
	}
	/**
	 * 带所有参数的构造方法
	 * @param sid
	 * @param sname
	 * @param sex
	 * @param age
	 * @param squadid
	 * @param passwords
	 * @param register
	 * @param identitycard
	 * @param phone
	 * @param guardian
	 * @param guardianwith
	 * @param guardianphone
	 * @param address
	 * @param situation
	 */
	public Student(String sid, String sname, String sex, int age, int sqid, String passwords, String register,
			String identitycard, String phone, String guardian, String guardianwith, String guardianphone,
			String address, String situation) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sex = sex;
		this.age = age;
		this.sqid = new SquadDaoImpl().findById(sqid);
		this.passwords = passwords;
		this.register = register;
		this.identitycard = identitycard;
		this.phone = phone;
		this.guardian = guardian;
		this.guardianwith = guardianwith;
		this.guardianphone = guardianphone;
		this.address = address;
		this.situation = situation;
	}
	
	/**
	 * Setter和Getter方法
	 * @return
	 */
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
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
	public Squad getSqid() {
		return sqid;
	}
	public void setSqid(int sqid) {
		this.sqid = new SquadDaoImpl().findById(sqid);
	}
	public String getPasswords() {
		return passwords;
	}
	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
	}
	public String getIdentitycard() {
		return identitycard;
	}
	public void setIdentitycard(String identitycard) {
		this.identitycard = identitycard;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGuardian() {
		return guardian;
	}
	public void setGuardian(String guardian) {
		this.guardian = guardian;
	}
	public String getGuardianwith() {
		return guardianwith;
	}
	public void setGuardianwith(String guardianwith) {
		this.guardianwith = guardianwith;
	}
	public String getGuardianphone() {
		return guardianphone;
	}
	public void setGuardianphone(String guardianphone) {
		this.guardianphone = guardianphone;
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


