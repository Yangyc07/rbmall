package qy.rb.service;

import qy.rb.common.ServerResponse;
import qy.rb.domain.PageEntity;
import qy.rb.domain.PartCategory;
import qy.rb.domain.Producer;
import qy.rb.util.Pagenation;

/**
 * @author hjy
 * @create 2018/02/16
 **/
public interface ProducerService {

	Pagenation selectProducerList(PageEntity pageEntity);


	/**
	 * 添加生产商
	 * @param producer
	 * @return
	 */
	ServerResponse insertProducer(Producer producer);


	/**
	 * 修改生产商
	 * @param producer
	 * @return
	 */
	ServerResponse updateProducer(Producer producer);

}
