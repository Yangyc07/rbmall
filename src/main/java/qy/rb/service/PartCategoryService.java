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
	 * @param partCategoryId
	 * @param partCategoryName
	 * @return
	 */
	ServerResponse updatePartCategoryName(String partCategoryId,String partCategoryName);

	/**
	 * 得到孩子分类信息
	 * @param partCategoryId
	 * @return
	 */
	ServerResponse<List<PartCategory>> getChildrenPartCategory(String partCategoryId);

	public Pagenation selectPartCategoryList(PageEntity pageEntity);


}
