package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet : 서블릿 클래스를 서블릿으로 등록하고 URL 주소를 매핑하기 위한 어노테이션(Annotation)
// => [web.xml] 파일의 servlet 엘리먼트 및 servlet-mapping 엘리먼트와 동일한 기능 제공
//@WebServlet 어노테이션 속성을 이용하여 서블릿 이름 또는 URL 주소에 대한 매핑 처리 등을 설정
// => name 속성 : 서블릿 이름을 속성값으로 설정 - name 속성을 생략하면 클래스명을 서블릿 이름으로 자동 설정
// => value 속성(필수) : 서블릿에 대한 요청 URL 주소를 속성값으로 설정 - 다른 속성이 없는 경우 속성값만 설정 가능
// => 어노테이션 속성은 , 기호로 구분하여 나열 가능
@WebServlet("/first.itwill")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//클라이언트 요청에 대한 요청 처리 및 응답 결과를 제공하기 위해 자동 호출되는 요청 처리 메소드
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//응답 결과를 제공하지 않는 서블릿인 경우 생략 가능
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//요청 처리 및 응답 결과 생성
		// => 웹프로그램은 클라이언트에게 일관성 있는 결과를 제공하여 동적인 페이지 구현
		Date now=new Date();//Date 인스턴스 생성 - 서버 시스템의 현재 날짜와 시간 저장
		//SimpleDateFormat 인스턴스 생성 - 날짜와 시간에 대한 패턴 정보 저장
		SimpleDateFormat simpleDateFormat
			=new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		//SimpleDateFormat 인스턴스의 format() 메소드를 호출하여 현재 날짜와 시간을
		//원하는 패턴의 문자열로 변환하여 반환받아 저장
		String displayNow=simpleDateFormat.format(now);
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>Servlet</title>");
		out.println("<style type='text/css'>");
		out.println("p {");
		out.println("width: 600px;");
		out.println("margin: 0 auto;");
		out.println("padding: 30px 0;");
		out.println("font-size: 2em;");
		out.println("font-weight: bold;");
		out.println("text-align: center;");
		out.println("border: 2px solid black;");
		out.println("}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>서블릿 시계</h1>");
		out.println("<hr>");
		out.println("<p>"+displayNow+"</p>");
		out.println("<script type='text/javascript'>");
		out.println("setInterval(function() { location.reload(); },1000)");
		out.println("</script>");
		out.println("</body>");
		out.println("</html>");
	}

}

































