package com.gdcc.live.spi.quartz.model;

public class SpiCommand {
	private String serialNo;
	private String senderNo;
	private String senderOrg;
	private String date;

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getSenderNo() {
		return senderNo;
	}

	public void setSenderNo(String senderNo) {
		this.senderNo = senderNo;
	}

	public String getSenderOrg() {
		return senderOrg;
	}

	public void setSenderOrg(String senderOrg) {
		this.senderOrg = senderOrg;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
