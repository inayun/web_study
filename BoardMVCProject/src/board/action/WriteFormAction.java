package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//글 입력 폼 처리
public class WriteFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, 
			HttpServletResponse response) throws Throwable {
		
		//제목글 답변글 구분
		
		int num = 0;
		int ref = 1;
		int step = 0;
		int depth = 0;
		
		try {
			
			if(request.getParameter("num")!=null) {
				num = Integer.parseInt(request.getParameter("num"));
				ref = Integer.parseInt(request.getParameter("ref"));
				step = Integer.parseInt(request.getParameter("step"));
				depth = Integer.parseInt(request.getParameter("depth"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//해당 뷰에서 사용할 속성
		request.setAttribute("num", num);
		request.setAttribute("ref", ref);
		request.setAttribute("step", step);
		request.setAttribute("depth", depth);
		
		//해당하는 뷰로 반환함
		return "/board/WriteForm.jsp";
		
		
	}

}
