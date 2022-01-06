package xyz.itwill.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




//���� ��¥�� �������� ������ �о� ������ Ŭ���̾�Ʈ�� ����(����)�ϴ� ����
//=> ���ó�¥�� �������� ������ ���°�� ���������� ������ �˸��¸޼���
//=> �������� ������ /WEB-INF/notice ������ �����(yyyyMMdd)�� �̿��Ͽ� �ۼ�


@WebServlet("/notice.itwill")
public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		/*
		//�ý����� ���� ��¥�� �ð������� ������date �ν��Ͻ��� �����Ͽ� ����
		Date now =new Date();
		//���ϴ� ������ ��¥�� �ð��� ����
		SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyyMMdd");
		*/
		//������ ���ƴ�
		String noticeFileName = new SimpleDateFormat("yyyyMMdd").format(new Date())+".txt";
		//������ �ܼ�Ȯ��
		//System.out.println(noticeFileName);
		
		//�������� ������ �ý��� ��θ� ��ȯ�޾� ����
		String noticeFilePath=request.getServletContext().getRealPath("/WEB-INF/notice/"+noticeFileName);
		/*
		FileInputStream in = new FileInputStream(noticeFilePath);
		BufferedInputStream bis = new BufferedInputStream(in);
		*/
		
		out.println("<!DOCTYPE html>"); 
		out.println("<html>"); 
		out.println("<head>"); 
		out.println("<meta charset='utf-8'>"); 
		out.println("<title>Servlet</title>"); 
		out.println("</head>"); 
		out.println("<body>"); 
		out.println("<h1 style='text-align :center'> �������� </h1>"); 
		out.println("<hr>"); 
		String displayNow =new SimpleDateFormat("yyyyMMdd").format(new Date());
		out.println("<p style='text-align :center'>["+displayNow+"]</p>");
		try {
			
			//�������� ������ ������ �б� ���� �Է½�Ʈ���� �����Ͽ� ����
			//=> ���ó�¥�� �������� ������ ���°�� 404 �߻�
			BufferedReader in = new BufferedReader(new FileReader(noticeFilePath));
			while(true) {
				String text=in.readLine();
				if(text==null) break; //EOF(end of file)�� ������ �ݺ�������
				if(text.equals("")) text="&nlsp;";
				out.println("<div>"+text+"</div>");
			}
			in.close();
			
		}catch(FileNotFoundException e) {
			out.println("<p>������ ���������� �����ϴ�</p>");
		}
		
		out.println("<br>"); 
		out.println("<div style='text-align :center'>"); 
		
		out.println("<button type='button' onclick='window.close();'>�ݱ�</button>"); 

		out.println("</body>"); 
		out.println("</html>"); 
		
		
		
		
	
	}

}
