package com.gomezcamila.cms.utilities;

public enum ProgramNamesEnum {
	SOFTWARE_ENGINEERING("Software Engineering"),
	CYBERSECURITY("Cybersecurity"),
	DATA_ANALYTICS("Data Analytics"),
	UX_DESIGN("UX Design"),
	IT_SUPPORT("IT Support");
	
	public String programName;
	
	ProgramNamesEnum(String programName){
		this.programName = programName;
		
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}
	
	
}
