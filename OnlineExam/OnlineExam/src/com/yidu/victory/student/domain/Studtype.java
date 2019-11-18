package com.yidu.victory.student.domain;

public class Studtype {
	//学号，主键
	private String sid;
	//考试状态
	private int examtype;
	//班级id
	private int squadid;

	/**
	 * 缺省的构造方法
	 */
	public Studtype() {
		super();
	}
	/**
	 * 带参构造方法
	 * @param sid
	 * @param examtype
	 * @param squadid
	 */

	public Studtype(String sid, int examtype, int squadid) {
		super();
		this.sid = sid;
		this.examtype = examtype;
		this.squadid = squadid;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public int getExamtype() {
		return examtype;
	}
	public void setExamtype(int examtype) {
		this.examtype = examtype;
	}
	public int getSquadid() {
		return squadid;
	}
	public void setSquadid(int squadid) {
		this.squadid = squadid;
	}
	

	
	
	
}
