package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
//서블릿(웹에서 실행되는 프로그램) 작성방법
//2.HttpServlet 클래스를 상속받은 자식 클래스 생성 - 서블릿클래스
// 객체직렬화 클래스로 serialVersionUID 필드를 선언하는것을 권장한다.
// 객체단위로 입출력할때 필요한거임!
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	//밑에 두개 오버라이드 선언
	//doGet() : 클라이언트 요청에 대한 처리와 처리결과(html)를 생성하기 위한 메소드 -was에 의해 자동호출된다
	//=> 클라이언트가 get 방식으로 요청한경우 호출되는 메소드
	//=> 일반적으로 doget 방식을 많이 쓴다.
	
	//doPost() : form 태그를 사용해야 요청할수 있다.
	//=> 클라이언트가 post 방식으로 요청한경우 호출되는 메소드
	//=> form 태그할때 사용.
	
	//doget,dopost 메소드대신 service 메소드 오버라이드 선언
	//주의) service 쓰게되면 doget,dopost 못씀!!
	//service() : 클라이언트의 모든 요청에 의해 호출되는 메소드
	//=> service() 메소드의 호출 우선순위가 높게 설정되어있다.(doget,dopost보다)
	
	//was에 의해 메소드가 호출이 될때, 밑에 2개 안스턴스가 매개변수에 자동으로 전달되어 저장된다.
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpServletRequest : 리퀘스트 메세지(요청정보)가 저장된 인스턴스
		//HttpServletResponse : 리스폰즈 메세지(응답정보)가 저장된 인스턴스
		//객체는 was 가 만들어주니까 이제 갖다 쓰면된다
		
		//3. 클라이언트에게 응답할 문서(파일)의 형식(MimeType) 설정(변경)
		//형식) HttpServletResponse.setContentType(String mimeType[;charset=encoding]) : 
		
		//문서가 아닌 일반파일은 ;charset=encoding 을 생략한다
		//-> 문서형식으로 응답할 경우 문서의 캐릭터셋(CharacterSet:문자 형식-인코딩)을 설정해야한다
		// 이걸안하면 기본 응답문서형식 : text/html, 캐릭터셋 : ISO-8859-1(서유럽어)
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		//4. 클라이언트 요청에 의해 처리결과(응답)를 생성하기위한 출력스트림을 반환받아 저장
		//형식) HttpServletResponse.getOutputStream() : 원시데이터(1Byte)를 전달할수있는 출력스트림(ServletOutputStream)을
		//반환하는 메소드
		//=> 그림, 영상 ,음향 파일 등을 클라이언트에게 응답하기위한 결과를 만들기 위한 출력 스트림
		
		//형식) HttpServletResponse.getWriter() : 인코딩 처리된 문자데이터(2Byte)를 전달할수있는 출력스트림(PringWriter)을
		//반환하는 메소드
		//=> PlainText,Html,Xml 문서등을 클라이언트에게 응답하기위한 결과롤 만들기위한 출력스트림
		
		PrintWriter out = response.getWriter();
		//out 안에 문서출력을 만들수있는 출력스트림이 들어가있는거야!!!!
		
		//5.요청에 처리와 처리결과를 문서(파일)에 생성 - 응답
		//=> 출력스트림을 사용하여 처리결과를 전달하면 문서(파일)이 생성된다.
		//출력스트림으로 문자열을 전달하는 메소드
		out.println("<!DOCTYPE html>"); 
		out.println("<html>"); 
		out.println("<head>"); 
		out.println("<meta charset='utf-8'>"); 
		out.println("<title>Servlet</title>"); 
		out.println("</head>"); 
		out.println("<body>"); 
		out.println("<h1>서블릿(servlet)</h1>"); 
		out.println("<hr>"); 
		out.println("<p>HELLO, SERVLET</p>"); 
		out.println("</body>"); 
		out.println("</html>"); 
		
		
		//★6.서블릿 클래스를 웹프로그램으로 등록하여 실행되도록 설정
		// => [web.xml] 파일에서 서블릿 클래스를 서블릿으로 등록하고, URL주소를 매핑설정해줘야한다.
		// 프로젝트의 자원을 웹에서 쓸수있는 자원으로 만들어주는 정보를 제공해준다.
		//=> 매핑된 url 주소로 클라이언트가 서블릿을 요청하면 WAS는 클래스를 객체로 생성하고 요청처리 메소드를 
		// 호출하여 처리와 응답결과 제공
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
