package qy.rb.domain;
/**
 * @author: hjy
 * @description:购物车
 */
public class ShoppingCart {
	/**
	 * 购物车明细ID
	 */
	private long shoppingCartID;
	/**
	 * 客户ID,删除客户，对应的购物明细也要删除
	 */
	private String customerID;
	/**
	 * 睿邦零件ID,不用外码和级联删除，用程序保持一致性
	 */
	private String rbPartID;
	/**
	 * 零件数量
	 */
	private int partAmount;
	/**
	 * 有效标志    1:有效     0:失效
	 */
	private byte validityFlag;
	/**
	 * 备注
	 */
	private String shoppingCartRemark;

	@Override
	public String toString() {
		return "ShoppingCart{" +
				"shoppingCartID=" + shoppingCartID +
				", customerID='" + customerID + '\'' +
				", rbPartID='" + rbPartID + '\'' +
				", partAmount=" + partAmount +
				", validityFlag=" + validityFlag +
				", shoppingCartRemark='" + shoppingCartRemark + '\'' +
				'}';
	}

	public long getShoppingCartID() {
		return shoppingCartID;
	}

	public void setShoppingCartID(long shoppingCartID) {
		this.shoppingCartID = shoppingCartID;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getRbPartID() {
		return rbPartID;
	}

	public void setRbPartID(String rbPartID) {
		this.rbPartID = rbPartID;
	}

	public int getPartAmount() {
		return partAmount;
	}

	public void setPartAmount(int partAmount) {
		this.partAmount = partAmount;
	}

	public byte getValidityFlag() {
		return validityFlag;
	}

	public void setValidityFlag(byte validityFlag) {
		this.validityFlag = validityFlag;
	}

	public String getShoppingCartRemark() {
		return shoppingCartRemark;
	}

	public void setShoppingCartRemark(String shoppingCartRemark) {
		this.shoppingCartRemark = shoppingCartRemark;
	}

	public ShoppingCart() {
	}

	public ShoppingCart(long shoppingCartID, String customerID, String rbPartID, int partAmount, byte validityFlag, String shoppingCartRemark) {
		this.shoppingCartID = shoppingCartID;
		this.customerID = customerID;
		this.rbPartID = rbPartID;
		this.partAmount = partAmount;
		this.validityFlag = validityFlag;
		this.shoppingCartRemark = shoppingCartRemark;
	}
}
