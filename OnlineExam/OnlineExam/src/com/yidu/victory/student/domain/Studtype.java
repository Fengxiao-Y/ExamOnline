package com.yidu.victory.student.domain;

public class Studtype {
	//ѧ�ţ�����
	private String sid;
	//����״̬
	private int examtype;
	//�༶id
	private int squadid;

	/**
	 * ȱʡ�Ĺ��췽��
	 */
	public Studtype() {
		super();
	}
	/**
	 * ���ι��췽��
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
