package com.yidu.victory.excle.domain;

import java.io.Serializable;

/**
 * exam表的实体类
 * @author asus
 *
 */
public class Exam implements Serializable{

	private static final long serialVersionUID = 6476409787210147036L;
	
	//考试编号
	private int eid;
	//试卷编号
	private int cid;
	//试卷标题
	private String headline;
	//课程名称
	private String cname;
	//班级编号
	private int sqid;
	//考试时间
	private String examtime;
	//结束时间
	private String finishtime;
	//补考编号
	private String againexam;
	
	/**
	 * 默认的构造方法
	 */
	public Exam() {
		super();
	}
	/**
	 * 带参的构造方法
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
	
	//缺参构造方法
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
	
	
	
	
	//生成的setter和getter方法
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
