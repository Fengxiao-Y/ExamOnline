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
	 * 创建静态区，加载驱动程序
	 */
	static{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 *工厂模式，不能在外部用new来创建对象
	 */
	private JdbcUtils(){
		
	}
	/**
	 * 获取数据库连接方法
	 * @return 数据库连接对象
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url,user,passworld);
		
	}
	/**
	 * 关闭资源
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
