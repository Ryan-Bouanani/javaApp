<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.englishtest.pojos.Partie" %>
<%@ page import="com.englishtest.pojos.Question" %>
<%
    Partie partie = (Partie) session.getAttribute("partie");
    Question question = (Question) session.getAttribute("question");
    if (partie == null) {
        response.sendRedirect("index.jsp");
        return;
    }
%>
<html>
<head>
    <title>Jeu - English Test</title>
</head>
<body>
<h1>Question</h1>
<p>Conjuguez le verbe "<%= question.getVerbe().getBaseVerbale() %>" :</p>

<form action="GameServlet" method="post">
    <label>Prétérit :</label>

