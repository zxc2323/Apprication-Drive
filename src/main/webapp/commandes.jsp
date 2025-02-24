<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="metier.Commande" %>
<%@ page import="metier.Etat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Commandes</title>
</head>
<body>
	<h2>Liste des Commandes à Préparer</h2>
    <table>
        <tr>
            <th>ID Commande</th>
            <th>État</th>
            <th>Date de Retrait</th>
            <th>Options</th>
        </tr>
        <%
            List<Commande> commandes = (List<Commande>) request.getAttribute("commandes");
            if (commandes != null && !commandes.isEmpty()) {
                for (Commande cmd : commandes) {
        %>
        <tr>
            <td><%= cmd.getIdCommande() %></td>
            <td><%= cmd.getEtatCommande() %></td>
            <td><%= cmd.getDateRetrait() %></td>
            <td><a href="ServletCommandeChoisis?idCommande=<%= cmd.getIdCommande() %>">Plus</a></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="3">Aucune commande disponible.</td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>