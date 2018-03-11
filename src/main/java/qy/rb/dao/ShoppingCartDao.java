package qy.rb.dao;

import qy.rb.common.ServerResponse;

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



	List show(String customerID);



}
