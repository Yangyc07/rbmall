package qy.rb.dao;

import org.springframework.stereotype.Repository;
import qy.rb.domain.Customer;

import java.util.List;
import qy.rb.domain.PageEntity;


public interface CustomerDao {
    /**
     * 添加顾客
     * @param customer
     * @return
     */
    public boolean insertCustomer(Customer customer);

    /**
     * 删除所有顾客
     * @return
     */
    public boolean delelteAllCustomers();

    /**
     * 修改顾客密码
     * @param customerLoginName
     * @param customerPassword
     * @return
     */
    public boolean updateCustomerPassword(String customerLoginName,String customerPassword);

    /**
     *  通过ID或者名称进行搜索
     * @param customerId
     * @return
     */
    public List<Customer> selectCustomerListByIdOrName(String customerId,String customerName,PageEntity pageEntity);

    /**
     * 查询客户清单
     * @return
     */
    public List<Customer> selectCustomerList(PageEntity pageEntity);


    /**
     * 检查是否有此用户名
     * @param customerLoginName
     * @return
     */
    boolean checkLoginName(String customerLoginName);

    /**
     * 通过登录名和密码查找顾客
     * @param customerLoginName
     * @param customerPassword
     * @return
     */
    Customer selecLogin(String customerLoginName, String customerPassword);

    /**
     * 通过用户名得到 找回密码问题
     * @param customerLoginName
     * @return
     */
    String selectQuestionByLoginName(String customerLoginName);

    /**
     * 检查此用户名的问题和答案是否匹配
     * @param customerLoginName
     * @param customerPwdQuestion
     * @param customerPwdAnswer
     * @return
     */
    boolean checkAnswer(String customerLoginName,String customerPwdQuestion,String customerPwdAnswer);
    /**
     * 获得数据总条数
     * @param pageEntity
     * @return
     */
    int listCustomerDataRawCount(PageEntity pageEntity);


}