package com.yidu.victory.student.dao;

import java.util.List;
/**
 * squad表的数据层接口
 */

import com.yidu.victory.student.domain.Squad;


public interface SquadDao {
	/**
	 * squad表的增加方法
	 * @param squadt 实体类对象
	 * @return 影响行数
	 */
	public int add(Squad squad);
	/**
	 * squad表的删除方法
	 * @param sid 主键
	 * @return 影响行数
	 */
	public int delete(int sqid);
	/**
	 * squad表的修改方法
	 * @param squad 实体类对象
	 * @return 影响行数
	 */
	public int update(Squad squad);
	/**
	 * squad表的查询单个方法
	 * @param sid 主键
	 * @return 实体类对象
	 */
	public Squad findById(int sqid);
	/**
	 * squad表查询所有方法
	 * @param rows 行数
	 * @param page 页码
	 * @param condition 条件
	 * @return 实体类对象集合
	 */
	public List<Squad> findAll(int rows,int page,String condition);
	/**
	 * squad表查询记录总数
	 * @param condition 条件
	 * @return 记录总数
	 */
	public int count(String condition);
	public List<Squad> findAll();
}
