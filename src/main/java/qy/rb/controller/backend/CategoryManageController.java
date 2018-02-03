package qy.rb.controller.backend;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import qy.rb.common.Const;
import qy.rb.common.ResponseCode;
import qy.rb.common.ServerResponse;
import qy.rb.domain.Employee;
import qy.rb.domain.PartCategory;
import qy.rb.service.PartCategoryService;


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
        if (Const.CURRENT_EMPLOYEE.equals(employee.getEmployeeType())) {
            //是普通员工
            //增加处理分类的逻辑
            PartCategory partCategory = new PartCategory(partCategoryID, partCategoryName, partCategoryRemark);
            return partCategoryService.insertPartCategory(partCategory);
        } else {
            return ServerResponse.createByErrorMessage("无权限操作,需要普通员工权限");
        }
    }

    /**
     * 设置分类名字
     * @param session
     * @param partcategoryId
     * @param partcategoryName
     * @return
     */
    @RequestMapping("set_part_category_name.do")
    public ServerResponse setCategoryName(HttpSession session, String partcategoryId, String partcategoryName) {
        Employee employee = (Employee) session.getAttribute(Const.CURRENT_EMPLOYEE);
        if (employee == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录");
        }
        //校验一下是否是普通员工
        if (Const.CURRENT_EMPLOYEE.equals(employee.getEmployeeType())) {
            //是普通员工
            //增加处理的逻辑
            return partCategoryService.updatePartCategoryName(partcategoryId,partcategoryName);
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
    public ServerResponse getChildrenParallelCategory(HttpSession session, @RequestParam(value = "categoryId", defaultValue = "0") String partCategoryId) {
        Employee employee = (Employee) session.getAttribute(Const.CURRENT_EMPLOYEE);
        if (employee == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录");
        }
        //校验一下是否是普通员工
        if (Const.CURRENT_EMPLOYEE.equals(employee.getEmployeeType())) {
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
    public ServerResponse getCategoryAndDeepChildrenCategory(HttpSession session, @RequestParam(value = "categoryId", defaultValue = "0") String partCategoryId) {
        Employee employee = (Employee) session.getAttribute(Const.CURRENT_EMPLOYEE);
        if (employee == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录");
        }
        //校验一下是否是普通员工
        if (Const.CURRENT_EMPLOYEE.equals(employee.getEmployeeType())) {
            //是普通员工
            //增加处理的逻辑
            return partCategoryService.getChildrenPartCategory(partCategoryId);
        } else {
            return ServerResponse.createByErrorMessage("无权限操作,需要普通员工权限");
        }
    }

}
