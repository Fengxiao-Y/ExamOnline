package com.yidu.victory.excle.domain;

import java.io.Serializable;

/**
 * topicbank表的实体类
 * @author asus
 *
 */
public class Topicbank implements Serializable{

	private static final long serialVersionUID = 4477488930161351990L;
	
	//试题编号
	private int testid;
	//试题类型
	private String testtype;
	//a选项
	private String aresult;
	//b选项
	private String bresult;
	//c选项
	private String cresult;
	//d选项
	private String dresult;
	//e选项
	private String eresult;
	//f选项
	private String fresult;
	//正确答案
	private String rightsult;
	//试题内容
	private String content;
	//难度等级
	private String grade;
	//试题错误率
	private double falsely;
	//课程名称
	private String cname;
	//所属阶段
	private String stagename;
	/**
	 * 默认的构造方法
	 */
	public Topicbank() {
		super();
	}
	
	/**
	 * 带参构造方法
	*/
	public Topicbank(int testid, String testtype, String aresult, String bresult, String cresult, String dresult,
			String eresult, String fresult, String rightsult, String content, String grade, double falsely,
			String cname, String stagename) {
		super();
		this.testid = testid;
		this.testtype = testtype;
		this.aresult = aresult;
		this.bresult = bresult;
		this.cresult = cresult;
		this.dresult = dresult;
		this.eresult = eresult;
		this.fresult = fresult;
		this.rightsult = rightsult;
		this.content = content;
		this.grade = grade;
		this.falsely = falsely;
		this.cname = cname;
		this.stagename = stagename;
	}
	
	//缺参（falsely）的构造方法
	public Topicbank(int testid, String testtype, String aresult, String bresult, String cresult, String dresult,
			String eresult, String fresult, String rightsult, String content, String grade, String cname,
			String stagename) {
		super();
		this.testid = testid;
		this.testtype = testtype;
		this.aresult = aresult;
		this.bresult = bresult;
		this.cresult = cresult;
		this.dresult = dresult;
		this.eresult = eresult;
		this.fresult = fresult;
		this.rightsult = rightsult;
		this.content = content;
		this.grade = grade;
		this.cname = cname;
		this.stagename = stagename;
	}

	
	//缺参的构造方法
	public Topicbank(String testtype, String aresult, String bresult, String cresult, String dresult, String eresult,
			String fresult, String rightsult, String content, String grade, double falsely, String cname,
			String stagename) {
		super();
		this.testtype = testtype;
		this.aresult = aresult;
		this.bresult = bresult;
		this.cresult = cresult;
		this.dresult = dresult;
		this.eresult = eresult;
		this.fresult = fresult;
		this.rightsult = rightsult;
		this.content = content;
		this.grade = grade;
		this.falsely = falsely;
		this.cname = cname;
		this.stagename = stagename;
	}
	
	

	//生成getter/setter

	public Topicbank(String testtype, String aresult, String bresult, String cresult, String dresult, String eresult,
			String fresult, String rightsult, String content, String grade, String cname, String stagename) {
		super();
		this.testtype = testtype;
		this.aresult = aresult;
		this.bresult = bresult;
		this.cresult = cresult;
		this.dresult = dresult;
		this.eresult = eresult;
		this.fresult = fresult;
		this.rightsult = rightsult;
		this.content = content;
		this.grade = grade;
		this.cname = cname;
		this.stagename = stagename;
	}

	public int getTestid() {
		return testid;
	}

	public String getTesttype() {
		return testtype;
	}

	public String getAresult() {
		return aresult;
	}

	public String getBresult() {
		return bresult;
	}

	public String getCresult() {
		return cresult;
	}

	public String getDresult() {
		return dresult;
	}

	public String getEresult() {
		return eresult;
	}

	public String getFresult() {
		return fresult;
	}

	public String getRightsult() {
		return rightsult;
	}

	public String getContent() {
		return content;
	}

	public String getGrade() {
		return grade;
	}

	public double getFalsely() {
		return falsely;
	}

	public String getCname() {
		return cname;
	}

	public String getStagename() {
		return stagename;
	}

	public void setTestid(int testid) {
		this.testid = testid;
	}

	public void setTesttype(String testtype) {
		this.testtype = testtype;
	}

	public void setAresult(String aresult) {
		this.aresult = aresult;
	}

	public void setBresult(String bresult) {
		this.bresult = bresult;
	}

	public void setCresult(String cresult) {
		this.cresult = cresult;
	}

	public void setDresult(String dresult) {
		this.dresult = dresult;
	}

	public void setEresult(String eresult) {
		this.eresult = eresult;
	}

	public void setFresult(String fresult) {
		this.fresult = fresult;
	}

	public void setRightsult(String rightsult) {
		this.rightsult = rightsult;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public void setFalsely(double falsely) {
		this.falsely = falsely;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public void setStagename(String stagename) {
		this.stagename = stagename;
	}
	
	
	
}
