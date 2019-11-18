package com.yidu.victory.excle.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yidu.victory.JdbcUtils.JdbcUtils;
import com.yidu.victory.excle.dao.ConditionsDao;
import com.yidu.victory.excle.domain.Conditions;

/**
 * ���ݣ�
 * ���� tzh
 * ��д����:����6:52:17
 * �汾1.0
 */
public class ConditionsDaoImpl implements ConditionsDao {

	/* (non-Javadoc)
	 * @see com.yidu.victry.excle.dao.ConditionsDao#add(com.yidu.victry.excle.domain.Conditions)
	 */
	@Override
	public int add(Conditions conditions) {
		//�������ݿ����Ӷ���
				Connection conn=null;
				//�������ݿ�������
				PreparedStatement pstmt=null;
				//�������������
				ResultSet rs=null;
				//��������
				int rows=0;
				try{
					//ʵ�������ݿ����Ӷ���
					conn=JdbcUtils.getConnection();
					//����SQLִ�����
					String sql="insert into conditions(tid,falsely) values(?,?)";
					//ʵ����������
					pstmt=conn.prepareStatement(sql);
					//��SQL��丳ֵ
					pstmt.setInt(1, conditions.getTid());
					pstmt.setDouble(2, conditions.getFalsely());
					//���������󷵻�
					rows=pstmt.executeUpdate();
				} catch (SQLException e) {
					throw new RuntimeException(e.getMessage());
				}finally{
					JdbcUtils.close(rs, pstmt, conn);
				}
				return rows;
			}

	/* (non-Javadoc)
	 * @see com.yidu.victry.excle.dao.ConditionsDao#delete(int)
	 */
	@Override
	public int delete(int tid) {
		//�������ݿ����Ӷ���
				Connection conn=null;
				//�������ݿ�������
				PreparedStatement pstmt=null;
				//�������������
				ResultSet rs=null;
				//��������
				int rows=0;
				try {
					//ʵ�������ݿ����Ӷ���
					conn=JdbcUtils.getConnection();
					//����SQLִ�����
					String sql="delete from conditions where tid=?";
					//ʵ����������
					pstmt=conn.prepareStatement(sql);
					//��SQL��丳ֵ
					pstmt.setInt(1,tid);
					
					//���������󷵻�
					rows=pstmt.executeUpdate();
					
				} catch (SQLException e) {
					throw new RuntimeException(e.getMessage());
				}finally{
					JdbcUtils.close(rs, pstmt, conn);
				}
				return rows;
			}
	
	@Override
	public int update(Conditions conditions) {
		//�������ݿ����Ӷ���
		Connection conn=null;
		//�������ݿ�������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		//��������
		int rows=0;
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����SQLִ�����
			String sql="update Conditions set falsely=? where tid=?";
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ
			
			pstmt.setDouble(1, conditions.getFalsely());
			pstmt.setInt(2, conditions.getTid());

			//���������󷵻�
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}finally{
			JdbcUtils.close(rs, pstmt, conn);
		}
		return rows;
}
	@Override
	public Conditions findById(int tid) {
			//�������ݿ����Ӷ���
			Connection conn=null;
			//�������ݿ�������
			PreparedStatement pstmt=null;
			//�������������
			ResultSet rs=null;
			//��������
			Conditions conditions=null;
			try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����SQLִ�����
			String sql="select * from conditions where tid=?";
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ
			pstmt.setInt(1, tid);
			//���������󷵻�
			rs=pstmt.executeQuery();
			//�жϽ�����Ƿ�Ϊ��
			if(rs.next()){
				//ʵ����ʵ�������
				conditions=new Conditions();
				//��������ڵ����ݸ���ʵ�������
				conditions.setTid(rs.getInt("tid"));
				conditions.setFalsely(rs.getDouble("falsely"));
				
				
			}
					
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}finally{
				JdbcUtils.close(rs, pstmt, conn);
			}
		return conditions;
			}

	@Override
	public List<Conditions> findAll(int rows, int page, String condition) {
		//�������ݿ����Ӷ���
				Connection conn=null;
				//�������ݿ�������
				PreparedStatement pstmt=null;
				//�������������
				ResultSet rs=null;
				//��������
				List<Conditions> conditionslist=new ArrayList<>();
				try {
					//ʵ�������ݿ����Ӷ���
					conn=JdbcUtils.getConnection();
					//����SQLִ�����
					String sql="select * from conditions "+condition+" limit ?,?";
					//ʵ����������
					pstmt=conn.prepareStatement(sql);
					//��SQL��丳ֵ
					pstmt.setInt(1, (page-1)*rows);
					pstmt.setInt(2, rows);
					//���������󷵻�
					rs=pstmt.executeQuery();
					//�жϽ�����Ƿ�Ϊ��
					while(rs.next()){
						//ʵ����ʵ�������
						Conditions conditions=new Conditions();
						//��������ڵ����ݸ���ʵ�������
						conditions.setTid(rs.getInt("tid"));
						conditions.setFalsely(rs.getDouble("falsely"));
						conditionslist.add(conditions);
						
					}
							
					} catch (SQLException e) {
						throw new RuntimeException(e.getMessage());
					}finally{
						JdbcUtils.close(rs, pstmt, conn);
					}
				return conditionslist;
			}

	@Override
	public int count(String condition) {
		//�������ݿ����Ӷ���
				Connection conn=null;
				//�������ݿ�������
				PreparedStatement pstmt=null;
				//�������������
				ResultSet rs=null;
				//��������
				int rows=0;
				try {
					//ʵ�������ݿ����Ӷ���
					conn=JdbcUtils.getConnection();
					//����SQLִ�����
					String sql="select count(*) from conditions "+condition;
					//ʵ����������
					pstmt=conn.prepareStatement(sql);
					//��SQL��丳ֵ
					
					//���������󷵻�
					rs=pstmt.executeQuery();
					if(rs.next()){
						rows=rs.getInt(1);
					}
					
				} catch (SQLException e) {
					throw new RuntimeException(e.getMessage());
				}finally{
					JdbcUtils.close(rs, pstmt, conn);
				}
				return rows;
			}

		}
