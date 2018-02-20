package qy.rb.dao;


import qy.rb.domain.CustomerAddress;
import qy.rb.domain.PageEntity;
import qy.rb.domain.PartCategory;

import java.util.List;

/**
 * @author hjy
 * @create 2018/01/30
 **/
public interface PartCategoryDao {

	/**
	 * 添加分类信息
	 * @param partCategory
	 * @return
	 */
	boolean insert(PartCategory partCategory);

	/**
	 * 更新分类信息
	 * @param partCategory
	 * @return
	 */
	boolean updatePartCategory(PartCategory partCategory);

	/**
	 * 通过此零件类别编号 找出所有该类别编号下的 零件类别编号
	 * @param partCategoryID
	 * @return partCategoryID
	 */
	List<PartCategory> selectCategoryChildrenByPartCategoryID(String partCategoryID);


	/**
	 * 返回零件类别信息条数
	 * @param pageEntity
	 * @return
	 */
	int listPartCategoryDataRawCount(PageEntity pageEntity);

	/**
	 * 返回零件类别信息条数 模糊查询
	 * @param partCategoryID
	 * @param partCategoryName
	 * @param pageEntity
	 * @return
	 */
	int listPartCategoryDataRawCount(String partCategoryID,String partCategoryName,PageEntity pageEntity);


	/**
	 * 查询零件类别息清单
	 * @param pageEntity
	 * @return
	 */
	public List<PartCategory> selectPartCategoryList(PageEntity pageEntity);


	/**
	 * 通过零件类别编号或者零件类别名称进行搜索
	 * @param partCategoryID
	 * @param partCategoryName
	 * @param pageEntity
	 * @return
	 */
	public List<PartCategory> selectPartCategoryListByIdOrName(String partCategoryID,String partCategoryName,PageEntity pageEntity);




}
