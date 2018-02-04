package qy.rb.controller.backend;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import qy.rb.domain.Customer;
import qy.rb.domain.PageEntity;
import qy.rb.service.CustomerService;
import qy.rb.util.Pagenation;

/**
 * @author hjy
 * @create 2018/02/03
 **/
@Controller
@RequestMapping("/manage/customer/")
public class CustomerManageController {

	@Resource
	CustomerService customerService;

	@RequestMapping(value = "/list.do",method = RequestMethod.GET)
	public String List(ModelMap modelMap,@RequestParam(value = "pageNum", defaultValue = "1")int pageNum) {
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(pageNum);
		Pagenation pagenation = customerService.selectCustomerList(pageEntity);
		modelMap.addAttribute("pagenation", pagenation);
		pagenation.setQueryUrl("/manage/customer/list.do?");
		return "back_customer";
	}

	@RequestMapping(value = "/search.do",method = RequestMethod.POST)
	public String searchList(ModelMap modelMap,@RequestParam(value = "pageNum", defaultValue = "1")int pageNum
							,String customerId, String customerName) {
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(pageNum);
		Pagenation pagenation = customerService.selectCustomerListByIdOrName(customerId,customerName,pageEntity);
		pagenation.setQueryUrl("/manage/customer/search.do?");
		modelMap.addAttribute("pagenation", pagenation);
		return "back_customer";
	}



}
