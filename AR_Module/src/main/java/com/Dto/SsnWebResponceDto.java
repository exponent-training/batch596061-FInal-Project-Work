package com.Dto;

public class SsnWebResponceDto
{
	private String citizenSsnNo;

	private String stateName;

	public String getCitizenSsnNo() {
		return citizenSsnNo;
	}

	public void setCitizenSsnNo(String citizenSsnNo) {
		this.citizenSsnNo = citizenSsnNo;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Override
	public String toString() {
		return "SsnWebResponseDto [citizenSsnNo=" + citizenSsnNo + ", stateName=" + stateName + "]";
	}

}
