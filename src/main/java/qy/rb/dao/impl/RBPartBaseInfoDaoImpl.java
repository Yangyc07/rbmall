package qy.rb.dao.impl;

import org.springframework.stereotype.Repository;
import qy.rb.dao.RBPartBaseInfoDao;
import qy.rb.domain.PageEntity;
import qy.rb.domain.Producer;
import qy.rb.domain.RBPartBaseInfo;
import qy.rb.util.DBPoolUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author hjy
 * @create 2018/02/17
 **/

@Repository //扫描Dao
public class RBPartBaseInfoDaoImpl implements RBPartBaseInfoDao {


	Connection conn = null;
	CallableStatement cstmt  = null;
	ResultSet rs = null;

	@Override
	public boolean insertRBPartBaseInfo(RBPartBaseInfo rbPartBaseInfo) {
		boolean result = false;
		conn = DBPoolUtil.getConnection();
		try {
			cstmt = conn.prepareCall("{call spInsertRBPartBaseInfo(?,?,?,?,?,?,?,?)}");
			cstmt.registerOutParameter(1, Types.NVARCHAR);
			cstmt.setString(2,rbPartBaseInfo.getRbPartID());
			cstmt.setString(3,rbPartBaseInfo.getPartModel());
			cstmt.setString(4,rbPartBaseInfo.getPartBrand());
			cstmt.setString(5,rbPartBaseInfo.getProducerID());
			cstmt.setString(6,rbPartBaseInfo.getPartImagesAddress());
			cstmt.setInt(7,rbPartBaseInfo.getPartStatus());
			cstmt.setString(8,rbPartBaseInfo.getRbPartBaseInfoRemark());
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
	public int listRBPartBaseInfoDataRawCount(PageEntity pageEntity) {
		conn = DBPoolUtil.getConnection();
		int result = 0;
		try {
			cstmt = conn.prepareCall("{call spSelectRBPartBaseInfoCount(?)}");
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
	public List<RBPartBaseInfo> selectRBPartBaseInfoList(PageEntity pageEntity) {
		List<RBPartBaseInfo> rbPartBaseInfoList = new ArrayList();
		try {
			conn = DBPoolUtil.getConnection();
			cstmt = conn.prepareCall("{call spGetLimitRBPartBaseInfoList(?,?)}");
			cstmt.setInt(1,pageEntity.getStartRow());
			cstmt.setInt(2,pageEntity.getPageSize());
			rs = cstmt.executeQuery();
			while(rs.next()) {
				RBPartBaseInfo rbPartBaseInfo = new RBPartBaseInfo();
				rbPartBaseInfo.setRbPartID(rs.getString("RBPartID"));
				rbPartBaseInfo.setPartModel(rs.getString("PartModel"));
				rbPartBaseInfo.setPartBrand(rs.getString("PartBrand"));
				rbPartBaseInfo.setProducerID(rs.getString("ProducerID"));
				rbPartBaseInfo.setPartImagesAddress(rs.getString("PartImagesAddress"));
				rbPartBaseInfo.setPartStatus(Integer.parseInt(rs.getString("PartStatus")));
				rbPartBaseInfo.setRbPartBaseInfoRemark(rs.getString("RBPartBaseInfoRemark"));
				rbPartBaseInfoList.add(rbPartBaseInfo);
			}
		} catch (SQLException ex) {
			Logger.getLogger(RBPartBaseInfoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DBPoolUtil.closeConnection(rs, cstmt, conn);
		}
		return rbPartBaseInfoList;
	}
}
