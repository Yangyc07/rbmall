package qy.rb.service;

import qy.rb.common.ServerResponse;
import qy.rb.domain.PageEntity;
import qy.rb.domain.RBPartBaseInfo;
import qy.rb.util.Pagenation;

/**
 * @author hjy
 * @create 2018/02/18
 **/
public interface RBPartBaseInfoService {

	Pagenation selectRBPartBaseInfoList(PageEntity pageEntity);

	ServerResponse insertRBPartBaseInfo(RBPartBaseInfo rbPartBaseInfo);


}
