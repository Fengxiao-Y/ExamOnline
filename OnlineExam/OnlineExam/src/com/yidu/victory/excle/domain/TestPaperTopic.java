package com.yidu.victory.excle.domain;

import java.io.Serializable;

/**
 * testPaperTopic���ʵ����
 * @author asus
 *
 */
public class TestPaperTopic implements Serializable{
	
	private static final long serialVersionUID = 1852798423697482184L;
	
	//�Ծ�����
	private int tid;
	//�Ծ�
	private int testpaperid;
	//����
	private int topicbankid;
	
	/**
	 * Ĭ�ϵĹ��췽��
	 */
	public TestPaperTopic() {
		super();
	}
	/**
	 * ���εĹ��췽��
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
	//���ɵ�setter��getter����
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
