package com.yidu.victory.popedom.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.yidu.victory.JdbcUtils.JdbcUtils;
import com.yidu.victory.popedom.dao.Role_popedomDao;
import com.yidu.victory.popedom.domain.Role_popedom;

public class Role_popedomDaoImpl implements Role_popedomDao {

	@Override
	public int add(Role_popedom role_popedom) {
		int rows=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=JdbcUtils.getConnection();
			String sql="insert into role_popedom(pdmid,roleid) values(?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, role_popedom.getPdmid());
			pstmt.setInt(2, role_popedom.getRoleid());
			
			
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			JdbcUtils.close(null, pstmt, conn);
		}
		return rows;
	}

	@Override
	public int delete(int rpid) {
		int rows=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=JdbcUtils.getConnection();
			String sql="delete from role_popedom where rpid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, rpid);
			
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			JdbcUtils.close(null, pstmt, conn);
		}
		return rows;
	}

	@Override
	public Role_popedom findById(int rpid) {
		Role_popedom role_popedom=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=JdbcUtils.getConnection();
			String sql="select * from role_popedom where rpid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, rpid);
			rs=pstmt.executeQuery();
			if(rs.next()){
				role_popedom=new Role_popedom();
				role_popedom.setRpid(rs.getInt("rpid"));
				role_popedom.setPdmid(rs.getInt("pdmid"));
				role_popedom.setRoleid(rs.getInt("roleid"));
				
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			JdbcUtils.close(rs, pstmt, conn);
		}
		return role_popedom;
	}

	@Override
	public List<Role_popedom> findByPage(int rows, int page) {
		List<Role_popedom> role_popedomList=new ArrayList<Role_popedom>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=JdbcUtils.getConnection();
			String sql="select * from role_popedom limit ?,?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Role_popedom role_popedom=new Role_popedom();
				role_popedom.setRpid(rs.getInt("rpid"));
				role_popedom.setPdmid(rs.getInt("empName"));
				role_popedom.setRoleid(rs.getInt("job"));
				
				role_popedomList.add(role_popedom);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			JdbcUtils.close(rs, pstmt, conn);
		}
		return role_popedomList;
	}

	@Override
	public List<Role_popedom> findBycondition(String condition) {
		List<Role_popedom> role_popedomList=new ArrayList<Role_popedom>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=JdbcUtils.getConnection();
			String sql="select * from role_popedom "+condition;
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Role_popedom role_popedom=new Role_popedom();
				role_popedom.setRpid(rs.getInt("rpid"));
				role_popedom.setPdmid(rs.getInt("pdmid"));
				role_popedom.setRoleid(rs.getInt("roleid"));
				role_popedomList.add(role_popedom);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			JdbcUtils.close(rs, pstmt, conn);
		}
		return role_popedomList;
	}

	@Override
	public int delete(String condition) {
		System.out.println("111111111qq");
		int rows=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			System.out.println("aaaaaabbbbb");
			conn=JdbcUtils.getConnection();
			String sql="delete from role_popedom "+condition;
			System.out.println("ddddddddddd");
			pstmt=conn.prepareStatement(sql);
			
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			JdbcUtils.close(null, pstmt, conn);
		}
		return rows;
	}

}
