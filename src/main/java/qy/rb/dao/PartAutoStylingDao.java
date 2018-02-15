package qy.rb.dao;

import qy.rb.domain.PageEntity;
import qy.rb.domain.PartAutoStyling;

import java.util.List;

/**
 * @author hjy
 * @create 2018/02/15
 **/
public interface PartAutoStylingDao {

	/**
	 * 添加零件-车型联系
	 * @param partAutoStyling
	 * @return
	 */
	boolean insertPartAutoStyling(PartAutoStyling partAutoStyling);


	/**
	 * 删除零件-车型联系
	 * @param partAutoStylingModel
	 * @return
	 */
	boolean deleteByPartAutoStylingModel(String partAutoStylingModel);


	/**
	 * 返回零件-车型联系条数
	 * @param pageEntity
	 * @return
	 */
	int listPartAutoStylingDataRawCount(PageEntity pageEntity);

	/**
	 * 查询零件-车型联系清单
	 * @param pageEntity
	 * @return
	 */
	public List<PartAutoStyling> selectPartAutoStylingList(PageEntity pageEntity);

	/**
	 * 通过车型名称或者品牌进行搜索
	 * @param partModel
	 * @param autoStylingName
	 * @param pageEntity
	 * @return
	 */
	public List<PartAutoStyling> selectAutoStylingListByModelOrName(String partModel,String autoStylingName,PageEntity pageEntity);




}
