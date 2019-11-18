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
			String sql="insert into student(sid,sname,sex,age,sqid,passwords,"
					+ "register,identitycard,phone,"
					+ "guardian,guardianwith,guardianphone,address,situation) "
					+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ
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
			String sql="delete from student where sid=?";
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ
			pstmt.setString(1,sid);
			
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
	public int update(Student student) {
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
			String sql="update student set sname=?,sex=?,age=?,sqid=?,passwords=?,register=?,"
					+ "identitycard=?,phone=?,guardian=?,guardianwith=?,guardianphone=?,"
					+ "address=?,situation=? where sid=?";
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ
			
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
	public Student findById(String sid) {
		//�������ݿ����Ӷ���
		Connection conn=null;
		//�������ݿ�������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		//��������
		Student student=null;
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����SQLִ�����
			String sql="select * from student where sid=?";
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ
			pstmt.setString(1, sid);
			//���������󷵻�
			rs=pstmt.executeQuery();
			//�жϽ�����Ƿ�Ϊ��
			System.out.println("dfkaldjflasjdf");
			if(rs.next()){
				//ʵ����ʵ�������
				student=new Student();
				//��������ڵ����ݸ���ʵ�������
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
		//�������ݿ����Ӷ���
		Connection conn=null;
		//�������ݿ�������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		//��������
		List<Student> studentlist=new ArrayList<>();
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����SQLִ�����
			String sql="select * from student "+condition+" limit ?,?";
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
				Student student=new Student();
				//��������ڵ����ݸ���ʵ�������
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
			String sql="select count(*) from student "+condition;
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
	public List<Student> findAll(String condition) {
		//�������ݿ����Ӷ���
				Connection conn=null;
				//�������ݿ�������
				PreparedStatement pstmt=null;
				//�������������
				ResultSet rs=null;
				//��������
				List<Student> studentlist=new ArrayList<>();
				try {
					//ʵ�������ݿ����Ӷ���
					conn=JdbcUtils.getConnection();
					//����SQLִ�����
					String sql="select * from student "+condition;
					//ʵ����������
					pstmt=conn.prepareStatement(sql);
					//���������󷵻�
					rs=pstmt.executeQuery();
					//�жϽ�����Ƿ�Ϊ��
					while(rs.next()){
						//ʵ����ʵ�������
						Student student=new Student();
						//��������ڵ����ݸ���ʵ�������
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
