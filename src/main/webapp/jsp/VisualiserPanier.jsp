<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Map" %>
<%@ page import="dao.PanierSession" %>
<html>
<head>
    <title>Mon Panier</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <link rel="stylesheet" href="css/main.css" />
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        function updateQuantite(produitId) {
            let nouvelleQuantite = $("#quantite_" + produitId).val();
            $.get("panier", { produitId: produitId, quantite: nouvelleQuantite }, function(data) {
                $(data).find("produit").each(function() {
                    let id = $(this).find("id").text();
                    let quantite = $(this).find("quantite").text();
                    if (quantite > 0) {
                        $("#quantite_" + id).val(quantite);
                    } else {
                        $("#row_" + id).remove();
                    }
                });
            }, "xml");
        }
    </script>
</head>
<body class="is-preload">
<!-- Nav -->
<nav id="nav">
    <ul class="container">
        <li><a href="#top">Top</a></li>
        <li><a href="#work">Work</a></li>
        <li><a href="/ProjetDAI_war/visualiserpanier">MonPanier</a></li>
        <li><a href="#contact">Contact</a></li>
    </ul>
</nav>
<h1>Mon Panier</h1>
<table border="1">
    <tr>
        <th>Picture</th>
        <th>Nom du Produit</th>
        <th>Prix (€)</th>
        <th>Quantité</th>
    </tr>
    <%
        PanierSession panier = (PanierSession) session.getAttribute("panier");
        if (panier == null) {
            panier = new PanierSession();
            session.setAttribute("panier", panier);
        }

        Map<Integer, Integer> produits = panier.getProduits();
        Map<Integer, String[]> produitsInfo = Map.of(
                101, new String[]{"iphone15.jpg", "iPhone 15", "1099"},
                102, new String[]{"macbookpro.jpg", "MacBook Pro", "2499"}
        );

        for (Map.Entry<Integer, Integer> entry : produits.entrySet()) {
            int produitId = entry.getKey();
            int quantite = entry.getValue();
            String[] details = produitsInfo.getOrDefault(produitId, new String[]{"unknown.jpg", "Produit inconnu", "0"});
    %>
    <tr id="row_<%= produitId %>">
        <td><img src="images/<%= details[0] %>" width="50"></td>
        <td><%= details[1] %></td>
        <td><%= details[2] %> €</td>
        <td>
            <input type="number" id="quantite_<%= produitId %>" value="<%= quantite %>" min="0">
            <button onclick="updateQuantite(<%= produitId %>)">Modifier</button>
        </td>
    </tr>
    <% } %>
</table>
</body>
</html>
