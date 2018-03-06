package qy.rb.service;

import qy.rb.domain.PageEntity;
import qy.rb.util.Pagenation;

/**
 * @author hjy
 * @create 2018/03/06
 **/
public interface BaseInfoService {

	Pagenation selcetPortalBaseInfoByPartNameOrAutoStylingName(String partName, String autoStylingName, PageEntity pageEntity);



}
