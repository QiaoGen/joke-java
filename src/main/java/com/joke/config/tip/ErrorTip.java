package com.joke.config.tip;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 返回给前台的错误提示
 * @author 
 */
@JsonPropertyOrder(value={"errCode","errMsg","success","data"})
public class ErrorTip extends Tip {

	public ErrorTip(String errMsg) {
		this(0, errMsg);
	}

	public ErrorTip(int errCode, String errMsg) {
		super(errCode, errMsg, false);
	}

	public ErrorTip(String errMsg, Object data) {
		super(0, errMsg, false,data);
	}
	
	public ErrorTip(int errCode, String errMsg, Object data) {
		super(errCode, errMsg, false, data);
	}


}
