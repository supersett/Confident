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




//오늘 날짜의 공지사항 파일을 읽어 내용을 클라이언트에 전달(응답)하는 서블릿
//=> 오늘날짜의 공지사항 파일이 없는경우 공지사항이 없음을 알리는메세지
//=> 공지사항 파일은 /WEB-INF/notice 폴더에 년월일(yyyyMMdd)을 이용하여 작성


@WebServlet("/notice.itwill")
public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		/*
		//시스템의 현재 날짜와 시간정보를 저장한date 인스턴스를 생성하여 저장
		Date now =new Date();
		//원하는 패턴의 날짜와 시간의 정보
		SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyyMMdd");
		*/
		//가독성 미쳤다
		String noticeFileName = new SimpleDateFormat("yyyyMMdd").format(new Date())+".txt";
		//디버깅용 콘솔확인
		//System.out.println(noticeFileName);
		
		//공지사항 파일의 시스템 경로를 반환받아 저장
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
		out.println("<h1 style='text-align :center'> 공지사항 </h1>"); 
		out.println("<hr>"); 
		String displayNow =new SimpleDateFormat("yyyyMMdd").format(new Date());
		out.println("<p style='text-align :center'>["+displayNow+"]</p>");
		try {
			
			//공지사항 파일의 내용을 읽기 위한 입력스트림을 생성하여 저장
			//=> 오늘날짜의 공지사항 파일이 없는경우 404 발생
			BufferedReader in = new BufferedReader(new FileReader(noticeFilePath));
			while(true) {
				String text=in.readLine();
				if(text==null) break; //EOF(end of file)을 만나면 반복문종료
				if(text.equals("")) text="&nlsp;";
				out.println("<div>"+text+"</div>");
			}
			in.close();
			
		}catch(FileNotFoundException e) {
			out.println("<p>오늘은 공지사항이 없습니다</p>");
		}
		
		out.println("<br>"); 
		out.println("<div style='text-align :center'>"); 
		
		out.println("<button type='button' onclick='window.close();'>닫기</button>"); 

		out.println("</body>"); 
		out.println("</html>"); 
		
		
		
		
	
	}

}
