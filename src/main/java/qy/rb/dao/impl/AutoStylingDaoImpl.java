package qy.rb.dao.impl;

import org.springframework.stereotype.Repository;
import qy.rb.dao.AutoStylingDao;
import qy.rb.domain.AutoStyling;
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
 * @create 2018/02/10
 **/
@Repository //扫描Dao
public class AutoStylingDaoImpl implements AutoStylingDao {

	Connection conn = null;
	CallableStatement cstmt  = null;
	ResultSet rs = null;


	@Override
	public boolean insertAutoStyling(AutoStyling autoStyling) {
		boolean result = false;
		conn = DBPoolUtil.getConnection();
		try {
			cstmt = conn.prepareCall("{call spInsertAutoStyling(?,?,?,?)}");
			cstmt.registerOutParameter(1, Types.NVARCHAR);
			cstmt.setString(2,autoStyling.getAutoStylingName());
			cstmt.setString(3,autoStyling.getAutoStylingBrand());
			cstmt.setString(4,autoStyling.getAutoStylingRemark());
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
	public boolean deleteByAutoStylingName(String autoStylingName) {
		return false;
	}

	@Override
	public boolean updateAutoStyling(AutoStyling autoStyling) {
		boolean result = false;
		conn = DBPoolUtil.getConnection();
		try {
			cstmt = conn.prepareCall("{call spUpdateAutoStylingByName(?,?,?,?)}");
			cstmt.registerOutParameter(1, Types.NVARCHAR);
			cstmt.setString(2,autoStyling.getAutoStylingName());
			cstmt.setString(3,autoStyling.getAutoStylingBrand());
			cstmt.setString(4,autoStyling.getAutoStylingRemark());
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
	public int listAutoStylingDataRawCount(PageEntity pageEntity) {
		conn = DBPoolUtil.getConnection();
		int result = 0;
		try {
			cstmt = conn.prepareCall("{call spSelectAutoStylingCount(?)}");
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
	public List<AutoStyling> selectAutoStylingList(PageEntity pageEntity) {
		List<AutoStyling> autoStylingList = new ArrayList();
		try {
			conn = DBPoolUtil.getConnection();
			cstmt = conn.prepareCall("{call spGetLimitAutoStylingList(?,?)}");
			cstmt.setInt(1,pageEntity.getStartRow());
			cstmt.setInt(2,pageEntity.getPageSize());
			rs = cstmt.executeQuery();
			while(rs.next()) {
				AutoStyling autoStyling = new AutoStyling();
				autoStyling.setAutoStylingName(rs.getString("AutoStylingName"));
				autoStyling.setAutoStylingBrand(rs.getString("AutoStylingBrand"));
				autoStyling.setAutoStylingRemark(rs.getString("AutoStylingRemark"));
				autoStylingList.add(autoStyling);
			}
		} catch (SQLException ex) {
			Logger.getLogger(AutoStylingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DBPoolUtil.closeConnection(rs, cstmt, conn);
		}
		return autoStylingList;
	}

	@Override
	public List<AutoStyling> selectAutoStylingListByNameOrBrand(String autoStylingName, String autoStylingBrand, PageEntity pageEntity) {
		List<AutoStyling> autoStylingList = new ArrayList();
		try {
			conn = DBPoolUtil.getConnection();
			cstmt = conn.prepareCall("{call spGetLimitAutoStylingList(?,?,?,?)}");
			cstmt.setString(1,autoStylingName);
			cstmt.setString(2,autoStylingBrand);
			cstmt.setInt(3,pageEntity.getStartRow());
			cstmt.setInt(4,pageEntity.getPageSize());
			rs = cstmt.executeQuery();
			while(rs.next()) {
				AutoStyling autoStyling = new AutoStyling();
				autoStyling.setAutoStylingName(rs.getString("AutoStylingName"));
				autoStyling.setAutoStylingBrand(rs.getString("AutoStylingBrand"));
				autoStyling.setAutoStylingRemark(rs.getString("AutoStylingRemark"));
				autoStylingList.add(autoStyling);
			}
		} catch (SQLException ex) {
			Logger.getLogger(AutoStylingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DBPoolUtil.closeConnection(rs, cstmt, conn);
		}
		return autoStylingList;
	}
}
