package com.yidu.victory.student.dao;

import java.util.List;
/**
 * teacher数据层接口
 * @author Administrator
 *
 */

import com.yidu.victory.student.domain.Teacher;

public interface TeacherDao {
	/**
	 * teacher表的增加方法
	 * @param teacher 实体类对象
	 * @return 影响行数
	 */
	public int add(Teacher teacher);
	/**
	 * teacher表的删除方法
	 * @param tid 主键
	 * @return 影响行数
	 */
	public int delete(String tid);
	/**
	 * teacher表的修改方法
	 * @param teacher 实体类对象
	 * @return 影响行数
	 */
	public int update(Teacher teacher);
	/**
	 * teacher表的查询单个方法
	 * @param tid 主键
	 * @return 实体类对象
	 */
	public Teacher findById(String tid);
	/**
	 * teacher表查询所有方法
	 * @param rows 行数
	 * @param page 页码
	 * @param condition 条件
	 * @return 实体类对象集合
	 */
	public List<Teacher> findAll(int rows,int page,String condition);
	/**
	 * teacher表查询记录总数
	 * @param condition 条件
	 * @return 记录总数
	 */
	public int count(String condition);
	public List<Teacher> findAll();
}
