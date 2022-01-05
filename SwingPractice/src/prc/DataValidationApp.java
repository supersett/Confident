package xyz.itwill.student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

//정규 표현식(Regular Expression) : Meta 문자, Escape 문자등을 이용하여 일정한 규칙(형식)의
//문자열을 표현하는 방법
/*
^문자 : 문자(열)로 시작됨을 의미
문자$ : 문자(열)로 종료됨을 의미
. : 임의의 문자 하나를 의미(\ 문자 표현 불가능)
[문자1문자2문자3] : 나열된 문자들 중 하나를 의미
[^문자1문자2문자3] : 나열된 문자들이 아닌 문자 중 하나를 의미
[문자1-문자2] : 문자1부터 문자2 범위의 문자 중 하나를 의미
문자열? : 문자열이 0번 또는 1번 존재함을 의미
문자열+ : 문자열이 1번이상 반복됨을 의미
문자열* : 문자열이 0번이상 반복됨을 의미
문자열{숫자} : 문자열이 숫자만큼 반복됨을 의미
문자열{숫자1,숫자2} : 문자열이 숫자1부터 숫자2 범위만큼 반복됨을 의미
(문자열1|문자열2|문자열3) : 나열된 문자열 중 하나를 의미
(?!)문자열 : 문자열에서 대소문자를 구분하지 않음을 의미
(?=문자열) : 문자열을 반드시 포함하고 있음을 의미
(?!문자열) : 문자열을 반드시 포함하고 있지 않음을 의미

\s : 공백이 존재하는 문자열을 의미
\S : 공백이 존재하지 않는 문자열을 의미
\w : 영문자,숫자,특수문자(_)의 문자로만 구성된 문자열을 의미
\W : 영문자,숫자,특수문자(_)의 문자를 제외한 문자들로 구성된 문자열을 의미
\d : 숫자 형식의 문자로만 구성된 문자열을 의미
\D : 숫자 형식의 문자를 제외한 문자들로 구성된 문자열을 의미
\메타문자 : 메타문자를 일반문자로 표현함을 의미
*/

//키보드로 입력된 문자열에 대한 검증 프로그램 - 입력값 유효성 검증(Data Validation)
// => 형식에 맞지 않는 문자열을 입력한 경우 프로그램 종료
public class DataValidationApp {
	public static void main(String[] args) throws IOException {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		/*
		System.out.print("아이디 입력 >> ");
		String id=in.readLine();
		
		//입력값 유무에 대한 검증 : 연산자 또는 String 클래스의 메소드를 이용한 입력값 검증
		if(id==null || id.equals("")) {
			System.out.println("[에러]아이디를 반드시 입력해 주세요.");
			System.exit(0);
		}
		
		//입력값 형식에 대한 검증 - 정규 표현식를 이용한 유효성 검증
		//아이디 형식 - 영문자로 시작되며 영문자,숫자,특수문자(_)의 조합으로 6~20 범위의 문자로 표현
		
		//아이디에 대한 형식을 정규 표현식으로 구현하여 저장
		//String idReg="^[a-zA-Z][a-zA-Z0-9_]{5,19}$";
		String idReg="^[a-zA-Z]\\w{5,19}$";
		
		//java.util.regex.Pattern : 정규 표현식을 저장하기 위한 클래스
		//Pattern.matches(String regex, CharSequence input) : 정규 표현식과 입력값을 전달받아
		//입력값에 대한 규칙을 비교하여 결과(boolean)를 반환하는 메소드
		// => false : 정규 표현식의 형식과 불일치, true : 정규 표현식의 형식과 일치 
		//입력값과 정규 표현식을 비교하여 형식에 맞지 않은 경우 프로그램 종료
		//if(!Pattern.matches(idReg, id)) {
		//	System.out.println("[에러]입력한 아이디는 형식에 맞지 않습니다.");
		//	System.exit(0);
		//}
		
		//Pattern.compile(String regex) : 정규 표현식을 전달받아 Pattern 인스턴스에 저장하여
		//반환하는 메소드
		Pattern idPattern=Pattern.compile(idReg);
		
		//java.util.regex.Matcher : 정규 표현식과 비교 문자열을 저장하기 위한 클래스 
		// => 정규 표현식과 문자열 비교하는 기능외에 검색 또는 변경,삭제 처리하는 메소드 제공
		//Pattern.matcher(CharSequence input) : Pattern 인스턴스에 저장된 정규 표현식과
		//비교 문자열을 제공받아 저장한 Matcher 인스턴스를 반환하는 메소드
		Matcher idMatcher=idPattern.matcher(id);
		
		//Matcher.matches() : Matcher 인스턴스에 저장된 정규 표현식과 문자열을 대한 규칙을 
		//비교하여 결과(boolean)를 반환하는 메소드
		// => false : 정규 표현식의 형식과 불일치, true : 정규 표현식의 형식과 일치
		if(!idMatcher.matches()) {
			System.out.println("[에러]입력한 아이디는 형식에 맞지 않습니다.");
			System.exit(0);
		}
		
		System.out.println("[메세지]형식에 맞는 아이디를 입력 하였습니다.");
		*/

		/*
		System.out.print("비밀번호 입력 >> ");
		String password=in.readLine();

		if(password==null || password.equals("")) {
			System.out.println("[에러]비밀번호를 반드시 입력해 주세요.");
			System.exit(0);
		}
		
		//비밀번호 형식 : 영문자,숫자,특수문자를 반드시 1개이상 포함하여 8~30 범위의 문자로 표현
		String passwordReg="^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*_-]).{8,30}$";
		
		if(!Pattern.matches(passwordReg, password)) {
			System.out.println("[에러]입력한 비밀번호는 형식에 맞지 않습니다.");
			System.exit(0);
		}

		System.out.println("[메세지]형식에 맞는 비밀번호를 입력 하였습니다.");
		*/
		System.exit();
		System.out.print("이메일 입력 >> ");
		String email=in.readLine();

		if(email==null || email.equals("")) {
			System.out.println("[에러]이메일을 반드시 입력해 주세요.");
			System.exit(0);
		}
		
		//이메일 형식 : [사용자명@도메인명] 형식의 문자열로 표현
		String emailReg="^([a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+)*$";
		if(!Pattern.matches(emailReg, email)) {
			System.out.println("[에러]입력한 이메일은 형식에 맞지 않습니다.");
			System.exit(0);
		}
		
		System.out.println("[메세지]형식에 맞는 이메일을 입력 하였습니다.");

	}
}



















