package qy.rb.controller.portal;

import org.springframework.stereotype.Controller;
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
		return shoppingCartService.insertShoppingCart(rbBasePartID,count,customer.getCustomerID());
	}


	@RequestMapping("show.do")
	public List<ShoppingCart> getShoppingCartList(HttpSession session) {
		Customer customer = (Customer) session.getAttribute(Const.CURRENT_CUSTOMER);
		return  shoppingCartService.showShoppingCartByCustomerID(customer.getCustomerID());
	}
}
