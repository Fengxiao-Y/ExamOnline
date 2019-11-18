/**
 * 
 */
package com.yidu.victory.student.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yidu.victory.JdbcUtils.JdbcUtils;
import com.yidu.victory.student.dao.MakeuptableDao;
import com.yidu.victory.student.domain.Makeuptable;

/**
 * ���ݣ�
 * ���� tzh
 * ��д����:����3:19:03
 * �汾1.0
 */
public class MakeuptableDaoImpl  implements MakeuptableDao{
	/* (non-Javadoc)
	 * @see com.yidu.victory.makeuptable.dao.MakeuptableDao#add(com.yidu.victory.makeuptable.domain.Makeuptable)
	 */
	@Override
	public int add(Makeuptable makeuptable) {
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
			String sql="insert into makeuptable(sid,sname,grade,squadId,eid,conditions) "
					+ " values(?,?,?,?,?,?)";
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ
			pstmt.setInt(1, makeuptable.getSid());
			pstmt.setString(2, makeuptable.getSname());
			pstmt.setInt(3, makeuptable.getGrade());
			pstmt.setInt(4, makeuptable.getSquadid());
			pstmt.setInt(5, makeuptable.getEid());
			pstmt.setString(6, makeuptable.getConditions());
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
	 * @see com.yidu.victory.makeuptable.dao.MakeuptableDao#delete(int)
	 */
	@Override
	public int delete(int sid) {
		//�������ݿ����Ӷ���
		Connection conn=null;
		//�������ݿ�������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		//��������
		int rows=0;
		System.out.print("xxxxx"+rows);
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����SQLִ�����
			String sql="delete from makeuptable where sid=?";
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ
			pstmt.setInt(1 ,sid);
			
			//���������󷵻�
			rows=pstmt.executeUpdate();
			System.out.println("ssss"+rows);
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}finally{
			JdbcUtils.close(rs, pstmt, conn);
		}
		return rows;
	}
	
	/* (non-Javadoc)
	 * @see com.yidu.victory.makeuptable.dao.MakeuptableDao#update(com.yidu.victory.makeuptable.domain.Makeuptable)
	 */
	@Override
	public int update(Makeuptable makeuptable) {
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
					String sql="update makeuptable set sname=?,grade=?,squadId=?,eid=?,"
							+ "conditions=? where sid=?";
					//ʵ����������
					pstmt=conn.prepareStatement(sql);
					//��SQL��丳ֵ
					
					pstmt.setString(1, makeuptable.getSname());
					pstmt.setInt(2, makeuptable.getGrade());
					pstmt.setInt(3, makeuptable.getSquadid());
					pstmt.setInt(4, makeuptable.getEid());
					pstmt.setString(5, makeuptable.getConditions());
					pstmt.setInt(6, makeuptable.getSid());
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
	 * @see com.yidu.victory.makeuptable.dao.MakeuptableDao#findById(java.lang.String)
	 */
	@Override
	public Makeuptable findById(String sid) {
			//�������ݿ����Ӷ���
				Connection conn=null;
				//�������ݿ�������
				PreparedStatement pstmt=null;
				//�������������
				ResultSet rs=null;
				//��������
				Makeuptable makeuptable=null;
				try {
					//ʵ�������ݿ����Ӷ���
					conn=JdbcUtils.getConnection();
					//����SQLִ�����
					String sql="select * from Makeuptable where sid=?";
					//ʵ����������
					pstmt=conn.prepareStatement(sql);
					//��SQL��丳ֵ
					pstmt.setString(1, sid);
					//���������󷵻�
					rs=pstmt.executeQuery();
					//�жϽ�����Ƿ�Ϊ��
					if(rs.next()){
						//ʵ����ʵ�������
						makeuptable=new Makeuptable();
						//��������ڵ����ݸ���ʵ�������
						makeuptable.setSid(rs.getInt("sid"));
						makeuptable.setSname(rs.getString("sname"));
						makeuptable.setGrade(rs.getInt("grade"));
						makeuptable.setSquadid(rs.getInt("squadid"));
						makeuptable.setEid(rs.getInt("eid"));
						makeuptable.setConditions(rs.getString("conditions"));
						
					}
							
					} catch (SQLException e) {
						throw new RuntimeException(e.getMessage());
					}finally{
						JdbcUtils.close(rs, pstmt, conn);
					}
				return makeuptable;
			}
	
	/* (non-Javadoc)
	 * @see com.yidu.victory.makeuptable.dao.MakeuptableDao#findAll(int, int, java.lang.String)
	 */
	@Override
	public List<Makeuptable> findAll(int rows, int page, String condition) {
		//�������ݿ����Ӷ���
				Connection conn=null;
				//�������ݿ�������
				PreparedStatement pstmt=null;
				//�������������
				ResultSet rs=null;
				//��������
				List<Makeuptable> makeuptablelist=new ArrayList<>();
				try {
					//ʵ�������ݿ����Ӷ���
					conn=JdbcUtils.getConnection();
					//����SQLִ�����
					String sql="select * from makeuptable "+condition+" limit ?,?";
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
						Makeuptable makeuptable=new Makeuptable();
						//��������ڵ����ݸ���ʵ�������
						makeuptable.setSid(rs.getInt("sid"));
						makeuptable.setSname(rs.getString("sname"));
						makeuptable.setGrade(rs.getInt("grade"));
						makeuptable.setSquadid(rs.getInt("squadid"));
						makeuptable.setEid(rs.getInt("eid"));
						makeuptable.setConditions(rs.getString("conditions"));
						
						makeuptablelist.add(makeuptable);
						
					}
							
					} catch (SQLException e) {
						throw new RuntimeException(e.getMessage());
					}finally{
						JdbcUtils.close(rs, pstmt, conn);
					}
				return makeuptablelist;
			}
	
	/* (non-Javadoc)
	 * @see com.yidu.victory.makeuptable.dao.MakeuptableDao#count(java.lang.String)
	 */
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
					String sql="select count(*) from makeuptable "+condition;
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