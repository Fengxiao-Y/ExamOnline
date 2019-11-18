package com.yidu.victory.popedom.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.yidu.victory.JdbcUtils.JdbcUtils;
import com.yidu.victory.popedom.dao.User_roleDao;
import com.yidu.victory.popedom.domain.User_role;

public class User_roleDaoImpl implements User_roleDao{
	@Override
	public int add(User_role user_role) {
		int rows=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=JdbcUtils.getConnection();
			String sql="insert into user_role(unumber,roleid) values(?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user_role.getUnumber());
			pstmt.setInt(2, user_role.getRoleid());

			
			
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			JdbcUtils.close(null, pstmt, conn);
		}
		return rows;
	}@Override
	public int delete(String unumber) {
		int rows=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=JdbcUtils.getConnection();
			String sql="delete from user_role where unumber=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, unumber);
			
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			JdbcUtils.close(null, pstmt, conn);
		}
		return rows;
	}
	@Override
	public List<User_role> findByPage(int rows, int page) {
		List<User_role> user_roleList=new ArrayList<User_role>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=JdbcUtils.getConnection();
			String sql="select * from user_role limit ?,?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			rs=pstmt.executeQuery();
			while(rs.next()){
				User_role user_role=new User_role();
				user_role.setUnumber(rs.getString("unumber"));
				user_role.setRoleid(rs.getInt("roleid"));
				
				user_roleList.add(user_role);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			JdbcUtils.close(rs, pstmt, conn);
		}
		return user_roleList;
	}
	@Override
	public List<User_role> findByPage(int rows, int page, String condition) {
		List<User_role> user_roleList=new ArrayList<User_role>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=JdbcUtils.getConnection();
			String sql="select * from user_role "+condition+" limit ?,? ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			rs=pstmt.executeQuery();
			while(rs.next()){
				User_role user_role=new User_role();
				user_role.setUnumber(rs.getString("unumber"));
				user_role.setRoleid(rs.getInt("roleid"));

				user_roleList.add(user_role);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			JdbcUtils.close(rs, pstmt, conn);
		}
		return user_roleList;
	}
	@Override
	public User_role findById(String unumber) {
		User_role user_role=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=JdbcUtils.getConnection();
			String sql="select * from user_role where unumber=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, unumber);
			rs=pstmt.executeQuery();
			while(rs.next()){
				user_role=new User_role();
				user_role.setUnumber(rs.getString("unumber"));
				user_role.setRoleid(rs.getInt("roleid"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			JdbcUtils.close(rs, pstmt, conn);
		}
		return user_role;
	}
	@Override
	public int update(User_role user_role) {
		int rows=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=JdbcUtils.getConnection();
			String sql="update user_role set roleid=? where unumber=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(2, user_role.getUnumber());
			pstmt.setInt(1, user_role.getRoleid());

			
			
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			JdbcUtils.close(null, pstmt, conn);
		}
		return rows;
	}
}
