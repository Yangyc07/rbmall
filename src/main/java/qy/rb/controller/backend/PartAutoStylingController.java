package qy.rb.controller.backend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import qy.rb.common.Const;
import qy.rb.common.ResponseCode;
import qy.rb.common.ServerResponse;
import qy.rb.domain.Employee;
import qy.rb.domain.PageEntity;
import qy.rb.domain.PartAutoStyling;
import qy.rb.domain.PartCategory;
import qy.rb.service.PartAutoStylingService;
import qy.rb.util.Pagenation;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author hjy
 * @create 2018/02/15
 **/

@Controller
@RequestMapping("/manage/part_auto_styling/")
public class PartAutoStylingController {

	@Resource
	PartAutoStylingService partAutoStylingService;


	@RequestMapping(value = "/list.do",method = RequestMethod.GET)
	public String PartAutoStylingList(ModelMap modelMap, @RequestParam(value = "pageNum", defaultValue = "1")int pageNum) {
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(pageNum);
		Pagenation pagenation = partAutoStylingService.selectPartAutoStylingList(pageEntity);
		modelMap.addAttribute("pagenation", pagenation);
		pagenation.setQueryUrl("/manage/part_auto_styling/list.do?");
		return "back_part_auto_styling";
	}

	@RequestMapping("add_part_category.do")
	@ResponseBody
	public ServerResponse addPartAutoStyling(
			HttpSession session,
			String partModel,
			String autoStylingName,
			String partAutoStylingRemark){
		Employee employee = (Employee) session.getAttribute(Const.CURRENT_EMPLOYEE);
		if (employee == null) {
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录");
		}
		//校验一下是否是普通员工
		if (Const.EmployeeRole.EMPLOYEEROLE_ORDINARY_CUSTOMER.equals(employee.getEmployeeType())) {
			//是普通员工
			//增加零件-车型联系的逻辑
			PartAutoStyling partAutoStyling = new PartAutoStyling(partModel,autoStylingName,partAutoStylingRemark);
			return partAutoStylingService.insertPartAutoStyling(partAutoStyling);
		} else {
			return ServerResponse.createByErrorMessage("无权限操作,需要普通员工权限");
		}
	}
}
