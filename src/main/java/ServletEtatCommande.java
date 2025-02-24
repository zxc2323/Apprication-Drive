

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ajax.Bd.Bd;

/**
 * Servlet implementation class ServletAnnulerCommande
 */
@WebServlet("/ServletEtatCommande")
public class ServletEtatCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEtatCommande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String idCommande = request.getParameter("idCommande");
	    String etat = request.getParameter("etat");

	    try {
	        // Vérification correcte des états
	        if ("EN_PREPARATION".equals(etat) || "LIVREE".equals(etat)) {
	            // Mettre à jour l'état dans la base de données
	            Bd.changerEtatCommande(idCommande, etat);
	            response.setStatus(HttpServletResponse.SC_OK);
	        } else {
	        	Bd.changerEtatCommande(idCommande, etat);
	            response.sendRedirect("commandes.jsp");
	        }
	    } catch (Exception e) {
	        // En cas d'erreur, retour à une page d'erreur
	        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	    }
	}


}
