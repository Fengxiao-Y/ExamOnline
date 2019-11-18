package com.yidu.victory.student.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yidu.victory.JdbcUtils.JdbcUtils;
import com.yidu.victory.student.dao.StudentDao;
import com.yidu.victory.student.domain.Student;

public class StudentDaoImpl implements StudentDao {

	@Override
	public int add(Student student) {
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
			String sql="insert into student(sid,sname,sex,age,sqid,passwords,"
					+ "register,identitycard,phone,"
					+ "guardian,guardianwith,guardianphone,address,situation) "
					+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			//实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//给SQL语句赋值
			pstmt.setString(1, student.getSid());
			pstmt.setString(2, student.getSname() );
			pstmt.setString(3, student.getSex());
			pstmt.setInt(4, student.getAge() );
			pstmt.setInt(5, student.getSqid().getsqid());
			pstmt.setString(6, student.getPasswords());
			pstmt.setString(7, student.getRegister());
			pstmt.setString(8, student.getIdentitycard());
			pstmt.setString(9, student.getPhone());
			pstmt.setString(10, student.getGuardian());
			pstmt.setString(11, student.getGuardianwith());
			pstmt.setString(12, student.getGuardianphone());
			pstmt.setString(13, student.getAddress() );
			pstmt.setString(14, student.getSituation());
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
	public int delete(String sid) {
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
			String sql="delete from student where sid=?";
			//实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//给SQL语句赋值
			pstmt.setString(1,sid);
			
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
	public int update(Student student) {
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
			String sql="update student set sname=?,sex=?,age=?,sqid=?,passwords=?,register=?,"
					+ "identitycard=?,phone=?,guardian=?,guardianwith=?,guardianphone=?,"
					+ "address=?,situation=? where sid=?";
			//实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//给SQL语句赋值
			
			pstmt.setString(1, student.getSname() );
			pstmt.setString(2, student.getSex());
			pstmt.setInt(3, student.getAge() );
			pstmt.setInt(4, student.getSqid().getsqid());
			pstmt.setString(5, student.getPasswords());
			pstmt.setString(6, student.getRegister());
			pstmt.setString(7, student.getIdentitycard());
			pstmt.setString(8, student.getPhone());
			pstmt.setString(9, student.getGuardian());
			pstmt.setString(10, student.getGuardianwith());
			pstmt.setString(11, student.getGuardianphone());
			pstmt.setString(12, student.getAddress() );
			pstmt.setString(13, student.getSituation());
			pstmt.setString(14, student.getSid());
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
	public Student findById(String sid) {
		//创建数据库连接对象
		Connection conn=null;
		//创建数据库语句对象
		PreparedStatement pstmt=null;
		//创建结果集对象
		ResultSet rs=null;
		//创建返回
		Student student=null;
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//创建SQL执行语句
			String sql="select * from student where sid=?";
			//实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//给SQL语句赋值
			pstmt.setString(1, sid);
			//调用语句对象返回
			rs=pstmt.executeQuery();
			//判断结果集是否为空
			System.out.println("dfkaldjflasjdf");
			if(rs.next()){
				//实例化实体类对象
				student=new Student();
				//将结果集内的数据赋给实体类对象
				student.setSid(rs.getString("sid"));
				student.setSname(rs.getString("sname"));
				student.setSex(rs.getString("sex"));
				student.setAge(rs.getInt("age"));
				student.setSqid(rs.getInt("sqid"));
				student.setPasswords(rs.getString("passwords"));
				student.setRegister(rs.getString("register"));
				student.setIdentitycard(rs.getString("identitycard"));
				student.setPhone(rs.getString("phone"));
				student.setGuardian(rs.getString("guardian"));
				student.setGuardianwith(rs.getString("guardianwith"));
				student.setGuardianphone(rs.getString("guardianphone"));
				student.setAddress(rs.getString("address"));
				student.setSituation(rs.getString("situation"));
				
				
				
			}
					
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}finally{
				JdbcUtils.close(rs, pstmt, conn);
			}
		return student;
	}

	@Override
	public List<Student> findAll(int rows, int page, String condition) {
		//创建数据库连接对象
		Connection conn=null;
		//创建数据库语句对象
		PreparedStatement pstmt=null;
		//创建结果集对象
		ResultSet rs=null;
		//创建返回
		List<Student> studentlist=new ArrayList<>();
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//创建SQL执行语句
			String sql="select * from student "+condition+" limit ?,?";
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
				Student student=new Student();
				//将结果集内的数据赋给实体类对象
				student.setSid(rs.getString("sid"));
				student.setSname(rs.getString("sname"));
				student.setSex(rs.getString("sex"));
				student.setAge(rs.getInt("age"));
				student.setSqid(rs.getInt("sqid"));
				student.setPasswords(rs.getString("passwords"));
				student.setRegister(rs.getString("register"));
				student.setIdentitycard(rs.getString("identitycard"));
				student.setPhone(rs.getString("phone"));
				student.setGuardian(rs.getString("guardian"));
				student.setGuardianwith(rs.getString("guardianwith"));
				student.setGuardianphone(rs.getString("guardianphone"));
				student.setAddress(rs.getString("address"));
				student.setSituation(rs.getString("situation"));
				studentlist.add(student);
				
			}
					
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}finally{
				JdbcUtils.close(rs, pstmt, conn);
			}
		return studentlist;
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
			String sql="select count(*) from student "+condition;
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
	public List<Student> findAll(String condition) {
		//创建数据库连接对象
				Connection conn=null;
				//创建数据库语句对象
				PreparedStatement pstmt=null;
				//创建结果集对象
				ResultSet rs=null;
				//创建返回
				List<Student> studentlist=new ArrayList<>();
				try {
					//实例化数据库连接对象
					conn=JdbcUtils.getConnection();
					//创建SQL执行语句
					String sql="select * from student "+condition;
					//实例化语句对象
					pstmt=conn.prepareStatement(sql);
					//调用语句对象返回
					rs=pstmt.executeQuery();
					//判断结果集是否为空
					while(rs.next()){
						//实例化实体类对象
						Student student=new Student();
						//将结果集内的数据赋给实体类对象
						student.setSid(rs.getString("sid"));
						student.setSname(rs.getString("sname"));
						student.setSex(rs.getString("sex"));
						student.setAge(rs.getInt("age"));
						student.setSqid(rs.getInt("sqid"));
						student.setPasswords(rs.getString("passwords"));
						student.setRegister(rs.getString("register"));
						student.setIdentitycard(rs.getString("identitycard"));
						student.setPhone(rs.getString("phone"));
						student.setGuardian(rs.getString("guardian"));
						student.setGuardianwith(rs.getString("guardianwith"));
						student.setGuardianphone(rs.getString("guardianphone"));
						student.setAddress(rs.getString("address"));
						student.setSituation(rs.getString("situation"));
						studentlist.add(student);
						
					}
							
					} catch (SQLException e) {
						throw new RuntimeException(e.getMessage());
					}finally{
						JdbcUtils.close(rs, pstmt, conn);
					}
				return studentlist;
	}

}
