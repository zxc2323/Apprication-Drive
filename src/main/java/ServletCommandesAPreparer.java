

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ajax.Bd.Bd;
import metier.Commande;

/**
 * Servlet implementation class ServletCommandesAPreparer
 */
@WebServlet("/ServletCommandesAPreparer")
public class ServletCommandesAPreparer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCommandesAPreparer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//HttpSession session = request.getSession();
    	String idUtil = (String) request.getParameter("idUtil");

        if (idUtil == null) {
            response.sendRedirect("login.jsp");// redirection vers page de connexion
            return;
        }

        try {
            ArrayList<Commande> commandes = Bd.recupererCommandes(idUtil);
            request.setAttribute("commandes", commandes);
            request.getRequestDispatcher("commandes.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }


	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
