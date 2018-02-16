package qy.rb.domain;

/**
 * @author: hjy
 * @description:生产商
 */
public class Producer {

	private String producerID;
	private String producerName;
	private int rankORDER;
	private String producerRemark;


	public Producer() {
	}

	@Override
	public String toString() {
		return "Producer{" +
				"producerID='" + producerID + '\'' +
				", producerName='" + producerName + '\'' +
				", rankORDER=" + rankORDER +
				", producerRemark='" + producerRemark + '\'' +
				'}';
	}

	public String getProducerID() {
		return producerID;
	}

	public void setProducerID(String producerID) {
		this.producerID = producerID;
	}

	public String getProducerName() {
		return producerName;
	}

	public void setProducerName(String producerName) {
		this.producerName = producerName;
	}

	public int getRankORDER() {
		return rankORDER;
	}

	public void setRankORDER(int rankORDER) {
		this.rankORDER = rankORDER;
	}

	public String getProducerRemark() {
		return producerRemark;
	}

	public void setProducerRemark(String producerRemark) {
		this.producerRemark = producerRemark;
	}

	public Producer(String producerID, String producerName, int rankORDER, String producerRemark) {
		this.producerID = producerID;
		this.producerName = producerName;
		this.rankORDER = rankORDER;
		this.producerRemark = producerRemark;
	}
}
