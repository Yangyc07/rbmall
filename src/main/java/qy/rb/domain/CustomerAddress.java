package qy.rb.domain;

/**
 * 客户地址表
 * @author hjy
 * @create 2018/01/22
 **/
public class CustomerAddress {
    private int receivingAddressID;
    private String customerID;
    private String receiverProvince;
    private String receiverCity;
    //县区
    private String receiverDistrict;
    //街道
    private String receiverStreet;
    //详细地址
    private String receiverDetailedAddress;
    private String receiverPostCode;
    private String receiverName;
    private String receiverMobilePhone;
    private String receiverTelePhone;
    private int receiverAddressFlag;
    private String customerReceivingAddressRemark;

    public CustomerAddress() {
    }

    @Override
    public String toString() {
        return "CustomerAddress{" +
                "receivingAddressID=" + receivingAddressID +
                ", customerID='" + customerID + '\'' +
                ", receiverProvince='" + receiverProvince + '\'' +
                ", receiverCity='" + receiverCity + '\'' +
                ", receiverDistrict='" + receiverDistrict + '\'' +
                ", receiverStreet='" + receiverStreet + '\'' +
                ", receiverDetailedAddress='" + receiverDetailedAddress + '\'' +
                ", receiverPostCode='" + receiverPostCode + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", receiverMobilePhone='" + receiverMobilePhone + '\'' +
                ", receiverTelePhone='" + receiverTelePhone + '\'' +
                ", receiverAddressFlag=" + receiverAddressFlag +
                ", customerReceivingAddressRemark='" + customerReceivingAddressRemark + '\'' +
                '}';
    }

    public int getReceivingAddressID() {
        return receivingAddressID;
    }

    public void setReceivingAddressID(int receivingAddressID) {
        this.receivingAddressID = receivingAddressID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getReceiverProvince() {
        return receiverProvince;
    }

    public void setReceiverProvince(String receiverProvince) {
        this.receiverProvince = receiverProvince;
    }

    public String getReceiverCity() {
        return receiverCity;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    public String getReceiverDistrict() {
        return receiverDistrict;
    }

    public void setReceiverDistrict(String receiverDistrict) {
        this.receiverDistrict = receiverDistrict;
    }

    public String getReceiverStreet() {
        return receiverStreet;
    }

    public void setReceiverStreet(String receiverStreet) {
        this.receiverStreet = receiverStreet;
    }

    public String getReceiverDetailedAddress() {
        return receiverDetailedAddress;
    }

    public void setReceiverDetailedAddress(String receiverDetailedAddress) {
        this.receiverDetailedAddress = receiverDetailedAddress;
    }

    public String getReceiverPostCode() {
        return receiverPostCode;
    }

    public void setReceiverPostCode(String receiverPostCode) {
        this.receiverPostCode = receiverPostCode;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverMobilePhone() {
        return receiverMobilePhone;
    }

    public void setReceiverMobilePhone(String receiverMobilePhone) {
        this.receiverMobilePhone = receiverMobilePhone;
    }

    public String getReceiverTelePhone() {
        return receiverTelePhone;
    }

    public void setReceiverTelePhone(String receiverTelePhone) {
        this.receiverTelePhone = receiverTelePhone;
    }

    public int getReceiverAddressFlag() {
        return receiverAddressFlag;
    }

    public void setReceiverAddressFlag(int receiverAddressFlag) {
        this.receiverAddressFlag = receiverAddressFlag;
    }

    public String getCustomerReceivingAddressRemark() {
        return customerReceivingAddressRemark;
    }

    public void setCustomerReceivingAddressRemark(String customerReceivingAddressRemark) {
        this.customerReceivingAddressRemark = customerReceivingAddressRemark;
    }

    public CustomerAddress(int receivingAddressID, String customerID, String receiverProvince, String receiverCity, String receiverDistrict, String receiverStreet, String receiverDetailedAddress, String receiverPostCode, String receiverName, String receiverMobilePhone, String receiverTelePhone, int receiverAddressFlag, String customerReceivingAddressRemark) {
        this.receivingAddressID = receivingAddressID;
        this.customerID = customerID;
        this.receiverProvince = receiverProvince;
        this.receiverCity = receiverCity;
        this.receiverDistrict = receiverDistrict;
        this.receiverStreet = receiverStreet;
        this.receiverDetailedAddress = receiverDetailedAddress;
        this.receiverPostCode = receiverPostCode;
        this.receiverName = receiverName;
        this.receiverMobilePhone = receiverMobilePhone;
        this.receiverTelePhone = receiverTelePhone;
        this.receiverAddressFlag = receiverAddressFlag;
        this.customerReceivingAddressRemark = customerReceivingAddressRemark;
    }
}
