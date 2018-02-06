package qy.rb.controller.portal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import qy.rb.common.Const;
import qy.rb.common.ServerResponse;
import qy.rb.dao.CustomerDao;
import qy.rb.domain.Customer;
import qy.rb.service.CustomerService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller //扫描
@RequestMapping("/customer/")
public class CustomerController {

    @Resource
    private CustomerService customerService;

    /**
     * 用户登录
     * @param loginName
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Customer> login(String loginName, String password,
                                          HttpSession session) {
        ServerResponse<Customer> response = customerService.login(loginName, password);
        if (response.isSuccess()) {
            session.setAttribute(Const.CURRENT_CUSTOMER,response.getData());
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
        session.removeAttribute(Const.CURRENT_CUSTOMER);
        return ServerResponse.createBySuccess();
    }

    /**
     * 注册
     * @param customerName
     * @param customerLoginName
     * @param customerPassword
     * @param customerPhone
     * @param customerPwdQuestion
     * @param customerPwdAnswer
     * @return
     */
    @RequestMapping(value = "register.do")
    @ResponseBody
    public ServerResponse<String> register(
            String customerName,String customerLoginName
            ,String customerPassword,String customerPhone
            ,String customerPwdQuestion,String customerPwdAnswer){
        Customer customer = new Customer();
        customer.setCustomerName(customerName);
        customer.setCustomerLoginName(customerLoginName);
        customer.setCustomerPassword(customerPassword);
        customer.setCustomerPhone(customerPhone);
        customer.setCustomerPwdQuestion(customerPwdQuestion);
        customer.setCustomerPwdAnswer(customerPwdAnswer);

        return customerService.register(customer);
    }

    /**
     * 得到找回密码问题
     * @param loginName
     * @return
     */
    @RequestMapping(value = "forget_get_question.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> forgetGetQuestion(String loginName){
        return customerService.selectQuestion(loginName);
    }

    /**
     * 检查找回问题答案是否正确
     * @param username
     * @param question
     * @param answer
     * @return
     */
    @RequestMapping(value = "forget_check_answer.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> forgetCheckAnswer(String username,String question,String answer){
        return customerService.checkAnswer(username,question,answer);
    }


    @RequestMapping(value = "forget_reset_password.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> forgetRestPassword(String username,String passwordNew,String forgetToken){
        return customerService.forgetResetPassword(username,passwordNew,forgetToken);
    }


}
