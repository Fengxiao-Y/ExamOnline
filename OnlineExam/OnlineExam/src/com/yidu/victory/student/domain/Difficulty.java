package com.yidu.victory.student.domain;

import java.io.Serializable;

/**
 * difficulty��ʵ����
 * @author Administrator
 *
 */
public class Difficulty implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2279763976334096332L;
	//����������
	private int tid;
	//�Ѷȵȼ�
	private String grade;
	//����Ĭ�ϵĹ��췽��
	/**
	 * @author dtzh
	 * ��д����:����8:59:47
	 * �汾1.0
	 */
	public Difficulty() {
		super();
	}
	//���ɴ������Ĺ��췽��
	/**
	 * @author dtzh
	 * ��д����:����9:00:02
	 * �汾1.0
	 */
	public Difficulty(int tid, String grade) {
		super();
		this.tid = tid;
		this.grade = grade;
	}
	//����set��get�ķ���
	/**
	 * @return the tid
	 */
	public int getTid() {
		return tid;
	}
	/**
	 * @param tid the tid to set
	 */
	public void setTid(int tid) {
		this.tid = tid;
	}
	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
	
}
