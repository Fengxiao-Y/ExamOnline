package com.yidu.victory.excle.domain;

import java.io.Serializable;

/**
 * testPaper���ʵ����
 * @author asus
 *
 */
public class TestPaper implements Serializable{

	private static final long serialVersionUID = 6999941330171461087L;
	
	//�Ծ���
	private int cid;
	//�Ծ����
	private String headline;
	//��Ŀ���
	private String courseid;
	//�Ծ�״̬
	private String state;
	/**
	 * Ĭ�ϵĹ��췽��
	 */
	public TestPaper() {
		super();
	}
	/**
	 * ���εĹ��췽��
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
	//���ɵ�setter��getter����
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
