package com.joke.config.tip;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 返回给前台的成功提示
 * @author 
 * 
 */
@JsonPropertyOrder(value={"code","msg","success","data"})
public class SuccessTip extends Tip {

	public SuccessTip() {
		this(200, "操作成功", null);
	}

	public SuccessTip(Object data) {
		this(200, "操作成功", data);
	}

	public SuccessTip(int code, String msg) {
		super(code, msg, true);
	}

	public SuccessTip(String msg, Object data) {
		this(200, msg, data);
	}

	public SuccessTip(int code, String msg, Object data) {
		super(code, msg, true,data);
	}

    public SuccessTip(int code) {
       super(code);
    }

}
