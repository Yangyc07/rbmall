package qy.rb.dao.impl;

import org.springframework.stereotype.Repository;
import qy.rb.common.ServerResponse;
import qy.rb.dao.ShoppingCartDao;
import qy.rb.domain.ShoppingCart;
import qy.rb.util.DBPoolUtil;

import java.sql.*;
import java.util.ArrayList;
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
			cstmt = conn.prepareCall("{call spInsertShoppingCart(?,?,?,?,?,?)}");
			cstmt.registerOutParameter(1, Types.NVARCHAR);
			cstmt.setString(2,customerID);
			cstmt.setString(3,rbBaseInfoID);
			cstmt.setInt(4, count);
			cstmt.setByte(5, (byte) 1);
			cstmt.setString(6, "");
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
	public List<ShoppingCart> showShoppingCartList(String customerID) {
		List<ShoppingCart> shoppingCartList = new ArrayList<>();

		conn = DBPoolUtil.getConnection();
		try {
			cstmt = conn.prepareCall("{call spGetShoppingCartListByCustomerID(?)}");
			cstmt.setString(1,customerID);
			rs = cstmt.executeQuery();
			while (rs.next()) {
				ShoppingCart shoppingCart = new ShoppingCart();
				shoppingCart.setShoppingCartID(rs.getLong("ShoppingCartListID"));
				shoppingCart.setCustomerID(rs.getString("CustomerID"));
				shoppingCart.setRbPartID(rs.getString("RBPartID"));
				shoppingCart.setPartAmount(rs.getInt("PartAmount"));
				shoppingCart.setValidityFlag(rs.getByte("ValidityFlag"));
				shoppingCart.setShoppingCartRemark(rs.getString("ShoppingCartListRemark"));
				shoppingCartList.add(shoppingCart);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBPoolUtil.closeConnection(rs,cstmt,conn);
		}
		return shoppingCartList;
	}

	@Override
	public boolean check(String rbBasePartID, String customerID) {
		boolean result = false;
		conn = DBPoolUtil.getConnection();
		try {
			cstmt = conn.prepareCall("{call checkShoppingCartByRbIDAndCustomerID(?,?,?)}");
			cstmt.registerOutParameter(1,Types.NVARCHAR);
			cstmt.setString(2,rbBasePartID);
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
		return result;
	}
}
