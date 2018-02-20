package qy.rb.dao.impl;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.springframework.stereotype.Repository;
import qy.rb.common.Const;
import qy.rb.dao.CustomerDao;
import qy.rb.domain.Customer;
import qy.rb.util.DBPoolUtil;

import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import qy.rb.domain.PageEntity;

/**
 * @author hjy
 * @create 2018/01/22
 **/
@Repository //扫描Dao
public class CustomerDaoImpl implements CustomerDao {

    Connection conn = null;
    CallableStatement cstmt  = null;
    ResultSet rs = null;

    @Override
    public boolean insertCustomer(Customer customer) {
        boolean result = false;
        conn = DBPoolUtil.getConnection();
        try {
            cstmt = conn.prepareCall("{call spInsertCustomer(?,?,?,?,?,?,?,?,?,?)}");
            cstmt.registerOutParameter(1, Types.NVARCHAR);
            cstmt.setString(2,customer.getCustomerID());
            cstmt.setString(3,customer.getCustomerName());
            cstmt.setString(4,customer.getCustomerLoginName());
            cstmt.setString(5,customer.getCustomerPassword());
            cstmt.setString(6,"会员客户");
            cstmt.setString(7,customer.getCustomerPhone());
            cstmt.setString(8,customer.getCustomerPwdQuestion());
            cstmt.setString(9,customer.getCustomerPwdAnswer());
            cstmt.setString(10,customer.getCustomerRemark());
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
    public boolean delelteAllCustomers() {
        boolean result = false;
        conn = DBPoolUtil.getConnection();
        try {
            cstmt = conn.prepareCall("{call spDeleteAllCustomers(?)}");
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
    public boolean updateCustomerPassword(String customerLoginName, String customerPassword) {
        boolean result = false;
        conn = DBPoolUtil.getConnection();
        try {
            cstmt = conn.prepareCall("{call spUpdateCustomerPWDByIDOrLoginName(?,?,?)}");
            cstmt.registerOutParameter(1, Types.NVARCHAR);
            cstmt.setString(2,customerLoginName);
            cstmt.setString(3,customerPassword);
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
    public List<Customer> selectCustomerListByIdOrName(String customerId,String customerName,PageEntity pageEntity) {
        List<Customer> customerList = new ArrayList();
        try {
            conn = DBPoolUtil.getConnection();
            cstmt = conn.prepareCall("{call spGetLimitCustomerListByIDOrName(?,?,?,?)}");
            cstmt.setString(1,customerId);
            cstmt.setString(2,customerName);
            cstmt.setInt(3,pageEntity.getStartRow());
            cstmt.setInt(4,pageEntity.getPageSize());
            rs = cstmt.executeQuery();
            while(rs.next()) {
                Customer customer = new Customer();
                customer.setCustomerID(rs.getString("CustomerID"));
                customer.setCustomerName(rs.getString("CustomerName"));
                customer.setCustomerLoginName(rs.getString("CustomerLoginName"));
                customer.setCustomerPassword(rs.getString("CustomerPassword"));
                customer.setCustomerPhone(rs.getString("CustomerPhone"));
                customer.setCustomerPwdQuestion(rs.getString("CustomerPwdQuestion"));
                customer.setCustomerPwdAnswer(rs.getString("CustomerPwdAnswer"));
                customer.setCustomerRemark(rs.getString("CustomerRemark"));
                customerList.add(customer);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBPoolUtil.closeConnection(rs, cstmt, conn);
        }
        return customerList;
    }

    @Override
    public List<Customer> selectCustomerList(PageEntity pageEntity) {
        List<Customer> customerList = new ArrayList();
        try {
            conn = DBPoolUtil.getConnection();
            cstmt = conn.prepareCall("{call spGetLimitCustomerList(?,?)}");
            cstmt.setInt(1,pageEntity.getStartRow());
            cstmt.setInt(2,pageEntity.getPageSize());
            rs = cstmt.executeQuery();
            while(rs.next()) {
                Customer customer = new Customer();
                customer.setCustomerID(rs.getString("CustomerID"));
                customer.setCustomerName(rs.getString("CustomerName"));
                customer.setCustomerLoginName(rs.getString("CustomerLoginName"));
                customer.setCustomerPassword(rs.getString("CustomerPassword"));
                customer.setCustomerPhone(rs.getString("CustomerPhone"));
                customer.setCustomerPwdQuestion(rs.getString("CustomerPwdQuestion"));
                customer.setCustomerPwdAnswer(rs.getString("CustomerPwdAnswer"));
                customer.setCustomerRemark(rs.getString("CustomerRemark"));
                customerList.add(customer);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBPoolUtil.closeConnection(rs, cstmt, conn);
        }
        return customerList;
    }

    @Override
    public boolean checkLoginName(String customerLoginName) {
        System.out.println(customerLoginName);
        boolean result = false;
        conn = DBPoolUtil.getConnection();
        try {
            cstmt = conn.prepareCall("{call spCheckLoginName(?,?)}");
            cstmt.registerOutParameter(1,Types.INTEGER);
            cstmt.setString(2,customerLoginName);
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

    @Override
    public Customer selecLogin(String customerLoginName, String customerPassword) {
        Customer customer = new Customer();
        try {
            conn = DBPoolUtil.getConnection();
            cstmt = conn.prepareCall("{call spCustomerLogin(?,?)}");
            cstmt.setString(1,customerLoginName);
            cstmt.setString(2,customerPassword);
            rs = cstmt.executeQuery();

            while(rs.next()) {
                customer.setCustomerID(rs.getString("CustomerID"));
                customer.setCustomerName(rs.getString("CustomerName"));
                customer.setCustomerLoginName(rs.getString("CustomerLoginName"));
                customer.setCustomerPassword(rs.getString("CustomerPassword"));
                customer.setCustomerPhone(rs.getString("CustomerPhone"));
                customer.setCustomerPwdQuestion(rs.getString("CustomerPwdQuestion"));
                customer.setCustomerPwdAnswer(rs.getString("CustomerPwdAnswer"));
                customer.setCustomerRemark(rs.getString("CustomerRemark"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBPoolUtil.closeConnection(rs, cstmt, conn);
        }
        return customer;
    }

    /**
     * 通过登录名获得找回密码问题
     * @param customerLoginName
     * @return
     */
    @Override
    public String selectQuestionByLoginName(String customerLoginName) {
        String result = null;
        try {
            conn = DBPoolUtil.getConnection();
            cstmt = conn.prepareCall("{call spSelectQuestionByLoginName(?,?)}");
            cstmt.registerOutParameter(1,Types.NVARCHAR);
            cstmt.setString(2,customerLoginName);
            cstmt.execute();
            result = cstmt.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBPoolUtil.closeConnection(rs, cstmt, conn);
        }
        return result;
    }

    @Override
    public boolean checkAnswer(String customerLoginName, String customerPwdQuestion, String customerPwdAnswer) {
        boolean result = false;
        try {
            conn = DBPoolUtil.getConnection();
            cstmt = conn.prepareCall("{call spCheckAnswer(?,?,?,?)}");
            cstmt.registerOutParameter(1,Types.INTEGER);
            cstmt.setString(2,customerLoginName);
            cstmt.setString(3,customerPwdQuestion);
            cstmt.setString(4,customerPwdAnswer);
            cstmt.execute();
            int flag = cstmt.getInt(1);
            if (flag == 1) {
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBPoolUtil.closeConnection(rs, cstmt, conn);
        }
        return result;
    }

    @Override
    public int listCustomerDataRawCount(String customerId, String customerName, PageEntity pageEntity) {
        conn = DBPoolUtil.getConnection();
        int result = 0;
        try {
            cstmt = conn.prepareCall("{call spSelectCountByIDOrName(?,?,?)}");
            cstmt.registerOutParameter(1,Types.INTEGER);
            cstmt.setString(2,customerId);
            cstmt.setString(3,customerName);
            cstmt.execute();
            result = cstmt.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBPoolUtil.closeConnection(conn);
        }
        return result;
    }


    @Override
    public int listCustomerDataRawCount(PageEntity pageEntity) {

        conn = DBPoolUtil.getConnection();
        int result = 0;
        try {
            cstmt = conn.prepareCall("{call spSelectCount(?)}");
            cstmt.registerOutParameter(1,Types.INTEGER);
            cstmt.execute();
            result = cstmt.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBPoolUtil.closeConnection(conn);
        }
        return result;
    }



}
