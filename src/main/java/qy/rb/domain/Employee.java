package qy.rb.domain;

/**
 * 雇员表
 * @author hjy
 * @create 2018/01/22
 **/
public class Employee {
	private String employeeID;
	private String employeeName;
	private String employeeType;
	private String employeeLoginName;
	private String employeePassword;

	private String employeeRemark;


	@Override
	public String toString() {
		return "Employee{" +
				"employeeID='" + employeeID + '\'' +
				", employeeName='" + employeeName + '\'' +
				", employeeType='" + employeeType + '\'' +
				", employeeLoginName='" + employeeLoginName + '\'' +
				", employeePassword='" + employeePassword + '\'' +
				", employeeRemark='" + employeeRemark + '\'' +
				'}';
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	public String getEmployeeLoginName() {
		return employeeLoginName;
	}

	public void setEmployeeLoginName(String employeeLoginName) {
		this.employeeLoginName = employeeLoginName;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	public String getEmployeeRemark() {
		return employeeRemark;
	}

	public void setEmployeeRemark(String employeeRemark) {
		this.employeeRemark = employeeRemark;
	}

	public Employee() {
	}

	public Employee(String employeeID, String employeeName, String employeeType, String employeeLoginName, String employeePassword, String employeeRemark) {
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.employeeType = employeeType;
		this.employeeLoginName = employeeLoginName;
		this.employeePassword = employeePassword;
		this.employeeRemark = employeeRemark;
	}
}
