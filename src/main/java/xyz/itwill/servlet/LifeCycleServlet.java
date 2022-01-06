package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿은 클라이언트 요청에 의해 was에 등록된 서블릿클래스를 읽어 메모리에 
// 저장하고 (Loading) 클래즈,, 서블릿 인스턴스를 생성하여 service()메소드를 호출해
// 요청에 대한 처리와 응답결과를 클라이언트에게 전달(응답)

//=> 서블릿인스턴스가 이미 존재할 경우 서블릿 인스턴스를 생성하지 않고
// 기존 서블릿 인스턴스로 service() 메소드 호출

//was의 주요기능 중 한나는 서블릿 관련 인스턴스를 관리하는 컨테이너(web container)기능

//컨테이너 : 인스턴스의 생명주기(lifeCycle)을 관리(생성,사용,소멸)하는 프로그램

//was가 종료되면 같이 서블릿인스턴스도 소멸된다!!!!!!

@WebServlet("/life.itwill")
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String name;
	//생성자 : 인스턴스를 생성하기 위한 특별한 메소드
	// => 초기화 작업 : 필드에 초기값 저장
	// => 클라이언트 요청시 was 프로그램에 의해 서블릿 클래스를 인스턴스로 생성할때 한번만 호출된다
	
	public LifeCycleServlet() {
		System.out.println("###LifeCycleServlet 클래스의 생성자호출");
	}

	//init() : was 프로그램이 서블릿 인스턴스를 생성ㅇ하고 가장 먼저 한번만 호출하는 메소드
	//=> 생성자 대신에 init() 메소드로 필드 초기화 작업할때 사용
	
	//생성자 대신 init 메소드로 초기화작업 하는 이유 : servletconfig 인스턴스를
	//매개변수로 제공받아 필드에 필요한 값을 얻어와 필드값으로 저장할수있다.
	//ServletConfig : 컨텍스트 관련 환경정보를 저장한 인스턴스
	//=> [web.xml]파일에 설정된 값을 제공받아 사용 가능 - 유지보수의 효율성 증가
	//
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//ServletConfig.getServletContext: servletContext 인스턴스 반환 메소드
		//servletContext.getInitParameter(String name) : [web.xml]파일의 context-param 엘리먼트로
		//제공되는 값을 얻어와 반환하는 메소드
		name = config.getServletContext().getInitParameter("name");
	}
	
	
	
	//service() : 클라이언트의 요청마다 was에 의해 반복호출되는 메소드
	//=> 클라이언트 요청에 대한 처리와 처리결과를 생성하여 응답
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("###LifeCycleServlet 클래스의 service() 메소드 호출");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>"); 
		out.println("<html>"); 
		out.println("<head>"); 
		out.println("<meta charset='utf-8'>"); 
		out.println("<title>Servlet</title>"); 
		out.println("</head>"); 
		out.println("<body>"); 
		out.println("<h1>서블릿의 생명주기</h1>"); 
		out.println("<hr>"); 
		out.println("<p>"+name+"님, 안녕하세요</p>"); 
		out.println("</body>"); 
		out.println("</html>"); 
		
	
	
	}
	
	//destroy() : was 프로그램이 서블린 인스턴스를 소멸하기 전에 한번만 호출하는 메소드
	// => was 프로그램 종료시 서블릿 인스턴스는 was프로그램에 의해 소멸
	public void destroy() {
		System.out.println("##destroy 메소드 호출");
	}
	
	

}





















