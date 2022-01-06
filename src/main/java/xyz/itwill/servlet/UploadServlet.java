package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

//�Է����������� ���޵� ��Ƽ��Ʈ �������͸� ó���ϱ����� Ŭ������ ����Ͽ� �����ۼ�
// => apache �׷쿡�� ������ commons-fileupload ���̺귯���� Ŭ���� ��� - ������ ���� ���ε�
// => oreilly �׷쿡�� ������ cos ���̺귯���� Ŭ���� ��� -������ ���� ���ε�

//oreilly �׷쿡�� ������ cos���̺귯�� ������ �ٿ�ε�޾�

//���̺귯�������� �ڵ����� ������Ʈ�� ����ȴ�!


//file_upload.html ���� ���޵� �Է°��� �Է����ϸ��� ��ȯ�޾� Ŭ���̾�Ʈ���� �����ϴ� ����
//=> ��� �Է������� ���޹޾� �������丮�� ����ǵ��� ó�� - ���ε�(upload)

@WebServlet("/upload.itwill")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//���޵� ������ �����ϱ� ���� ���� ���丮�� �ý��� ��θ� ��ȯ�޾� ����
		//����) was ���α׷� ���۽� �۾� ���丮�� ������Ʈ�� �����丮�� ����ȭó���Ǿ� ���ؽ�Ʈ
		//��ȯ�Ǵµ� �۾� ���丮���� ���� ���ε� ������ �����Ƿ� �����丮�� ���ε������� �����ȴ�
		//  => �۾� ���丮�� ���������� �����丮���� �����ȴ�
		String saveDirectory=request.getServletContext().getRealPath("/upload");
		//System.out.println(saveDirectory);
		
		//multipartrequest Ŭ������ �ν��Ͻ� ����
		// => ��Ƽ��Ʈ �������͸� ó���ϱ� ���� ����� �����ϴ� �ν��Ͻ�
		// => �ν��Ͻ��� �����ϸ� ��� �Է������� ���޹޾� �������丮�� ����
		
		//MultipartRequest(request, saveDirectory,int maxPostSize,String encoding);
		// request : ��û������ ������ �ν��Ͻ�
		// savedirectory : ���� ������ �����ϱ� ���� ���� �÷��丮�� �ý��� ��� ����
		// maxPostSize : ó�������� ��Ƽ��Ʈ �������� ũ����� - ����: byte
		// encoding : ����� ���ް��� ĳ���ͼ� ���� 
		// policy : FileRenamePolicy �ν��Ͻ�����
		// -> ���Ͼ��ε� ó���� �Է����ϰ� ���� �̸��� ������ ���ε�Ǵ� �������丮�� �̹� �����Ұ��
		// ���������� �̸��� �ڵ����� �����ϴ� �ν��Ͻ�
		// ���� ���ϸ� ���������� �������Ϸ� ������(overwrite)�Ѵ�
		//DefaultFileRenamePolicy : �ߺ��̸��Ǹ�
		
		
		MultipartRequest mr = new MultipartRequest(request, saveDirectory,20*1024*1024 ,"utf-8",new DefaultFileRenamePolicy()); //20Mb
		
		
		
		//�Է°��� ��ȯ�޾� ����
		//MultipartRequest.getparameter
		String name = mr.getParameter("name");
		
		//�Է� ���ϸ��� ��ȯ�޾� ����
		//multipartrequest.getoriginalfilename(String name): ��Ƽ��Ʈ �������Ϳ� ����� �������ϸ�
		/*
		String fileone = mr.getOriginalFileName("fileone");
		String filetwo = mr.getOriginalFileName("filetwo");
		*/
		//getFilesystemName() : ����(��)���丮�� ����� ���ε� ���ϸ��� ��ȯ�ϴ� �޼ҵ�
		String fileone = mr.getFilesystemName("fileone");
		String filetwo = mr.getFilesystemName("filetwo");
		
		
		
		
		
		
		out.println("<!DOCTYPE html>"); 
		out.println("<html>"); 
		out.println("<head>"); 
		out.println("<meta charset='utf-8'>"); 
		out.println("<title>Servlet</title>"); 
		out.println("</head>"); 
		out.println("<body>"); 
		out.println("<h1>���� ���ε�</h1>"); 
		out.println("<hr>"); 
		out.println("<p>�ø���="+name+"</p>"); 
		out.println("<p>���ϸ�-1="+fileone+"</p>"); 
		out.println("<p>���ϸ�-2="+filetwo+"</p>"); 
		out.println("</body>"); 
		out.println("</html>"); 
		
		
		
		
		
	
	}

}

























