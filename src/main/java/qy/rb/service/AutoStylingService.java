package qy.rb.service;

import qy.rb.common.ServerResponse;
import qy.rb.domain.AutoStyling;
import qy.rb.domain.PageEntity;
import qy.rb.util.Pagenation;

/**
 * @author hjy
 * @create 2018/02/10
 **/
public interface AutoStylingService {
	/**
	 * 查找所有车型
	 * @param pageEntity
	 * @return
	 */
	Pagenation selectAutoStylingList(PageEntity pageEntity);

	/**
	 * 添加车型
	 * @param autoStyling
	 * @return
	 */
	ServerResponse insertAutoStyling(AutoStyling autoStyling);

}
