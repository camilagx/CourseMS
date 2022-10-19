package com.gomezcamila.cms.utilities;

public enum ProgramNamesEnum {
	SOFTWARE_ENGINEERING("Software Engineering"),
	CYBERSECURITY("Cybersecurity"),
	DATA_ANALYTICS("Data Analytics"),
	UX_DESIGN("UX Design"),
	IT_SUPPORT("IT Support");
	
	final public String programName;
	
	ProgramNamesEnum(String programName){
		this.programName = programName;
		
	}	
	public String getProgamName() {
		return programName;
	}
}
