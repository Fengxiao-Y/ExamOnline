package com.yidu.victory.student.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yidu.victory.JdbcUtils.JdbcUtils;
import com.yidu.victory.student.dao.TeacherDao;
import com.yidu.victory.student.domain.Student;
import com.yidu.victory.student.domain.Teacher;

public class TeacherDaoImpl implements TeacherDao {

	@Override
	public int add(Teacher teacher) {
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
			String sql="insert into teacher(tid,tname,"
					+ "sex,age,phone,"
					+ "penguin,address,situation)"
					+ " values(?,?,?,?,?,?,?,?)";

			//实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//给SQL语句赋值
			pstmt.setString(1, teacher.getTid());
			pstmt.setString(2, teacher.getTname() );
			pstmt.setString(3, teacher.getSex());
			pstmt.setInt(4, teacher.getAge() );
			pstmt.setString(5, teacher.getPhone());
			pstmt.setInt(6, teacher.getPenguin());
			pstmt.setString(7, teacher.getAddress());
			pstmt.setString(8, teacher.getSituation());
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
	public int delete(String tid) {
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
			String sql="delete from teacher where tid=?";
			pstmt=conn.prepareStatement(sql);
			//实例化语句对象
			pstmt.setString(1,tid);
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
	public int update(Teacher teacher) {
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
			String sql="update teacher set tname=?,sex=?,age=?,phone=?,penguin=?,"

					+ "address=?,situation=? where tid=?";

			//实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//给SQL语句赋值
			pstmt.setString(1, teacher.getTname() );
			pstmt.setString(2, teacher.getSex());
			pstmt.setInt(3, teacher.getAge() );
			pstmt.setString(4, teacher.getPhone());
			pstmt.setInt(5, teacher.getPenguin());
			pstmt.setString(6, teacher.getAddress());
			pstmt.setString(7, teacher.getSituation());
			pstmt.setString(8, teacher.getTid());
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
	public Teacher findById(String tid) {
		//创建数据库连接对象
				Connection conn=null;
				//创建数据库语句对象
				PreparedStatement pstmt=null;
				//创建结果集对象
				ResultSet rs=null;
				//创建返回
				Teacher teacher=null;
				try {
					//实例化数据库连接对象
					conn=JdbcUtils.getConnection();
					//创建SQL执行语句
					String sql="select * from teacher where tid=?";

					//实例化语句对象
					pstmt=conn.prepareStatement(sql);
					//给SQL语句赋值
					pstmt.setString(1, tid);
					//调用语句对象返回
					rs=pstmt.executeQuery();
					if(rs.next()){
						//实例化实体类对象
						teacher=new Teacher();
						//将结果集内的数据赋给实体类对象
						teacher.setTid(rs.getString("tid"));
						teacher.setTname(rs.getString("tname"));
						teacher.setSex(rs.getString("sex"));
						teacher.setAge(rs.getInt("age"));
						teacher.setPhone(rs.getString("phone"));
						teacher.setPenguin(rs.getInt("penguin"));
						teacher.setAddress(rs.getString("address"));
						teacher.setSituation(rs.getString("situation"));

					}
					
				} catch (SQLException e) {
					throw new RuntimeException(e.getMessage());
				}finally{
					JdbcUtils.close(rs, pstmt, conn);
				}
				return teacher;
	}

	@Override
	public List<Teacher> findAll(int rows, int page, String condition) {
		//创建数据库连接对象
				Connection conn=null;
				//创建数据库语句对象
				PreparedStatement pstmt=null;
				//创建结果集对象
				ResultSet rs=null;
				//创建返回
				List<Teacher> teacherlist=new ArrayList<>();
				try {
					//实例化数据库连接对象
					conn=JdbcUtils.getConnection();
					//创建SQL执行语句
					String sql="select * from teacher "+condition+" limit ?,?";

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
						Teacher teacher=new Teacher();
						//将结果集内的数据赋给实体类对象
						teacher.setTid(rs.getString("tid"));
						teacher.setTname(rs.getString("tname"));
						teacher.setSex(rs.getString("sex"));
						teacher.setAge(rs.getInt("age"));
						teacher.setPhone(rs.getString("phone"));
						teacher.setPenguin(rs.getInt("penguin"));
						teacher.setAddress(rs.getString("address"));
						teacher.setSituation(rs.getString("situation"));
						
						teacherlist.add(teacher);
						
					}
					
				} catch (SQLException e) {
					throw new RuntimeException(e.getMessage());
				}finally{
					JdbcUtils.close(rs, pstmt, conn);
				}
		return teacherlist;
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
			String sql="select count(*) from teacher "+condition;
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

	@Override
	public List<Teacher> findAll() {
		//创建数据库连接对象
		Connection conn=null;
		//创建数据库语句对象
		PreparedStatement pstmt=null;
		//创建结果集对象
		ResultSet rs=null;
		//创建返回
		List<Teacher> teacherlist=new ArrayList<>();
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//创建SQL执行语句
			String sql="select * from teacher ";

			//实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//给SQL语句赋值

			//调用语句对象返回
			rs=pstmt.executeQuery();
			//判断结果集是否为空
			while(rs.next()){
				//实例化实体类对象
				Teacher teacher=new Teacher();
				//将结果集内的数据赋给实体类对象
				teacher.setTid(rs.getString("tid"));
				teacher.setTname(rs.getString("tname"));
				teacher.setSex(rs.getString("sex"));
				teacher.setAge(rs.getInt("age"));
				teacher.setPhone(rs.getString("phone"));
				teacher.setPenguin(rs.getInt("penguin"));
				teacher.setAddress(rs.getString("address"));
				teacher.setSituation(rs.getString("situation"));
				
				teacherlist.add(teacher);
				
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}finally{
			JdbcUtils.close(rs, pstmt, conn);
		}
return teacherlist;
	}

}
