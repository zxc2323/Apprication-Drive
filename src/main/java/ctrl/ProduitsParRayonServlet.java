package ctrl;

import dao.ProduitDAO;
import metier.Produit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ProduitsParRayonServlet")
public class ProduitsParRayonServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProduitDAO produitDAO;

    @Override
    public void init() throws ServletException {
        produitDAO = new ProduitDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rayonIdParam = request.getParameter("rayonId");

        if (rayonIdParam == null || rayonIdParam.isEmpty()) {
            response.sendRedirect("index.html");
            return;
        }

        try {
            int rayonId = Integer.parseInt(rayonIdParam);
            List<Produit> produits = produitDAO.getProduitsParRayon(rayonId);

            request.setAttribute("produits", produits);
            request.getRequestDispatcher("/produitsParRayon.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect("index.html");
        }
    }
}



