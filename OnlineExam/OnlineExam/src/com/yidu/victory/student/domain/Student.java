package com.yidu.victory.student.domain;

import java.io.Serializable;

import com.yidu.victory.student.dao.Impl.SquadDaoImpl;
/**
 * Student��ʵ����
 * @author tang
 *
 */
public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5248050023420434776L;
	//ѧ�ţ�����
	private String sid;
	//ѧ������
	private String sname;
	//�Ա�
	private String sex;
	//����
	private int age;
	//�༶id
	private Squad sqid;
	//����
	private String passwords;
	//ע��ʱ��
	private String register;
	//���֤����
	private String identitycard;
	//ѧ���绰����
	private String phone;
	//�໤������
	private String guardian;
	//�໤�˹�ϵ
	private String guardianwith;
	//�໤�˵绰
	private String guardianphone;
	//��ַ
	private String address;
	//ѧ�����
	private String situation;
	/**
	 * �յĹ��췽��
	 */
	public Student() {
		super();
	}
	/**
	 * �����в����Ĺ��췽��
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
	 * Setter��Getter����
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


