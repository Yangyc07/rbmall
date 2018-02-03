package qy.rb.domain;
/**
 * 客户表
 * @author hjy
 * @create 2018/01/22
 **/
public class Customer {

    private String customerID;

    private String customerName;

    private String customerLoginName;

    private String customerPassword;

    private String customerPhone;

    private String customerPwdQuestion;

    private String customerPwdAnswer;

    private String customerRemark;

    public Customer() {}

    public Customer(String customerID, String customerName, String customerPassword) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerPassword = customerPassword;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "customerID='" + customerID + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerLoginName='" + customerLoginName + '\'' +
                ", customerPassword='" + customerPassword + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", customerPwdQuestion='" + customerPwdQuestion + '\'' +
                ", customerPwdAnswer='" + customerPwdAnswer + '\'' +
                ", customerRemark='" + customerRemark + '\'' +
                '}';
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerLoginName() {
        return customerLoginName;
    }

    public void setCustomerLoginName(String customerLoginName) {
        this.customerLoginName = customerLoginName;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerPwdQuestion() {
        return customerPwdQuestion;
    }

    public void setCustomerPwdQuestion(String customerPwdQuestion) {
        this.customerPwdQuestion = customerPwdQuestion;
    }

    public String getCustomerPwdAnswer() {
        return customerPwdAnswer;
    }

    public void setCustomerPwdAnswer(String customerPwdAnswer) {
        this.customerPwdAnswer = customerPwdAnswer;
    }

    public String getCustomerRemark() {
        return customerRemark;
    }

    public void setCustomerRemark(String customerRemark) {
        this.customerRemark = customerRemark;
    }

    public Customer(String customerID, String customerName, String customerLoginName, String customerPassword, String customerPhone, String customerPwdQuestion, String customerPwdAnswer, String customerRemark) {

        this.customerID = customerID;
        this.customerName = customerName;
        this.customerLoginName = customerLoginName;
        this.customerPassword = customerPassword;
        this.customerPhone = customerPhone;
        this.customerPwdQuestion = customerPwdQuestion;
        this.customerPwdAnswer = customerPwdAnswer;
        this.customerRemark = customerRemark;
    }
}
