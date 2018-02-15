package qy.rb.dao.impl;

import org.springframework.stereotype.Repository;
import qy.rb.dao.PartAutoStylingDao;
import qy.rb.domain.AutoStyling;
import qy.rb.domain.PageEntity;
import qy.rb.domain.PartAutoStyling;
import qy.rb.util.DBPoolUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author hjy
 * @create 2018/02/15
 **/
@Repository //扫描Dao
public class PartAutoStylingDaoImpl implements PartAutoStylingDao {

	Connection conn = null;
	CallableStatement cstmt  = null;
	ResultSet rs = null;


	@Override
	public boolean insertPartAutoStyling(PartAutoStyling partAutoStyling) {
		boolean result = false;
		conn = DBPoolUtil.getConnection();
		try {
			cstmt = conn.prepareCall("{call spInsertPartAutoStyling(?,?,?,?)}");
			cstmt.registerOutParameter(1, Types.NVARCHAR);
			cstmt.setString(2,partAutoStyling.getPartModel());
			cstmt.setString(3,partAutoStyling.getAutoStylingName());
			cstmt.setString(4,partAutoStyling.getPartAutoStylingRemark());
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
	public boolean deleteByPartAutoStylingModel(String partAutoStylingModel) {
		return false;
	}

	@Override
	public int listPartAutoStylingDataRawCount(PageEntity pageEntity) {
		conn = DBPoolUtil.getConnection();
		int result = 0;
		try {
			cstmt = conn.prepareCall("{call spSelectPartAutoStylingCount(?)}");
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
	public List<PartAutoStyling> selectPartAutoStylingList(PageEntity pageEntity) {
		List<PartAutoStyling> partAutoStylingList = new ArrayList<>();
		try {
			conn = DBPoolUtil.getConnection();
			cstmt = conn.prepareCall("{call spGetLimitPartAutoStylingList(?,?)}");
			cstmt.setInt(1,pageEntity.getStartRow());
			cstmt.setInt(2,pageEntity.getPageSize());
			rs = cstmt.executeQuery();
			while(rs.next()) {
				PartAutoStyling partAutoStyling = new PartAutoStyling();
				partAutoStyling.setPartModel(rs.getString("PartModel"));
				partAutoStyling.setAutoStylingName(rs.getString("AutoStylingName"));
				partAutoStyling.setPartAutoStylingRemark(rs.getString("PartAutoStylingRemark"));
				partAutoStylingList.add(partAutoStyling);
			}
		} catch (SQLException ex) {
			Logger.getLogger(PartAutoStylingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DBPoolUtil.closeConnection(rs, cstmt, conn);
		}
		return partAutoStylingList;
	}

	@Override
	public List<PartAutoStyling> selectAutoStylingListByModelOrName(String partModel, String autoStylingName, PageEntity pageEntity) {
		List<PartAutoStyling> partAutoStylingList = new ArrayList<>();
		try {
			conn = DBPoolUtil.getConnection();
			cstmt = conn.prepareCall("{call spGetLimitPartAutoStylingList(?,?,?,?)}");
			cstmt.setString(1,partModel);
			cstmt.setString(2,autoStylingName);
			cstmt.setInt(3,pageEntity.getStartRow());
			cstmt.setInt(4,pageEntity.getPageSize());
			rs = cstmt.executeQuery();
			while(rs.next()) {
				PartAutoStyling partAutoStyling = new PartAutoStyling();
				partAutoStyling.setPartModel(rs.getString("PartModel"));
				partAutoStyling.setAutoStylingName(rs.getString("AutoStylingName"));
				partAutoStyling.setPartAutoStylingRemark(rs.getString("PartAutoStylingRemark"));
				partAutoStylingList.add(partAutoStyling);
			}
		} catch (SQLException ex) {
			Logger.getLogger(AutoStylingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DBPoolUtil.closeConnection(rs, cstmt, conn);
		}
		return partAutoStylingList;
	}
}
