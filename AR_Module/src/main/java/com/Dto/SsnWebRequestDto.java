package com.Dto;

import lombok.Data;

@Data
public class SsnWebRequestDto
{
	private String citizenName;

	private String citizenDob;

	private String citizenSsnNo;

	public String getCitizenName() {
		return citizenName;
	}

	public void setCitizenName(String citizenName) {
		this.citizenName = citizenName;
	}

	public String getCitizenDob() {
		return citizenDob;
	}

	public void setCitizenDob(String citizenDob) {
		this.citizenDob = citizenDob;
	}

	public String getCitizenSsnNo() {
		return citizenSsnNo;
	}

	public void setCitizenSsnNo(String citizenSsnNo) {
		this.citizenSsnNo = citizenSsnNo;
	}

	@Override
	public String toString() {
		return "SsnWebRequestDto [citizenName=" + citizenName + ", citizenDob=" + citizenDob + ", citizenSsnNo="
				+ citizenSsnNo + "]";
	}

}
