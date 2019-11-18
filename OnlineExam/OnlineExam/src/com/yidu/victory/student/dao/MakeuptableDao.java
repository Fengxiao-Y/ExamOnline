/**
 * 
 */
package com.yidu.victory.student.dao;

import java.util.List;

import com.yidu.victory.student.domain.Makeuptable;

/**
 * 内容：Makeuptable表的数据层接口
 * 作者 tzh
 * 编写日期:下午7:40:45
 * 版本1.0
 */
public interface MakeuptableDao {
	/**
	 * Makeuptable表的增加方法
	 * @param student 实体类对象
	 * @return 影响行数
	 */
	public int add(Makeuptable makeuptable);
	
	/**
	 * Makeuptable表的删除方法
	 * @param student 实体类对象
	 * @return 影响行数
	 */
	public int delete(int sid);
	
	/**
	 * Makeuptable表的修改方法
	 * @param student 实体类对象
	 * @return 影响行数
	 */
	public int update(Makeuptable makeuptable);
	/**
	 * Makeuptable表的查询单个方法
	 * @param sid 主键
	 * @return 实体类对象
	 */
	public Makeuptable findById(String sid);
	/**
	 * Makeuptable表查询所有方法
	 * @param rows 行数
	 * @param page 页码
	 * @param condition 条件
	 * @return 实体类对象集合
	 */
	public List<Makeuptable> findAll(int rows,int page,String condition);
	/**
	 * Makeuptable表查询记录总数
	 * @param condition 条件
	 * @return 记录总数
	 */
	public int count(String condition);
}
