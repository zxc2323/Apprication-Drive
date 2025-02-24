package ctrl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.google.gson.Gson;

import dao.ProduitDAO;
import metier.Produit;

/**
 * Servlet implementation class ctrlComfirmerPanier
 */
@WebServlet("/ComfirmerPanier")
public class ctrlComfirmerPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ctrlComfirmerPanier() {
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
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");

	    Gson gson = new Gson();
	    CartRequest cartRequest = gson.fromJson(request.getReader(), CartRequest.class);

	    int productId = cartRequest.getProductId();
	    int quantity = cartRequest.getQuantity();
	    System.out.println("Product ID: " + productId);
	    System.out.println("Quantity: " + quantity);
	    
	    ProduitDAO PDAO = new ProduitDAO();
	    Produit NP = PDAO.getProduitById(productId);
	    HttpSession session = request.getSession();
	    HashMap<Produit, Integer> LP = (HashMap<Produit, Integer>) session.getAttribute("ListProduit");
	    
	    if (LP == null) {
	        LP = new HashMap<Produit, Integer>(); // 初始化购物车
	    }

	    if (LP.containsKey(NP)) {
	        int existingQuantity = LP.get(NP);
	        LP.put(NP, existingQuantity + quantity);
	    } else {
	        LP.put(NP, quantity);
	    }

	    session.setAttribute("ListProduit", LP);

	    response.getWriter().write(gson.toJson(new CartResponse("Product added to cart successfully!")));
       
	}
	private static class CartRequest {
        private int productId;
        private int quantity;

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }

	private static class CartResponse {
        private String message;

        public CartResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
