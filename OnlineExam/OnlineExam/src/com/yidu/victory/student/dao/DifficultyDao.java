package com.yidu.victory.student.dao;

import java.util.List;
/**
 * difficulty的数据层接口
 */

import com.yidu.victory.student.domain.Difficulty;



public interface DifficultyDao {
	/**
	 * difficulty表的增加方法
	 * @param adifficulty 实体类对象
	 * @return 影响行数
	 */
	public int add(Difficulty difficulty);
	/**
	 * difficulty表的删除方法
	 * @param
	 * @return 影响行数
	 */
	public int delete(int tid);
	/**
	 * difficulty表的修改方法
	 * @param difficulty 实体类对象
	 * @return 影响行数
	 */
	public int update(Difficulty difficulty);
	/**
	 * difficulty表的查询单个方法
	 * @param tid 主键
	 * @return 实体类对象
	 */
	public Difficulty findById(int tid);
	/**
	 * difficulty表查询所有方法
	 * @param rows 行数
	 * @param page 页码
	 * @param condition 条件
	 * @return 实体类对象集合
	 */
	public List<Difficulty> findAll(int rows,int page,String condition);
	/**
	 * difficulty表查询记录总数
	 * @param difficulty 条件
	 * @return 记录总数
	 */
	public int count(String condition);
}
