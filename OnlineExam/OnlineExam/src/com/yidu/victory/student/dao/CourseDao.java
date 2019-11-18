package com.yidu.victory.student.dao;

import java.util.List;
/**
 * course������ݲ�ӿ�
 */

import com.yidu.victory.student.domain.Course;



public interface CourseDao {
	/**
	 * course������ӷ���
	 * @param course ʵ�������
	 * @return Ӱ������
	 */
	public int add(Course course);
	/**
	 * course���ɾ������
	 * @param
	 * @return Ӱ������
	 */
	public int delete(int cid);
	/**
	 * courset����޸ķ���
	 * @param course ʵ�������
	 * @return Ӱ������
	 */
	public int update(Course course);
	/**
	 * course��Ĳ�ѯ��������
	 * @param cid ����
	 * @return ʵ�������
	 */
	public Course findById(String cid);
	/**
	 * course���ѯ���з���
	 * @param rows ����
	 * @param page ҳ��
	 * @param condition ����
	 * @return ʵ������󼯺�
	 */
	public List<Course> findAll(int rows,int page,String condition);
	/**
	 * courset���ѯ��¼����
	 * @param condition ����
	 * @return ��¼����
	 */
	public int count(String condition);
	public List<Course> findAll();
	public Course findAll(String condition);
	
}
