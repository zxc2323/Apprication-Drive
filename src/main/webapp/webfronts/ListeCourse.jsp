<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="metier.*" %>
<%@ page import="java.util.*" %>
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


<div class="container">
  <img src="./images/taoxin.png" alt="Heart" class="heart-image">
  <div class="text"><h1>Liste des Courses</h1></div>
</div>

<div>
<form>
<input type="text" class="TextR">
<input type="submit" class="TextB" value="chercher">
</form>
</div>

<table class="table">
<% 
            List<ListeCourse> listeCourses = (List<ListeCourse>) request.getAttribute("listeCourses");
            if (listeCourses != null) {
                for (int i=0;i<listeCourses.size();i++) {
                	if(i%4==0){
%>
                		<tr>
<%               	}
                	
%> 
          <td class="hover-shadow" id="<%= listeCourses.get(i).getIdListe() %>">
          <br><br><br><br><br>
		    <a href="LCindex?id=<%= listeCourses.get(i).getIdListe() %>">  
		      <%= listeCourses.get(i).getIdListe() %>: <%= listeCourses.get(i).getNomListe() %>
			</a> 
		  </td>   
        <% if(i%4==3&&i!=0){ %>
        				</tr>
       <%		}
            }
        }        
%>
</table>

<!--creation-->
<button class="blue-button" id="createButton">Create</button>

<div class="create" id="createDiv" style="display: none;">
    <label>Nom de List de Course : </label>
    <input id="inputData" type="text" placeholder="Nom">
    <br>
    <label>post-it : </label>
    <input id="inputData2" type="text" placeholder="pt">
    <br>
    <button onclick="sendRequest()">create</button>
</div>
<div class="resultat" id="resultat"></div> 

 
<br>
<br>

<script src="./js/LCMain.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</body>
</html>