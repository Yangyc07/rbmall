package qy.rb.service.impl;

import org.springframework.stereotype.Service;
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
}
