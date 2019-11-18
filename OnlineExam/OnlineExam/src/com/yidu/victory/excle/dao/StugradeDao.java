package com.yidu.victory.excle.dao;

import java.util.List;

import com.yidu.victory.excle.domain.Stugrade;

/**
 * Stugrade表的数据层接口
 * @author asus
 *
 */
public interface StugradeDao {
	/**
	 * Stugrade表的增加方法
	 * @param stugrade
	 * @return
	 */
	public int add(Stugrade stugrade);
	
	/**
	 * Stugrade表的删除方法
	 * @param gid
	 * @return
	 */
	public int delete(int gid);
	
	/**
	 * Stugrade表的修改方法
	 * @param stugrade
	 * @return
	 */
	public int update(Stugrade stugrade);
	
	/**
	 * Stugrade表的查询单个方法
	 * @param gid
	 * @return
	 */
	public Stugrade findById(int gid);
	
	/**
	 * Stugrade表的查询所有方法
	 * @param rows
	 * @param page
	 * @param conditon
	 * @return
	 */
	public List<Stugrade> findAll(int rows,int page,String condition);
	
	/**
	 * Stugrade表的查询记录总数
	 * @param conditon
	 * @return
	 */
	public int count(String condition);
	public Stugrade findByCondition(String condition);
}
