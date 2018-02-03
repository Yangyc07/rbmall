/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package qy.rb.controller.backend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import qy.rb.domain.PageEntity;
import qy.rb.service.CustomerAddressService;
import qy.rb.util.Pagenation;

import javax.annotation.Resource;

/**
 *
 * @author Administrator
 */
@Controller
@RequestMapping("/manage/receiver_address/")
public class ReceiverAddressManageController {

	@Resource
    CustomerAddressService customerAddressService;
     
	@RequestMapping(value = "/list.do",method = RequestMethod.GET)
	public String customerAddressList(ModelMap modelMap,@RequestParam(value = "pageNum", defaultValue = "1")int pageNum) {
                PageEntity pageEntity = new PageEntity();
                pageEntity.setPageNum(pageNum);
		Pagenation pagenation = customerAddressService.selectCustomerAddressList(pageEntity);
                modelMap.addAttribute("pagenation", pagenation);
		return "back_receiver_address";
	}
}
