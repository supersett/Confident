package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//클라이언트에서 보내온 쿠키를읽어 클라이언트에게 쿠키값을 응답하는 서블릿
//=> 클라이언트는 요청 url 주소의 서버정보를 이용하여 해당서버의 모든 쿠키를 무조건 전달
@WebServlet("/read.itwill")
public class CookieReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		
		//클라이언트에서 전달된 모든 쿠키를 반환받아 저장
		//getcookies() : 클라이언트에서 전달된 모든 쿠키를 cookie 배열로 반환하는 메소드
		Cookie[] cookies = request.getCookies();
		
		out.println("<!DOCTYPE html>"); 
		out.println("<html>"); 
		out.println("<head>"); 
		out.println("<meta charset='utf-8'>"); 
		out.println("<title>Servlet</title>"); 
		out.println("</head>"); 
		out.println("<body>"); 
		out.println("<h1>쿠키 읽기</h1>"); 
		out.println("<hr>");
		//클라이언트에서 보내온 쿠키가 없는 경우
		if(cookies==null) {
			out.println("<p>넌 쿠키가 없어</p>");
		}else {
			String id ="";
			String count ="";
			
			//쿠키 배열에 저장된 쿠키 인스턴스를 제공받아 반복처리
			// => 클라이언트에게 보내온 쿠키중 원하는 쿠키값만 반환받아 저장
			for(Cookie cookie:cookies) {
				//cookie.getName(): cookie 인스턴스에 저장된 쿠키명을 반환하는 메소드
				if(cookie.getName().equals("id")) {//반환받은 쿠키명을 비교하여 같은경우
					id=cookie.getValue(); // cookie 인스턴스에 저장된 쿠키값을 반환하는 메소드
				} else if(cookie.getName().equals("count")){
					count=cookie.getValue();
				}
				
				
			}
			//클라이언트에게 쿠키값 전달
			if(!id.equals("")) { // 쿠키값이 있는경우
				out.println("<p>아이디 = "+id+"</p>");
			}
			if(!count.equals("")) { // 쿠키값이 있는경우
				int cnt = Integer.parseInt(count)+1;
				out.println("<p>아이디 = "+cnt+"</p>");
				
				//쿠키 인스턴스를 생성하여 클라이언트에게 전달
				//=> 클라이언트에 저장된 쿠키와 같은 쿠키명으로 쿠키값을 전달하면 쿠키값이 변경된다
				Cookie cookie = new Cookie("count",cnt+"");
				cookie.setMaxAge(24*60*60);
				response.addCookie(cookie);
			}
			
		}
		//강사님 혹시 쿠키배열안에 쿠키가 여러개있다면 밑에 출력부분이 향상된 for문안에 들어가있어야하는거 아닌가요?!
		out.println("<hr>"); 
		out.println("<p>HELLO, SERVLET</p>"); 
		out.println("</body>"); 
		out.println("</html>"); 
	
	
	}

}
