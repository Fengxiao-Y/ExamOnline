package com.yidu.victory.student.domain;

import java.io.Serializable;

/**
 * squad的实体类
 * @author Administrator
 *
 */
public class Squad implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3290256336167614724L;
	//班级编号
	private int sqid;
	//班级班好
	private String snumber;
	//班级人数
	private int speople;
	//创办时间
	private String squadtime;
	//教员
	private String teacher;
	//班主任
	private String sadministration;
	//班级状态
	private String state;
	//班级分类
	private String classify;
	//生成默认的构造方法
	public Squad() {
		super();
	}
	//生成带所有带参数的方法
	public Squad(int sqid, String snumber, int speople, String squadtime, String teacher, String sadministration,
			String state, String classify) {
		super();
		this.sqid = sqid;
		this.snumber = snumber;
		this.speople = speople;
		this.squadtime = squadtime;
		this.teacher = teacher;
		this.sadministration = sadministration;
		this.state = state;
		this.classify = classify;
	}
	
	
	
	public Squad(String snumber, int speople, String squadtime, String teacher, String sadministration, String state,
			String classify) {
		super();
		this.snumber = snumber;
		this.speople = speople;
		this.squadtime = squadtime;
		this.teacher = teacher;
		this.sadministration = sadministration;
		this.state = state;
		this.classify = classify;
	}
	//生成set和get方法
	public int getsqid() {
		return sqid;
	}
	public void setsqid(int sqid) {
		this.sqid = sqid;
	}
	public String getSnumber() {
		return snumber;
	}
	public void setSnumber(String snumber) {
		this.snumber = snumber;
	}
	public int getSpeople() {
		return speople;
	}
	public void setSpeople(int speople) {
		this.speople = speople;
	}
	public String getSquadtime() {
		return squadtime;
	}
	public void setSquadtime(String squadtime) {
		this.squadtime = squadtime;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getSadministration() {
		return sadministration;
	}
	public void setSadministration(String sadministration) {
		this.sadministration = sadministration;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	
	
}
