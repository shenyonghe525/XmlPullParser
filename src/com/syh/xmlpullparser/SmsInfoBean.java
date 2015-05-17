package com.syh.xmlpullparser;

/**
 * @author shenyonghe
 * 
 *         2014-10-5
 */
public class SmsInfoBean {
	/**
	 * 短信的时间
	 */
	private long data;
	/**
	 * 短信的地址
	 */
	private long adress;
	/**
	 * 短信的内容
	 */
	private String body;
	/**
	 * 短信的类型
	 */
	private int type;
	/**
	 * 短信id
	 */
	private int id;

	public SmsInfoBean() {

	}

	@Override
	public String toString() {
		return "[信息时间=" + data + ", 信息地址=" + adress + ", 信息内容="
				+ body + ", 信息类型=" + type + ", 信息id=" + id + "]";
	}

	public SmsInfoBean(long data, long adress, String body, int type, int id) {
		this.data = data;
		this.adress = adress;
		this.body = body;
		this.type = type;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getData() {
		return data;
	}

	public void setData(long data) {
		this.data = data;
	}

	public long getAdress() {
		return adress;
	}

	public void setAdress(long adress) {
		this.adress = adress;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
