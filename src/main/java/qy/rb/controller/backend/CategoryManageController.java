package qy.rb.controller.backend;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import qy.rb.common.Const;
import qy.rb.common.ResponseCode;
import qy.rb.common.ServerResponse;
import qy.rb.domain.AutoStyling;
import qy.rb.domain.Employee;
import qy.rb.domain.PageEntity;
import qy.rb.domain.PartCategory;
import qy.rb.service.PartCategoryService;
import qy.rb.util.Pagenation;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author hjy
 * @create 2018/01/13
 **/
@Controller
@RequestMapping("/manage/part_category/")
public class CategoryManageController {


    @Resource
    private PartCategoryService partCategoryService;


    /**
     * 添加分类
     * @param session
     * @param partCategoryID
     * @param partCategoryName
     * @param partCategoryRemark
     * @return
     */
    @RequestMapping("add_part_category.do")
    @ResponseBody
    public ServerResponse addCategory(
            HttpSession session,
            String partCategoryID,
            String partCategoryName,
            String partCategoryRemark) {
        Employee employee = (Employee) session.getAttribute(Const.CURRENT_EMPLOYEE);
         if (employee == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录");
        }
        //校验一下是否是普通员工
        if (Const.EmployeeRole.EMPLOYEEROLE_ORDINARY_CUSTOMER.equals(employee.getEmployeeType())) {
            //是普通员工
            //增加处理分类的逻辑
            PartCategory partCategory = new PartCategory(partCategoryID, partCategoryName, partCategoryRemark);
            return partCategoryService.insertPartCategory(partCategory);
        } else {
            return ServerResponse.createByErrorMessage("无权限操作,需要普通员工权限");
        }
    }

    /**
     * 得到分类category的信息
     * @param session
     * @param partCategoryId
     * @return
     */
    @RequestMapping("get_part_category.do")
    @ResponseBody
    public ServerResponse getChildrenParallelCategory(HttpSession session, @RequestParam(value = "categoryId", defaultValue = "0") String partCategoryId) {
        Employee employee = (Employee) session.getAttribute(Const.CURRENT_EMPLOYEE);
        if (employee == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录");
        }
        //校验一下是否是普通员工
        if (Const.EmployeeRole.EMPLOYEEROLE_ORDINARY_CUSTOMER.equals(employee.getEmployeeType())) {
            //是普通员工
            //增加处理的逻辑
            return partCategoryService.getChildrenPartCategory(partCategoryId);
        } else {
            return ServerResponse.createByErrorMessage("无权限操作,需要普通员工权限");
        }
    }

    /**
     * 得到分类category及子结点的ID
     * @param session
     * @param partCategoryId
     * @return 成功返回Integer集合
     */
    @RequestMapping("get_deep_category.do")
    @ResponseBody
    public ServerResponse getCategoryAndDeepChildrenCategory(HttpSession session, @RequestParam(value = "categoryId", defaultValue = "0") String partCategoryId) {
        Employee employee = (Employee) session.getAttribute(Const.CURRENT_EMPLOYEE);
        if (employee == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录");
        }
        //校验一下是否是普通员工
        if (Const.EmployeeRole.EMPLOYEEROLE_ORDINARY_CUSTOMER.equals(employee.getEmployeeType())) {
            //是普通员工
            //增加处理的逻辑
            return partCategoryService.getChildrenPartCategory(partCategoryId);
        } else {
            return ServerResponse.createByErrorMessage("无权限操作,需要普通员工权限");
        }
    }

    @RequestMapping(value = "/list.do",method = RequestMethod.GET)
    public String partCategoryList(ModelMap modelMap, @RequestParam(value = "pageNum", defaultValue = "1")int pageNum) {
        PageEntity pageEntity = new PageEntity();
        pageEntity.setPageNum(pageNum);
        Pagenation pagenation = partCategoryService.selectPartCategoryList(pageEntity);
        modelMap.addAttribute("pagenation", pagenation);
        pagenation.setQueryUrl("/manage/part_category/list.do?");
        return "back_part_category";
    }


    @RequestMapping(value = "update_part_category.do")
    @ResponseBody
    public ServerResponse updateCategory(
            HttpSession session,
            String partCategoryID,
            String partCategoryName,
            String partCategoryRemark) {
        System.out.println("partCategoryName" + partCategoryName);
        Employee employee = (Employee) session.getAttribute(Const.CURRENT_EMPLOYEE);
        if (employee == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录");
        }
        //校验一下是否是普通员工
        if (Const.EmployeeRole.EMPLOYEEROLE_ORDINARY_CUSTOMER.equals(employee.getEmployeeType())) {
            //是普通员工
            //修改车型表的逻辑
            PartCategory partCategory = new PartCategory(partCategoryID,partCategoryName,partCategoryRemark);
            return partCategoryService.updatePartCategory(partCategory);
        } else {
            return ServerResponse.createByErrorMessage("无权限操作,需要普通员工权限");
        }
    }



    @RequestMapping(value = "/search.do")
    public String searchList(ModelMap modelMap,@RequestParam(value = "pageNum", defaultValue = "1")int pageNum
            ,String partCategoryID, String partCategoryName) {
        PageEntity pageEntity = new PageEntity();
        pageEntity.setPageNum(pageNum);
        Pagenation pagenation = partCategoryService.selectPartCategoryListByIdOrName(partCategoryID,partCategoryName,pageEntity);
        pagenation.setQueryUrl("/manage/part_category/search.do?");

        modelMap.addAttribute("pagenation", pagenation);
        return "back_part_category";
    }



}
