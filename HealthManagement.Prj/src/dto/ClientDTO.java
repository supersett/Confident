package dto;

import java.util.Date;

public class ClientDTO {
	private int c_ClientNum;//회원번호
	private String c_Name;
	private String c_PhoneNum;
	private int c_age;
	private String c_Sex;
	private String c_Address;
	private int c_Height;
	private int c_Weight;
	private Date c_RegistrationDate;
	private int c_Reg_Months;
	private Date c_ExpirationDate;
	private int c_ifPT; // 0이면 false 1이면 true 이런식으로 받을까?
	private int c_LeftPTCnt; 

	public ClientDTO() {
	}
	
	public ClientDTO(int c_ClientNum, String c_Name, String c_PhoneNum) {
		this.c_ClientNum = c_ClientNum;
		this.c_Name = c_Name;
		this.c_PhoneNum = c_PhoneNum;
	}

	public ClientDTO(int c_ClientNum, String c_Name, String c_PhoneNum, int c_age, String c_Sex, String c_Address,
			int c_Height, int c_Weight, Date c_RegistrationDate, int c_Reg_Months, Date c_ExpirationDate, int c_ifPT, int c_LeftPTCnt) {
		this.c_ClientNum = c_ClientNum;
		this.c_Name = c_Name;
		this.c_PhoneNum = c_PhoneNum;
		this.c_age = c_age;
		this.c_Sex = c_Sex;
		this.c_Address = c_Address;
		this.c_Height = c_Height;
		this.c_Weight = c_Weight;
		this.c_RegistrationDate = c_RegistrationDate;
		this.c_Reg_Months = c_Reg_Months;
		this.c_ExpirationDate = c_ExpirationDate;
		this.c_ifPT = c_ifPT;
		this.c_LeftPTCnt = c_LeftPTCnt;
	}

	public int getC_ClientNum() {
		return c_ClientNum;
	}

	public void setC_ClientNum(int c_ClientNum) {
		this.c_ClientNum = c_ClientNum;
	}

	public int getC_LeftPTCnt() {
		return c_LeftPTCnt;
	}

	public void setC_LeftPTCnt(int c_LeftPTCnt) {
		this.c_LeftPTCnt = c_LeftPTCnt;
	}

	public String getC_Name() {
		return c_Name;
	}

	public void setC_Name(String c_Name) {
		this.c_Name = c_Name;
	}

	public String getC_PhoneNum() {
		return c_PhoneNum;
	}

	public void setC_PhoneNum(String c_PhoneNum) {
		this.c_PhoneNum = c_PhoneNum;
	}

	public int getC_age() {
		return c_age;
	}

	public void setC_age(int c_age) {
		this.c_age = c_age;
	}

	public String getC_Sex() {
		return c_Sex;
	}

	public void setC_Sex(String c_Sex) {
		this.c_Sex = c_Sex;
	}

	public String getC_Address() {
		return c_Address;
	}

	public void setC_Address(String c_Address) {
		this.c_Address = c_Address;
	}

	public int getC_Height() {
		return c_Height;
	}

	public void setC_Height(int c_Height) {
		this.c_Height = c_Height;
	}

	public int getC_Weight() {
		return c_Weight;
	}

	public void setC_Weight(int c_Weight) {
		this.c_Weight = c_Weight;
	}

	public Date getC_RegistrationDate() {
		return c_RegistrationDate;
	}

	public void setC_RegistrationDate(Date c_RegistrationDate) {
		this.c_RegistrationDate = c_RegistrationDate;
	}
	
	public int getC_Reg_Months() {
		return c_Reg_Months;
	}

	public void setC_Reg_Months(int c_Reg_Months) {
		this.c_Reg_Months = c_Reg_Months;
	}
	
	public Date getC_ExpirationDate() {
		return c_ExpirationDate;
	}

	public void setC_ExpirationDate(Date c_ExpirationDate) {
		this.c_ExpirationDate = c_ExpirationDate;
	}

	public int getC_ifPT() {
		return c_ifPT;
	}

	public void setC_ifPT(int c_ifPT) {
		this.c_ifPT = c_ifPT;
	}

}
