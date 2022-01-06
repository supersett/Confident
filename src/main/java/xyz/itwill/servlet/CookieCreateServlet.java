package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//쿠키를 생성하여 클라이언트에게 전달하는 서블릿
//쿠키 : 서버(웹프로그램)와 클라이언트와의 연결지속성을 제공하기 위해 클라이언트에 저장되는값
// =>  쿠키는 접속서버정보를 이름(식별자)으로 하여 클라이언트에 저장
@WebServlet("/create.itwill")
public class CookieCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//Cookie 클래스로 인스턴스 생성
		//쿠키정보를 저장한 인스턴스
		//Cookie(String name, String value) : 쿠키명과 쿠키값을 전달하여 인스턴스를 생성하는 생성자
		//쿠키명 : 쿠키값을 제공받기위한 식별자
		//쿠키명과 쿠키값은 영문자,숫자
		Cookie idCookie = new Cookie("id","abc123");
		Cookie countCookie = new Cookie("count","0");
		
		//클라이언트에 전달되어 저장될 쿠키의 유지시간 변경
		//cookie.setmaxage(int expiry) : 쿠키유지시간(초)를 변경하는 메소드
		//유지시간을 변경하지 않은경우, 기본값은 -1로 설정
		// => 유지시간이 -1로 설정된경우 , 쿠키는 브라우저가 종료될경우 자동 소멸된다
		countCookie.setMaxAge(24*60*60);
		
		
		//클라이언트는 전달받은 쿠키를 저장
		//addcookie : 클라이언트에게 쿠키를 전달하는 메소드
		// => 유지시간을 변경하지 않은 쿠키는 브라우저 메모리에 저장
		// => 유지시간을 변경한 쿠키는 쿠키파일에 저장
		response.addCookie(idCookie);
		response.addCookie(countCookie);
		
		
		out.println("<!DOCTYPE html>"); 
		out.println("<html>"); 
		out.println("<head>"); 
		out.println("<meta charset='utf-8'>"); 
		out.println("<title>Servlet</title>"); 
		out.println("</head>"); 
		out.println("<body>"); 
		out.println("<h1>쿠키전달</h1>"); 
		out.println("<hr>"); 
		out.println("<p>쿠키있음</p>");
		out.println("<p><a href='read.itwill';>쿠키읽기</a></p>");
		out.println("</body>"); 
		out.println("</html>"); 
		
	
	
	}

}


























