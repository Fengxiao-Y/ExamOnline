package com.yidu.victory.student.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yidu.victory.JdbcUtils.JdbcUtils;
import com.yidu.victory.student.dao.StudtypeDao;
import com.yidu.victory.student.domain.Studtype;

public class StudtypeDaoImpl implements StudtypeDao {

	@Override
	public int add(Studtype studtype) {
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
			String sql="insert into studtype(sid,examtype,squadid) values(?,?,?)";
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ
			pstmt.setString(1, studtype.getSid());
			pstmt.setInt(2, studtype.getExamtype());
			pstmt.setInt(3, studtype.getSquadid());
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
	public int delete(String sid) {
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
			String sql="delete from studtype where sid=?";
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ
			pstmt.setString(1, sid);
			
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
	public int update(Studtype studtype) {
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
			String sql="update studtype set examtype=?,squadid=? where sid=?";
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ
			pstmt.setInt(1, studtype.getExamtype());
			pstmt.setInt(2, studtype.getSquadid());
			pstmt.setString(3, studtype.getSid());
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
	public Studtype findById(String sid) {
		//�������ݿ����Ӷ���
		Connection conn=null;
		//�������ݿ�������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		//��������
		Studtype studtype=null;
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����SQLִ�����
			String sql="select * from studtype where sid=?";
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ
			pstmt.setString(1, sid);
			//���������󷵻�
			rs=pstmt.executeQuery();
			//�жϽ�����Ƿ�Ϊ��
			if(rs.next()){
				//ʵ����ʵ�������
				studtype=new Studtype();
				//��������ڵ����ݸ���ʵ�������
				studtype.setSid(rs.getString("sid"));		
				studtype.setExamtype(rs.getInt("examtype"));
				studtype.setSquadid(rs.getInt("squadid"));
			}
					
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}finally{
				JdbcUtils.close(rs, pstmt, conn);
			}
		return studtype;
	}

	@Override
	public List<Studtype> findAll(String condition) {
		//�������ݿ����Ӷ���
		Connection conn=null;
		//�������ݿ�������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		//��������
		List<Studtype> studtypelist=new ArrayList<>();
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����SQLִ�����
			String sql="select * from studtype ";
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//���������󷵻�
			rs=pstmt.executeQuery();
			//�жϽ�����Ƿ�Ϊ��
			while(rs.next()){
				//ʵ����ʵ�������
				Studtype studtype=new Studtype();
				//��������ڵ����ݸ���ʵ�������
				studtype.setSid(rs.getString ("sid"));
				studtype.setExamtype(rs.getInt("examtype"));
				studtype.setSquadid(rs.getInt("squadid"));
				//��ӵ�����
				studtypelist.add(studtype);	
			}
					
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}finally{
				JdbcUtils.close(rs, pstmt, conn);
			}
			return studtypelist;
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
			String sql="select count(*) from studtype "+condition;
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

	@Override
	public int deleteBycondition(String condition) {
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
					String sql="delete from studtype  "+condition;
					//ʵ����������
					pstmt=conn.prepareStatement(sql);
					
					
					//���������󷵻�
					rows=pstmt.executeUpdate();
					
				} catch (SQLException e) {
					throw new RuntimeException(e.getMessage());
				}finally{
					JdbcUtils.close(rs, pstmt, conn);
				}
				return rows;
	}

}
