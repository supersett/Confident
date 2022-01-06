package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//������ Ŭ���̾�Ʈ ��û�� ���� was�� ��ϵ� ����Ŭ������ �о� �޸𸮿� 
// �����ϰ� (Loading) Ŭ����,, ���� �ν��Ͻ��� �����Ͽ� service()�޼ҵ带 ȣ����
// ��û�� ���� ó���� �������� Ŭ���̾�Ʈ���� ����(����)

//=> �����ν��Ͻ��� �̹� ������ ��� ���� �ν��Ͻ��� �������� �ʰ�
// ���� ���� �ν��Ͻ��� service() �޼ҵ� ȣ��

//was�� �ֿ��� �� �ѳ��� ���� ���� �ν��Ͻ��� �����ϴ� �����̳�(web container)���

//�����̳� : �ν��Ͻ��� �����ֱ�(lifeCycle)�� ����(����,���,�Ҹ�)�ϴ� ���α׷�

//was�� ����Ǹ� ���� �����ν��Ͻ��� �Ҹ�ȴ�!!!!!!

@WebServlet("/life.itwill")
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String name;
	//������ : �ν��Ͻ��� �����ϱ� ���� Ư���� �޼ҵ�
	// => �ʱ�ȭ �۾� : �ʵ忡 �ʱⰪ ����
	// => Ŭ���̾�Ʈ ��û�� was ���α׷��� ���� ���� Ŭ������ �ν��Ͻ��� �����Ҷ� �ѹ��� ȣ��ȴ�
	
	public LifeCycleServlet() {
		System.out.println("###LifeCycleServlet Ŭ������ ������ȣ��");
	}

	//init() : was ���α׷��� ���� �ν��Ͻ��� �������ϰ� ���� ���� �ѹ��� ȣ���ϴ� �޼ҵ�
	//=> ������ ��ſ� init() �޼ҵ�� �ʵ� �ʱ�ȭ �۾��Ҷ� ���
	
	//������ ��� init �޼ҵ�� �ʱ�ȭ�۾� �ϴ� ���� : servletconfig �ν��Ͻ���
	//�Ű������� �����޾� �ʵ忡 �ʿ��� ���� ���� �ʵ尪���� �����Ҽ��ִ�.
	//ServletConfig : ���ؽ�Ʈ ���� ȯ�������� ������ �ν��Ͻ�
	//=> [web.xml]���Ͽ� ������ ���� �����޾� ��� ���� - ���������� ȿ���� ����
	//
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//ServletConfig.getServletContext: servletContext �ν��Ͻ� ��ȯ �޼ҵ�
		//servletContext.getInitParameter(String name) : [web.xml]������ context-param ������Ʈ��
		//�����Ǵ� ���� ���� ��ȯ�ϴ� �޼ҵ�
		name = config.getServletContext().getInitParameter("name");
	}
	
	
	
	//service() : Ŭ���̾�Ʈ�� ��û���� was�� ���� �ݺ�ȣ��Ǵ� �޼ҵ�
	//=> Ŭ���̾�Ʈ ��û�� ���� ó���� ó������� �����Ͽ� ����
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("###LifeCycleServlet Ŭ������ service() �޼ҵ� ȣ��");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>"); 
		out.println("<html>"); 
		out.println("<head>"); 
		out.println("<meta charset='utf-8'>"); 
		out.println("<title>Servlet</title>"); 
		out.println("</head>"); 
		out.println("<body>"); 
		out.println("<h1>������ �����ֱ�</h1>"); 
		out.println("<hr>"); 
		out.println("<p>"+name+"��, �ȳ��ϼ���</p>"); 
		out.println("</body>"); 
		out.println("</html>"); 
		
	
	
	}
	
	//destroy() : was ���α׷��� ���� �ν��Ͻ��� �Ҹ��ϱ� ���� �ѹ��� ȣ���ϴ� �޼ҵ�
	// => was ���α׷� ����� ���� �ν��Ͻ��� was���α׷��� ���� �Ҹ�
	public void destroy() {
		System.out.println("##destroy �޼ҵ� ȣ��");
	}
	
	

}





















