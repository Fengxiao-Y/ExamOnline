package com.yidu.victory.student.domain;

import java.io.Serializable;

public class Announce implements Serializable{
	/**
	 *  序列化编号
	 */
	private static final long serialVersionUID = -1727915799770849549L;
	//通告编号
	public int aid;
	//主题
	public String theme;
	//标题内容
	public String titlecontent;
	//通告内容
	public String announcecont;
	//发布人
	public String issuepeople;
	//发布时间
	public String issuetime;
	//默认构造方法
	public Announce() {
		super();
	}
	//带参构造方法
	public Announce(int aid, String theme, String titlecontent, String announcecont, String issuepeople,
			String issuetime) {
		super();
		this.aid = aid;
		this.theme = theme;
		this.titlecontent = titlecontent;
		this.announcecont = announcecont;
		this.issuepeople = issuepeople;
		this.issuetime = issuetime;
	}
	
	
	
	
	public Announce(String theme, String titlecontent, String announcecont, String issuepeople, String issuetime) {
		super();
		this.theme = theme;
		this.titlecontent = titlecontent;
		this.announcecont = announcecont;
		this.issuepeople = issuepeople;
		this.issuetime = issuetime;
	}
	//生成setter/getter
	public int getAid() {
		return aid;
	}
	public String getTheme() {
		return theme;
	}
	public String getTitlecontent() {
		return titlecontent;
	}
	public String getAnnouncecont() {
		return announcecont;
	}
	public String getIssuepeople() {
		return issuepeople;
	}
	public String getIssuetime() {
		return issuetime;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public void setTitlecontent(String titlecontent) {
		this.titlecontent = titlecontent;
	}
	public void setAnnouncecont(String announcecont) {
		this.announcecont = announcecont;
	}
	public void setIssuepeople(String issuepeople) {
		this.issuepeople = issuepeople;
	}
	public void setIssuetime(String issuetime) {
		this.issuetime = issuetime;
	}
	
	
}
