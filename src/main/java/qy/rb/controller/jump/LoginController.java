package qy.rb.controller.jump;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author hjy
 * @create 2018/01/14
 **/
@Controller
public class LoginController {

    //返回顾客登录界面
    @RequestMapping(value = "/to_test",method = RequestMethod.GET)
    public String toTest() {
        return "test";
    }



    //返回顾客登录界面
    @RequestMapping(value = "/customer/to_login",method = RequestMethod.GET)
    public String toLogin() {
        return "login";
    }

    //返回注册界面
    @RequestMapping(value = "/customer/to_register",method = RequestMethod.GET)
    public String toRegister() {
        return "register";
    }

    //返回找回密码界面
    @RequestMapping(value = "/customer/to_forget_answer",method = RequestMethod.GET)
    public String toForgetAnswer() {
        return "forget_answer";
    }

    //返回前台界面
    @RequestMapping(value = "/customer/to_portal_index",method = RequestMethod.GET)
    public String toPortalIndex() {
        return "portal_index";
    }


    //返回后台界面
    @RequestMapping(value = "/employee/to_back_index",method = RequestMethod.GET)
    public String toBackEndIndex() {
        return "back_index";
    }

    //返回雇员登录界面
    @RequestMapping(value = "/employee/to_login",method = RequestMethod.GET)
    public String EmployeetoLogin() {
        return "employee_login";
    }



}
