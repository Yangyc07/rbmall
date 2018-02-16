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
import qy.rb.domain.AutoStyling;
import qy.rb.domain.Employee;
import qy.rb.domain.PageEntity;
import qy.rb.domain.PartCategory;
import qy.rb.service.AutoStylingService;
import qy.rb.util.Pagenation;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author hjy
 * @create 2018/02/10
 **/
@Controller
@RequestMapping("/manage/auto_styling/")
public class AutoStylingManageController {

	@Resource
	AutoStylingService autoStylingService;

	@RequestMapping(value = "/list.do",method = RequestMethod.GET)
	public String AutoStylingList(ModelMap modelMap, @RequestParam(value = "pageNum", defaultValue = "1")int pageNum) {
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(pageNum);
		Pagenation pagenation = autoStylingService.selectAutoStylingList(pageEntity);
		modelMap.addAttribute("pagenation", pagenation);
		pagenation.setQueryUrl("/manage/auto_styling/list.do?");
		return "back_auto_styling";
	}

	@RequestMapping("add_auto_styling.do")
	@ResponseBody
	public ServerResponse addAutoStyling(
			HttpSession session,
			String autoStylingName,
			String autoStylingBrand ,
			String autoStylingRemark) {
		Employee employee = (Employee) session.getAttribute(Const.CURRENT_EMPLOYEE);
		if (employee == null) {
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录");
		}
		//校验一下是否是普通员工
		if (Const.EmployeeRole.EMPLOYEEROLE_ORDINARY_CUSTOMER.equals(employee.getEmployeeType())) {
			//是普通员工
			//增加车型表的逻辑
			AutoStyling autoStyling = new AutoStyling(autoStylingName,autoStylingBrand,autoStylingRemark);
			return autoStylingService.insertAutoStyling(autoStyling);
		} else {
			return ServerResponse.createByErrorMessage("无权限操作,需要普通员工权限");
		}
	}


}
