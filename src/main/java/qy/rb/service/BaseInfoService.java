package qy.rb.service;

import qy.rb.domain.PageEntity;
import qy.rb.util.Pagenation;
import qy.rb.vo.BaseInfoDetail;

/**
 * @author hjy
 * @create 2018/03/06
 **/
public interface BaseInfoService {

	Pagenation selectPortalBaseInfoByPartNameOrAutoStylingName(String partName, String autoStylingName, PageEntity pageEntity);


	BaseInfoDetail selectBaseInfoDetailByrbPartID(String rbPartID);



}
