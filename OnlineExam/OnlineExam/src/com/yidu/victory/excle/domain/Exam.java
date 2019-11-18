package com.yidu.victory.excle.domain;

import java.io.Serializable;

/**
 * exam���ʵ����
 * @author asus
 *
 */
public class Exam implements Serializable{

	private static final long serialVersionUID = 6476409787210147036L;
	
	//���Ա��
	private int eid;
	//�Ծ���
	private int cid;
	//�Ծ����
	private String headline;
	//�γ�����
	private String cname;
	//�༶���
	private int sqid;
	//����ʱ��
	private String examtime;
	//����ʱ��
	private String finishtime;
	//�������
	private String againexam;
	
	/**
	 * Ĭ�ϵĹ��췽��
	 */
	public Exam() {
		super();
	}
	/**
	 * ���εĹ��췽��
	 * @param eid
	 * @param cid
	 * @param headline
	 * @param cname
	 * @param sqid
	 * @param examtime
	 * @param finishtime
	 * @param againexam
	 */
	public Exam(int eid, int cid, String headline, String cname, int sqid, String examtime, String finishtime,
			String againexam) {
		super();
		this.eid = eid;
		this.cid = cid;
		this.headline = headline;
		this.cname = cname;
		this.sqid = sqid;
		this.examtime = examtime;
		this.finishtime = finishtime;
		this.againexam = againexam;
	}
	
	//ȱ�ι��췽��
		public Exam(int cid, String headline, String cname, int sqid, String examtime, String finishtime,
			String againexam) {
		super();
		this.cid = cid;
		this.headline = headline;
		this.cname = cname;
		this.sqid = sqid;
		this.examtime = examtime;
		this.finishtime = finishtime;
		this.againexam = againexam;
	}
	
	
	
	
	//���ɵ�setter��getter����
	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}
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
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getSqid() {
		return sqid;
	}
	public void setSid(int sid) {
		this.sqid = sid;
	}
	public String getExamtime() {
		return examtime;
	}
	public void setExamtime(String examtime) {
		this.examtime = examtime;
	}
	public String getFinishtime() {
		return finishtime;
	}
	public void setFinishtime(String finishtime) {
		this.finishtime = finishtime;
	}
	public String getAgainexam() {
		return againexam;
	}
	public void setAgainexam(String againexam) {
		this.againexam = againexam;
	}
	
	
}
