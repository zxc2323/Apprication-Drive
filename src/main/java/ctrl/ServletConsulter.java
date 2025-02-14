package ctrl;

import dao.ProduitDAO;
import metier.Produit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;

@WebServlet("/ServletConsulter")
public class ServletConsulter extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/xml;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String saisie = request.getParameter("saisie");
        System.out.println("ServletConsulter.class_Recherche pour : " + saisie);

        try
        {
            if (saisie == null || saisie.trim().isEmpty()) {
                throw new IllegalArgumentException("Le mot-clé de recherche est vide !");
            }
            ProduitDAO pdtdao = new ProduitDAO();
            List<Produit> produits = pdtdao.getProduitsParMotCle(saisie);
            try(PrintWriter out = response.getWriter()){
                out.println("<?xml version=\"1.0\"?>");
                out.println("<liste_pdts>");

                for (Produit p : produits) {
                    out.println("    <produit>");
                    out.println("        <id>" + p.getIdPro() + "</id>");
                    out.println("        <nom>" + p.getLibellePro() + "</nom>");
                    out.println("        <prix>" + p.getPrixUnitaire() + "</prix>");
                    out.println("        <poids>" + p.getPoidsPro() + "</poids>");
                    out.println("        <nutriscore>" + p.getNutriscore() + "</nutriscore>");
                    out.println("    </produit>");
                }

                out.println("</liste_pdts>");

            } catch (Exception e) {
                System.err.println("Erreur d'entrée utilisateur : " + e.getMessage());
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Requête invalide : " + e.getMessage());
            }
        } catch (Exception e) {
            System.err.println("Erreur serveur dans ServletConsulter: " + e.getMessage());
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erreur serveur : " + e.getMessage());
        }


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
