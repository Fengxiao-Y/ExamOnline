/**
 * 
 */
package com.yidu.victory.excle.dao;

import java.util.List;

import com.yidu.victory.excle.domain.Conditions;

/**
 * Student表的数据层接口
 * @author tzg
 *
 */
public interface ConditionsDao {
	/**
	 * Conditions表的增加方法
	 * @param student 实体类对象
	 * @return 影响行数
	 */
	public int add(Conditions conditions);
	/**
	 * Conditions表的删除方法
	 * @param sid 主键
	 * @return 影响行数
	 */
	public int delete(int tid);
	/**
	 * Conditions表的修改方法
	 * @param student 实体类对象
	 * @return 影响行数
	 */
	public int update(Conditions conditions);
	
	/**
	 * Conditions表的查询单个方法
	 * @param sid 主键
	 * @return 实体类对象
	 */
	public Conditions findById(int tid);
	/**
	 * Conditions表查询所有方法
	 * @param rows 行数
	 * @param page 页码
	 * @param condition 条件
	 * @return 实体类对象集合
	 */
	public List<Conditions> findAll(int rows,int page,String condition);
	/**
	 * Conditions表查询记录总数
	 * @param condition 条件
	 * @return 记录总数
	 */
	public int count(String condition);
}
