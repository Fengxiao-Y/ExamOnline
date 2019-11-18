package com.yidu.victory.popedom.dao;

import java.util.List;

import com.yidu.victory.popedom.domain.Role_popedom;

public interface Role_popedomDao {
	/**
	 * ����
	 * @param role_poprdom
	 * @return
	 */
	public int add(Role_popedom role_popedom);
	/**
	 * ɾ��
	 * @param rpid
	 * @return
	 */
	public int delete(int rpid);
	public int delete(String condition);
	/**
	 * ��ѯ����
	 * @param rpid
	 * @return
	 */
	public Role_popedom findById(int rpid);
	/**
	 * ��ҳ��ѯ
	 * @param rows
	 * @param page
	 * @return
	 */
	public List<Role_popedom> findByPage(int rows,int page);
	/**
	 * ��������ҳ��ѯ
	 * @param rows
	 * @param page
	 * @param condition
	 * @return
	 */
	public List<Role_popedom> findBycondition(String condition);
}
