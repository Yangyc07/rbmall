package qy.rb.dao.impl;

import org.springframework.stereotype.Repository;
import qy.rb.dao.PartCategoryDao;
import qy.rb.domain.CustomerAddress;
import qy.rb.domain.PageEntity;
import qy.rb.domain.PartCategory;
import qy.rb.util.DBPoolUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author hjy
 * @create 2018/02/04
 **/
@Repository //扫描Dao
public class PartCategoryDaoImpl implements PartCategoryDao {

	Connection conn = null;
	CallableStatement cstmt  = null;
	ResultSet rs = null;


	@Override
	public boolean insert(PartCategory partCategory) {
		return false;
	}

	@Override
	public boolean updateByPartCategoryId(String partCategoryId, String partCategoryName) {
		return false;
	}

	@Override
	public List<PartCategory> selectCategoryChildrenByPartCategoryID(String partCategoryID) {
		return null;
	}

	@Override
	public int listPartCategoryDataRawCount(PageEntity pageEntity) {
		conn = DBPoolUtil.getConnection();
		int result = 0;
		try {
			cstmt = conn.prepareCall("{call spSelectPartCategoryCount(?)}");
			cstmt.registerOutParameter(1, Types.INTEGER);
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
	public List<PartCategory> selectPartCategoryList(PageEntity pageEntity) {
		List<PartCategory> partCategoryList = new ArrayList<>();
		try {
			conn = DBPoolUtil.getConnection();
			cstmt = conn.prepareCall("{call spGetLimitPartCategoryList(?,?)}");
			cstmt.setInt(1,pageEntity.getStartRow());
			cstmt.setInt(2,pageEntity.getPageSize());
			rs = cstmt.executeQuery();
			while(rs.next()) {
				PartCategory partCategory = new PartCategory();
				partCategory.setPartCategoryID(rs.getString("PartCategoryID"));
				partCategory.setPartCategoryName(rs.getString("PartCategoryName"));
				partCategory.setPartCategoryRemark(rs.getString("PartCategoryRemark"));
				partCategoryList.add(partCategory);
			}
		} catch (SQLException ex) {
			Logger.getLogger(PartCategoryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DBPoolUtil.closeConnection(rs,cstmt,conn);
		}
		return  partCategoryList;
	}
}
