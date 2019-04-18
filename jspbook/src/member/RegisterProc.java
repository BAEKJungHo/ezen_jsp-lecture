package member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/registerProcServlet")
public class RegisterProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterProc() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");
		String address = request.getParameter("address");
		
		MemberDAO mDao = new MemberDAO();
		mDao.insertMember(new MemberDTO(password, name, birthday, address));
		mDao.close();
		
		response.sendRedirect("loginMain.jsp");
	}
	
}
