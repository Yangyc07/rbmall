package qy.rb.domain;

/**
 * 汽车配件分类实体
 * @author hjy
 * @create 2018/01/30
 **/
public class PartCategory {
	/**
	 * 零件类别编号，支持至多四级类别
	 */
	private String partCategoryID;
	//零件类别名称
	private String partCategoryName;
	//零件类别备注
	private String partCategoryRemark;

	public PartCategory() {
	}

	@Override
	public String toString() {
		return "PartCategory{" +
				"partCategoryID='" + partCategoryID + '\'' +
				", partCategoryName='" + partCategoryName + '\'' +
				", partCategoryRemark='" + partCategoryRemark + '\'' +
				'}';
	}

	public String getPartCategoryID() {
		return partCategoryID;
	}

	public void setPartCategoryID(String partCategoryID) {
		this.partCategoryID = partCategoryID;
	}

	public String getPartCategoryName() {
		return partCategoryName;
	}

	public void setPartCategoryName(String partCategoryName) {
		this.partCategoryName = partCategoryName;
	}

	public String getPartCategoryRemark() {
		return partCategoryRemark;
	}

	public void setPartCategoryRemark(String partCategoryRemark) {
		this.partCategoryRemark = partCategoryRemark;
	}

	public PartCategory(String partCategoryID, String partCategoryName, String partCategoryRemark) {
		this.partCategoryID = partCategoryID;
		this.partCategoryName = partCategoryName;
		this.partCategoryRemark = partCategoryRemark;
	}
}
