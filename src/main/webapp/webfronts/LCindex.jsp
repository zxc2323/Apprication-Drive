<%@page import="metier.ListeCourse"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "metier.*" %>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List de Course</title>
<link rel="stylesheet" href="./css/LCMain.css" />

</head>
<body>
<!-- Nav -->
<div>
    <nav id="nav">
        <ul>
            <li><a href="#top">Top</a></li>
            <li><a href="#work">Work</a></li>
            <li><a href="#portfolio">Portfolio</a></li>
            <li><a href="#contact">Contact</a></li>
        </ul>
    </nav>
</div>

<% 
ListeCourse lc = (ListeCourse)request.getAttribute("lc"); 
%>
<h1><%= lc.getNomListe() %></h1>
<h2>Post-it</h2>
<div id="cont">1233212312</div>
<h2>Produit:</h2>


<button class="blue-button" id="ModifierButton">Modifier</button>

<a class="blue-button" id="SupprimerButton" href="ListCourse">Supprimer</a>
<div class="ModifierLC" id="ModifierLC" style="display: none;">
    <label>post-it : </label>
    <input id="ModifierPI" type="text" placeholder="pt">
    <br>
    <button onclick="sendRequest()">Modifier</button>
</div>
<div class="resultat" id="resultat"></div>

<script src="./js/index.js"></script>
</body>
</html>