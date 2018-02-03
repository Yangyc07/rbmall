package qy.rb.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import qy.rb.common.ServerResponse;
import qy.rb.dao.PartCategoryDao;
import qy.rb.domain.PartCategory;
import qy.rb.service.PartCategoryService;


import javax.annotation.Resource;
import java.util.List;

/**
 * @author hjy
 * @create 2018/02/01
 **/
@Service("PartCategoryService")
public class PartCategoryServiceImpl implements PartCategoryService {

	private Logger logger = LoggerFactory.getLogger(PartCategoryServiceImpl.class);


	@Resource
	PartCategoryDao partCategoryDao;

	@Override
	public ServerResponse insertPartCategory(PartCategory partCategory) {
		boolean flag = partCategoryDao.insert(partCategory);
		if (flag) {
			return ServerResponse.createBySuccess("添加成功");
		}
		return ServerResponse.createByErrorMessage("添加失败");
	}

	@Override
	public ServerResponse updatePartCategoryName(String partCategoryId, String partCategoryName) {
		if(partCategoryId == null || StringUtils.isBlank(partCategoryName)){
			return ServerResponse.createByErrorMessage("更新配件分类参数错误");
		}
		boolean flag = partCategoryDao.updateByPartCategoryId(partCategoryId,partCategoryName);
		if(flag){
			return ServerResponse.createBySuccess("更新配件分类名字成功");
		}
		return ServerResponse.createByErrorMessage("更新配件分类名字失败");



	}

	@Override
	public ServerResponse<List<PartCategory>> getChildrenPartCategory(String partCategoryId) {
		List<PartCategory> partCategoryList = partCategoryDao.selectCategoryChildrenByPartCategoryID(partCategoryId);
		if(CollectionUtils.isEmpty(partCategoryList)){
			logger.info("未找到当前分类的子分类");
		}
		return ServerResponse.createBySuccess(partCategoryList);
	}
}
