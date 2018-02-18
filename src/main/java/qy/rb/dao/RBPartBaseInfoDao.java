package qy.rb.dao;

import qy.rb.domain.PageEntity;
import qy.rb.domain.RBPartBaseInfo;

import java.util.List;


/**
 * @author: hjy
 * @description:睿邦零件基本信息
 */
public interface RBPartBaseInfoDao {

	/**
	 * 添加睿邦零件基本信息
	 * @param rbPartBaseInfo
	 * @return
	 */
	boolean insertRBPartBaseInfo(RBPartBaseInfo rbPartBaseInfo);

	/**
	 * 返回睿邦零件基本信息条数
	 * @param pageEntity
	 * @return
	 */
	int listRBPartBaseInfoDataRawCount(PageEntity pageEntity);

	/**
	 * 查询睿邦零件基本信息清单
	 * @param pageEntity
	 * @return
	 */
	List<RBPartBaseInfo> selectRBPartBaseInfoList(PageEntity pageEntity);




}
