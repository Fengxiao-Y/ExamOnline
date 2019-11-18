package com.yidu.victory.JdbcUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class JdbcUtils {
	private static String driver="com.mysql.cj.jdbc.Driver";
	private static String user="root";
	private static String passworld="tanghong123";
	private static String url="jdbc:mysql://localhost:3306/victory?useUnicode=ture"
			+ "&characterEncoding=utf-8&serverTimezone=GMT";
	/**
	 * ������̬����������������
	 */
	static{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 *����ģʽ���������ⲿ��new����������
	 */
	private JdbcUtils(){
		
	}
	/**
	 * ��ȡ���ݿ����ӷ���
	 * @return ���ݿ����Ӷ���
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url,user,passworld);
		
	}
	/**
	 * �ر���Դ
	 */
	public static void close(ResultSet rs,Statement pstmt,Connection conn){
		try {
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(pstmt!=null){
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					if(conn!=null){
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
