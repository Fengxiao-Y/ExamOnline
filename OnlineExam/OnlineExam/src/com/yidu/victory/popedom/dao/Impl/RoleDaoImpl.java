package com.yidu.victory.popedom.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yidu.victory.JdbcUtils.JdbcUtils;
import com.yidu.victory.popedom.dao.RoleDao;
import com.yidu.victory.popedom.domain.Role;

public class RoleDaoImpl implements RoleDao {

	@Override
	public Role findById(int roleid) {
		// ����Role����
		Role role = null;
		// �������ݿ����Ӷ���
		Connection conn = null;
		// ����������
		PreparedStatement pstmt = null;
		// �������������
		ResultSet rs = null;
		try {
			// ʵ�������ݿ����Ӷ���
			conn = JdbcUtils.getConnection();
			// ����sql���
			String sql = "select * from role where roleid=?";
			// ʵ����������
			pstmt = conn.prepareStatement(sql);
			// ��sql���Ĳ�����ֵ
			pstmt.setInt(1, roleid);
			// ִ�в����ؽ����
			rs = pstmt.executeQuery();
			// �ж�
			if (rs.next()) {
				role = new Role();
				// ����������Ը�ֵ
				role.setRoleid(roleid);
				role.setRolename(rs.getNString("rolename"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			// �ر���Դ
			JdbcUtils.close(rs, pstmt, conn);
		}

		// �����û�����
		return role;
	}

}