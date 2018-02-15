package qy.rb.domain;


/**
 * @author: hjy
 * @description:车型表
 */
public class AutoStyling {
	private String autoStylingName;

	private String autoStylingBrand;

	private String autoStylingRemark;


	@Override
	public String toString() {
		return "AutoStyling{" +
				"autoStylingName='" + autoStylingName + '\'' +
				", autoStylingBrand='" + autoStylingBrand + '\'' +
				", autoStylingRemark='" + autoStylingRemark + '\'' +
				'}';
	}

	public String getAutoStylingName() {
		return autoStylingName;
	}

	public void setAutoStylingName(String autoStylingName) {
		this.autoStylingName = autoStylingName;
	}

	public String getAutoStylingBrand() {
		return autoStylingBrand;
	}

	public void setAutoStylingBrand(String autoStylingBrand) {
		this.autoStylingBrand = autoStylingBrand;
	}

	public String getAutoStylingRemark() {
		return autoStylingRemark;
	}

	public void setAutoStylingRemark(String autoStylingRemark) {
		this.autoStylingRemark = autoStylingRemark;
	}

	public AutoStyling() { }

	public AutoStyling(String autoStylingName, String autoStylingBrand, String autoStylingRemark) {
		this.autoStylingName = autoStylingName;
		this.autoStylingBrand = autoStylingBrand;
		this.autoStylingRemark = autoStylingRemark;
	}
}
