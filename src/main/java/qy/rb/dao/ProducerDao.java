package qy.rb.dao;

import qy.rb.domain.AutoStyling;
import qy.rb.domain.PageEntity;
import qy.rb.domain.Producer;

import java.util.List;

/**
 * @author hjy
 * @create 2018/02/16
 **/
public interface ProducerDao {

	/**
	 * 添加生产商
	 * @param producer
	 * @return
	 */
	boolean insertProducer(Producer producer);

	/**
	 * 删除生产商
	 * @param producerName
	 * @return
	 */
	boolean deleteByProducerName(String producerName);

	/**
	 * 更新生产商
	 * @param producer
	 * @return
	 */
	boolean updateProducer(Producer producer);


	/**
	 * 返回生成商信息条数
	 * @param pageEntity
	 * @return
	 */
	int listProducerDataRawCount(PageEntity pageEntity);

	/**
	 * 查询生产商信息清单
	 * @param pageEntity
	 * @return
	 */
	public List<Producer> selectProducerList(PageEntity pageEntity);


	/**
	 * 通过生产商名称进行搜索
	 * @param producerName
	 * @param pageEntity
	 * @return
	 */
	public List<Producer> selectProducerListByName(String producerName,PageEntity pageEntity);





}
