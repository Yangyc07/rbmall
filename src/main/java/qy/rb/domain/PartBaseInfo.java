package qy.rb.domain;
/**
 * @author: hjy
 * @description:零件基本信息表,含有与分类的联系
 */
public class PartBaseInfo {
	/**
	 * 零件号，配件制造商的型号<俗称零件号>
	 */
	private String partModel;
	/**
	 * 零件名称
	 */
	private String partName;
	/**
	 * 零件副标题
	 */
	private String partSubtitle;
	/**
	 * 零件单位
	 */
	private String partUnit;
	/**
	 * 零件所属类别编号
	 */
	private String partCategoryId;
	/**
	 * 零件基本信息备注
	 */
	private String partBaseInfoRemark;

	public PartBaseInfo() {
	}

	@Override
	public String toString() {
		return "PartBaseInfo{" +
				"partModel='" + partModel + '\'' +
				", partName='" + partName + '\'' +
				", partSubtitle='" + partSubtitle + '\'' +
				", partUnit='" + partUnit + '\'' +
				", partCategoryId='" + partCategoryId + '\'' +
				", partBaseInfoRemark='" + partBaseInfoRemark + '\'' +
				'}';
	}

	public String getPartModel() {
		return partModel;
	}

	public void setPartModel(String partModel) {
		this.partModel = partModel;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public String getPartSubtitle() {
		return partSubtitle;
	}

	public void setPartSubtitle(String partSubtitle) {
		this.partSubtitle = partSubtitle;
	}

	public String getPartUnit() {
		return partUnit;
	}

	public void setPartUnit(String partUnit) {
		this.partUnit = partUnit;
	}

	public String getPartCategoryId() {
		return partCategoryId;
	}

	public void setPartCategoryId(String partCategoryId) {
		this.partCategoryId = partCategoryId;
	}

	public String getPartBaseInfoRemark() {
		return partBaseInfoRemark;
	}

	public void setPartBaseInfoRemark(String partBaseInfoRemark) {
		this.partBaseInfoRemark = partBaseInfoRemark;
	}

	public PartBaseInfo(String partModel, String partName, String partSubtitle, String partUnit, String partCategoryId, String partBaseInfoRemark) {
		this.partModel = partModel;
		this.partName = partName;
		this.partSubtitle = partSubtitle;
		this.partUnit = partUnit;
		this.partCategoryId = partCategoryId;
		this.partBaseInfoRemark = partBaseInfoRemark;
	}
}
