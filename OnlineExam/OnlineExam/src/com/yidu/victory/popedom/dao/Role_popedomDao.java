package com.yidu.victory.popedom.dao;

import java.util.List;

import com.yidu.victory.popedom.domain.Role_popedom;

public interface Role_popedomDao {
	/**
	 * 增加
	 * @param role_poprdom
	 * @return
	 */
	public int add(Role_popedom role_popedom);
	/**
	 * 删除
	 * @param rpid
	 * @return
	 */
	public int delete(int rpid);
	public int delete(String condition);
	/**
	 * 查询单个
	 * @param rpid
	 * @return
	 */
	public Role_popedom findById(int rpid);
	/**
	 * 分页查询
	 * @param rows
	 * @param page
	 * @return
	 */
	public List<Role_popedom> findByPage(int rows,int page);
	/**
	 * 按条件分页查询
	 * @param rows
	 * @param page
	 * @param condition
	 * @return
	 */
	public List<Role_popedom> findBycondition(String condition);
}
