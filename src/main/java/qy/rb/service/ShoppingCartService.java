package qy.rb.service;

import qy.rb.common.ServerResponse;
import qy.rb.domain.ShoppingCart;

import java.util.List;

/**
 * @author hjy
 * @create 2018/03/11
 **/
public interface ShoppingCartService {


	ServerResponse insertShoppingCart(String rbBaseInfoID, int count, String customerID);

	boolean deleteShoppingCart(String rbBaseInfoID, String customerID);

	List<ShoppingCart> showShoppingCartByCustomerID(String customerID);



}
