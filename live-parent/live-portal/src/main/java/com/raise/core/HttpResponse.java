package com.raise.core;

/**
 * 主要用于保存Http返回的值。
 * @author longsheng.wang
 *
 */
public class HttpResponse {
	
	/**
	 * 状态
	 */
	private int status;
	
	/**
	 * 数据
	 */
	private Object data;

	/**
	 * 错误或警告消息
	 */
	private String message;
	

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
