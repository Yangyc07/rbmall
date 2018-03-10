package qy.rb.vo;

/**
 * 详情页的bean
 * @author hjy
 * @create 2018/03/10
 **/
public class BaseInfoDetail {

	//睿邦内部编号
	private String rbPartID;
	//零件号
	private String partModel;
	//零件名称
	private String partName;
	//副标题
	private String partSubtitle;
	//价格
	private String ordinaryPrice;

	public BaseInfoDetail() {
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

	public String getOrdinaryPrice() {
		return ordinaryPrice;
	}

	public void setOrdinaryPrice(String ordinaryPrice) {
		this.ordinaryPrice = ordinaryPrice;
	}

	@Override
	public String toString() {
		return "BaseInfo{" +
				"rbPartID='" + rbPartID + '\'' +
				", partModel='" + partModel + '\'' +
				", partName='" + partName + '\'' +
				", partSubtitle='" + partSubtitle + '\'' +
				", ordinaryPrice='" + ordinaryPrice + '\'' +
				'}';
	}

	public BaseInfoDetail(String rbPartID, String partModel, String partName, String partSubtitle, String ordinaryPrice) {
		this.rbPartID = rbPartID;
		this.partModel = partModel;
		this.partName = partName;
		this.partSubtitle = partSubtitle;
		this.ordinaryPrice = ordinaryPrice;
	}



}
