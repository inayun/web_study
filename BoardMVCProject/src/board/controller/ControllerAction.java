package board.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import board.action.CommandAction;

//@WebServlet("/ControllerAction")
public class ControllerAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	//명령어와 명령어 처리 클래스를 쌍으로 맵에 저장
	private Map<String,Object> commandMap =
			new HashMap<String,Object>();
	
	//명령어 처리 클래스가 매핑되어있는 properties 파일을 읽어서 
	//Map 객체인 commandMap에 저장
	
	//명령어와 처리클래스가 매핑되어있는 properties 파일은 CommandPro.properties파일
	
	
	
	public void init(ServletConfig config) throws ServletException {
		
		//web.xml 파일에서 properyConfig에 해당하는 init-param의 값을 얻어와서 변수에 저장
		String props = config.getInitParameter("propertyConfig");
		
		//명령어와 처리클래스의 매핑정보를 저장할 properties 객체를 생성
		Properties pr = new Properties();
		
		//파일을 읽어올 파일 객체 생성
		FileInputStream f = null;
		
		//context 경로를 저장할 변수를 선언하여 경로 지정
		String path = config.getServletContext().getRealPath("/WEB-INF");
		
		try {
			
			//properties 파일의 내용을 읽어옴. 파일 처리시 예외처리
			//Command.properties 파일의 내용 읽어옴
			f = new FileInputStream(new File(path,props));
			
			//properties객체에 load()를 통해서 객체를 저장
			pr.load(f);
		} catch(IOException e) {
			throw new ServletException(e);
		} finally {
			if(f!=null) try {f.close();}catch(IOException e){}
		}
		
		//Iterator 객체를 통해서 properties에 저장되어 있는 객체를 하나씩 꺼내옴
		//맵으로 설정되어 있으며 키값을 통해서 가져옴
		Iterator<Object> keyIter = pr.keySet().iterator();
		//키값을 저장하고 있는 keySet() 메소드를 통해서 Iterator 인터페이스에 있는 
		//iterator() 메소드를 이용하여 하나씩 꺼내옴
		
		//키값이 여러개 이므로 while문 이용
		while(keyIter.hasNext()) {
			//키 값을 이용하여 꺼낸후 해당 문자열을 클래스로 만듦
			//클래스로 만든후 저장할 클래스 변수 선언
			String command = (String)keyIter.next();
			String className = pr.getProperty(command);
			
			
			//클래스 예외사항을 처리해야 하므로  try~catch문 사용
			try {
				Class commandClass = Class.forName(className);
				Object commandInstance = commandClass.newInstance();
				//해당하는 클래스의 객체를 생성함
				//생성한 객체를 Map 객체인 commandMap 객체에 저장
				
				commandMap.put(command, commandInstance);
				
			} catch(ClassNotFoundException e) {
				throw new ServletException(e);
			} catch(InstantiationException e) {
				throw new ServletException(e);
			} catch(IllegalAccessException e) {
				throw new ServletException(e);
			}
		}
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request,response);
	}
	
	protected void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//사용자의 분석을 처리
		
		String view = null;
		CommandAction com = null;
		
		try {
			String command = request.getRequestURI();
			
			if(command.indexOf(request.getContextPath()) == 0) {
				command = command.substring(request.getContextPath().length());
			}
		
			com = (CommandAction)commandMap.get(command);
			view = com.requestPro(request, response);
		} catch(Throwable e) {
			throw new ServletException(e);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
		
		
	}
}
