package ctrl;

import metier.Rayon;
import dao.RayonDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;

@WebServlet("/rayons")
public class ServletRayon extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/xml;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        System.out.println("RayonServlet.class - Récupération des rayons...");

        try {
            // 获取所有的 Rayon
            RayonDAO rayonDAO = new RayonDAO();
            List<Rayon> rayons = rayonDAO.getAllRayons();

            try (PrintWriter out = response.getWriter()) {
                out.println("<?xml version=\"1.0\"?>");
                out.println("<liste_rayons>");

                for (Rayon rayon : rayons) {
                    out.println("<rayon>");
                    out.println("<nom>" + rayon.getNomRayon() + "</nom>");
                    out.println("<id>" + rayon.getIdRayon() + "</id>");
                    out.println("</rayon>");
                }

                out.println("</liste_rayons>");

            } catch (Exception e) {
                System.err.println("Erreur lors de l'écriture de la réponse XML : " + e.getMessage());
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Requête invalide : " + e.getMessage());
            }
        } catch (Exception e) {
            System.err.println("Erreur serveur dans RayonServlet: " + e.getMessage());
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erreur serveur : " + e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
