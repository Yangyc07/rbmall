package qy.rb.controller.backend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import qy.rb.domain.PageEntity;
import qy.rb.service.RBPartBaseInfoService;
import qy.rb.util.Pagenation;

import javax.annotation.Resource;

/**
 * @author hjy
 * @create 2018/02/18
 **/

@Controller
@RequestMapping("/manage/rb_part_base_info/")
public class RBPartBaseInfoController {


	@Resource
	RBPartBaseInfoService rbPartBaseInfoService;

	@RequestMapping(value = "/list.do",method = RequestMethod.GET)
	public String RBPartBaseInfoList(ModelMap modelMap, @RequestParam(value = "pageNum", defaultValue = "1")int pageNum) {
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(pageNum);
		Pagenation pagenation = rbPartBaseInfoService.selectRBPartBaseInfoList(pageEntity);
		modelMap.addAttribute("pagenation", pagenation);
		pagenation.setQueryUrl("/manage/rb_part_base_info/list.do?");
		return "back_rb_part_base_info";
	}


}
