package qy.rb.util;



import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import qy.rb.dao.CustomerDao;
import qy.rb.dao.impl.CustomerDaoImpl;
import qy.rb.domain.Customer;
import qy.rb.service.CustomerService;
import qy.rb.service.impl.CustomerServiceImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


//  dbcp 版本的连接

public final class DBPoolUtil {

    private static DataSource dataSource = new DataSource();

    static {
        PoolProperties poolProperties = new PoolProperties();
        Properties dbProperties = new Properties();
        try {
            dbProperties.load(DBPoolUtil.class.getClassLoader().getResourceAsStream("jdbc_pool.properties"));
            //设置URL
            poolProperties.setUrl(dbProperties.getProperty("url"));
            //设置驱动名
            poolProperties.setDriverClassName(dbProperties.getProperty("driver"));
            //设置数据库用户名
            poolProperties.setUsername(dbProperties.getProperty("username"));
            //设置数据库密码
            poolProperties.setPassword(dbProperties.getProperty("password"));
            //设置初始化连接数
            poolProperties.setInitialSize(Integer.valueOf(dbProperties.getProperty("initialSize")));

            poolProperties.setMaxActive(Integer.valueOf(dbProperties.getProperty("maxActive")));
            poolProperties.setMaxIdle(Integer.valueOf(dbProperties.getProperty("maxIdle")));
            poolProperties.setMinIdle(Integer.valueOf(dbProperties.getProperty("minIdle")));
            poolProperties.setMaxWait(Integer.valueOf(dbProperties.getProperty("maxWait")));
            poolProperties.setRemoveAbandoned(Boolean.valueOf(dbProperties.getProperty("removeAbandoned")));
            poolProperties.setRemoveAbandonedTimeout(Integer.valueOf(dbProperties.getProperty("removeAbandonedTimeout")));
            dataSource.setPoolProperties(poolProperties);
        } catch (Exception e) {
            throw new RuntimeException("初始化数据库连接池失败");
        }
    }

    private DBPoolUtil() {
        super();
    }

    public static final Connection getConnection() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();

        } catch (SQLException ex) {
            Logger.getLogger(DBPoolUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    /*
    关闭连接
    */
    public static void closeConnection(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("关闭数据库连接失败");
        }
    }
    
    public static void closeConnection(ResultSet rs,Statement st, Connection conn) {
        try {
            if(rs !=null && !rs.isClosed()){
               rs.close();
            }
            if(st !=null && !st.isClosed()){
               st.close();
            }
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("关闭数据库连接失败");
        }
    }

    public static void main(String[] args) {
        //测试
//        Connection con1 = getConnection();
//        Connection con2 = getConnection();
//        System.out.println(con1+"   "+con2);
//        closeConnection(con1);
//        closeConnection(con2);


//        Customer customer =
//                new Customer("2265", "223", "test","test","22","223","22","22");
        CustomerDao customerDao = new CustomerDaoImpl();
       // System.out.println(customerDao.checkLoginName("test"));
        //System.out.println(customerDao.selectCustomerListByIdOrName(null,"%"));

//        System.out.println(ss);
//        List<Customer> customerList  = customerdao.selectCustomerList();
//        for (Customer c :
//                customerList) {
//            System.out.println(c.getCustomerName());
//        }
    }

}
