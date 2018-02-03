
package qy.rb.controller.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import qy.rb.common.Const;
import qy.rb.common.ServerResponse;
import qy.rb.domain.Employee;
import qy.rb.service.EmployeeService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
@Controller
@RequestMapping("/manage/employee/")
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    /**
     * 用户登录
     * @param loginName
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Employee> login(String loginName, String password,
                                          HttpSession session) {
        ServerResponse<Employee> response = employeeService.login(loginName, password);
        if (response.isSuccess()) {
            session.setAttribute(Const.CURRENT_EMPLOYEE,response.getData());
        }
        return response;
    }

    /**
     * 注销
     * @param session
     * @return
     */
    @RequestMapping(value = "logout.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> logout(HttpSession  session) {
        session.removeAttribute(Const.CURRENT_EMPLOYEE);
        return ServerResponse.createBySuccess();
    }

    /**
     * 注册
     * @param employeeID
     * @param employeeName
     * @param employeeType
     * @param employeeLoginName
     * @param employeePassword
     * @param employeeRemark
     * @return
     */
    @RequestMapping(value = "register.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> register(
            String employeeID,String employeeName
            ,String employeeType,String employeeLoginName
            ,String employeePassword,String employeeRemark){
        Employee employee = new Employee(employeeID,employeeName,employeeType,employeeLoginName,employeePassword,employeeRemark);
        return employeeService.register(employee);
    }
}
