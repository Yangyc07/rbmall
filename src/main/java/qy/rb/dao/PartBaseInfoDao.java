package qy.rb.dao;

import qy.rb.domain.PageEntity;
import qy.rb.domain.PartAutoStyling;
import qy.rb.domain.PartBaseInfo;

import java.util.List;

/**
 * @author hjy
 * @create 2018/02/15
 **/
public interface PartBaseInfoDao {


	/**
	 * 添加基本零件信息
	 * @param partBaseInfo
	 * @return
	 */
	boolean insertPartBaseInfo(PartBaseInfo partBaseInfo);

	/**
	 * 删除基本零件信息
	 * @param partBaseInfoName
	 * @return
	 */
	boolean deleteByPartBaseInfoName(String partBaseInfoName);


	/**
	 * 修改基本零件信息
	 * @param partBaseInfo
	 * @return
	 */
	boolean updatePartBaseInfo(PartBaseInfo partBaseInfo);


	/**
	 * 返回基本零件信息
	 * @param pageEntity
	 * @return
	 */
	int listPartBaseInfoDataRawCount(PageEntity pageEntity);

	/**
	 * 返回基本零件信息 模糊查询
	 * @param partModel
	 * @param partName
	 * @param pageEntity
	 * @return
	 */
	int listPartBaseInfoDataRawCount(String partModel,String partName,PageEntity pageEntity);

	/**
	 * 查询基本零件信息
	 * @param pageEntity
	 * @return
	 */
	public List<PartBaseInfo> selectPartBaseInfoList(PageEntity pageEntity);


	public List<PartBaseInfo> selectPartBaseInfoListByModelOrName(String partModel,String partName,PageEntity pageEntity);

}
