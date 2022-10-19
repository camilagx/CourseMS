package com.gomezcamila.cms.utilities;

public enum TypeOfStatusEnum {
	UNASSIGNED("Unassigned"),
	ASSIGNED("Assigned");
	
	final public String status;
	
	TypeOfStatusEnum(String status){
		this.status = status;
	
	}
	public String getStatus() {
		return status;
	}
}
