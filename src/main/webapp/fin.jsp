<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%
    session.invalidate();
%>
<html>
<head>
    <title>Fin de Partie</title>
</head>
<body>
    <h1>Partie terminée !</h1>
    <p>Merci d'avoir joué.</p>
    <a href="index.jsp">Retour à l'accueil</a>
</body>
</html>
