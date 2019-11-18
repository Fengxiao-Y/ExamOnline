package com.yidu.victory.student.domain;

import java.io.Serializable;

public class Announce implements Serializable{
	/**
	 *  ���л����
	 */
	private static final long serialVersionUID = -1727915799770849549L;
	//ͨ����
	public int aid;
	//����
	public String theme;
	//��������
	public String titlecontent;
	//ͨ������
	public String announcecont;
	//������
	public String issuepeople;
	//����ʱ��
	public String issuetime;
	//Ĭ�Ϲ��췽��
	public Announce() {
		super();
	}
	//���ι��췽��
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
	//����setter/getter
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
