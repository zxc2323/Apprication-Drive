

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ajax.Bd.Bd;
import metier.Produit;

/**
 * Servlet implementation class ServletCommandeChoisis
 */
@WebServlet("/ServletCommandeChoisis")
public class ServletCommandeChoisis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCommandeChoisis() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idCommande = request.getParameter("idCommande");

        if (idCommande == null || idCommande.isEmpty()) {
            response.sendRedirect("commandes.jsp");
            return;
        }

        try {
            ArrayList<Produit> produits = Bd.recuperer1Commande(idCommande);
            request.setAttribute("produits", produits);
            request.setAttribute("idCommande", idCommande);
            request.getRequestDispatcher("la_commande.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String idCommande = request.getParameter("idCommande");

	        if (idCommande == null || idCommande.isEmpty()) {
	            response.sendRedirect("commandes.jsp");
	            return;
	        }

	        try {
	            Bd.changerEtatCommande(idCommande, "EN_PREPARATION");
	            response.sendRedirect("commandes.jsp");
	        } catch (SQLException | ClassNotFoundException e) {
	            e.printStackTrace();
	            response.sendRedirect("error.jsp");
	        }
	 }
}


