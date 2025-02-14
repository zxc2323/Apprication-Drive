package ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ListeCourseDAO;
import metier.ListeCourse;

/**
 * Servlet implementation class ctrlLCindex
 */
@WebServlet("/LCindex")
public class ctrlLCindex extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ctrlLCindex() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id1 = request.getParameter("id");
		int id= Integer.valueOf(id1);
		ListeCourseDAO lcdao = new ListeCourseDAO();
		ListeCourse lc = lcdao.findListeCourseById(id);
		request.setAttribute("lc", lc);
		request.getRequestDispatcher("webfronts/LCindex.jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/xml"); 
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		ListeCourseDAO listeCourseDAO = new ListeCourseDAO();
		String postit = request.getParameter("postit");
		System.out.println(postit);
		ListeCourse lc = new ListeCourse();
		//listeCourseDAO.insert(lc);

		out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	    out.println("<response>");
	    out.println("<status>" + postit + "</status>");
	    out.println("</response>");

	    out.close();
	}

}
