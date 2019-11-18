package com.yidu.victory.popedom.domain;

import java.io.Serializable;

public class Role_popedom implements Serializable{
	
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -7922729123334427219L;
	//角色权限id
	public int rpid;
	//菜单id
	public Integer pdmid;
	//角色ID
	public int roleid;
	//默认构造方法
	public Role_popedom() {
		super();
	}
	//带参方法
	public Role_popedom(int rpid, Integer pdmid, int roleid) {
		super();
		this.rpid = rpid;
		this.pdmid = pdmid;
		this.roleid = roleid;
	}
	
	
	public Role_popedom(Integer pdmid, int roleid) {
		super();
		this.pdmid = pdmid;
		this.roleid = roleid;
	}
	//生成setter/getter
	
	public int getRpid() {
		return rpid;
	}
	public Integer getPdmid() {
		return pdmid;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRpid(int rpid) {
		this.rpid = rpid;
	}
	public void setPdmid(Integer pdmid) {
		this.pdmid = pdmid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	
	
	
}
