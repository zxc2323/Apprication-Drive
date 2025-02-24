package ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UtilisateurDAO;

/**
 * Servlet implementation class ctrlRegister
 */
@WebServlet("/Register")
public class ctrlRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ctrlRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Username = request.getParameter("Username");
		String Adresse = request.getParameter("Adresse");
		String Nom = request.getParameter("Nom");
		String Prenom = request.getParameter("Prenom");
		String Password = request.getParameter("Password");
		
		UtilisateurDAO UDAO = new UtilisateurDAO();
		if(UDAO.insert(Username, Adresse, Nom, Prenom, Password)) {
			response.sendRedirect("Login.jsp");
			
		}
		
		
	}

}
