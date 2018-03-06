package qy.rb.dao.impl;

import org.springframework.stereotype.Repository;
import qy.rb.dao.BaseInfoVoDao;
import qy.rb.domain.AutoStyling;
import qy.rb.domain.PageEntity;
import qy.rb.domain.RBPartBaseInfo;
import qy.rb.util.DBPoolUtil;
import qy.rb.vo.BaseInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hjy
 * @create 2018/03/06
 **/
@Repository //扫描Dao
public class BaseInfoVoDaoImpl implements BaseInfoVoDao {

	Connection conn = null;
	CallableStatement cstmt  = null;
	ResultSet rs = null;

	@Override
	public List<BaseInfo> getList(String partName,String autoStylingName,PageEntity pageEntity) {
		List<BaseInfo> baseInfoList = new ArrayList<>();
		conn = DBPoolUtil.getConnection();
		int result = 0;
		try {
			cstmt = conn.prepareCall("{call spPortalBaseInfoByPartNameOrAutoStylingName(?,?,?,?)}");
			cstmt.setString(1,partName);
			cstmt.setString(2,autoStylingName);
			cstmt.setInt(3,pageEntity.getStartRow());
			cstmt.setInt(4,pageEntity.getPageSize());
			cstmt.execute();
			result = cstmt.getInt(1);
			rs = cstmt.executeQuery();
			while(rs.next()) {
				BaseInfo baseInfo = new BaseInfo();
				baseInfo.setRbPartID(rs.getString("RBPartID"));
				baseInfo.setPartName(rs.getString("PartName"));
				baseInfo.setPartModel(rs.getString("PartModel"));
				baseInfo.setPartSubtitle(rs.getString("PartSubtitle"));
				baseInfo.setOrdinaryPrice(rs.getString("OrdinaryPrice"));
				baseInfoList.add(baseInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBPoolUtil.closeConnection(conn);
		}
		return baseInfoList;
	}

	@Override
	public int getListCount(String partName, String autoStylingName, PageEntity pageEntity) {
		return 10;
	}
}
