package qy.rb.controller.portal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import qy.rb.common.Const;
import qy.rb.common.ResponseCode;
import qy.rb.common.ServerResponse;
import qy.rb.domain.Customer;
import qy.rb.domain.ShoppingCart;
import qy.rb.service.ShoppingCartService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author hjy
 * @create 2018/03/11
 **/
@Controller
@RequestMapping("/customer/shopping_cart")
public class ShoppingCartController {

	@Resource
	private ShoppingCartService shoppingCartService;

	@RequestMapping("insert.do")
	@ResponseBody
	public ServerResponse insertShoppingCart(HttpSession session,
											 String rbBasePartID,int count) {
		Customer customer = (Customer)session.getAttribute(Const.CURRENT_CUSTOMER);
		if (customer == null) {
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录");
		}
		//判断是否购物车中已经存在此商品
		if(shoppingCartService.checkShoppingCart(rbBasePartID,customer.getCustomerID())) {
			return ServerResponse.createByErrorMessage("此商品已在您的购物车中存在！");
		}

		return shoppingCartService.insertShoppingCart(rbBasePartID,count,customer.getCustomerID());
	}


	@RequestMapping("show.do")
	public String getShoppingCartList(ModelMap modelMap, HttpSession session) {
		Customer customer = (Customer) session.getAttribute(Const.CURRENT_CUSTOMER);
		List<ShoppingCart> shoppingCartList = shoppingCartService.showShoppingCartByCustomerID(customer.getCustomerID());

		modelMap.addAttribute("shoppingCartList", shoppingCartList);

		return "portal_shopping_cart";
	}

}
