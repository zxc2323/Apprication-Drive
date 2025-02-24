package ctrl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategorieDAO;
import dao.ProduitDAO;
import dao.RayonDAO;
import metier.*;

/**
 * Servlet implementation class ctrlProduit
 */
@WebServlet("/Produit")
public class ctrlProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ctrlProduit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProduitDAO PDAO = new ProduitDAO();
		CategorieDAO CDAO = new CategorieDAO();
		RayonDAO RDAO = new RayonDAO();
		
		ArrayList<Rayon> ListR = (ArrayList<Rayon>) RDAO.getAllRayons();
		ArrayList<Categorie> ListC = (ArrayList<Categorie>) CDAO.findAllCategorie();
		ArrayList<Produit> listProduits = (ArrayList<Produit>) PDAO.findAllProduits();
		
		
		request.setAttribute("ListP", listProduits);
		request.setAttribute("ListR", ListR);
		request.setAttribute("ListC", ListC);
		request.getRequestDispatcher("webfronts/Produit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
