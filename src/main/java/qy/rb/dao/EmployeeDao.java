package qy.rb.dao;

import qy.rb.domain.Employee;

import java.util.List;

/**
 * @author hjy
 * @create 2018/01/22
 **/
public interface EmployeeDao {


	/**
	 * 添加雇员
	 * @param employee
	 * @return
	 */
	public boolean insertEmployee(Employee employee);

	/**
	 * 删除所有雇员
	 * @return
	 */
	public boolean deleteAllEmployee();

	/**
	 * 检查是否有此用户名
	 * @param EmployeeName
	 * @return
	 */
	public boolean selectEmployeeByName(String EmployeeName);

	/**
	 * 查询雇员清单
	 * @return
	 */
	public List<Employee> selectEmployeeList();

	/**
	 * 通过登录名和密码查找雇员
	 * @param employeeLoginName
	 * @param employeePassword
	 * @return
	 */
	Employee selecLogin(String employeeLoginName, String employeePassword);


	/**
	 * 是否有该登录名
	 * @param employeeLoginName
	 * @return
	 */
	Boolean checkLoginName(String employeeLoginName);


}
