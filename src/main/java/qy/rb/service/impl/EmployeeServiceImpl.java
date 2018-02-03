package qy.rb.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import qy.rb.common.ServerResponse;
import qy.rb.dao.EmployeeDao;
import qy.rb.domain.Employee;
import qy.rb.service.EmployeeService;
import qy.rb.util.MD5Util;

import javax.annotation.Resource;

/**
 * @author hjy
 * @create 2018/02/01
 **/
@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {
	@Resource
	private EmployeeDao employeeDao;

	@Override
	public ServerResponse<Employee> login(String loginName, String password) {
		String md5Password = MD5Util.MD5EncodeUtf8(password);
		Employee employee = employeeDao.selecLogin(loginName,md5Password);
		if (employee == null) {
			return ServerResponse.createByErrorMessage("密码错误");
		}
		employee.setEmployeePassword(StringUtils.EMPTY);
		return ServerResponse.createBySuccess("登录成功",employee);
	}

	@Override
	public ServerResponse<String> register(Employee employee) {
		boolean flag = employeeDao.checkLoginName(employee.getEmployeeLoginName());
		if (flag) {
			return ServerResponse.createByErrorMessage("用户名已存在");
		}
		//加密
		employee.setEmployeePassword(MD5Util.MD5EncodeUtf8(employee.getEmployeePassword()));

		employee.setEmployeeID("rb_" + employee.getEmployeeName());
		flag = employeeDao.insertEmployee(employee);
		if(flag) {
			return ServerResponse.createBySuccessMessage("注册成功");
		}
		return ServerResponse.createByErrorMessage("注册失败");
	}
}
