package qy.rb.service;

import qy.rb.common.ServerResponse;
import qy.rb.domain.PageEntity;
import qy.rb.domain.PartBaseInfo;
import qy.rb.util.Pagenation;

/**
 * @author hjy
 * @create 2018/02/15
 **/
public interface PartBaseInfoService {

	Pagenation selectPartBaseInfoList(PageEntity pageEntity);


	/**
	 * 添加基本信息
	 * @param partBaseInfo
	 * @return
	 */
	ServerResponse insertPartBaseInfo(PartBaseInfo partBaseInfo);


}
