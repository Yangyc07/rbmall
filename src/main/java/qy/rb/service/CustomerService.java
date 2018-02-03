package qy.rb.service;

import java.util.List;
import qy.rb.common.ServerResponse;
import qy.rb.domain.Customer;
import qy.rb.domain.PageEntity;
import qy.rb.util.Pagenation;

/**
 * @author hjy
 * @create 2018/01/25
 *
 */
public interface CustomerService {

	/**
	 * 登录
	 *
	 * @param loginName
	 * @param password
	 * @return
	 */
	ServerResponse<Customer> login(String loginName, String password);

	/**
	 * 注册
	 *
	 * @param customer
	 * @return
	 */
	ServerResponse<String> register(Customer customer);

	/**
	 * 找到找回密码问题
	 *
	 * @param loginName
	 * @return
	 */
	ServerResponse selectQuestion(String loginName);

	/**
	 * 检查找回密码答案是否正确 guava缓存来做token，利用
	 * 缓存的有效期来搞定token的有效期
	 *
	 * @param loginName
	 * @param question
	 * @param answer
	 * @return
	 */
	ServerResponse<String> checkAnswer(String loginName, String question, String answer);

	/**
	 *重置密码  forgetToken防止没有验证答案的接口直接修改密码了
	 * @param username
	 * @param passwordNew
	 * @param forgetToken
	 * @return
	 */
	ServerResponse<String> forgetResetPassword(String username, String passwordNew, String forgetToken);


	Pagenation selectCustomerList(PageEntity pageEntity);
}
