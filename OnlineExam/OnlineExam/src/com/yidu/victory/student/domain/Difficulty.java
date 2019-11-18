package com.yidu.victory.student.domain;

import java.io.Serializable;

/**
 * difficulty的实体类
 * @author Administrator
 *
 */
public class Difficulty implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2279763976334096332L;
	//试题编号主键
	private int tid;
	//难度等级
	private String grade;
	//生成默认的构造方法
	/**
	 * @author dtzh
	 * 编写日期:上午8:59:47
	 * 版本1.0
	 */
	public Difficulty() {
		super();
	}
	//生成带参数的构造方法
	/**
	 * @author dtzh
	 * 编写日期:上午9:00:02
	 * 版本1.0
	 */
	public Difficulty(int tid, String grade) {
		super();
		this.tid = tid;
		this.grade = grade;
	}
	//生成set和get的方法
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
