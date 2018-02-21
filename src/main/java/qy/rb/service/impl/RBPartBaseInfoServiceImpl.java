package qy.rb.service.impl;

import org.springframework.stereotype.Service;
import qy.rb.common.ServerResponse;
import qy.rb.dao.RBPartBaseInfoDao;
import qy.rb.domain.AutoStyling;
import qy.rb.domain.PageEntity;
import qy.rb.domain.RBPartBaseInfo;
import qy.rb.service.RBPartBaseInfoService;
import qy.rb.util.Pagenation;

import javax.annotation.Resource;

/**
 * @author hjy
 * @create 2018/02/18
 **/
@Service("RBPartBaseInfoService")
public class RBPartBaseInfoServiceImpl implements RBPartBaseInfoService {


	@Resource
	RBPartBaseInfoDao rbPartBaseInfoDao;


	@Override
	public Pagenation selectRBPartBaseInfoList(PageEntity pageEntity) {
		//算出所需数据的总条数
		int cout = rbPartBaseInfoDao.listRBPartBaseInfoDataRawCount(pageEntity);
		//通过（当前页、每页显示条数、总条数） 初始化分页信息
		Pagenation pagenation = new Pagenation(pageEntity.getPageSize(), pageEntity.getPageNum(), cout);
		//通过上步骤算出要查询的 开始条数，边set 到分页入参实体类中。
		pageEntity.setStartRow(pagenation.getStartRow());
		//在查询 list 的时候，让传入的startRow 和 pageSize 作为limit 条件，添加至 sql。
		pagenation.setList(rbPartBaseInfoDao.selectRBPartBaseInfoList(pageEntity));
		return pagenation;
	}

	@Override
	public ServerResponse insertRBPartBaseInfo(RBPartBaseInfo rbPartBaseInfo) {

		if (rbPartBaseInfo != null) {
			boolean flag = rbPartBaseInfoDao.insertRBPartBaseInfo(rbPartBaseInfo);
			if (flag) {
				return ServerResponse.createBySuccessMessage("添加成功");
			} else {
				return ServerResponse.createByErrorMessage("添加失败");
			}
		}
		return ServerResponse.createByErrorMessage("添加参数不正确");
	}


}
