package qy.rb.dao.impl;

import org.springframework.stereotype.Repository;
import qy.rb.common.ServerResponse;
import qy.rb.dao.ShoppingCartDao;
import qy.rb.util.DBPoolUtil;

import java.sql.*;
import java.util.List;

/**
 * @author hjy
 * @create 2018/03/11
 **/
@Repository
public class ShoppingCartDaoImpl implements ShoppingCartDao {

	Connection conn = null;
	CallableStatement cstmt = null;
	ResultSet rs = null;

	@Override
	public ServerResponse insert(String rbBaseInfoID, int count, String customerID) {
		conn = DBPoolUtil.getConnection();

		try {
			cstmt = conn.prepareCall("{call spInsertShoppingCart()}");
			cstmt.registerOutParameter(1, Types.NVARCHAR);
			cstmt.setString(2,rbBaseInfoID);
			cstmt.setInt(3,count);
			cstmt.setString(4, customerID);
			cstmt.executeUpdate();
			String flag = cstmt.getString(1);
			if ("OK".equals(flag)) {
				return ServerResponse.createBySuccessMessage("添加成功！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBPoolUtil.closeConnection(conn);
		}
		return ServerResponse.createByErrorMessage("添加失败！");
	}

	@Override
	public boolean delete(String rbBaseInfoID, String customerID) {
		boolean result = false;
		conn = DBPoolUtil.getConnection();

		try {
			cstmt = conn.prepareCall("{call }");
			cstmt.registerOutParameter(1,Types.NVARCHAR);
			cstmt.setString(2,rbBaseInfoID);
			cstmt.setString(3,customerID);
			cstmt.executeUpdate();
			String flag = cstmt.getString(1);
			if ("OK".equals(flag)) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBPoolUtil.closeConnection(conn);
		}
		return  result;
	}

	@Override
	public List show(String customerID) {


		return null;
	}
}
