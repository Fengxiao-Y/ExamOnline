package com.yidu.victory.popedom.domain;

import java.io.Serializable;

public class Role_popedom implements Serializable{
	
	/**
	 * ���л�
	 */
	private static final long serialVersionUID = -7922729123334427219L;
	//��ɫȨ��id
	public int rpid;
	//�˵�id
	public Integer pdmid;
	//��ɫID
	public int roleid;
	//Ĭ�Ϲ��췽��
	public Role_popedom() {
		super();
	}
	//���η���
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
	//����setter/getter
	
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
