package com.yidu.victory.student.domain;

import java.io.Serializable;

/*
 * course的实体类
 */
public class Course implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1463836928959906833L;
	private int cid;
	private String cname;
	private String stagename;
	//生成默认的构造方法
	/**
	 * @author d280
	 * 编写日期:下午3:28:58
	 * 版本1.0
	 */
	public Course() {
		super();
	}
	/**
	 * @author d280
	 * 编写日期:下午3:29:05
	 * 版本1.0
	 */
	public Course(int cid, String cname, String stagename) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.stagename = stagename;
	}
	
	
	public Course(String cname, String stagename) {
		super();
		this.cname = cname;
		this.stagename = stagename;
	}
	/**
	 * @return the cid
	 */
	public int getCid() {
		return cid;
	}
	/**
	 * @param cid the cid to set
	 */
	public void setCid(int cid) {
		this.cid = cid;
	}
	/**
	 * @return the cname
	 */
	public String getCname() {
		return cname;
	}
	/**
	 * @param cname the cname to set
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}
	/**
	 * @return the stagename
	 */
	public String getStagename() {
		return stagename;
	}
	/**
	 * @param stagename the stagename to set
	 */
	public void setStagename(String stagename) {
		this.stagename = stagename;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
