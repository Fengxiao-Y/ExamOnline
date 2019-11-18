package com.yidu.victory.student.dao;

import java.util.List;

import com.yidu.victory.student.domain.Student;

/**
 * Student������ݲ�ӿ�
 * @author tang
 *
 */
public interface StudentDao {
	/**
	 * student������ӷ���
	 * @param student ʵ�������
	 * @return Ӱ������
	 */
	public int add(Student student);
	/**
	 * student���ɾ������
	 * @param sid ����
	 * @return Ӱ������
	 */
	public int delete(String sid);
	/**
	 * student����޸ķ���
	 * @param student ʵ�������
	 * @return Ӱ������
	 */
	public int update(Student student);
	/**
	 * student��Ĳ�ѯ��������
	 * @param sid ����
	 * @return ʵ�������
	 */
	public Student findById(String sid);
	/**
	 * student���ѯ���з���
	 * @param rows ����
	 * @param page ҳ��
	 * @param condition ����
	 * @return ʵ������󼯺�
	 */
	public List<Student> findAll(int rows,int page,String condition);
	/**
	 * Student���ѯ��¼����
	 * @param condition ����
	 * @return ��¼����
	 */
	public int count(String condition);
	public List<Student> findAll(String condition);
}
