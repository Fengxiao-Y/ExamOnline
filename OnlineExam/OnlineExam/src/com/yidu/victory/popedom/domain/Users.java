package com.yidu.victory.popedom.domain;

import java.io.Serializable;

public class Users implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -944456033825879162L;
	private int uid;
	private String unumber;
	private String passwords;
	
	public Users(int uid, String unumber, String passwords) {
		super();
		this.uid = uid;
		this.unumber = unumber;
		this.passwords = passwords;
	}
	
	

	public Users(String unumber, String passwords) {
		super();
		this.unumber = unumber;
		this.passwords = passwords;
	}



	public Users() {
		super();
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUnumber() {
		return unumber;
	}

	public void setUnumber(String unumber) {
		this.unumber = unumber;
	}

	public String getPasswords() {
		return passwords;
	}

	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}
}
