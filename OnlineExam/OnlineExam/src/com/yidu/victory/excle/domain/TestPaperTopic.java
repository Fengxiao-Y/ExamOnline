package com.yidu.victory.excle.domain;

import java.io.Serializable;

/**
 * testPaperTopic表的实体类
 * @author asus
 *
 */
public class TestPaperTopic implements Serializable{
	
	private static final long serialVersionUID = 1852798423697482184L;
	
	//试卷题编号
	private int tid;
	//试卷
	private int testpaperid;
	//试题
	private int topicbankid;
	
	/**
	 * 默认的构造方法
	 */
	public TestPaperTopic() {
		super();
	}
	/**
	 * 带参的构造方法
	 * @param tid
	 * @param testpaperid
	 * @param topicbankid
	 */
	public TestPaperTopic(int tid, int testpaperid, int topicbankid) {
		super();
		this.tid = tid;
		this.testpaperid = testpaperid;
		this.topicbankid = topicbankid;
	}
	
	
	public TestPaperTopic(int testpaperid, int topicbankid) {
		super();
		this.testpaperid = testpaperid;
		this.topicbankid = topicbankid;
	}
	//生成的setter和getter方法
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getTestPaperid() {
		return testpaperid;
	}
	public void setTestPaperid(int testPaperid) {
		this.testpaperid = testPaperid;
	}
	public int getTopicbankid() {
		return topicbankid;
	}
	public void setTopicbankid(int topicbankid) {
		this.topicbankid = topicbankid;
	}
	
	
}
