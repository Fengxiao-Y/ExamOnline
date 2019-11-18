package com.yidu.victory.popedom.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Popedom implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7518427245127728555L;
	//�˵�ID   ��Ӧ���ݿ�id
	private Integer id;
	//�˵����� ��Ӧ���ݿ�text
	private String text;
	//���˵�ID
	private Integer pdmfather;
	//�Ӳ˵�
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
