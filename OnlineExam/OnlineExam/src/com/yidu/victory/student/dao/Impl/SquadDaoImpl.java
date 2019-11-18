package com.yidu.victory.student.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yidu.victory.JdbcUtils.JdbcUtils;
import com.yidu.victory.student.dao.SquadDao;
import com.yidu.victory.student.domain.Squad;
import com.yidu.victory.student.domain.Student;

public class SquadDaoImpl implements SquadDao {

	@Override
	public int add(Squad squad) {
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
					String sql="insert into squad(snumber,speople,squadtime,teacher,"
							+ "sadministration,state,classify)"
							
							+ "  values(?,?,?,?,?,?,?)";
					//ʵ����������
					pstmt=conn.prepareStatement(sql);
					//��SQL��丳ֵ
					pstmt.setString(1, squad.getSnumber() );
					pstmt.setInt(2, squad.getSpeople());
					pstmt.setString(3, squad.getSquadtime() );
					pstmt.setString(4, squad.getTeacher());
					pstmt.setString(5, squad.getSadministration());
					pstmt.setString(6, squad.getState());
					pstmt.setString(7, squad.getClassify());
					
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
	public int delete(int sqid) {
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
			String sql="delete from squad where sqid=?";
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ
			pstmt.setInt(1,sqid);
			
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
	public int update(Squad squad) {
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
			String sql="update squad set snumber=?,speople=?,"
					+ "squadtime=?,teacher=?,sadministration=?,"
					+ "state=?,classify=? where sqid=?";
					
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ

			pstmt.setString(1, squad.getSnumber() );
			pstmt.setInt(2, squad.getSpeople());
			pstmt.setString(3, squad.getSquadtime() );
			pstmt.setString(4, squad.getTeacher());
			pstmt.setString(5, squad.getSadministration());
			pstmt.setString(6, squad.getState());
			pstmt.setString(7, squad.getClassify());
			pstmt.setInt(8, squad.getsqid());
			
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
	public Squad findById(int sqid) {
		//�������ݿ����Ӷ���
		Connection conn=null;
		//�������ݿ�������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		//��������
		Squad squad=null;
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����SQLִ�����
			String sql="select * from squad where sqid=?";
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ
			pstmt.setInt(1, sqid);
			
			//���������󷵻�
			rs=pstmt.executeQuery();
			//�жϽ�����Ƿ�Ϊ��
			if(rs.next()){
				//ʵ����ʵ�������
				squad=new Squad();
				//��������ڵ����ݸ���ʵ�������
				squad.setsqid(rs.getInt("sqid"));
				squad.setSnumber(rs.getString("snumber"));
				squad.setSpeople(rs.getInt("speople"));
				squad.setSquadtime(rs.getString("squadtime"));
				squad.setTeacher(rs.getString("teacher"));
				squad.setSadministration(rs.getString("sadministration"));
				squad.setState(rs.getString("state"));
				squad.setClassify(rs.getString("classify"));
				
				
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}finally{
			JdbcUtils.close(rs, pstmt, conn);
		}
		return squad;
	}

	@Override
	public List<Squad> findAll(int rows, int page, String condition) {
		//�������ݿ����Ӷ���
		Connection conn=null;
		//�������ݿ�������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		//��������
		List<Squad> squadlist=new ArrayList<>();
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����SQLִ�����
			String sql="select * from squad  "+condition+" limit ?,?";
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
				Squad squad=new Squad();
				//��������ڵ����ݸ���ʵ�������
				squad.setsqid(rs.getInt("sqid"));
				squad.setSnumber(rs.getString("snumber"));
				squad.setSpeople(rs.getInt("speople"));
				squad.setSquadtime(rs.getString("squadtime"));
				squad.setTeacher(rs.getString("teacher"));
				squad.setSadministration(rs.getString("sadministration"));
				squad.setState(rs.getString("state"));
				squad.setClassify(rs.getString("classify"));
				
				squadlist.add(squad);
				
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}finally{
			JdbcUtils.close(rs, pstmt, conn);
		}
		return squadlist;
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
			String sql="select count(*) from squad "+condition;
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ
			
			
			//���������󷵻�
			rs=pstmt.executeQuery();
			if(rs.next()){
				rows=rs.getInt(1);
			}
		}catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}finally{
			JdbcUtils.close(rs, pstmt, conn);
		}
		return rows;
	}

	@Override
	public List<Squad> findAll() {
		//�������ݿ����Ӷ���
				Connection conn=null;
				//�������ݿ�������
				PreparedStatement pstmt=null;
				//�������������
				ResultSet rs=null;
				//��������
				List<Squad> squadlist=new ArrayList<>();
				try {
					//ʵ�������ݿ����Ӷ���
					conn=JdbcUtils.getConnection();
					//����SQLִ�����
					String sql="select * from squad  ";
					//ʵ����������
					pstmt=conn.prepareStatement(sql);
					//��SQL��丳ֵ
					//���������󷵻�
					rs=pstmt.executeQuery();
					//�жϽ�����Ƿ�Ϊ��
					while(rs.next()){
						//ʵ����ʵ�������
						Squad squad=new Squad();
						//��������ڵ����ݸ���ʵ�������
						squad.setsqid(rs.getInt("sqid"));
						squad.setSnumber(rs.getString("snumber"));
						squad.setSpeople(rs.getInt("speople"));
						squad.setSquadtime(rs.getString("squadtime"));
						squad.setTeacher(rs.getString("teacher"));
						squad.setSadministration(rs.getString("sadministration"));
						squad.setState(rs.getString("state"));
						squad.setClassify(rs.getString("classify"));
						
						squadlist.add(squad);
						
					}
					
				} catch (SQLException e) {
					throw new RuntimeException(e.getMessage());
				}finally{
					JdbcUtils.close(rs, pstmt, conn);
				}
				return squadlist;
	}

}
