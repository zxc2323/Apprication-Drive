package ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.PanierSession;

@WebServlet("/VisualiserPanierServlet")
public class VisualiserPanierServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // 检查用户是否登录
        Integer userId = (Integer) session.getAttribute("userId");

        // 获取 session 中的 panier（未登录时的购物车）
        PanierSession sessionPanier = (PanierSession) session.getAttribute("panier");

        PanierSession panier;

        // 用户未登录，使用 session 中的 panier
        if (sessionPanier == null) {
            panier = new PanierSession(userId);
            session.setAttribute("panier", panier);
        } else {
            panier = sessionPanier;
        }

        // 处理 AJAX 请求（修改数量）
        String produitIdParam = request.getParameter("produitId");
        String quantiteParam = request.getParameter("quantite");

        if (produitIdParam != null && quantiteParam != null) {
            int produitId = Integer.parseInt(produitIdParam);
            int nouvelleQuantite = Integer.parseInt(quantiteParam);
            panier.modifierQuantite(produitId, nouvelleQuantite);
        }

        // 生成 XML 响应
        response.setContentType("text/xml;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        out.println("<panier>");

        for (Map.Entry<Integer, Integer> entry : panier.getProduits().entrySet()) {
            out.println("  <produit>");
            out.println("    <id>" + entry.getKey() + "</id>");
            out.println("    <quantite>" + entry.getValue() + "</quantite>");
            out.println("  </produit>");
        }

        out.println("</panier>");
        out.flush();
    }
}

