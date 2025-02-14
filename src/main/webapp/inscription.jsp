<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inscription - English Test</title>
</head>
<body>
<h1>Inscription</h1>
<form action="InscriptionServlet" method="post">
    <label>Nom :</label>
    <input type="text" name="nom" required>

    <label>Prénom :</label>
    <input type="text" name="prenom" required>

    <label>Email :</label>
    <input type="email" name="email" required>

    <label>Mot de passe :</label>
    <input type="password" name="password" required>

    <label>Niveau :</label>
    <select name="niveau">
        <option value="Débutant">Débutant</option>
        <option value="Intermédiaire">Intermédiaire</option>
        <option value="Avancé">Avancé</option>
    </select>

    <label>Ville :</label>
    <input type="number" name="idVille" required>

    <button type="submit">S'inscrire</button>
</form>
<a href="index.jsp">Retour à l'accueil</a>
</body>
</html>
