package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//입력페이지(join.html)에서 전달된 입력값을 반환받아 클라이언트에게 응답하는 서블릿
@WebServlet("/join.itwill")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//입력페이지(form.html)의 form 태그를 이용하여 POST 방식으로 요청하여 실행되는 서블릿
		// => 서블릿을 GET 방식으로 요청한 경우 비정상적인 요청
		//클라이언트가 웹프로그램을 비정상적으로 요청한 경우 클라이언트에게 에러코드를 전달하거나
		//에러페이지 또는 입력페이지로 이동되도록 처리
		//HttpServletRequest.getMethod() : 클라이언트의 요청방식(GET or POST)을 반환하는 메소드
		if(request.getMethod().equals("GET")) {//서블릿을 GET 방식으로 요청한 경우 - 비정상적인 요청
			/*
			//HttpServletResponse.sendError(int sc) : 클라이언트에게 에러코드(Status Code - 4XX or 5XX)를 
			//전달하는 메소드
			// => 에러코드는 HttpServletResponse 인터페이스의 상수 표현되어 제공
			//response.sendError(HttpServletResponse.SC_BAD_REQUEST);//400
			response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);//405
			return;//서블릿 종료
			*/
			
			//HttpServletResponse.sendRedirect(String url) : 클라이언트에게 301 상태코드와
			//URL 주소를 전달하는 메소드
			// => 301 : 전달된 URL 주소의 웹프로그램을 요청하기 위한 상태코드
			response.sendRedirect("form.html");
			return;
		}
		
		//POST 방식으로 웹프로그램을 요청한 경우 리퀘스트 메세지의 바디(BODY)에 값을 저장하여 전달
		// => 리퀘스트 메세지의 바디(BODY)의 기본 캐릭터셋은 ISO-8859-1(서유럽어)로 설정
		//HttpServletRequest.setCharacterEncoding(String encoding) : 리퀘스트 메세지의 바디에 
		//저장되어 전달되는 값에 대한 캐릭터셋을 변경하는 메소드
		request.setCharacterEncoding("utf-8");
		
		//서블릿 요청시 전달된 값(사용자 입력값)을 반환받아 저장
		//HttpServletRequest.getParameter(String name) : 웹프로그램 요청시 전달된 값을
		//얻어와 반환하는 메소드 - 전달값은 무조건 문자열(String 인스턴스)로 반환
		// => GET : QueryString으로 전달된 값의 이름(식별자)을 이용하여 전달값 반환
		// => POST : 입력태그의 name 속성값을 이용하여 전달값 반환
		//이름(name)에 해당하는 전달값이 존재하지 않는 경우 null 반환
		// => GET 방식에서는 이름만 있고 값이 없는 경우 NullString 반환
		String id=request.getParameter("id");
		
		//전달값에 대한 검증 처리
		if(id==null || id.equals("")) {//전달값이 없는 경우 - 비정상적인 요청
			return;
		}
		
		if(!Pattern.matches("^[a-zA-Z]\\w{5,19}$", id)) {//전달값이 형식에 맞지 않은 경우 - 비정상적인 요청
			return;
		}
		
		String pass=request.getParameter("pass");
		String name=request.getParameter("name");
		String addr=request.getParameter("addr");
		String sex=request.getParameter("sex");
		String job=request.getParameter("job");
		//같은 이름으로 전달된 값이 있는 경우 첫번째 전달값만 반환받아 저장
		//String hobby=request.getParameter("hobby");
		
		//HttpServletRequest.getParameterValues(String name) : 같은 이름으로 전달되는 모든 값들을
		//얻어와 문자열 배열로 반환하는 메소드
		// => 다중 선택 기능의 입력태그(checkbox, select 등)로 전달된 값을 반환받을 때 사용
		String[] hobby=request.getParameterValues("hobby");
	
		String profile=request.getParameter("profile");
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>회원정보확인</h1>");
		out.println("<hr>");
		out.println("<p>아이디 = "+id+"</p>");
		out.println("<p>비밀번호 = "+pass+"</p>");
		out.println("<p>이름 = "+name+"</p>");
		out.println("<p>주소 = "+addr+"</p>");
		out.println("<p>성별 = "+sex+"</p>");
		out.println("<p>직업 = "+job+"</p>");
		//out.println("<p>취미 = "+hobby+"</p>");
		if(hobby==null) {//전달값이 없는 경우
			out.println("<p>취미 = 미선택</p>");
		} else {
			out.println("<p>취미 = ");
			for(int i=0;i<hobby.length;i++) {
				out.println(hobby[i]);
				if(i<hobby.length-1) {//배열의 마지막 요소값 아닌 경우
					out.println(",");
				}
			}
		}
		//textarea 태그로 입력되어 전달된 값은 엔터(Enter)를 br 태그로 변환하여 응답 
		out.println("<p>자기소개<br>"+profile.replace("\n", "<br>")+"</p>");
		out.println("</body>");
		out.println("</html>");
	}

}










