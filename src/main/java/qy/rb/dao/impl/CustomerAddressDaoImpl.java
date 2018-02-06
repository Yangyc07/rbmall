package qy.rb.dao.impl;

import org.springframework.stereotype.Repository;
import qy.rb.common.Const;
import qy.rb.dao.CustomerAddressDao;
import qy.rb.domain.CustomerAddress;
import qy.rb.domain.PageEntity;
import qy.rb.util.DBPoolUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author hjy
 * @create 2018/01/22
 **/
@Repository //扫描Dao
public class CustomerAddressDaoImpl implements CustomerAddressDao {

	Connection conn = null;
	CallableStatement cstmt  = null;
	ResultSet rs = null;

	@Override
	public boolean insert(CustomerAddress customerAddress, String customerID) {
		boolean result = false;
		conn = DBPoolUtil.getConnection();
		try {
			cstmt = conn.prepareCall("{call spInsertCustomerAddress(?,?,?,?,?,?,?,?,?,?)}");
			cstmt.registerOutParameter(1, Types.NVARCHAR);
			cstmt.setString(2,customerID);
			cstmt.setString(3,customerAddress.getReceiverProvince());
			cstmt.setString(4,customerAddress.getReceiverCity());
			cstmt.setString(5,customerAddress.getReceiverDistrict());
			cstmt.setString(6,customerAddress.getReceiverStreet());
			cstmt.setString(7,customerAddress.getReceiverDetailedAddress());
			cstmt.setString(8,customerAddress.getReceiverPostCode());
			cstmt.setString(9,customerAddress.getReceiverName());
			cstmt.setString(10,customerAddress.getReceiverMobilePhone());
			cstmt.setString(11,customerAddress.getReceiverTelePhone());
			cstmt.setInt(12,customerAddress.getReceiverAddressFlag());
			cstmt.setString(13,customerAddress.getCustomerReceivingAddressRemark());
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
	public boolean deleteByReceivingAddressID(int receivingAddressID) {
		boolean result = false;
		conn = DBPoolUtil.getConnection();
		try {
			cstmt = conn.prepareCall("{call spDeleteByReceivingAddressID(?,?)}");
			cstmt.registerOutParameter(1, Types.NVARCHAR);
			cstmt.setInt(2,receivingAddressID);
			cstmt.executeUpdate();
			String flag = cstmt.getString(1);
			if (Const.OK.equals(flag)) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBPoolUtil.closeConnection(conn);
		}
		return result;
	}

	@Override
	public int listCustomerAddressDataRawCount(PageEntity pageEntity) {
		conn = DBPoolUtil.getConnection();
		int result = 0;
		try {
			cstmt = conn.prepareCall("{call spSelectCustomerAddressCount(?)}");
			cstmt.registerOutParameter(1,Types.INTEGER);
			cstmt.execute();
			result = cstmt.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBPoolUtil.closeConnection(conn);
		}
		return result;
	}

	@Override
	public List<CustomerAddress> selectCustomerAddressList(PageEntity pageEntity) {
		List<CustomerAddress> customerAddressList = new ArrayList();
		try {
			conn = DBPoolUtil.getConnection();
			cstmt = conn.prepareCall("{call spGetLimitCustomerAddressList(?,?)}");
			cstmt.setInt(1,pageEntity.getStartRow());
			cstmt.setInt(2,pageEntity.getPageSize());
			rs = cstmt.executeQuery();
			while(rs.next()) {
				CustomerAddress customerAddress = new CustomerAddress();
				customerAddress.setCustomerID(rs.getString("CustomerID"));
				customerAddress.setReceiverProvince(rs.getString("ReceiverProvince"));
				customerAddress.setReceiverCity(rs.getString("ReceiverCity"));
				customerAddress.setReceiverDetailedAddress(rs.getString("ReceiverDistrict"));
				customerAddress.setReceiverStreet(rs.getString("ReceiverStreet"));
				customerAddress.setReceiverDetailedAddress(rs.getString("ReceiverDetailedAddress"));
				customerAddress.setReceiverPostCode(rs.getString("ReceiverPostCode"));
				customerAddress.setReceiverName(rs.getString("ReceiverName"));
				customerAddress.setReceiverMobilePhone(rs.getString("ReceiverMobilePhone"));
				customerAddress.setReceiverTelePhone(rs.getString("ReceiverTelePhone"));
				customerAddress.setReceiverAddressFlag(rs.getInt("ReceiverAddressFlag"));
				customerAddress.setCustomerReceivingAddressRemark(rs.getString("CustomerReceivingAddressRemark"));
				customerAddressList.add(customerAddress);
			}
		} catch (SQLException ex) {
			Logger.getLogger(CustomerAddressDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DBPoolUtil.closeConnection(rs, cstmt, conn);
		}
		return customerAddressList;
	}


	@Override
	public List<CustomerAddress> selectCustomerAddressListByIdOrName(String customerId,String receiverName,PageEntity pageEntity) {
		List<CustomerAddress> customerAddressList = new ArrayList<>();

		try {
			conn = DBPoolUtil.getConnection();
			cstmt = conn.prepareCall("{call spGetLimitCustomerAddressListByIDOrName(?,?,?,?)}");
			cstmt.setString(1,customerId);
			cstmt.setString(2,receiverName);
			cstmt.setInt(3,pageEntity.getStartRow());
			cstmt.setInt(4,pageEntity.getPageSize());
			rs = cstmt.executeQuery();

			while(rs.next()) {
				CustomerAddress customerAddress = new CustomerAddress();
				customerAddress.setCustomerID(rs.getString("CustomerID"));
				customerAddress.setReceiverProvince(rs.getString("ReceiverProvince"));
				customerAddress.setReceiverCity(rs.getString("ReceiverCity"));
				customerAddress.setReceiverDetailedAddress(rs.getString("ReceiverDistrict"));
				customerAddress.setReceiverStreet(rs.getString("ReceiverStreet"));
				customerAddress.setReceiverDetailedAddress(rs.getString("ReceiverDetailedAddress"));
				customerAddress.setReceiverPostCode(rs.getString("ReceiverPostCode"));
				customerAddress.setReceiverName(rs.getString("ReceiverName"));
				customerAddress.setReceiverMobilePhone(rs.getString("ReceiverMobilePhone"));
				customerAddress.setReceiverTelePhone(rs.getString("ReceiverTelePhone"));
				customerAddress.setReceiverAddressFlag(rs.getInt("ReceiverAddressFlag"));
				customerAddress.setCustomerReceivingAddressRemark(rs.getString("CustomerReceivingAddressRemark"));
				customerAddressList.add(customerAddress);
			}
		} catch (SQLException ex) {
			Logger.getLogger(CustomerAddressDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DBPoolUtil.closeConnection(rs, cstmt, conn);
		}
		return customerAddressList;
	}
}
