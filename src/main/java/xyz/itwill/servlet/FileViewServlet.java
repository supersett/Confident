package xyz.itwill.servlet;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//입력페이지(file_view.html)에서 전달된 입력값(올린이)과 입력 파일명(파일명)을 반환받아 클라이언트에게
//응답하는 서블릿

@WebServlet("/view.itwill")
public class FileViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//비정상적인 요청에 대한 처리
		if(request.getMethod().equals("GET")) {
			response.sendRedirect("file_view.html");
			return;
		}
	
		//post 방식으로 요청하여 전달된 값에 대한 캐릭터셋 변경
		request.setCharacterEncoding("utf-8");
		
		//전달값을 반환받아 저장
		//멀티파트 폼데이터로 전달된 값은 httpservletrequest 인스턴스의 getparameter()메소드를
		//호출해서 반환 불가능하다....
		//
		/*
		String name = request.getParameter("name");
		String fileone = request.getParameter("fileone");
		*/
		/*
		//처리결과 생성 >> 응답
		out.println("<!DOCTYPE html>"); 
		out.println("<html>"); 
		out.println("<head>"); 
		out.println("<meta charset='utf-8'>"); 
		out.println("<title>Servlet</title>"); 
		out.println("</head>"); 
		out.println("<body>"); 
		out.println("<h1>입력값과 입력파일</h1>"); 
		out.println("<hr>"); 
		out.println("<p>올린이="+name+"</p>"); 
		out.println("<p>파일명="+fileone+"</p>"); 
		out.println("</body>"); 
		out.println("</html>"); 
		*/
		
		//멀티파트 폼데이터는 리퀘스트 메세지의 입력스트림을 사용하여 반환받아 사용해야한다
		//request.getInputstream() : 요청메세지의 입력스트림(servletinputStream)을 반환하는메소드
		//ServletInputStream in = request.getInputStream();
		InputStreamReader in = new InputStreamReader(request.getInputStream(),"utf-8");
		
		//BufferedInputStream bis = new BufferedInputStream(in);
		
		
		
		out.println("<!DOCTYPE html>"); 
		out.println("<html>"); 
		out.println("<head>"); 
		out.println("<meta charset='utf-8'>"); 
		out.println("<title>Servlet</title>"); 
		out.println("</head>"); 
		out.println("<body>"); 
		out.println("<h1>입력값과 입력파일</h1>"); 
		out.println("<hr>"); 
		out.println("<pre>");
		
		while(true) {
			int readByte=in.read();
			if(readByte==-1) break; //EOF(end of file)을 만나면 반복문종료
			out.write(readByte);//변수에 저장된 원시데이터를 전달하여 응답결과 생성
			
		}
		
		out.println("</pre>");
		
		
		out.println("</body>"); 
		out.println("</html>"); 
		
		//파일을받아서 서버에 저장할거야 (upload)
		//클라이언트에게 갖고가면 (download)
		
		
	}

}




























