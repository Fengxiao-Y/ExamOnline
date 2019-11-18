package com.yidu.victory.student.dao;

import java.util.List;

import com.yidu.victory.student.domain.Studtype;

public interface StudtypeDao {
		/**
		 * studtype������ӷ���
		 * @param student ʵ�������
		 * @return Ӱ������
		 */
		public int add(Studtype studtype);
		/**
		 * studtype���ɾ������
		 * @param sid ����
		 * @return Ӱ������
		 */
		public int delete(String sid);
		public int deleteBycondition(String condition);
		/**
		 * studtype����޸ķ���
		 * @param student ʵ�������
		 * @return Ӱ������
		 */
		public int update(Studtype studtype);
		/**
		 * studtype��Ĳ�ѯ��������
		 * @param sid ����
		 * @return ʵ�������
		 */
		public Studtype findById(String sid);
		/**
		 * studtype���ѯ���з���
		 * @param rows ����
		 * @param page ҳ��
		 * @param condition ����
		 * @return ʵ������󼯺�
		 */
		public List<Studtype> findAll(String condition);
		/**
		 * Studtype���ѯ��¼����
		 * @param condition ����
		 * @return ��¼����
		 */
		public int count(String condition);
}
