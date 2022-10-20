package com.gomezcamila.cms.utilities;

public enum TypeOfStatusEnum {
	UNASSIGNED("unassigned"),
	ASSIGNED("assigned");
	
	final public String status;
	
	TypeOfStatusEnum(String status){
		this.status = status;
	
	}
	public String getStatus() {
		return status;
	}
}
