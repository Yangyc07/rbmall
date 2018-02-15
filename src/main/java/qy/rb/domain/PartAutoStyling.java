package qy.rb.domain;

/**
 *
 * @author: hjy
 * @description:零件-车型联系
 */
public class PartAutoStyling {

	private String partModel;

	private String autoStylingName;

	private String partAutoStylingRemark;


	@Override
	public String toString() {
		return "PartAutoStyling{" +
				"partModel='" + partModel + '\'' +
				", autoStylingName='" + autoStylingName + '\'' +
				", partAutoStylingRemark='" + partAutoStylingRemark + '\'' +
				'}';
	}

	public PartAutoStyling(String partModel, String autoStylingName, String partAutoStylingRemark) {
		this.partModel = partModel;
		this.autoStylingName = autoStylingName;
		this.partAutoStylingRemark = partAutoStylingRemark;
	}

	public String getPartModel() {
		return partModel;
	}

	public void setPartModel(String partModel) {
		this.partModel = partModel;
	}

	public String getAutoStylingName() {
		return autoStylingName;
	}

	public void setAutoStylingName(String autoStylingName) {
		this.autoStylingName = autoStylingName;
	}

	public String getPartAutoStylingRemark() {
		return partAutoStylingRemark;
	}

	public void setPartAutoStylingRemark(String partAutoStylingRemark) {
		this.partAutoStylingRemark = partAutoStylingRemark;
	}

	public PartAutoStyling() {
	}
}
