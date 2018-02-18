package qy.rb.domain;



/**
 * @author: hjy
 * @description:睿邦零件基本信息表
 */
public class RBPartBaseInfo {
	/**
	 * 睿邦零件编号，睿邦定义:由 RB_零件号_生产商代码 组成
	 */
	private String rbPartID;

	/**
	 * 零件号 ，生产商定义
	 */
	private String partModel;

	/**
	 * 零件品牌
	 */
	private String partBrand;

	/**
	 * 生产商代码
	 */
	private String producerID;


	/**
	 * 图片文件夹地址
	 */
	private String partImagesAddress;

	/**
	 * 零件状态        1-有货   2-缺货  3－下架
	 */
	private String partStatus;

	private String rbPartBaseInfoRemark;




	@Override
	public String toString() {
		return "RBPartBaseInfo{" +
				"rbPartID='" + rbPartID + '\'' +
				", partModel='" + partModel + '\'' +
				", partBrand='" + partBrand + '\'' +
				", producerID='" + producerID + '\'' +
				", partImagesAddress='" + partImagesAddress + '\'' +
				", partStatus='" + partStatus + '\'' +
				", rbPartBaseInfoRemark='" + rbPartBaseInfoRemark + '\'' +
				'}';
	}

	public String getRbPartID() {
		return rbPartID;
	}

	public void setRbPartID(String rbPartID) {
		this.rbPartID = rbPartID;
	}

	public String getPartModel() {
		return partModel;
	}

	public void setPartModel(String partModel) {
		this.partModel = partModel;
	}

	public String getPartBrand() {
		return partBrand;
	}

	public void setPartBrand(String partBrand) {
		this.partBrand = partBrand;
	}

	public String getProducerID() {
		return producerID;
	}

	public void setProducerID(String producerID) {
		this.producerID = producerID;
	}

	public String getPartImagesAddress() {
		return partImagesAddress;
	}

	public void setPartImagesAddress(String partImagesAddress) {
		this.partImagesAddress = partImagesAddress;
	}

	public String getPartStatus() {
		return partStatus;
	}

	public void setPartStatus(String partStatus) {
		this.partStatus = partStatus;
	}

	public String getRbPartBaseInfoRemark() {
		return rbPartBaseInfoRemark;
	}

	public void setRbPartBaseInfoRemark(String rbPartBaseInfoRemark) {
		this.rbPartBaseInfoRemark = rbPartBaseInfoRemark;
	}

	public RBPartBaseInfo(String rbPartID, String partModel, String partBrand, String producerID, String partImagesAddress, String partStatus, String rbPartBaseInfoRemark) {
		this.rbPartID = rbPartID;
		this.partModel = partModel;
		this.partBrand = partBrand;
		this.producerID = producerID;
		this.partImagesAddress = partImagesAddress;
		this.partStatus = partStatus;
		this.rbPartBaseInfoRemark = rbPartBaseInfoRemark;
	}

	public RBPartBaseInfo() {
	}



}
