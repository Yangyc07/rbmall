package qy.rb.controller.portal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import qy.rb.domain.PageEntity;
import qy.rb.service.BaseInfoService;
import qy.rb.util.Pagenation;

import javax.annotation.Resource;

/**
 * @author hjy
 * @create 2018/03/06
 **/

@Controller
@RequestMapping("/customer/")
public class BaseInfoController {

	@Resource
	private BaseInfoService baseInfoService;




	@RequestMapping(value = "/baseInfo/list.do")
	@ResponseBody
	public String baseInfoList(ModelMap modelMap, @RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
							   String partName, String autoStylingName) {
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(pageNum);
		Pagenation pagenation = baseInfoService.selcetPortalBaseInfoByPartNameOrAutoStylingName(partName,autoStylingName,pageEntity);
		modelMap.addAttribute("pagenation", pagenation);
		pagenation.setQueryUrl("/customer/auto_styling/list.do?");
		return "portal_index";
	}





}
