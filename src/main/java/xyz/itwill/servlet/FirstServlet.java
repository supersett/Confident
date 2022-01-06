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

//@WebServlet : ���� Ŭ������ �������� ����ϰ� URL �ּҸ� �����ϱ� ���� ������̼�(Annotation)
// => [web.xml] ������ servlet ������Ʈ �� servlet-mapping ������Ʈ�� ������ ��� ����
//@WebServlet ������̼� �Ӽ��� �̿��Ͽ� ���� �̸� �Ǵ� URL �ּҿ� ���� ���� ó�� ���� ����
// => name �Ӽ� : ���� �̸��� �Ӽ������� ���� - name �Ӽ��� �����ϸ� Ŭ�������� ���� �̸����� �ڵ� ����
// => value �Ӽ�(�ʼ�) : ������ ���� ��û URL �ּҸ� �Ӽ������� ���� - �ٸ� �Ӽ��� ���� ��� �Ӽ����� ���� ����
// => ������̼� �Ӽ��� , ��ȣ�� �����Ͽ� ���� ����
@WebServlet("/first.itwill")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//Ŭ���̾�Ʈ ��û�� ���� ��û ó�� �� ���� ����� �����ϱ� ���� �ڵ� ȣ��Ǵ� ��û ó�� �޼ҵ�
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���� ����� �������� �ʴ� ������ ��� ���� ����
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//��û ó�� �� ���� ��� ����
		// => �����α׷��� Ŭ���̾�Ʈ���� �ϰ��� �ִ� ����� �����Ͽ� ������ ������ ����
		Date now=new Date();//Date �ν��Ͻ� ���� - ���� �ý����� ���� ��¥�� �ð� ����
		//SimpleDateFormat �ν��Ͻ� ���� - ��¥�� �ð��� ���� ���� ���� ����
		SimpleDateFormat simpleDateFormat
			=new SimpleDateFormat("yyyy�� MM�� dd�� HH�� mm�� ss��");
		//SimpleDateFormat �ν��Ͻ��� format() �޼ҵ带 ȣ���Ͽ� ���� ��¥�� �ð���
		//���ϴ� ������ ���ڿ��� ��ȯ�Ͽ� ��ȯ�޾� ����
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
		out.println("<h1>���� �ð�</h1>");
		out.println("<hr>");
		out.println("<p>"+displayNow+"</p>");
		out.println("<script type='text/javascript'>");
		out.println("setInterval(function() { location.reload(); },1000)");
		out.println("</script>");
		out.println("</body>");
		out.println("</html>");
	}

}

































