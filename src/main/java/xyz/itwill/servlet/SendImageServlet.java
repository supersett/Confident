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




//클라이언트 요청에 의한 결과로 이미지 파일을 응답하기 위한 서블릿
@WebServlet("/image.itwill")
public class SendImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//클라이언트에게 이미지 파일로 응답되도록 설정
	//=> 이미지 파일로 응답하므로 캐릭터셋 미설정
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/png");
		
		//클라이언트에 응답될 이미지 파일을 생성하기 위한 출력스트림을 반환받아 저장
		ServletOutputStream out = response.getOutputStream();
		
		//서버에 저장된 이미지파일의 시스템 경로를 반환받아 저장한다.
		//request.getServletContext(): servletContext 인스턴스를 반환하는 메소드
		
		//
		//컨텍스트(Context) : 웹서버(was)에 의해 사용될 수 있는 자원 - html문서 , 이미지파일
		
		//servletcontext : 클라이언트가 요청ㅇ한 컨텍스트정보(웹자원)를 저장한 인스턴스
		//					-> 서블릿이 사용할수있는 자원!
		
		//servletContext.getRealPath(String contextFilePath): 컨텍스트 파일의 시스템경로 반환 메소드
		String filePath = request.getServletContext().getRealPath("/WEB-INF/tt.png");
		
		//서버콘솔에 출력 - 디버깅
		System.out.println("filePath ="+filePath);
	
		//서버에 저장된 이미지 파일을 읽기위한 입력스트림 생성
		FileInputStream in = new FileInputStream(filePath);
		BufferedInputStream bis = new BufferedInputStream(in);
		//입력스트림(서버 이미지파일)에서 원시데이터(1byte)를 읽어 출력스트림(클라이언트응답파일)로\
		//전달
		while(true) {
			int readByte=bis.read();
			if(readByte==-1) break; //EOF(end of file)을 만나면 반복문종료
			out.write(readByte);//변수에 저장된 원시데이터를 전달하여 응답결과 생성
			
		}
		
		
	}

}




















