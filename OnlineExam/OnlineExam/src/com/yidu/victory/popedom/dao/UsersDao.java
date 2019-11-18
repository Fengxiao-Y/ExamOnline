package com.yidu.victory.popedom.dao;

import java.util.List;

import com.yidu.victory.popedom.domain.Users;


/**
 *  ���ݲ�ӿ�
 * @author Administrator
 *
 */
public interface UsersDao{
 

	/**
	 * ���
	 * @param emp
	 * @return
	 */
	public int add(Users user);
	/**
	 * ɾ��
	 * @param empNo
	 * @return
	 */
	public int delete(int uid);
	/**
	 * �޸�
	 * @param emp
	 * @return
	 */
	public int update(Users user);
	
	/**
	 * ����Ա����Ų��ҵ���Ա����Ϣ
	 * @param empNo
	 * @return
	 */
	public Users findById(String unumber);
	public Users findById(int uid);
	
	/**
	 * ��������
	 * @return
	 */
	//public List<Emp> findAll();
	/**
	 * ��ҳ����
	 * @param rows ÿҳ��ʾ�ļ�¼��
	 * @param page ��ǰ��ʾ��ҳ����
	 * @return ָ��ҳ������Ա����Ϣ����
	 */
	public List<Users> findByPage(int rows,int page);

	/**
	 * ��������ҳ����
	 * @param rows ÿҳ��ʾ�ļ�¼��
	 * @param page ��ǰ��ʾ��ҳ����
	 * @param condition ����
	 * @return
	 */
	public List<Users> findByPage(int rows,int page,String condition);

	/**
	 * ͳ�Ƽ�¼��
	 * @return �������м�¼����
	 */
	public int count();
	
	/**
	 * ͳ�Ʒ��������ļ�¼��
	 * @param condition ����
	 * @return
	 */
	public int count(String condition);
}

