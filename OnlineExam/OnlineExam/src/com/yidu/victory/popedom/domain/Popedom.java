package com.yidu.victory.popedom.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Popedom implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7518427245127728555L;
	//菜单ID   对应数据库id
	private Integer id;
	//菜单名称 对应数据库text
	private String text;
	//父菜单ID
	private Integer pdmfather;
	//子菜单
	private List<Popedom> children = new ArrayList<>();
	public Popedom() {
		super();
	}
	public Popedom(Integer id, String text, Integer pdmfather, List<Popedom> chilrden) {
		super();
		this.id = id;
		this.text = text;
		this.pdmfather = pdmfather;
		this.children = children;
	}
	public Popedom(String text, Integer pdmfather, List<Popedom> children) {
		super();
		this.text = text;
		this.pdmfather = pdmfather;
		
		this.children = children;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Integer getPdmfather() {
		return pdmfather;
	}
	public void setPdmfather(Integer pdmfather) {
		this.pdmfather = pdmfather;
	}
	public List<Popedom> getChildren() {
		return children;
	}
	public void setChilden(List<Popedom> children) {
		this.children = children;
	}
	
	
	
	
}
