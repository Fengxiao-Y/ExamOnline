package com.yidu.victory.excle.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yidu.victory.JdbcUtils.JdbcUtils;
import com.yidu.victory.excle.dao.StugradeDao;
import com.yidu.victory.excle.domain.Stugrade;

public class StugradeDaoImpl implements StugradeDao {

	@Override
	public int add(Stugrade stugrade) {
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
			String sql="insert into stugrade(sid,sname,grade,squadid,cid,remark) "
					+ "values(?,?,?,?,?,?)";
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ
			
			pstmt.setString(1, stugrade.getSid());;
			pstmt.setString(2, stugrade.getSname());
			pstmt.setInt(3, stugrade.getGrade());
			pstmt.setInt(4, stugrade.getSquadid().getsqid());
			pstmt.setInt(5, stugrade.getcid().getEid());
			pstmt.setString(6, stugrade.getRemark());

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
	public int delete(int gid) {
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
			String sql="delete from stugrade where gid=?";
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ
			pstmt.setInt(1, gid);
			
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
	public int update(Stugrade stugrade) {
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
			String sql="update stugrade set sid=?,sname=?,grade=?,squadid=?, "
					+ " cid=?,remark=? where gid=?";
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ		
			pstmt.setString(1, stugrade.getSid());;
			pstmt.setString(2, stugrade.getSname());
			pstmt.setInt(3, stugrade.getGrade());
			pstmt.setInt(4, stugrade.getSquadid().getsqid());
			pstmt.setInt(5, stugrade.getcid().getEid());
			pstmt.setString(6, stugrade.getRemark());
			pstmt.setInt(7, stugrade.getGid());
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
	public Stugrade findById(int gid) {
		//�������ݿ����Ӷ���
		Connection conn=null;
		//�������ݿ�������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		//��������
		Stugrade stugrade=null;
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����SQLִ�����
			String sql="select * from stugrade where gid=?";
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ
			pstmt.setInt(1, gid);
			//���������󷵻�
			rs=pstmt.executeQuery();
			//�жϽ�����Ƿ�Ϊ��
			if(rs.next()){
				//ʵ����ʵ�������
				stugrade=new Stugrade();
				//��������ڵ����ݸ���ʵ�������
				stugrade.setGid(rs.getInt("gid"));
				stugrade.setSid(rs.getString("sid"));
				stugrade.setSname(rs.getString("sname"));
				stugrade.setGrade(rs.getInt("grade"));
				stugrade.setSquadid(rs.getInt("squadid"));
				stugrade.setcid(rs.getInt("cid"));
				stugrade.setRemark(rs.getString("remark"));
			}
					
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}finally{
				JdbcUtils.close(rs, pstmt, conn);
			}
		return stugrade;
	}

	@Override
	public List<Stugrade> findAll(int rows, int page, String condition) {
		//�������ݿ����Ӷ���
		Connection conn=null;
		//�������ݿ�������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		//��������
		List<Stugrade> stugradelist=new ArrayList<>();
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����SQLִ�����
			String sql="select * from stugrade "+condition+" limit ?,?";
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
				Stugrade stugrade=new Stugrade();
				//��������ڵ����ݸ���ʵ�������
				stugrade.setGid(rs.getInt("gid"));
				stugrade.setSid(rs.getString("sid"));
				stugrade.setSname(rs.getString("sname"));
				stugrade.setGrade(rs.getInt("grade"));
				stugrade.setSquadid(rs.getInt("squadid"));
				stugrade.setcid(rs.getInt("cid"));
				stugrade.setRemark(rs.getString("remark"));
				
				stugradelist.add(stugrade);
			}	
					
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}finally{
				JdbcUtils.close(rs, pstmt, conn);
			}
		return stugradelist;
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
			String sql="select count(*) from stugrade "+condition;
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
	public Stugrade findByCondition(String condition) {
		//�������ݿ����Ӷ���
				Connection conn=null;
				//�������ݿ�������
				PreparedStatement pstmt=null;
				//�������������
				ResultSet rs=null;
				//��������
				Stugrade stugrade=null;
				try {
					//ʵ�������ݿ����Ӷ���
					conn=JdbcUtils.getConnection();
					//����SQLִ�����
					String sql="select * from stugrade "+condition;
					//ʵ����������
					pstmt=conn.prepareStatement(sql);

					//���������󷵻�
					rs=pstmt.executeQuery();
					//�жϽ�����Ƿ�Ϊ��
					if(rs.next()){
						//ʵ����ʵ�������
						stugrade=new Stugrade();
						//��������ڵ����ݸ���ʵ�������
						stugrade.setGid(rs.getInt("gid"));
						stugrade.setSid(rs.getString("sid"));
						stugrade.setSname(rs.getString("sname"));
						stugrade.setGrade(rs.getInt("grade"));
						stugrade.setSquadid(rs.getInt("squadid"));
						stugrade.setcid(rs.getInt("cid"));
						stugrade.setRemark(rs.getString("remark"));
					}
							
					} catch (SQLException e) {
						throw new RuntimeException(e.getMessage());
					}finally{
						JdbcUtils.close(rs, pstmt, conn);
					}
				return stugrade;
	}

}
