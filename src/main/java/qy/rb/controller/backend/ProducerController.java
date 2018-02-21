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
import qy.rb.domain.Producer;
import qy.rb.service.PartAutoStylingService;
import qy.rb.service.ProducerService;
import qy.rb.util.Pagenation;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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
	public String producerList(ModelMap modelMap, @RequestParam(value = "pageNum", defaultValue = "1")int pageNum) {
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(pageNum);
		Pagenation pagenation = producerService.selectProducerList(pageEntity);
		modelMap.addAttribute("pagenation", pagenation);
		pagenation.setQueryUrl("/manage/producer/list.do?");
		return "back_producer";
	}

	@RequestMapping("add_producer.do")
	@ResponseBody
	public ServerResponse addProducer(
			HttpSession session,
			String producerID,
			String producerName ,
			String producerRemark) {
		Employee employee = (Employee) session.getAttribute(Const.CURRENT_EMPLOYEE);
		if (employee == null) {
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录");
		}
		//校验一下是否是普通员工
		if (Const.EmployeeRole.EMPLOYEEROLE_ORDINARY_CUSTOMER.equals(employee.getEmployeeType())) {
			//是普通员工
			//增加生产商表的逻辑
			Producer producer = new Producer(producerID,producerName,producerRemark);
			return producerService.insertProducer(producer);
		} else {
			return ServerResponse.createByErrorMessage("无权限操作,需要普通员工权限");
		}
	}


	@RequestMapping("update_producer.do")
	@ResponseBody
	public ServerResponse updateProducer(
			HttpSession session,
			String producerID,
			String producerName ,
			String producerRemark) {
		Employee employee = (Employee) session.getAttribute(Const.CURRENT_EMPLOYEE);
		if (employee == null) {
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录");
		}
		//校验一下是否是普通员工
		if (Const.EmployeeRole.EMPLOYEEROLE_ORDINARY_CUSTOMER.equals(employee.getEmployeeType())) {
			//是普通员工
			//增加生产商表的逻辑
			Producer producer = new Producer(producerID,producerName,producerRemark);
			return producerService.updateProducer(producer);
		} else {
			return ServerResponse.createByErrorMessage("无权限操作,需要普通员工权限");
		}
	}




}
