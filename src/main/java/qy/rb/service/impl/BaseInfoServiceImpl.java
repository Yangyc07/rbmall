package qy.rb.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import qy.rb.dao.BaseInfoVoDao;
import qy.rb.domain.PageEntity;
import qy.rb.service.BaseInfoService;
import qy.rb.util.Pagenation;

import javax.annotation.Resource;

/**
 * @author hjy
 * @create 2018/03/06
 **/
@Service("BaseInfoService")
public class BaseInfoServiceImpl implements BaseInfoService {

	@Resource
	BaseInfoVoDao baseInfoVoDao;


	@Override
	public Pagenation selcetPortalBaseInfoByPartNameOrAutoStylingName(String partName, String autoStylingName, PageEntity pageEntity) {
		if (StringUtils.isNoneBlank(partName)) {
			//customerId为空不执行
			partName = new StringBuilder().append("%").append(partName).append("%").toString();
		} else {
			autoStylingName = null;
		}
		if (StringUtils.isNoneBlank(autoStylingName)) {
			//autoStylingName
			autoStylingName = new StringBuilder().append("%").append(autoStylingName).append("%").toString();
		} else {
			autoStylingName = null;
		}
		//算出所需数据的总条数
		int cout = baseInfoVoDao.getListCount(partName, autoStylingName, pageEntity);

		//通过（当前页、每页显示条数、总条数） 初始化分页信息
		Pagenation pagenation = new Pagenation(pageEntity.getPageSize(), pageEntity.getPageNum(), cout);
		//通过上步骤算出要查询的 开始条数，边set 到分页入参实体类中。
		pageEntity.setStartRow(pagenation.getStartRow());
		//在查询 list 的时候，让传入的startRow 和 pageSize 作为limit 条件，添加至 sql。
		pagenation.setList(baseInfoVoDao.getList(partName, autoStylingName, pageEntity));
		return pagenation;
	}
}
