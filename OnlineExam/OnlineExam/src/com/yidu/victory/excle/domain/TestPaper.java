package com.yidu.victory.excle.domain;

import java.io.Serializable;

/**
 * testPaper表的实体类
 * @author asus
 *
 */
public class TestPaper implements Serializable{

	private static final long serialVersionUID = 6999941330171461087L;
	
	//试卷编号
	private int cid;
	//试卷标题
	private String headline;
	//科目编号
	private String courseid;
	//试卷状态
	private String state;
	/**
	 * 默认的构造方法
	 */
	public TestPaper() {
		super();
	}
	/**
	 * 带参的构造方法
	 * @param cid
	 * @param headline
	 * @param courseid
	 * @param state
	 */
	public TestPaper(int cid, String headline, String courseid, String state) {
		super();
		this.cid = cid;
		this.headline = headline;
		this.courseid = courseid;
		this.state = state;
	}
	
	
	public TestPaper(String headline, String courseid, String state) {
		super();
		this.headline = headline;
		this.courseid = courseid;
		this.state = state;
	}
	//生成的setter和getter方法
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getHeadline() {
		return headline;
	}
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
