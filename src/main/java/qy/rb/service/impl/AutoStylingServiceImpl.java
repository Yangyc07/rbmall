package qy.rb.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import qy.rb.common.ServerResponse;
import qy.rb.dao.AutoStylingDao;
import qy.rb.domain.AutoStyling;
import qy.rb.domain.PageEntity;
import qy.rb.service.AutoStylingService;
import qy.rb.util.Pagenation;

import javax.annotation.Resource;

/**
 * @author hjy
 * @create 2018/02/10
 **/
@Service("AutoStylingService")
public class AutoStylingServiceImpl implements AutoStylingService {

	@Resource
	AutoStylingDao autoStylingDao;

	@Override
	public Pagenation selectAutoStylingList(PageEntity pageEntity) {
		//算出所需数据的总条数
		int cout = autoStylingDao.listAutoStylingDataRawCount(pageEntity);
		//通过（当前页、每页显示条数、总条数） 初始化分页信息
		Pagenation pagenation = new Pagenation(pageEntity.getPageSize(), pageEntity.getPageNum(), cout);
		//通过上步骤算出要查询的 开始条数，边set 到分页入参实体类中。
		pageEntity.setStartRow(pagenation.getStartRow());
		//在查询 list 的时候，让传入的startRow 和 pageSize 作为limit 条件，添加至 sql。
		pagenation.setList(autoStylingDao.selectAutoStylingList(pageEntity));
		return pagenation;
	}

	@Override
	public ServerResponse insertAutoStyling(AutoStyling autoStyling) {
		boolean flag = autoStylingDao.insertAutoStyling(autoStyling);
		if (flag) {
			return ServerResponse.createBySuccess("添加成功");
		}
		return ServerResponse.createByErrorMessage("添加失败");
	}

	@Override
	public ServerResponse updateAutoStyling(AutoStyling autoStyling) {
		boolean flag = autoStylingDao.updateAutoStyling(autoStyling);
		if (flag) {
			return ServerResponse.createBySuccessMessage("修改成功");
		}
		return ServerResponse.createByErrorMessage("修改失败");
	}

	@Override
	public Pagenation selectAutoStylingListByNameOrBrand(String autoStylingName, String autoStylingBrand, PageEntity pageEntity) {
		if (StringUtils.isNoneBlank(autoStylingName)) {
			//customerId为空不执行
			autoStylingName = new StringBuilder().append(autoStylingName).append("%").toString();
		} else {
			autoStylingName = null;
		}
		if (StringUtils.isNoneBlank(autoStylingBrand)) {
			//autoStylingBrand
			autoStylingBrand = new StringBuilder().append(autoStylingBrand).append("%").toString();
		} else {
			autoStylingBrand = null;
		}
		//算出所需数据的总条数
		int cout = autoStylingDao.listAutoStylingDataRawCount(autoStylingName,autoStylingBrand,pageEntity);

		//通过（当前页、每页显示条数、总条数） 初始化分页信息
		Pagenation pagenation = new Pagenation(pageEntity.getPageSize(), pageEntity.getPageNum(), cout);
		//通过上步骤算出要查询的 开始条数，边set 到分页入参实体类中。
		pageEntity.setStartRow(pagenation.getStartRow());
		//在查询 list 的时候，让传入的startRow 和 pageSize 作为limit 条件，添加至 sql。
		pagenation.setList(autoStylingDao.selectAutoStylingListByNameOrBrand(autoStylingName,autoStylingBrand,pageEntity));
		return pagenation;
	}

}
