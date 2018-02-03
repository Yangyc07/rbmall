package qy.rb.service;

import qy.rb.common.ServerResponse;
import qy.rb.domain.Customer;
import qy.rb.domain.Employee;

/**
 * @author hjy
 * @create 2018/02/01
 **/
public interface EmployeeService {

	/**
	 * 登录
	 * @param loginName
	 * @param password
	 * @return
	 */
	ServerResponse<Employee> login(String loginName, String password);

	/**
	 * 注册
	 * @param employee
	 * @return
	 */
	ServerResponse<String> register(Employee employee);



}
