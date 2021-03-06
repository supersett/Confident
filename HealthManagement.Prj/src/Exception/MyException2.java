package Exception;

import java.util.regex.Pattern;

public class MyException2 {

	// 아이디 자리수 테스트
	public void idCheck(String mngId) throws MyException {
		if (mngId.length() < 4 || mngId.length() > 8) {
			throw new MyException(" 아이디는 4~8자 사이로 입력해주세요.");
		}

	}

	// 이름 확인
	public void nameCheck(String name) throws MyException {

		boolean check = Pattern.matches("^[ㄱ-ㅎ가-힣]*$", name);

		if (!check)

			throw new MyException("※이름은 한글로 입력해주세요");

	}

	// 전화번호 확인
	public void phoneCheck(String phone) throws MyException {

		boolean check = Pattern.matches("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$", phone);

		if (!check)

			throw new MyException("전화 번호 형식은 : [010 6-9] - xxxx - xxxx");

	}

	public void numberException() throws MyException {
		throw new MyException("공백 문자가 입력 되었습니다. 다시 입력해주세요. ");
	}
}
