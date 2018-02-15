package qy.rb.controller.backend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import qy.rb.domain.AutoStyling;
import qy.rb.domain.PageEntity;
import qy.rb.service.AutoStylingService;
import qy.rb.util.Pagenation;

import javax.annotation.Resource;

/**
 * @author hjy
 * @create 2018/02/10
 **/
@Controller
@RequestMapping("/manage/auto_styling/")
public class AutoStylingController {

	@Resource
	AutoStylingService autoStylingService;

	@RequestMapping(value = "/list.do",method = RequestMethod.GET)
	public String customerAddressList(ModelMap modelMap, @RequestParam(value = "pageNum", defaultValue = "1")int pageNum) {
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(pageNum);
		Pagenation pagenation = autoStylingService.selectAutoStylingList(pageEntity);
		modelMap.addAttribute("pagenation", pagenation);
		pagenation.setQueryUrl("/manage/auto_styling/list.do?");
		return "back_auto_styling";
	}

}
