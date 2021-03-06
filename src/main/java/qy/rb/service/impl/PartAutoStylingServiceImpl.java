package qy.rb.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import qy.rb.common.ServerResponse;
import qy.rb.dao.PartAutoStylingDao;
import qy.rb.domain.PageEntity;
import qy.rb.domain.PartAutoStyling;
import qy.rb.service.PartAutoStylingService;
import qy.rb.util.Pagenation;

import javax.annotation.Resource;

/**
 * @author hjy
 * @create 2018/02/15
 **/
@Service("PartAutoStylingService")
public class PartAutoStylingServiceImpl implements PartAutoStylingService {

	@Resource
	PartAutoStylingDao partAutoStylingDao;



	@Override
	public Pagenation selectPartAutoStylingList(PageEntity pageEntity) {
		//算出所需数据的总条数
		int cout = partAutoStylingDao.listPartAutoStylingDataRawCount(pageEntity);
		//通过（当前页、每页显示条数、总条数） 初始化分页信息
		Pagenation pagenation = new Pagenation(pageEntity.getPageSize(), pageEntity.getPageNum(), cout);
		//通过上步骤算出要查询的 开始条数，边set 到分页入参实体类中。
		pageEntity.setStartRow(pagenation.getStartRow());
		//在查询 list 的时候，让传入的startRow 和 pageSize 作为limit 条件，添加至 sql。
		pagenation.setList(partAutoStylingDao.selectPartAutoStylingList(pageEntity));
		return pagenation;
	}

	@Override
	public ServerResponse insertPartAutoStyling(PartAutoStyling partAutoStyling) {
		boolean flag = partAutoStylingDao.insertPartAutoStyling(partAutoStyling);
		if (flag) {
			return ServerResponse.createBySuccessMessage("添加零件-车型成功");
		}
		return ServerResponse.createByErrorMessage("添加零件-车型失败");
	}

	@Override
	public ServerResponse updatePartAutoStyling(PartAutoStyling partAutoStyling) {
		if (partAutoStyling.getPartModel() == null || StringUtils.isBlank(partAutoStyling.getAutoStylingName())) {
			return ServerResponse.createByErrorMessage("更新零件-车型参数错误");
		}
		boolean flag = partAutoStylingDao.updatePartAutoStyling(partAutoStyling);
		if(flag){
			return ServerResponse.createBySuccessMessage("更新零件-车型信息成功");
		}
		return ServerResponse.createByErrorMessage("更新零件-车型信息失败");
	}


}
