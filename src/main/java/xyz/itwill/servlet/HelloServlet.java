package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
//����(������ ����Ǵ� ���α׷�) �ۼ����
//2.HttpServlet Ŭ������ ��ӹ��� �ڽ� Ŭ���� ���� - ����Ŭ����
// ��ü����ȭ Ŭ������ serialVersionUID �ʵ带 �����ϴ°��� �����Ѵ�.
// ��ü������ ������Ҷ� �ʿ��Ѱ���!
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	//�ؿ� �ΰ� �������̵� ����
	//doGet() : Ŭ���̾�Ʈ ��û�� ���� ó���� ó�����(html)�� �����ϱ� ���� �޼ҵ� -was�� ���� �ڵ�ȣ��ȴ�
	//=> Ŭ���̾�Ʈ�� get ������� ��û�Ѱ�� ȣ��Ǵ� �޼ҵ�
	//=> �Ϲ������� doget ����� ���� ����.
	
	//doPost() : form �±׸� ����ؾ� ��û�Ҽ� �ִ�.
	//=> Ŭ���̾�Ʈ�� post ������� ��û�Ѱ�� ȣ��Ǵ� �޼ҵ�
	//=> form �±��Ҷ� ���.
	
	//doget,dopost �޼ҵ��� service �޼ҵ� �������̵� ����
	//����) service ���ԵǸ� doget,dopost ����!!
	//service() : Ŭ���̾�Ʈ�� ��� ��û�� ���� ȣ��Ǵ� �޼ҵ�
	//=> service() �޼ҵ��� ȣ�� �켱������ ���� �����Ǿ��ִ�.(doget,dopost����)
	
	//was�� ���� �޼ҵ尡 ȣ���� �ɶ�, �ؿ� 2�� �Ƚ��Ͻ��� �Ű������� �ڵ����� ���޵Ǿ� ����ȴ�.
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpServletRequest : ������Ʈ �޼���(��û����)�� ����� �ν��Ͻ�
		//HttpServletResponse : �������� �޼���(��������)�� ����� �ν��Ͻ�
		//��ü�� was �� ������ִϱ� ���� ���� ����ȴ�
		
		//3. Ŭ���̾�Ʈ���� ������ ����(����)�� ����(MimeType) ����(����)
		//����) HttpServletResponse.setContentType(String mimeType[;charset=encoding]) : 
		
		//������ �ƴ� �Ϲ������� ;charset=encoding �� �����Ѵ�
		//-> ������������ ������ ��� ������ ĳ���ͼ�(CharacterSet:���� ����-���ڵ�)�� �����ؾ��Ѵ�
		// �̰ɾ��ϸ� �⺻ ���乮������ : text/html, ĳ���ͼ� : ISO-8859-1(��������)
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		//4. Ŭ���̾�Ʈ ��û�� ���� ó�����(����)�� �����ϱ����� ��½�Ʈ���� ��ȯ�޾� ����
		//����) HttpServletResponse.getOutputStream() : ���õ�����(1Byte)�� �����Ҽ��ִ� ��½�Ʈ��(ServletOutputStream)��
		//��ȯ�ϴ� �޼ҵ�
		//=> �׸�, ���� ,���� ���� ���� Ŭ���̾�Ʈ���� �����ϱ����� ����� ����� ���� ��� ��Ʈ��
		
		//����) HttpServletResponse.getWriter() : ���ڵ� ó���� ���ڵ�����(2Byte)�� �����Ҽ��ִ� ��½�Ʈ��(PringWriter)��
		//��ȯ�ϴ� �޼ҵ�
		//=> PlainText,Html,Xml �������� Ŭ���̾�Ʈ���� �����ϱ����� ����� ��������� ��½�Ʈ��
		
		PrintWriter out = response.getWriter();
		//out �ȿ� ��������� ������ִ� ��½�Ʈ���� ���ִ°ž�!!!!
		
		//5.��û�� ó���� ó������� ����(����)�� ���� - ����
		//=> ��½�Ʈ���� ����Ͽ� ó������� �����ϸ� ����(����)�� �����ȴ�.
		//��½�Ʈ������ ���ڿ��� �����ϴ� �޼ҵ�
		out.println("<!DOCTYPE html>"); 
		out.println("<html>"); 
		out.println("<head>"); 
		out.println("<meta charset='utf-8'>"); 
		out.println("<title>Servlet</title>"); 
		out.println("</head>"); 
		out.println("<body>"); 
		out.println("<h1>����(servlet)</h1>"); 
		out.println("<hr>"); 
		out.println("<p>HELLO, SERVLET</p>"); 
		out.println("</body>"); 
		out.println("</html>"); 
		
		
		//��6.���� Ŭ������ �����α׷����� ����Ͽ� ����ǵ��� ����
		// => [web.xml] ���Ͽ��� ���� Ŭ������ �������� ����ϰ�, URL�ּҸ� ���μ���������Ѵ�.
		// ������Ʈ�� �ڿ��� ������ �����ִ� �ڿ����� ������ִ� ������ �������ش�.
		//=> ���ε� url �ּҷ� Ŭ���̾�Ʈ�� ������ ��û�ϸ� WAS�� Ŭ������ ��ü�� �����ϰ� ��ûó�� �޼ҵ带 
		// ȣ���Ͽ� ó���� ������ ����
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
