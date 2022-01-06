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


//�Է�������(file_view.html)���� ���޵� �Է°�(�ø���)�� �Է� ���ϸ�(���ϸ�)�� ��ȯ�޾� Ŭ���̾�Ʈ����
//�����ϴ� ����

@WebServlet("/view.itwill")
public class FileViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//���������� ��û�� ���� ó��
		if(request.getMethod().equals("GET")) {
			response.sendRedirect("file_view.html");
			return;
		}
	
		//post ������� ��û�Ͽ� ���޵� ���� ���� ĳ���ͼ� ����
		request.setCharacterEncoding("utf-8");
		
		//���ް��� ��ȯ�޾� ����
		//��Ƽ��Ʈ �������ͷ� ���޵� ���� httpservletrequest �ν��Ͻ��� getparameter()�޼ҵ带
		//ȣ���ؼ� ��ȯ �Ұ����ϴ�....
		//
		/*
		String name = request.getParameter("name");
		String fileone = request.getParameter("fileone");
		*/
		/*
		//ó����� ���� >> ����
		out.println("<!DOCTYPE html>"); 
		out.println("<html>"); 
		out.println("<head>"); 
		out.println("<meta charset='utf-8'>"); 
		out.println("<title>Servlet</title>"); 
		out.println("</head>"); 
		out.println("<body>"); 
		out.println("<h1>�Է°��� �Է�����</h1>"); 
		out.println("<hr>"); 
		out.println("<p>�ø���="+name+"</p>"); 
		out.println("<p>���ϸ�="+fileone+"</p>"); 
		out.println("</body>"); 
		out.println("</html>"); 
		*/
		
		//��Ƽ��Ʈ �������ʹ� ������Ʈ �޼����� �Է½�Ʈ���� ����Ͽ� ��ȯ�޾� ����ؾ��Ѵ�
		//request.getInputstream() : ��û�޼����� �Է½�Ʈ��(servletinputStream)�� ��ȯ�ϴ¸޼ҵ�
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
		out.println("<h1>�Է°��� �Է�����</h1>"); 
		out.println("<hr>"); 
		out.println("<pre>");
		
		while(true) {
			int readByte=in.read();
			if(readByte==-1) break; //EOF(end of file)�� ������ �ݺ�������
			out.write(readByte);//������ ����� ���õ����͸� �����Ͽ� ������ ����
			
		}
		
		out.println("</pre>");
		
		
		out.println("</body>"); 
		out.println("</html>"); 
		
		//�������޾Ƽ� ������ �����Ұž� (upload)
		//Ŭ���̾�Ʈ���� ������ (download)
		
		
	}

}




























