package com.yidu.victory.popedom.domain;

import java.io.Serializable;

public class  User_role implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5012840694918425778L;
	//�û��˺�
	private String unumber;
	//��ɫ���
	private int roleid;
	//Ĭ�Ϲ��췽��
	public User_role() {
		super();
	}
	//���ι��췽��
	
	public User_role(String unumber, int roleid) {
		super();
		this.unumber = unumber;
		this.roleid = roleid;
	}
	//����setter/getter
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
