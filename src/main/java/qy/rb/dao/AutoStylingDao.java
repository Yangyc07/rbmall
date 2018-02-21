package qy.rb.dao;

import qy.rb.domain.AutoStyling;
import qy.rb.domain.CustomerAddress;
import qy.rb.domain.PageEntity;

import java.util.List;

/**
 * @author: hjy
 * @description:
 */
public interface AutoStylingDao {

	/**
	 * 添加车型
	 * @param autoStyling
	 * @return
	 */
	boolean insertAutoStyling(AutoStyling autoStyling);

	/**
	 * 删除车型
	 * @param autoStylingName
	 * @return
	 */
	boolean deleteByAutoStylingName(String autoStylingName);

	/**
	 * 修改车型
	 * @param autoStyling
	 * @return
	 */
	boolean updateAutoStyling(AutoStyling autoStyling);

	/**
	 * 返回车型信息条数
	 * @param pageEntity
	 * @return
	 */
	int listAutoStylingDataRawCount(PageEntity pageEntity);

	/**
	 * 返回车型信息条数 模糊查询
	 * @param autoStylingName
	 * @param autoStylingBrand
	 * @param pageEntity
	 * @return
	 */
	int listAutoStylingDataRawCount(String autoStylingName, String autoStylingBrand, PageEntity pageEntity);

	/**
	 * 查询车型信息清单
	 * @param pageEntity
	 * @return
	 */
	public List<AutoStyling> selectAutoStylingList(PageEntity pageEntity);

	/**
	 * 通过车型名称或者品牌进行搜索
	 * @param autoStylingName
	 * @param autoStylingBrand
	 * @param pageEntity
	 * @return
	 */
	public List<AutoStyling> selectAutoStylingListByNameOrBrand(String autoStylingName,String autoStylingBrand,PageEntity pageEntity);
}
