package qy.rb.service;

import qy.rb.domain.PageEntity;
import qy.rb.util.Pagenation;

/**
 * @author hjy
 * @create 2018/02/16
 **/
public interface ProducerService {

	Pagenation selectProducerList(PageEntity pageEntity);


}
