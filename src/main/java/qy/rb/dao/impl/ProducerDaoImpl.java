package qy.rb.dao.impl;

import org.springframework.stereotype.Repository;
import qy.rb.dao.ProducerDao;
import qy.rb.domain.AutoStyling;
import qy.rb.domain.PageEntity;
import qy.rb.domain.Producer;
import qy.rb.util.DBPoolUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author hjy
 * @create 2018/02/16
 **/

@Repository //扫描Dao
public class ProducerDaoImpl implements ProducerDao {

	Connection conn = null;
	CallableStatement cstmt  = null;
	ResultSet rs = null;



	@Override
	public boolean insertProducer(Producer producer) {
		boolean result = false;
		conn = DBPoolUtil.getConnection();
		try {
			cstmt = conn.prepareCall("{call spInsertProducer(?,?,?,?)}");
			cstmt.registerOutParameter(1, Types.NVARCHAR);
			cstmt.setString(2,producer.getProducerID());
			cstmt.setString(3,producer.getProducerName());
			cstmt.setInt(4,producer.getRankORDER());
			cstmt.setString(5,producer.getProducerRemark());
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
	public boolean deleteByProducerName(String producerName) {


		return false;
	}

	@Override
	public int listProducerDataRawCount(PageEntity pageEntity) {
		conn = DBPoolUtil.getConnection();
		int result = 0;
		try {
			cstmt = conn.prepareCall("{call spSelectProducerCount(?)}");
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
	public List<Producer> selectProducerList(PageEntity pageEntity) {
		List<Producer> producerList = new ArrayList();
		try {
			conn = DBPoolUtil.getConnection();
			cstmt = conn.prepareCall("{call spGetLimitProducerList(?,?)}");
			cstmt.setInt(1,pageEntity.getStartRow());
			cstmt.setInt(2,pageEntity.getPageSize());
			rs = cstmt.executeQuery();
			while(rs.next()) {
				Producer producer = new Producer();
				producer.setProducerID(rs.getString("ProducerID"));
				producer.setProducerName(rs.getString("ProducerName"));
				producer.setRankORDER(rs.getInt("RankORDER"));
				producer.setProducerRemark(rs.getString("ProducerRemark"));
				producerList.add(producer);
			}
		} catch (SQLException ex) {
			Logger.getLogger(ProducerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DBPoolUtil.closeConnection(rs, cstmt, conn);
		}
		return producerList;
	}

	@Override
	public List<Producer> selectProducerListByName(String producerName, PageEntity pageEntity) {
		List<Producer> producerList = new ArrayList();
		try {
			conn = DBPoolUtil.getConnection();
			cstmt = conn.prepareCall("{call spGetLimitAutoStylingList(?,?)}");
			cstmt.setInt(1,pageEntity.getStartRow());
			cstmt.setInt(2,pageEntity.getPageSize());
			rs = cstmt.executeQuery();
			while(rs.next()) {
				Producer producer = new Producer();
				producer.setProducerID(rs.getString("ProducerID"));
				producer.setProducerName(rs.getString("ProducerName"));
				producer.setRankORDER(rs.getInt("RankORDER"));
				producer.setProducerRemark(rs.getString("ProducerRemark"));
				producerList.add(producer);
			}
		} catch (SQLException ex) {
			Logger.getLogger(ProducerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DBPoolUtil.closeConnection(rs, cstmt, conn);
		}
		return producerList;

	}
}
