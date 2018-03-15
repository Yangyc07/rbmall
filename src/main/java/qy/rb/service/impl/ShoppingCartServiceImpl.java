package qy.rb.service.impl;

import org.springframework.stereotype.Service;
import qy.rb.common.ServerResponse;
import qy.rb.dao.ShoppingCartDao;
import qy.rb.domain.ShoppingCart;
import qy.rb.service.ShoppingCartService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hjy
 * @create 2018/03/11
 **/
@Service("ShoppingCartService")
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Resource
	ShoppingCartDao shoppingCartDao;


	@Override
	public ServerResponse insertShoppingCart(String rbBaseInfoID, int count, String customerID) {
		return shoppingCartDao.insert(rbBaseInfoID, count, customerID);
	}

	@Override
	public boolean deleteShoppingCart(String rbBaseInfoID, String customerID) {

		return shoppingCartDao.delete(rbBaseInfoID, customerID);
	}

	@Override
	public List<ShoppingCart> showShoppingCartByCustomerID(String customerID) {
		return null;
	}

	@Override
	public boolean checkShoppingCart(String rbBasePartID, String customerID) {
		return shoppingCartDao.check(rbBasePartID,customerID);
	}


}
