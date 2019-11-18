package com.yidu.victory.popedom.domain;

import java.io.Serializable;

public class  User_role implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5012840694918425778L;
	//用户账号
	private String unumber;
	//角色编号
	private int roleid;
	//默认构造方法
	public User_role() {
		super();
	}
	//带参构造方法
	
	public User_role(String unumber, int roleid) {
		super();
		this.unumber = unumber;
		this.roleid = roleid;
	}
	//生成setter/getter
	public String getUnumber() {
		return unumber;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setUnumber(String unumber) {
		this.unumber = unumber;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	
	
	
	
}
