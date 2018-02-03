package qy.rb.dao.impl;

import org.springframework.stereotype.Repository;
import qy.rb.common.Const;
import qy.rb.dao.EmployeeDao;
import qy.rb.domain.Customer;
import qy.rb.domain.Employee;
import qy.rb.util.DBPoolUtil;

import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author hjy
 * @create 2018/01/22
 **/
@Repository //扫描Dao
public class EmployeeDaoImpl implements EmployeeDao {

	Connection conn = null;
	CallableStatement cstmt  = null;
	ResultSet rs = null;

	@Override
	public boolean insertEmployee(Employee employee) {
		boolean result = false;
		conn = DBPoolUtil.getConnection();
		try {
			cstmt = conn.prepareCall("{call spInsertEmployee(?,?,?,?,?,?,?)}");
			cstmt.registerOutParameter(1, Types.NVARCHAR);
			cstmt.setString(2,employee.getEmployeeID());
			cstmt.setString(3,employee.getEmployeeName());
			cstmt.setString(4,employee.getEmployeeType());
			cstmt.setString(5,employee.getEmployeeLoginName());
			cstmt.setString(6,employee.getEmployeePassword());
			cstmt.setString(7,employee.getEmployeeRemark());
			cstmt.executeUpdate();
			String flag = cstmt.getString(1);
			if ("OK".equals(flag)) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBPoolUtil.closeConnection(conn);
		}
		return result;
	}

	@Override
	public boolean deleteAllEmployee() {
		boolean result = false;
		conn = DBPoolUtil.getConnection();
		try {
			cstmt = conn.prepareCall("{call spDeleteAllEmployees(?)}");
			cstmt.registerOutParameter(1, Types.NVARCHAR);
			cstmt.executeUpdate();
			String flag = cstmt.getString(1);
			if (Const.OK.equals(flag)) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBPoolUtil.closeConnection(conn);
		}
		return result;


	}

	@Override
	public boolean selectEmployeeByName(String EmployeeName) {

		return false;
	}

	@Override
	public List<Employee> selectEmployeeList() {
		return null;
	}

	@Override
	public Employee selecLogin(String employeeLoginName, String employeePassword) {
		Employee employee = new Employee();
		try {
			conn = DBPoolUtil.getConnection();
			cstmt = conn.prepareCall("{call spEmployeeLogin(?,?)}");
			cstmt.setString(1,employeeLoginName);
			cstmt.setString(2,employeePassword);
			rs = cstmt.executeQuery();
			while(rs.next()) {
				employee.setEmployeeID(rs.getString("EmployeeID"));
				employee.setEmployeeName(rs.getString("EmployeeName"));
				employee.setEmployeeLoginName(rs.getString("EmployeeLoginName"));
				employee.setEmployeePassword(rs.getString("EmployeePassword"));
				employee.setEmployeeType(rs.getString("EmployeeType"));
				employee.setEmployeeRemark(rs.getString("EmployeeRemark"));
			}
		} catch (SQLException ex) {
			Logger.getLogger(EmployeeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DBPoolUtil.closeConnection(rs, cstmt, conn);
		}
		return employee;
	}

	@Override
	public Boolean checkLoginName(String employeeLoginName) {
		boolean result = false;
		conn = DBPoolUtil.getConnection();
		try {
			cstmt = conn.prepareCall("{call spCheckEmployeeLoginName(?,?)}");
			cstmt.registerOutParameter(1,Types.INTEGER);
			cstmt.setString(2,employeeLoginName);
			cstmt.execute();
			int flag = cstmt.getInt(1);
			if (flag == 1) {
				result =true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBPoolUtil.closeConnection(conn);
		}
		return result;
	}
}
