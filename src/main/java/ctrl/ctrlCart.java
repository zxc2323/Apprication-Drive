package ctrl;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import metier.Produit;

/**
 * Servlet implementation class ctrlCart
 */
@WebServlet("/Cart")
public class ctrlCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ctrlCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		HashMap<Produit, Integer> LP = (HashMap<Produit, Integer>)session.getAttribute("ListProduit");
		float prix=0;
		if(LP!=null) {
		
		for (HashMap.Entry<Produit, Integer> entry : LP.entrySet()) {
			Produit key = entry.getKey();
	        Integer value = entry.getValue();
	        prix += key.getPrixUnitaire() * value;}
		}
		request.setAttribute("prix", prix);
		
		request.setAttribute("LP", LP);
		request.getRequestDispatcher("webfronts/Cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
