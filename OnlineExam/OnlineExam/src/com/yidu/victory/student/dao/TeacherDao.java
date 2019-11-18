package com.yidu.victory.student.dao;

import java.util.List;
/**
 * teacher���ݲ�ӿ�
 * @author Administrator
 *
 */

import com.yidu.victory.student.domain.Teacher;

public interface TeacherDao {
	/**
	 * teacher������ӷ���
	 * @param teacher ʵ�������
	 * @return Ӱ������
	 */
	public int add(Teacher teacher);
	/**
	 * teacher���ɾ������
	 * @param tid ����
	 * @return Ӱ������
	 */
	public int delete(String tid);
	/**
	 * teacher����޸ķ���
	 * @param teacher ʵ�������
	 * @return Ӱ������
	 */
	public int update(Teacher teacher);
	/**
	 * teacher��Ĳ�ѯ��������
	 * @param tid ����
	 * @return ʵ�������
	 */
	public Teacher findById(String tid);
	/**
	 * teacher���ѯ���з���
	 * @param rows ����
	 * @param page ҳ��
	 * @param condition ����
	 * @return ʵ������󼯺�
	 */
	public List<Teacher> findAll(int rows,int page,String condition);
	/**
	 * teacher���ѯ��¼����
	 * @param condition ����
	 * @return ��¼����
	 */
	public int count(String condition);
	public List<Teacher> findAll();
}
