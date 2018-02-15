package qy.rb.controller.backend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import qy.rb.domain.PageEntity;
import qy.rb.service.PartBaseInfoService;
import qy.rb.util.Pagenation;

import javax.annotation.Resource;

/**
 * @author hjy
 * @create 2018/02/15
 **/


@Controller
@RequestMapping("/manage/part_base_info/")
public class PartBaseInfoController {

	@Resource
	PartBaseInfoService partBaseInfoService;

	@RequestMapping(value = "/list.do",method = RequestMethod.GET)
	public String partBaseInfoList(ModelMap modelMap, @RequestParam(value = "pageNum", defaultValue = "1")int pageNum){
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(pageNum);
		Pagenation pagenation = partBaseInfoService.selectPartBaseInfoList(pageEntity);
		modelMap.addAttribute("pagenation", pagenation);
		pagenation.setQueryUrl("/manage/part_base_info/list.do?");
		return "back_part_base_info";
	}
}
