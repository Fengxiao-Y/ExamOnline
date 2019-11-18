package com.yidu.victory.student.domain;

import java.io.Serializable;

/**
 * squad��ʵ����
 * @author Administrator
 *
 */
public class Squad implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3290256336167614724L;
	//�༶���
	private int sqid;
	//�༶���
	private String snumber;
	//�༶����
	private int speople;
	//����ʱ��
	private String squadtime;
	//��Ա
	private String teacher;
	//������
	private String sadministration;
	//�༶״̬
	private String state;
	//�༶����
	private String classify;
	//����Ĭ�ϵĹ��췽��
	public Squad() {
		super();
	}
	//���ɴ����д������ķ���
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
	//����set��get����
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
