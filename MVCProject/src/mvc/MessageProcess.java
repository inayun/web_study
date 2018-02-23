package mvc;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MessageProcess implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		
		request.setAttribute("message", "파라미터 전달!");
		return "/mvc/process.jsp";
	}

}
