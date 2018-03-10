package qy.rb.dao;

import qy.rb.domain.PageEntity;
import qy.rb.vo.BaseInfo;
import qy.rb.vo.BaseInfoDetail;

import java.util.List;

/**
 * @author hjy
 * @create 2018/03/06
 **/
public interface BaseInfoDao {

	List<BaseInfo> getList(String partName,String autoStylingName,PageEntity pageEntity);

	int getListCount(String partName,String autoStylingName,PageEntity pageEntity);

	public BaseInfoDetail getDetail(String rbPartID);

}
