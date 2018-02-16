package qy.rb.controller.backend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import qy.rb.domain.PageEntity;
import qy.rb.service.PartAutoStylingService;
import qy.rb.service.ProducerService;
import qy.rb.util.Pagenation;

import javax.annotation.Resource;

/**
 * @author hjy
 * @create 2018/02/16
 **/

@Controller
@RequestMapping("/manage/producer/")
public class ProducerController {

	@Resource
	ProducerService producerService;

	@RequestMapping(value = "/list.do",method = RequestMethod.GET)
	public String customerAddressList(ModelMap modelMap, @RequestParam(value = "pageNum", defaultValue = "1")int pageNum) {
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(pageNum);
		Pagenation pagenation = producerService.selectProducerList(pageEntity);
		modelMap.addAttribute("pagenation", pagenation);
		pagenation.setQueryUrl("/manage/producer/list.do?");
		return "back_producer";
	}

}
