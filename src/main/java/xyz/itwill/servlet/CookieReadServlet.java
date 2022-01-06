package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//Ŭ���̾�Ʈ���� ������ ��Ű���о� Ŭ���̾�Ʈ���� ��Ű���� �����ϴ� ����
//=> Ŭ���̾�Ʈ�� ��û url �ּ��� ���������� �̿��Ͽ� �ش缭���� ��� ��Ű�� ������ ����
@WebServlet("/read.itwill")
public class CookieReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		
		//Ŭ���̾�Ʈ���� ���޵� ��� ��Ű�� ��ȯ�޾� ����
		//getcookies() : Ŭ���̾�Ʈ���� ���޵� ��� ��Ű�� cookie �迭�� ��ȯ�ϴ� �޼ҵ�
		Cookie[] cookies = request.getCookies();
		
		out.println("<!DOCTYPE html>"); 
		out.println("<html>"); 
		out.println("<head>"); 
		out.println("<meta charset='utf-8'>"); 
		out.println("<title>Servlet</title>"); 
		out.println("</head>"); 
		out.println("<body>"); 
		out.println("<h1>��Ű �б�</h1>"); 
		out.println("<hr>");
		//Ŭ���̾�Ʈ���� ������ ��Ű�� ���� ���
		if(cookies==null) {
			out.println("<p>�� ��Ű�� ����</p>");
		}else {
			String id ="";
			String count ="";
			
			//��Ű �迭�� ����� ��Ű �ν��Ͻ��� �����޾� �ݺ�ó��
			// => Ŭ���̾�Ʈ���� ������ ��Ű�� ���ϴ� ��Ű���� ��ȯ�޾� ����
			for(Cookie cookie:cookies) {
				//cookie.getName(): cookie �ν��Ͻ��� ����� ��Ű���� ��ȯ�ϴ� �޼ҵ�
				if(cookie.getName().equals("id")) {//��ȯ���� ��Ű���� ���Ͽ� �������
					id=cookie.getValue(); // cookie �ν��Ͻ��� ����� ��Ű���� ��ȯ�ϴ� �޼ҵ�
				} else if(cookie.getName().equals("count")){
					count=cookie.getValue();
				}
				
				
			}
			//Ŭ���̾�Ʈ���� ��Ű�� ����
			if(!id.equals("")) { // ��Ű���� �ִ°��
				out.println("<p>���̵� = "+id+"</p>");
			}
			if(!count.equals("")) { // ��Ű���� �ִ°��
				int cnt = Integer.parseInt(count)+1;
				out.println("<p>���̵� = "+cnt+"</p>");
				
				//��Ű �ν��Ͻ��� �����Ͽ� Ŭ���̾�Ʈ���� ����
				//=> Ŭ���̾�Ʈ�� ����� ��Ű�� ���� ��Ű������ ��Ű���� �����ϸ� ��Ű���� ����ȴ�
				Cookie cookie = new Cookie("count",cnt+"");
				cookie.setMaxAge(24*60*60);
				response.addCookie(cookie);
			}
			
		}
		//����� Ȥ�� ��Ű�迭�ȿ� ��Ű�� �������ִٸ� �ؿ� ��ºκ��� ���� for���ȿ� ���־���ϴ°� �ƴѰ���?!
		out.println("<hr>"); 
		out.println("<p>HELLO, SERVLET</p>"); 
		out.println("</body>"); 
		out.println("</html>"); 
	
	
	}

}
