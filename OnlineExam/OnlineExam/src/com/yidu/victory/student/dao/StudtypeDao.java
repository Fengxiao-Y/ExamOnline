package com.yidu.victory.student.dao;

import java.util.List;

import com.yidu.victory.student.domain.Studtype;

public interface StudtypeDao {
		/**
		 * studtype表的增加方法
		 * @param student 实体类对象
		 * @return 影响行数
		 */
		public int add(Studtype studtype);
		/**
		 * studtype表的删除方法
		 * @param sid 主键
		 * @return 影响行数
		 */
		public int delete(String sid);
		public int deleteBycondition(String condition);
		/**
		 * studtype表的修改方法
		 * @param student 实体类对象
		 * @return 影响行数
		 */
		public int update(Studtype studtype);
		/**
		 * studtype表的查询单个方法
		 * @param sid 主键
		 * @return 实体类对象
		 */
		public Studtype findById(String sid);
		/**
		 * studtype表查询所有方法
		 * @param rows 行数
		 * @param page 页码
		 * @param condition 条件
		 * @return 实体类对象集合
		 */
		public List<Studtype> findAll(String condition);
		/**
		 * Studtype表查询记录总数
		 * @param condition 条件
		 * @return 记录总数
		 */
		public int count(String condition);
}
