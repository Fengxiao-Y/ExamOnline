package com.yidu.victory.popedom.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yidu.victory.JdbcUtils.JdbcUtils;
import com.yidu.victory.popedom.dao.PopedomDao;
import com.yidu.victory.popedom.domain.Popedom;

public class PopedomDaoImpl implements PopedomDao {

	@Override
	public Popedom findById(int pdmid) {
		//�������ݿ����Ӷ���
				Connection conn=null;
				//�������ݿ�������
				PreparedStatement pstmt=null;
				//�������������
				ResultSet rs=null;
				//��������
				Popedom pdm=null;
				try {
					//ʵ�������ݿ����Ӷ���
					conn=JdbcUtils.getConnection();
					//����SQLִ�����
					String sql="select * from popedom where pdmid=? ";
					//ʵ����������
					pstmt=conn.prepareStatement(sql);
					//��SQLִ����丳ֵ
					pstmt.setInt(1, pdmid);
					//���������󷵻�
					rs=pstmt.executeQuery();
					//�жϽ�����Ƿ�Ϊ��
					while(rs.next()){
						//ʵ����ʵ�������
						pdm=new Popedom();
						//��������ڵ����ݸ���ʵ�������
						pdm.setId(rs.getInt("pdmid"));
						pdm.setText(rs.getString("pdmname"));
						pdm.setPdmfather(rs.getInt("pdmfather"));
						
					}
							
					} catch (SQLException e) {
						throw new RuntimeException(e.getMessage());
					}finally{
						JdbcUtils.close(rs, pstmt, conn);
					}
				return pdm;
	}

}
