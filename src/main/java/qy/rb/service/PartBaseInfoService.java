package qy.rb.service;

import qy.rb.common.ServerResponse;
import qy.rb.domain.AutoStyling;
import qy.rb.domain.PageEntity;
import qy.rb.domain.PartBaseInfo;
import qy.rb.util.Pagenation;

/**
 * @author hjy
 * @create 2018/02/15
 **/
public interface PartBaseInfoService {
	/**
	 * 列表
	 * @param pageEntity
	 * @return
	 */
	Pagenation selectPartBaseInfoList(PageEntity pageEntity);

	/**
	 * 模糊查询列表
	 * @param partModel
	 * @param partName
	 * @param pageEntity
	 * @return
	 */
	Pagenation selectPartBaseInfoListByIdOrName(String partModel,String partName,PageEntity pageEntity);


	/**
	 * 添加基本信息
	 * @param partBaseInfo
	 * @return
	 */
	ServerResponse insertPartBaseInfo(PartBaseInfo partBaseInfo);

	/**
	 * 修改基本信息
	 * @param partBaseInfo
	 * @return
	 */
	ServerResponse updatePartBaseInfo(PartBaseInfo partBaseInfo);


}
