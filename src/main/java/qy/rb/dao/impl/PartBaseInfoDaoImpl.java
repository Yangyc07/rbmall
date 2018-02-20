package qy.rb.dao.impl;

import org.springframework.stereotype.Repository;
import qy.rb.dao.PartBaseInfoDao;
import qy.rb.domain.AutoStyling;
import qy.rb.domain.PageEntity;
import qy.rb.domain.PartBaseInfo;
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
public class PartBaseInfoDaoImpl implements PartBaseInfoDao {

	Connection conn = null;
	CallableStatement cstmt  = null;
	ResultSet rs = null;

	@Override
	public boolean insertPartBaseInfo(PartBaseInfo partBaseInfo) {
		boolean result = false;
		conn = DBPoolUtil.getConnection();
		try {
			cstmt = conn.prepareCall("{call spInsertPartBaseInfo(?,?,?,?,?,?,?)}");
			cstmt.registerOutParameter(1, Types.NVARCHAR);
			cstmt.setString(2,partBaseInfo.getPartModel());
			cstmt.setString(3,partBaseInfo.getPartName());
			cstmt.setString(4,partBaseInfo.getPartSubtitle());
			cstmt.setString(5,partBaseInfo.getPartUnit());
			cstmt.setString(6,partBaseInfo.getPartCategoryId());
			cstmt.setString(7,partBaseInfo.getPartBaseInfoRemark());
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
	public boolean deleteByPartBaseInfoName(String partBaseInfoName) {

		return false;
	}

	@Override
	public int listPartBaseInfoDataRawCount(PageEntity pageEntity) {
		conn = DBPoolUtil.getConnection();
		int result = 0;
		try {
			cstmt = conn.prepareCall("{call spSelectPartBaseInfoCount(?)}");
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
	public int listPartBaseInfoDataRawCount(String partModel, String partName, PageEntity pageEntity) {
		conn = DBPoolUtil.getConnection();
		int result = 0;
		try {
			cstmt = conn.prepareCall("{call spSelectPartBaseInfoCountByModelOrName(?,?,?)}");
			cstmt.registerOutParameter(1,Types.INTEGER);
			cstmt.setString(2,partModel);
			cstmt.setString(3,partName);
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
	public List<PartBaseInfo> selectPartBaseInfoList(PageEntity pageEntity) {
		List<PartBaseInfo> partBaseInfoList = new ArrayList<>();
		try {
			conn = DBPoolUtil.getConnection();
			cstmt = conn.prepareCall("{call spGetLimitPartBaseInfoList(?,?)}");
			cstmt.setInt(1,pageEntity.getStartRow());
			cstmt.setInt(2,pageEntity.getPageSize());
			rs = cstmt.executeQuery();
			while(rs.next()) {
				PartBaseInfo partBaseInfo = new PartBaseInfo();
				partBaseInfo.setPartModel(rs.getString("PartModel"));
				partBaseInfo.setPartName(rs.getString("PartName"));
				partBaseInfo.setPartSubtitle(rs.getString("PartSubtitle"));
				partBaseInfo.setPartUnit(rs.getString("PartUnit"));
				partBaseInfo.setPartCategoryId(rs.getString("PartCategoryId"));
				partBaseInfo.setPartBaseInfoRemark(rs.getString("PartBaseInfoRemark"));
				partBaseInfoList.add(partBaseInfo);
			}
		} catch (SQLException ex) {
			Logger.getLogger(PartBaseInfoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DBPoolUtil.closeConnection(rs, cstmt, conn);
		}
		return partBaseInfoList;
	}

	@Override
	public List<PartBaseInfo> selectPartBaseInfoListByModelOrName(String partModel, String partName, PageEntity pageEntity) {
		List<PartBaseInfo> partBaseInfoList = new ArrayList<>();
		try {
			conn = DBPoolUtil.getConnection();
			cstmt = conn.prepareCall("{call spGetLimitPartBaseInfoListByModelOrName(?,?,?,?)}");
			cstmt.setString(1,partModel);
			cstmt.setString(2,partName);
			cstmt.setInt(3,pageEntity.getStartRow());
			cstmt.setInt(4,pageEntity.getPageSize());
			rs = cstmt.executeQuery();
			while(rs.next()) {
				PartBaseInfo partBaseInfo = new PartBaseInfo();
				partBaseInfo.setPartModel(rs.getString("PartModel"));
				partBaseInfo.setPartName(rs.getString("PartName"));
				partBaseInfo.setPartSubtitle(rs.getString("PartSubtitle"));
				partBaseInfo.setPartUnit(rs.getString("PartUnit"));
				partBaseInfo.setPartCategoryId(rs.getString("PartCategoryId"));
				partBaseInfo.setPartBaseInfoRemark(rs.getString("PartBaseInfoRemark"));
				partBaseInfoList.add(partBaseInfo);
			}
		} catch (SQLException ex) {
			Logger.getLogger(PartBaseInfoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DBPoolUtil.closeConnection(rs, cstmt, conn);
		}
		return partBaseInfoList;
	}
}
