package qy.rb.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import qy.rb.common.ServerResponse;
import qy.rb.dao.ProducerDao;
import qy.rb.domain.PageEntity;
import qy.rb.domain.Producer;
import qy.rb.service.ProducerService;
import qy.rb.util.Pagenation;

import javax.annotation.Resource;

/**
 * @author hjy
 * @create 2018/02/16
 **/

@Service("ProducerService")
public class ProducerServiceImpl implements ProducerService {

	@Resource
	ProducerDao producerDao;


	@Override
	public Pagenation selectProducerList(PageEntity pageEntity) {
		//算出所需数据的总条数
		int cout = producerDao.listProducerDataRawCount(pageEntity);
		//通过（当前页、每页显示条数、总条数） 初始化分页信息
		Pagenation pagenation = new Pagenation(pageEntity.getPageSize(), pageEntity.getPageNum(), cout);
		//通过上步骤算出要查询的 开始条数，边set 到分页入参实体类中。
		pageEntity.setStartRow(pagenation.getStartRow());
		//在查询 list 的时候，让传入的startRow 和 pageSize 作为limit 条件，添加至 sql。
		pagenation.setList(producerDao.selectProducerList(pageEntity));
		return pagenation;
	}

	@Override
	public ServerResponse insertProducer(Producer producer) {
		boolean flag = producerDao.insertProducer(producer);
		if (flag) {
			return ServerResponse.createBySuccessMessage("添加生产商成功");
		}
		return ServerResponse.createByErrorMessage("添加生产商失败");
	}

	@Override
	public ServerResponse updateProducer(Producer producer) {
		if (producer.getProducerID() == null || StringUtils.isBlank(producer.getProducerName())) {
			return ServerResponse.createByErrorMessage("更新生产商参数错误");
		}
		boolean flag = producerDao.updateProducer(producer);
		if(flag){
			return ServerResponse.createBySuccessMessage("更新生产商信息成功");
		}
		return ServerResponse.createByErrorMessage("更新生产商信息失败");
	}
}
