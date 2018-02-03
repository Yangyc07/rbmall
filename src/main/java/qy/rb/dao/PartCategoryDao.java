package qy.rb.dao;


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
	 * @param partCategoryId
	 * @param partCategoryName
	 * @return
	 */
	boolean updateByPartCategoryId(String partCategoryId,String partCategoryName);

	/**
	 * 通过此零件类别编号 找出所有该类别编号下的 零件类别编号
	 * @param partCategoryID
	 * @return partCategoryID
	 */
	List<PartCategory> selectCategoryChildrenByPartCategoryID(String partCategoryID);


}
