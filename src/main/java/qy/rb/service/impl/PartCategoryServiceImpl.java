package qy.rb.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import qy.rb.common.ServerResponse;
import qy.rb.dao.PartCategoryDao;
import qy.rb.domain.PageEntity;
import qy.rb.domain.PartCategory;
import qy.rb.service.PartCategoryService;
import qy.rb.util.Pagenation;


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
			return ServerResponse.createBySuccessMessage("添加成功");
		}
		return ServerResponse.createByErrorMessage("添加失败");
	}

	@Override
	public ServerResponse updatePartCategory(PartCategory partCategory) {
		if(partCategory.getPartCategoryID() == null || StringUtils.isBlank(partCategory.getPartCategoryName())){
			return ServerResponse.createByErrorMessage("更新配件分类参数错误");
		}
		boolean flag = partCategoryDao.updatePartCategory(partCategory);
		if(flag){
			return ServerResponse.createBySuccessMessage("更新配件分类成功");
		}
		return ServerResponse.createByErrorMessage("更新配件分类失败");



	}

	@Override
	public ServerResponse<List<PartCategory>> getChildrenPartCategory(String partCategoryId) {
		List<PartCategory> partCategoryList = partCategoryDao.selectCategoryChildrenByPartCategoryID(partCategoryId);
		if(CollectionUtils.isEmpty(partCategoryList)){
			logger.info("未找到当前分类的子分类");
		}
		return ServerResponse.createBySuccess(partCategoryList);
	}

	@Override
	public Pagenation selectPartCategoryList(PageEntity pageEntity) {
		//算出所需数据的总条数
		int cout = partCategoryDao.listPartCategoryDataRawCount(pageEntity);
		//通过（当前页、每页显示条数、总条数） 初始化分页信息
		Pagenation pagenation = new Pagenation(pageEntity.getPageSize(), pageEntity.getPageNum(), cout);
		//通过上步骤算出要查询的 开始条数，边set 到分页入参实体类中。
		pageEntity.setStartRow(pagenation.getStartRow());
		//在查询 list 的时候，让传入的startRow 和 pageSize 作为limit 条件，添加至 sql。
		pagenation.setList(partCategoryDao.selectPartCategoryList(pageEntity));
		return pagenation;
	}

	@Override
	public Pagenation selectPartCategoryListByIdOrName(String partCategoryId, String partCategoryName, PageEntity pageEntity) {
		if (StringUtils.isNoneBlank(partCategoryId)) {
			//customerId为空不执行
			partCategoryId = new StringBuilder().append(partCategoryId).append("%").toString();
		} else {
			partCategoryId = null;
		}
		if (StringUtils.isNoneBlank(partCategoryName)) {
			//partCategoryName
			partCategoryName = new StringBuilder().append(partCategoryName).append("%").toString();
		} else {
			partCategoryName = null;
		}
		//算出所需数据的总条数
		int cout = partCategoryDao.listPartCategoryDataRawCount(partCategoryId,partCategoryName,pageEntity);

		//通过（当前页、每页显示条数、总条数） 初始化分页信息
		Pagenation pagenation = new Pagenation(pageEntity.getPageSize(), pageEntity.getPageNum(), cout);
		//通过上步骤算出要查询的 开始条数，边set 到分页入参实体类中。
		pageEntity.setStartRow(pagenation.getStartRow());
		//在查询 list 的时候，让传入的startRow 和 pageSize 作为limit 条件，添加至 sql。
		pagenation.setList(partCategoryDao.selectPartCategoryListByIdOrName(partCategoryId, partCategoryName, pageEntity));
		return pagenation;
	}


}
