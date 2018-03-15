package qy.rb.dao;

import qy.rb.common.ServerResponse;
import qy.rb.domain.ShoppingCart;

import java.util.List;

/**
 * @author hjy
 * @create 2018/03/11
 **/
public interface ShoppingCartDao {

	/**
	 * 添加商品进购物车
	 * @param rbBaseInfoID 睿邦零件号
	 * @param count	 数量
	 * @param customerID 用户ID
	 * @return
	 */
	ServerResponse insert(String rbBaseInfoID, int count, String customerID);

	/**
	 * 从用户购物车中删除商品
	 * @param rbBaseInfoID
	 * @param customerID
	 * @return
	 */
	boolean delete(String rbBaseInfoID,String customerID);


	/**
	 * 显示购物车列表
	 * @param customerID 用户ID
	 * @return
	 */
	List<ShoppingCart> showShoppingCartList(String customerID);


	/**
	 * 检查这个物品是否在购物车中是否存在
	 * @param rbBasePartID 睿邦零件ID
	 * @param customerID  用户ID
	 * @return
	 */
	boolean check(String rbBasePartID, String customerID);
}
