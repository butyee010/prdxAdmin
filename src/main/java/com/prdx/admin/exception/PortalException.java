package com.prdx.admin.exception;

import org.apache.commons.lang3.StringUtils;

import com.prdx.admin.commons.utils.CommonUtil;

public class PortalException extends Exception {
	
	private static final long serialVersionUID = -1615644828703300779L;

	protected String statusCode;
	protected String statusDesc;
	protected String[] params = null;
    private Throwable originalException;
    
    public PortalException() {
    	
    }
    
    public PortalException(String statusCode) {
		super(statusCode);
		this.statusCode = statusCode;
		init();
	}
    
	public PortalException(String statusCode , String[] params) {
		super(statusCode);
		this.statusCode = statusCode;
		this.params = params;
		init();
	}
	
	public PortalException(String statusCode , String statusDesc) {
		super(statusCode);
		this.statusCode = statusCode;
		this.statusDesc = statusDesc;
		init();
	}
	
	public PortalException(String statusCode , String statusDesc , String[] params) {
		super(statusCode);
		this.statusCode = statusCode;
		this.statusDesc = statusDesc;
		this.params = params;
		init();
	}
	
	public PortalException(String statusCode , String statusDesc , Throwable originalException) {
		super(originalException.getMessage() , originalException);
		this.statusCode = statusCode;
		this.statusDesc = statusDesc;
		init();
	}
	
	public PortalException(String statusCode , Throwable originalException) {
		super(originalException.getMessage() , originalException);
		this.statusCode = statusCode;
		this.originalException = originalException;
		init();
	}
	
	public void init() {
		//String statusDescFromStatusCd = ErrorMsgHelper.getErrorDesc(statusCode);
		String statusDescFromStatusCd = "";
		if (StringUtils.isNotBlank(statusDescFromStatusCd)) {
			if (params != null) {
				statusDesc = CommonUtil.replaceParamInMessage(statusDescFromStatusCd, params);
			}
			else {
				if (org.apache.commons.lang3.StringUtils.isBlank(statusDesc))
					statusDesc = statusDescFromStatusCd;
			}
		}
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
	
}
