package qy.rb.dao;

import qy.rb.domain.Customer;
import qy.rb.domain.CustomerAddress;
import qy.rb.domain.PageEntity;

import java.util.List;

/**
 * @author hjy
 * @create 2018/01/22
 **/
public interface CustomerAddressDao {

	/**
	 * 添加收货地址
	 * @param customerAddress
	 * @param customerID
	 * @return
	 */
	boolean insert(CustomerAddress customerAddress,String customerID);

	/**
	 * 删除收货地址
	 * @param receivingAddressID
	 * @return
	 */
	boolean deleteByReceivingAddressID(int receivingAddressID);

	/**
	 * 返回客户地址信息条数
	 * @param pageEntity
	 * @return
	 */
	int listCustomerAddressDataRawCount(PageEntity pageEntity);


	/**
	 * 查询客户地址信息清单
	 * @param pageEntity
	 * @return
	 */
	public List<CustomerAddress> selectCustomerAddressList(PageEntity pageEntity);

	/**
	 * 通过客户ID或者收货人名称进行搜索
	 * @param customerId
	 * @param receiverName
	 * @param pageEntity
	 * @return
	 */
	public List<CustomerAddress> selectCustomerAddressListByIdOrName(String customerId,String receiverName,PageEntity pageEntity);





}
