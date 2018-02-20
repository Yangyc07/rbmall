package qy.rb.service;

import qy.rb.common.ServerResponse;
import qy.rb.domain.PageEntity;
import qy.rb.domain.PartCategory;
import qy.rb.util.Pagenation;


import java.util.List;

/**
 * @author hjy
 * @create 2018/02/01
 **/
public interface PartCategoryService {
	/**
	 * 添加分类
	 * @param partCategory
	 * @return
	 */
	ServerResponse insertPartCategory(PartCategory partCategory);

	/**
	 * 修改分类名称
	 * @param partCategory
	 * @return
	 */
	ServerResponse updatePartCategory(PartCategory partCategory);

	/**
	 * 得到孩子分类信息
	 * @param partCategoryId
	 * @return
	 */
	ServerResponse<List<PartCategory>> getChildrenPartCategory(String partCategoryId);

	public Pagenation selectPartCategoryList(PageEntity pageEntity);

	Pagenation selectPartCategoryListByIdOrName(String partCategoryId,String partCategoryName,PageEntity pageEntity);

}
