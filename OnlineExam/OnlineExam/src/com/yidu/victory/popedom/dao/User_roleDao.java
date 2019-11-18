package com.yidu.victory.popedom.dao;

import java.util.List;

import com.yidu.victory.popedom.domain.User_role;

public interface User_roleDao {
	/**
	 * 添加方法
	 * @param user_role 对象
	 * @return 
	 */
	public int add(User_role user_role);
	public int update(User_role user_role);
	
	/**
	 * 删除
	 * @param unumber
	 * @return
	 */
	public int delete(String unumber);
	/**
	 * 查询所有
	 * @return 返回对象 
	 */
	public List<User_role> findByPage(int rows,int page);
	/**
	 * 带条件查询
	 * 
	 * @param rows
	 * @param page
	 * @param condition
	 * @return
	 */
	public List<User_role> findByPage(int rows,int page,String condition);
	//查单个方法
	public User_role findById(String unumber);
}
	
