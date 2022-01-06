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

//입력페이지에서 전달된 멀티파트 폼데이터를 처리하기위한 클래스를 사용하여 서블릿작성
// => apache 그룹에서 배포한 commons-fileupload 라이브러리의 클래스 사용 - 선택적 파일 업로드
// => oreilly 그룹에서 배포한 cos 라이브러리의 클래스 사용 -무조건 파일 업로드

//oreilly 그룹에서 배포한 cos라이브러리 파일을 다운로드받아

//라이브러리파일이 자동으로 프로젝트에 빌드된다!


//file_upload.html 에서 전달된 입력값과 입력파일명을 반환받아 클랑이언트에게 응답하는 서블릿
//=> 모든 입력파일을 전달받아 서버디렉토리에 저장되도록 처리 - 업로드(upload)

@WebServlet("/upload.itwill")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//전달된 파일을 저장하기 위한 서버 디렉토리의 시스템 경로를 반환받아 저장
		//주의) was 프로그램 시작시 작업 디렉토리의 프로젝트가 웹디렉토리에 동기화처리되어 컨텍스트
		//변환되는데 작업 디렉토리에는 기존 업로드 파일이 없으므로 웹디렉토리의 업로드파일이 삭제된다
		//  => 작업 디렉토리에 없는파일은 웹디렉토리에서 삭제된다
		String saveDirectory=request.getServletContext().getRealPath("/upload");
		//System.out.println(saveDirectory);
		
		//multipartrequest 클래스로 인스턴스 생성
		// => 멀티파트 폼데이터를 처리하기 위한 기능을 제공하는 인스턴스
		// => 인스턴스를 생성하면 모든 입력파일을 전달받아 서버디렉토리에 저장
		
		//MultipartRequest(request, saveDirectory,int maxPostSize,String encoding);
		// request : 요청정보를 저장한 인스턴스
		// savedirectory : 전달 파일을 저장하기 위한 서버 시렉토리의 시스템 경로 전달
		// maxPostSize : 처리가능한 멀티파트 폼데이터 크기단위 - 단위: byte
		// encoding : 저장된 전달값의 캐릭터셋 전달 
		// policy : FileRenamePolicy 인스턴스전달
		// -> 파일업로드 처리시 입력파일과 같은 이름의 파일이 업로드되는 서버디렉토리에 이미 존재할경우
		// 전달파일의 이름을 자동으로 변경하는 인스턴스
		// 전달 안하면 기존파일을 전달파일로 덮어씌우기(overwrite)한다
		//DefaultFileRenamePolicy : 중복이름되면
		
		
		MultipartRequest mr = new MultipartRequest(request, saveDirectory,20*1024*1024 ,"utf-8",new DefaultFileRenamePolicy()); //20Mb
		
		
		
		//입력값을 반환받아 저장
		//MultipartRequest.getparameter
		String name = mr.getParameter("name");
		
		//입력 파일명을 반환받아 저장
		//multipartrequest.getoriginalfilename(String name): 멀티파트 폼데이터에 저장된 전달파일명
		/*
		String fileone = mr.getOriginalFileName("fileone");
		String filetwo = mr.getOriginalFileName("filetwo");
		*/
		//getFilesystemName() : 서버(웹)디렉토리에 저장된 업로드 파일명을 반환하는 메소드
		String fileone = mr.getFilesystemName("fileone");
		String filetwo = mr.getFilesystemName("filetwo");
		
		
		
		
		
		
		out.println("<!DOCTYPE html>"); 
		out.println("<html>"); 
		out.println("<head>"); 
		out.println("<meta charset='utf-8'>"); 
		out.println("<title>Servlet</title>"); 
		out.println("</head>"); 
		out.println("<body>"); 
		out.println("<h1>파일 업로드</h1>"); 
		out.println("<hr>"); 
		out.println("<p>올린이="+name+"</p>"); 
		out.println("<p>파일명-1="+fileone+"</p>"); 
		out.println("<p>파일명-2="+filetwo+"</p>"); 
		out.println("</body>"); 
		out.println("</html>"); 
		
		
		
		
		
	
	}

}

























