<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="metier.Produit" %>
<html>
<head>
    <title>Détails de la Commande</title>
</head>
<body>
    <h2>Produits de la Commande #<%= request.getAttribute("idCommande") %></h2>
    <table>
        <tr>
            <th>Image</th>
            <th>Libellé</th>
            <th>Poids</th>
            <th>Conditionnement</th>
            <th>Prix Unitaire (€)</th>
            <th>Prix/kg (€)</th>
            <th>Nutriscore</th>
        </tr>
        <%
            List<Produit> produits = (List<Produit>) request.getAttribute("produits");
            if (produits != null && !produits.isEmpty()) {
                for (Produit produit : produits) {
        %>
        <tr>
            <td><img src="<%= produit.getURLImage() %>" alt="Produit" width="50"></td>
            <td><%= produit.getLibellePro() %></td>
            <td><%= produit.getPoidsPro() %> g</td>
            <td><%= produit.getConditionnementPro() %></td>
            <td><%= produit.getPrixUnitaire() %></td>
            <td><%= produit.getPrixKg() %></td>
            <td><%= produit.getNutriscore() %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="7">Aucun produit dans cette commande.</td>
        </tr>
        <%
            }
        %>
    </table>

    <div class="buttons">
    <!-- Bouton Préparer avec AJAX -->
    <button id="preparer-btn" onclick="preparerCommande('<%= request.getAttribute("idCommande") %>')" 
            style="background-color: green; color: white;">
        Préparer
    </button>

    <!-- Bouton Terminer qui apparaîtra dynamiquement -->
    <button id="terminer-btn" onclick="terminerCommande('<%= request.getAttribute("idCommande") %>')" 
            style="display: none; background-color: blue; color: white;">
        Terminer
    </button>

    <!-- Bouton Annuler avec un formulaire classique -->
    <form action="ServletEtatCommande" method="post">
        <input type="hidden" name="idCommande" value="<%= request.getAttribute("idCommande") %>">
        <input type="hidden" name="etat" value="ANNULEE">
        <button type="submit" style="background-color: red; color: white;">Annuler</button>
    </form>
	</div>
<script src="js/fonctionXml.js"></script>
</body>
</html>
