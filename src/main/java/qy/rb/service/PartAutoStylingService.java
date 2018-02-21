package qy.rb.service;

import qy.rb.common.ServerResponse;
import qy.rb.domain.AutoStyling;
import qy.rb.domain.PageEntity;
import qy.rb.domain.PartAutoStyling;
import qy.rb.util.Pagenation;

/**
 * @author hjy
 * @create 2018/02/15
 **/
public interface PartAutoStylingService {

	Pagenation selectPartAutoStylingList(PageEntity pageEntity);


	ServerResponse insertPartAutoStyling(PartAutoStyling partAutoStyling);


	ServerResponse updatePartAutoStyling(PartAutoStyling partAutoStyling);

}
