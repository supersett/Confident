package dto;

public class ManagerDTO {
	private String m_Id;
	private String m_Pwd;
	private String m_Name;
	private String m_PhoneNum;
	private String m_Position;
	private int num;

	public ManagerDTO() {

	}

	public ManagerDTO(String m_Id, String m_Pwd, String m_Name, String m_PhoneNum, String m_Position) {
		this.m_Id = m_Id;
		this.m_Pwd = m_Pwd;
		this.m_Name = m_Name;
		this.m_PhoneNum = m_PhoneNum;
		this.m_Position = m_Position;
	}

	public ManagerDTO(int num) {

		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getM_Id() {
		return m_Id;
	}

	public void setM_Id(String m_Id) {
		this.m_Id = m_Id;
	}

	public String getM_Pwd() {
		return m_Pwd;
	}

	public void setM_Pwd(String m_Pwd) {
		this.m_Pwd = m_Pwd;
	}

	public String getM_Name() {
		return m_Name;
	}

	public void setM_Name(String m_Name) {
		this.m_Name = m_Name;
	}

	public String getM_PhoneNum() {
		return m_PhoneNum;
	}

	public void setM_PhoneNum(String m_PhoneNum) {
		this.m_PhoneNum = m_PhoneNum;
	}

	public String getM_Position() {
		return m_Position;
	}

	public void setM_Position(String m_Position) {
		this.m_Position = m_Position;
	}

	@Override
	public String toString() {
		String str = String.format("관리자 이름: %s\n관리자 휴대폰: %s\n관리자 직급: %s", m_Name, m_PhoneNum, m_Position);
		return str;
	}
}
