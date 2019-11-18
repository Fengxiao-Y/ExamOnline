package com.yidu.victory.student.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yidu.victory.JdbcUtils.JdbcUtils;
import com.yidu.victory.student.dao.CourseDao;
import com.yidu.victory.student.domain.Course;


public class CourseDaoImpl implements CourseDao {

	@Override
	public int add(Course course) {
		//创建数据库连接对象
				Connection conn=null;
				//创建数据库语句对象
				PreparedStatement pstmt=null;
				//创建结果集对象
				ResultSet rs=null;
				//创建返回
				int rows=0;
				try {
					//实例化数据库连接对象
					conn=JdbcUtils.getConnection();
					//创建SQL执行语句
					String sql="insert into course(cname,stagename) "
							+ " values(?,?)";
					//实例化语句对象
					pstmt=conn.prepareStatement(sql);
					//给SQL语句赋值
					
					pstmt.setString(1, course .getCname());
					pstmt.setString(2, course .getStagename());
					//调用语句对象返回
					rows=pstmt.executeUpdate();
					
				} catch (SQLException e) {
					throw new RuntimeException(e.getMessage());
				}finally{
					JdbcUtils.close(rs, pstmt, conn);
				}
				return rows;
			}
	@Override
	public int delete(int cid) {
		//创建数据库连接对象
				Connection conn=null;
				//创建数据库语句对象
				PreparedStatement pstmt=null;
				//创建结果集对象
				ResultSet rs=null;
				//创建返回
				int rows=0;
				
				try {
					//实例化数据库连接对象
					conn=JdbcUtils.getConnection();
					//创建SQL执行语句
					String sql="delete from course where cid=?";
					//实例化语句对象
					pstmt=conn.prepareStatement(sql);
					//给SQL语句赋值
					pstmt.setInt(1, cid);
					
					//调用语句对象返回
					rows=pstmt.executeUpdate();
					System.out.println("ssss"+rows);
					
				} catch (SQLException e) {
					throw new RuntimeException(e.getMessage());
				}finally{
					JdbcUtils.close(rs, pstmt, conn);
				}
				return rows;
			}
	@Override
	public int update(Course course) {
		//创建数据库连接对象
		Connection conn=null;
		//创建数据库语句对象
		PreparedStatement pstmt=null;
		//创建结果集对象
		ResultSet rs=null;
		//创建返回
		int rows=0;
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//创建SQL执行语句
			String sql="update course set cname=?,stagename=? where cid=?";
			//实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//给SQL语句赋值
			
			pstmt.setString(1, course.getCname());
			pstmt.setString(2, course.getStagename());
			pstmt.setInt(3, course.getCid());
			//调用语句对象返回
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}finally{
			JdbcUtils.close(rs, pstmt, conn);
		}
		return rows;
		}

	@Override
	public Course findById(String cid) {
		//创建数据库连接对象
		Connection conn=null;
		//创建数据库语句对象
		PreparedStatement pstmt=null;
		//创建结果集对象
		ResultSet rs=null;
		//创建返回
		Course course=null;
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//创建SQL执行语句
			String sql="select * from course where cid=?";
			//实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//给SQL语句赋值
			pstmt.setString(1, cid);
			//调用语句对象返回
			rs=pstmt.executeQuery();
			//判断结果集是否为空
			if(rs.next()){
				//实例化实体类对象
				course=new Course();
				//将结果集内的数据赋给实体类对象
				course.setCid(rs.getInt("cid"));
				course.setCname(rs.getString("cname"));
				course.setStagename(rs.getString("stagename"));
				
			}
					
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}finally{
				JdbcUtils.close(rs, pstmt, conn);
			}
		return course;
	}

	@Override
	public List<Course> findAll(int rows, int page, String condition) {
		//创建数据库连接对象
		Connection conn=null;
		//创建数据库语句对象
		PreparedStatement pstmt=null;
		//创建结果集对象
		ResultSet rs=null;
		//创建返回
		List<Course> courselist=new ArrayList<>();
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//创建SQL执行语句
			String sql="select * from course "+condition+" limit ?,?";
			//实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//给SQL语句赋值
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			//调用语句对象返回
			rs=pstmt.executeQuery();
			
			//判断结果集是否为空
			while(rs.next()){
				//实例化实体类对象
				Course course=new Course();
				//将结果集内的数据赋给实体类对象
				course.setCid(rs.getInt("cid"));
				course.setCname(rs.getString("cname"));
				course.setStagename(rs.getString("stagename"));
				courselist.add(course);
				
			}
					
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}finally{
				JdbcUtils.close(rs, pstmt, conn);
			}
		return courselist;
	}

	
	public List<Course> findAll() {
		//创建数据库连接对象
		Connection conn=null;
		//创建数据库语句对象
		PreparedStatement pstmt=null;
		//创建结果集对象
		ResultSet rs=null;
		//创建返回
		List<Course> courselist=new ArrayList<>();
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//创建SQL执行语句
			String sql="select * from course ";
			//实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//调用语句对象返回
			rs=pstmt.executeQuery();
			
			//判断结果集是否为空
			while(rs.next()){
				//实例化实体类对象
				Course course=new Course();
				//将结果集内的数据赋给实体类对象
				course.setCid(rs.getInt("cid"));
				course.setCname(rs.getString("cname"));
				course.setStagename(rs.getString("stagename"));
				courselist.add(course);
				
			}
					
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}finally{
				JdbcUtils.close(rs, pstmt, conn);
			}
		return courselist;
	}
	
	public Course findAll(String condition) {
		//创建数据库连接对象
		Connection conn=null;
		//创建数据库语句对象
		PreparedStatement pstmt=null;
		//创建结果集对象
		ResultSet rs=null;
		//创建返回
		Course course=null;
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//创建SQL执行语句
			String sql="select * from course "+condition;
			//实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//调用语句对象返回
			rs=pstmt.executeQuery();
			
			//判断结果集是否为空
			if(rs.next()){
				//实例化实体类对象
				course=new Course();
				//将结果集内的数据赋给实体类对象
				course.setCid(rs.getInt("cid"));
				course.setCname(rs.getString("cname"));
				course.setStagename(rs.getString("stagename"));
				
				
			}
					
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}finally{
				JdbcUtils.close(rs, pstmt, conn);
			}
		return course;
	}
	

	@Override
	public int count(String condition) {
		//创建数据库连接对象
		Connection conn=null;
		//创建数据库语句对象
		PreparedStatement pstmt=null;
		//创建结果集对象
		ResultSet rs=null;
		//创建返回
		int rows=0;
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//创建SQL执行语句
			String sql="select count(*) from course "+condition;
			//实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//给SQL语句赋值
			
			//调用语句对象返回
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