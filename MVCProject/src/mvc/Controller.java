package mvc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	//명령어(String)와 명령어 처리 클래스(Object)를 쌍으로 저장
	//명령어와 처리 클래스가 매핑되어 있는 'properties 파일(Command.properties)'을 읽어서 
	//Map객체인 commandMap에 저장
	private Map<String, Object> commandMap = new HashMap<String, Object>();
	
	@SuppressWarnings({ "deprecation", "rawtypes" })
	public void init(ServletConfig config) throws ServletException {
		
		//web.xml에서 propertyConfig에 해당하는 init-param의 값을 읽어옴
		String props = config.getInitParameter("propertyConfig");
		
		
		Properties pr = new Properties();
		//web-inf 아래에 있는 properties파일들을 다 가져옴
		String path = config.getServletContext().getRealPath("/WEB-INF");
		
		FileInputStream f = null;
		
		System.out.println(props);
		System.out.println(path);

		try {
			f = new FileInputStream(new File(path,props));
			pr.load(f);
		} catch(IOException e) {
			throw new ServletException(e);
		} finally {
			if(f!=null) try {f.close();} catch(IOException ex) {}
		}
 		
		Iterator<Object> keyIter = pr.keySet().iterator();
		while(keyIter.hasNext()) {
			String command = (String)keyIter.next(); //  /mvc/message.do (키)
			String className = pr.getProperty(command); // mvc.MessageProcess (밸류)
			
			try { //해당 문자열을 클래스로 만듦
				Class commandClass = Class.forName(className);
				//해당 클래스의 객체를 생성
				Object commandInstance = commandClass.newInstance(); 
				commandMap.put(command, commandInstance);
			} catch(ClassNotFoundException e){
				throw new ServletException(e);
			} catch (InstantiationException e) {
				throw new ServletException(e);
			} catch(IllegalAccessException e) {
				throw new ServletException(e);
			}
		}//while
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		requestPro(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		requestPro(request, response);
	}

	protected void requestPro(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String view = null;
		CommandProcess com = null;
		
		
		//getRequestURI : 프로젝트와  파일 경로까지 가져옴
		try {
			String command = request.getRequestURI();
			
		//getContextPath : 프로젝트 경로만 가져오기
			if(command.indexOf(request.getContextPath()) == 0) {
				command = command.substring(request.getContextPath().length());
				
			}
			
			com = (CommandProcess)commandMap.get(command);
			view = com.requestPro(request, response);
			
		} catch(Throwable e) {
			throw new ServletException(e);
		}
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher(view);
				
		dispatcher.forward(request, response);
	}
	
	
}
