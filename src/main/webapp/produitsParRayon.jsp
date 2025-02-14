<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="metier.Produit" %>


<html>
<head>
    <title>Produits par Rayon</title>
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
<h1>Liste des Produits du Rayon</h1>

<table border="1">
    <tr>
        <th>Nom</th>
        <th>Prix</th>
        <th>Description</th>
    </tr>
    <%
        List<Produit> produits = (List<Produit>) request.getAttribute("produits");
        if (produits != null && !produits.isEmpty()) {
            for (Produit p : produits) {
    %>
    <tr>
        <td><%= p.getLibellePro()%></td>
        <td><%= p.getPrixUnitaire() %> €</td>
        <td><%= p.getNutriscore() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="3">Aucun produit trouvé pour ce rayon.</td>
    </tr>
    <%
        }
    %>
</table>

<br>
<a href="index.html">Retour</a>
</body>
</html>
