package xyz.itwill.servlet;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




//Ŭ���̾�Ʈ ��û�� ���� ����� �̹��� ������ �����ϱ� ���� ����
@WebServlet("/image.itwill")
public class SendImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//Ŭ���̾�Ʈ���� �̹��� ���Ϸ� ����ǵ��� ����
	//=> �̹��� ���Ϸ� �����ϹǷ� ĳ���ͼ� �̼���
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/png");
		
		//Ŭ���̾�Ʈ�� ����� �̹��� ������ �����ϱ� ���� ��½�Ʈ���� ��ȯ�޾� ����
		ServletOutputStream out = response.getOutputStream();
		
		//������ ����� �̹��������� �ý��� ��θ� ��ȯ�޾� �����Ѵ�.
		//request.getServletContext(): servletContext �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		
		//
		//���ؽ�Ʈ(Context) : ������(was)�� ���� ���� �� �ִ� �ڿ� - html���� , �̹�������
		
		//servletcontext : Ŭ���̾�Ʈ�� ��û���� ���ؽ�Ʈ����(���ڿ�)�� ������ �ν��Ͻ�
		//					-> ������ ����Ҽ��ִ� �ڿ�!
		
		//servletContext.getRealPath(String contextFilePath): ���ؽ�Ʈ ������ �ý��۰�� ��ȯ �޼ҵ�
		String filePath = request.getServletContext().getRealPath("/WEB-INF/tt.png");
		
		//�����ֿܼ� ��� - �����
		System.out.println("filePath ="+filePath);
	
		//������ ����� �̹��� ������ �б����� �Է½�Ʈ�� ����
		FileInputStream in = new FileInputStream(filePath);
		BufferedInputStream bis = new BufferedInputStream(in);
		//�Է½�Ʈ��(���� �̹�������)���� ���õ�����(1byte)�� �о� ��½�Ʈ��(Ŭ���̾�Ʈ��������)��\
		//����
		while(true) {
			int readByte=bis.read();
			if(readByte==-1) break; //EOF(end of file)�� ������ �ݺ�������
			out.write(readByte);//������ ����� ���õ����͸� �����Ͽ� ������ ����
			
		}
		
		
	}

}




















