package com.yidu.victory.student.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yidu.victory.JdbcUtils.JdbcUtils;
import com.yidu.victory.student.dao.DifficultyDao;
import com.yidu.victory.student.domain.Difficulty;

public class DifficultyDaoImpl implements DifficultyDao {

	@Override
	public int add(Difficulty difficulty) {
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
					String sql="insert into difficulty(tid,grade) "
							+ " values(?,?)";
					//ʵ����������
					pstmt=conn.prepareStatement(sql);
					//��SQL��丳ֵ
					pstmt.setInt(1, difficulty.getTid());
					pstmt.setString(2, difficulty.getGrade() );
					
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
			String sql="delete from difficulty where tid=?";
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
	public int update(Difficulty difficulty) {
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
			String sql="update difficulty set grade=?"
					+ " where tid=?";
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ
			pstmt.setString(1, difficulty.getGrade() );
			pstmt.setInt(2, difficulty.getTid());
			
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
	public Difficulty findById(int tid) {
		 //�������ݿ����Ӷ���
		Connection conn=null;
		//�������ݿ�������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		//��������
		Difficulty difficulty=null;
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����SQLִ�����
			String sql="select * from difficulty where tid=?";
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ
			pstmt.setInt(1, tid);
			
			//���������󷵻�
			rs=pstmt.executeQuery();
			//�жϽ�����Ƿ�Ϊ��
			if(rs.next()){
				//ʵ����ʵ�������
				difficulty=new Difficulty();
				//��������ڵ����ݸ���ʵ�������
				difficulty.setTid(rs.getInt("tid"));
				difficulty.setGrade(rs.getString("grade"));
				
			}
					
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}finally{
			JdbcUtils.close(rs, pstmt, conn);
		}
		return difficulty;
	}

	@Override
	public List<Difficulty> findAll(int rows, int page, String condition) {
		 //�������ݿ����Ӷ���
		Connection conn=null;
		//�������ݿ�������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		//��������
		List<Difficulty> difficultylist=new ArrayList<>();
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����SQLִ�����
			String sql="select * from  difficulty "+condition+" limit ?,?";
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows); //����ĳ�rows ��ʾ��ҳ����
			//���������󷵻�
			rs=pstmt.executeQuery();
			//�жϽ�����Ƿ�Ϊ��
			while(rs.next()){
				//ʵ����ʵ�������
				Difficulty difficulty=new Difficulty();
				//��������ڵ����ݸ���ʵ�������
				difficulty.setTid(rs.getInt("tid"));
				difficulty.setGrade(rs.getString("grade"));
				
				difficultylist.add(difficulty);
				
			}		
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}finally{
			JdbcUtils.close(rs, pstmt, conn);
		}
		return difficultylist;
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
			String sql="select count(*) from  difficulty "+condition;
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
