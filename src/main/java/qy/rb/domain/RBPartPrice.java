package qy.rb.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 汽车配件价格表实体
 * @author hjy
 * @create 2018/01/22
 **/
public class RBPartPrice {


	private String RBPartID;

	private BigDecimal ordinaryPrice;

	private BigDecimal memberPrice;

	private Date partPriceStartTime;

	private Date partPriceEndTime;

	private Integer partPriceFlag;

	private String RBPartPriceRemark;


	public RBPartPrice() {
	}

	@Override
	public String toString() {
		return "PartPrice{" +
				"RBPartID='" + RBPartID + '\'' +
				", ordinaryPrice=" + ordinaryPrice +
				", memberPrice=" + memberPrice +
				", partPriceStartTime=" + partPriceStartTime +
				", partPriceEndTime=" + partPriceEndTime +
				", partPriceFlag=" + partPriceFlag +
				", RBPartPriceRemark='" + RBPartPriceRemark + '\'' +
				'}';
	}

	public String getRBPartID() {
		return RBPartID;
	}

	public void setRBPartID(String RBPartID) {
		this.RBPartID = RBPartID;
	}

	public BigDecimal getOrdinaryPrice() {
		return ordinaryPrice;
	}

	public void setOrdinaryPrice(BigDecimal ordinaryPrice) {
		this.ordinaryPrice = ordinaryPrice;
	}

	public BigDecimal getMemberPrice() {
		return memberPrice;
	}

	public void setMemberPrice(BigDecimal memberPrice) {
		this.memberPrice = memberPrice;
	}

	public Date getPartPriceStartTime() {
		return partPriceStartTime;
	}

	public void setPartPriceStartTime(Date partPriceStartTime) {
		this.partPriceStartTime = partPriceStartTime;
	}

	public Date getPartPriceEndTime() {
		return partPriceEndTime;
	}

	public void setPartPriceEndTime(Date partPriceEndTime) {
		this.partPriceEndTime = partPriceEndTime;
	}

	public Integer getPartPriceFlag() {
		return partPriceFlag;
	}

	public void setPartPriceFlag(Integer partPriceFlag) {
		this.partPriceFlag = partPriceFlag;
	}

	public String getRBPartPriceRemark() {
		return RBPartPriceRemark;
	}

	public void setRBPartPriceRemark(String RBPartPriceRemark) {
		this.RBPartPriceRemark = RBPartPriceRemark;
	}

	public RBPartPrice(String RBPartID, BigDecimal ordinaryPrice, BigDecimal memberPrice, Date partPriceStartTime, Date partPriceEndTime, Integer partPriceFlag, String RBPartPriceRemark) {
		this.RBPartID = RBPartID;
		this.ordinaryPrice = ordinaryPrice;
		this.memberPrice = memberPrice;
		this.partPriceStartTime = partPriceStartTime;
		this.partPriceEndTime = partPriceEndTime;
		this.partPriceFlag = partPriceFlag;
		this.RBPartPriceRemark = RBPartPriceRemark;
	}
}
