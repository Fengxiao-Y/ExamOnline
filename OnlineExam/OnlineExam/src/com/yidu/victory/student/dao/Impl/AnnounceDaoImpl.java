package com.yidu.victory.student.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.yidu.victory.student.domain.Announce;
import com.yidu.victory.student.dao.AnnounceDao;
import com.yidu.victory.JdbcUtils.JdbcUtils;

public class AnnounceDaoImpl implements AnnounceDao {
	@Override
	public int add(Announce announce) {
		
		//����һ����������
		int rows=0;
		//����һ�����Ӷ���
		Connection conn=null;
		//����һ��������
		PreparedStatement pstmt=null;
		try {
			//1.ʵ�������Ӷ���
			conn=JdbcUtils.getConnection();
			//2.A����һ��SQL�������
			String sql="insert into announce(theme,"
					+ "titlecontent,announcecont,issuepeople,issuetime)"
					+ "  values(?,?,?,?,?)";
			//2.Bʵ����SQL��估���Ӷ��󣬵õ�������
			pstmt=conn.prepareStatement(sql);
			//2.C�������е�ֵ������������ 
			
			pstmt.setString(1, announce.getTheme());
			pstmt.setString(2, announce.getTitlecontent());
			pstmt.setString(3, announce.getAnnouncecont());
			pstmt.setString(4, announce.getIssuepeople());
			pstmt.setString(5, announce.getIssuetime());
			//���������󣬽��ı��ֵ����rows
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			JdbcUtils.close(null, pstmt, conn);
		}
		//������������
		return rows;
	}

@Override
	public int delete(int aid) {
		//����һ����������
		int rows=0;
		//����һ�����Ӷ���
		Connection conn=null;
		//����һ��������
		PreparedStatement pstmt=null;
		try {
			//1.ʵ�������Ӷ���
			conn=JdbcUtils.getConnection();
			//2.A����һ��SQL�������
			String sql="delete from announce where aid=?";
			//2.Bʵ����SQL��估���Ӷ��󣬵õ�������
			pstmt=conn.prepareStatement(sql);
			//2.C�������е�ֵ������������ 
			pstmt.setInt(1, aid);
			//���������󣬽��ı��ֵ����rows
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			JdbcUtils.close(null, pstmt, conn);
		}
		//������������
		return rows;
	}

@Override
	public int update(Announce announce) {
	//����һ����������
	int rows=0;
	//����һ�����Ӷ���
	Connection conn=null;
	//����һ��������
	PreparedStatement pstmt=null;
	try {
		//1.ʵ�������Ӷ���
		conn=JdbcUtils.getConnection();
		//2.A����һ��SQL�������
		String sql="update announce set theme=?,titlecontent=?,"
				+ "announcecont=?,issuepeople=?,issuetime=?"
				+ " where aid=?";
		//2.Bʵ����SQL��估���Ӷ��󣬵õ�������
		pstmt=conn.prepareStatement(sql);
		//2.C�������е�ֵ������������ 
		pstmt.setString(1, announce.getTheme());
		pstmt.setString(2, announce.getTitlecontent());
		pstmt.setString(3, announce.getAnnouncecont());
		pstmt.setString(4, announce.getIssuepeople());
		pstmt.setString(5, announce.getIssuetime());
		pstmt.setInt(6, announce.getAid());
		//���������󣬽��ı��ֵ����rows
		rows=pstmt.executeUpdate();
		
	} catch (SQLException e) {
		throw new RuntimeException(e.getMessage(),e);
	} finally{
		JdbcUtils.close(null, pstmt, conn);
	}
	return rows;
	}

@Override
	public Announce findById(int aid) {
		Announce announce=null;
		//����һ�����Ӷ���
		Connection conn=null;
		//����һ��������
		PreparedStatement pstmt=null;
		//����һ�������
		ResultSet rs=null;
		try {
			//1.ʵ�������Ӷ���
			conn=JdbcUtils.getConnection();
			//2.A����һ��SQL�������
			String sql="select * from announce where aid=?";
			//2.Bʵ����SQL��估���Ӷ��󣬵õ�������
			pstmt=conn.prepareStatement(sql);
			//2.C�������е�ֵ������������ 
			pstmt.setInt(1, aid);
			//���������󣬽�ֵ����rs�����
			rs=pstmt.executeQuery();
			if(rs.next()){
				announce=new Announce();
				announce.setAid(rs.getInt("aid"));
				announce.setTheme(rs.getString("theme"));
				announce.setTitlecontent(rs.getString("titlecontent"));
				announce.setAnnouncecont(rs.getString("announcecont"));
				announce.setIssuepeople(rs.getString("issuepeople"));
				announce.setIssuetime(rs.getString("issuetime"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			JdbcUtils.close(rs, pstmt, conn);
		}
		return announce;
	}
@Override
	public List<Announce> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
@Override
public List<Announce> findByPage(int rows, int page) {
	List<Announce> announceList=new ArrayList<Announce>();
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try {
		conn=JdbcUtils.getConnection();
		String sql="select * from announce limit ?,?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, (page-1)*rows);
		pstmt.setInt(2, rows);
		rs=pstmt.executeQuery();
		while(rs.next()){
			Announce announce=new Announce();
			announce.setAid(rs.getInt("aid"));
			announce.setTheme(rs.getString("theme"));
			announce.setTitlecontent(rs.getString("titlecontent"));
			announce.setAnnouncecont(rs.getString("announcecont"));
			announce.setIssuepeople(rs.getString("issuepeople"));
			announce.setIssuetime(rs.getString("issuetime"));
			
			announceList.add(announce);
		}
	} catch (SQLException e) {
		throw new RuntimeException(e.getMessage(),e);
	} finally{
		JdbcUtils.close(rs, pstmt, conn);
	}
	return announceList;
}

@Override
	public List<Announce> findByPage(int rows, int page, String condition) {
		List<Announce> announceList=new ArrayList<Announce>();
		//����һ�����Ӷ���
		Connection conn=null;
		//����һ��������
		PreparedStatement pstmt=null;
		//����һ�������
		ResultSet rs=null;
		try {
			//1.ʵ�������Ӷ���
			conn=JdbcUtils.getConnection();
			//2.A����һ��SQL�������
			String sql="select * from announce "+condition+" limit ?,? ";
			//2.Bʵ����SQL��估���Ӷ��󣬵õ�������
			pstmt=conn.prepareStatement(sql);
			//2.C�������е�ֵ������������ 
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			//���������󣬽�ֵ����rs�����
			rs=pstmt.executeQuery();
			while(rs.next()){
				Announce announce=new Announce();
				announce.setAid(rs.getInt("aid"));
				announce.setTheme(rs.getString("theme"));
				announce.setTitlecontent(rs.getString("titlecontent"));
				announce.setAnnouncecont(rs.getString("announcecont"));
				announce.setIssuepeople(rs.getString("issuepeople"));
				announce.setIssuetime(rs.getString("issuetime"));
				//�������е�ֵ����������
				announceList.add(announce);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			JdbcUtils.close(rs, pstmt, conn);
		}
		return announceList;
	}

@Override
	public int count() {
		//����һ����������
		int rows=0;
		//����һ�����Ӷ���
		Connection conn=null;
		//����һ��������
		PreparedStatement pstmt=null;
		//����һ�������
		ResultSet rs=null;
		try {
			//1.ʵ�������Ӷ���
			conn=JdbcUtils.getConnection();
			//2.A����һ��SQL�������
			String sql="select count(*) from announce";
			//2.Bʵ����SQL��估���Ӷ��󣬵õ�������
			pstmt=conn.prepareStatement(sql);
			//���������󣬽�ֵ����rs�����
			rs=pstmt.executeQuery();
			//�жϽ�������Ƿ���ֵ
			if(rs.next()){
				rows=rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			JdbcUtils.close(rs, pstmt, conn);
		}
		return rows;
	}
	@Override
		public int count(String condition) {
			int rows=0;
			//����һ�����Ӷ���
			Connection conn=null;
			//����һ��������
			PreparedStatement pstmt=null;
			//����һ�������
			ResultSet rs=null;
			try {
				//1.ʵ�������Ӷ���
				conn=JdbcUtils.getConnection();
				//2.A����һ��SQL�������
				String sql="select count(*) from announce "+condition;
				//2.Bʵ����SQL��估���Ӷ��󣬵õ�������
				pstmt=conn.prepareStatement(sql);
				//���������󣬽�ֵ����rs�����
				rs=pstmt.executeQuery();
				if(rs.next()){
					rows=rs.getInt(1);
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage(),e);
			} finally{
				JdbcUtils.close(rs, pstmt, conn);
			}
			return rows;
		}
	
}
