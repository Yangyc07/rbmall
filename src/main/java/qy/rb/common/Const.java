package qy.rb.common;

/**
 * @author hjy
 * @create 2018/01/23
 **/
public class Const {

	public static final String OK = "OK";

	public static final String CURRENT_CUSTOMER = "currentUser";

	public static final String CURRENT_EMPLOYEE = "currentEmployee";

	public interface Role {
		int ROLE_ORDINARY_CUSTOMER = 0; //普遍用户
		int ROLE_MEMBER_CUSTOMER = 1; //会员用员
	}

	public interface EmployeeRole {
		String EMPLOYEEROLE_ORDINARY_CUSTOMER = "普通员工";
		String EMPLOYEEROLE_MEMBER_CUSTOMER = "经理";
	}



}
