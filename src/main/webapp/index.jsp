<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.englishtest.pojos.Joueur" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%
  Joueur joueur = (Joueur) session.getAttribute("joueurConnecte");
  boolean isLoggedIn = (joueur != null);
%>
<html>
<head>
  <title>Accueil - English Test</title>
</head>
<body>
<h1>Bienvenue sur English Test</h1>

<% if (isLoggedIn) { %>
<p>Bonjour, <%= joueur.getPrenom() %> <%= joueur.getNom() %> !</p>
<a href="jeu.jsp">Commencer une partie</a> |
<a href="logout.jsp">Se déconnecter</a>
<% } else { %>
<form action="ConnexionServlet" method="post">
  <label>Email :</label>
  <input type="email" name="email" required>
  <label>Mot de passe :</label>
  <input type="password" name="password" required>
  <button type="submit">Se connecter</button>
</form>
<a href="inscription.jsp">Créer un compte</a>
<% } %>
</body>
</html>
