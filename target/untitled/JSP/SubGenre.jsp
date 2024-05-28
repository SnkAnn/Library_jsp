<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Genre</title>
    <link rel="stylesheet" href="../CSS/SubGenre.css" type ="text/css"/>
</head>
<body>

<div class="books-container">
    <%-- Здесь будут отображаться книги выбранного под жанра --%>
    <c:forEach var="book" items="${books}">
        <a>
            <img src="${book.image}" onclick="expandImage(this)">
            <p>Название: ${book.title}<br>Дата издания: ${book.addingTime}<br> Автор: ${book.author.login}<br> Жанр: ${book.genre}</p>
            <details>
                <summary>Описание книги</summary>
                <p>${book.text}</p>
            </details>
            <button style="width: 170pt; height: 30pt; background-color: whitesmoke; font-size: 15px; border-color: lightgrey;" onclick="window.location.href='/TextOfBook?book=${book.title}&authorID=${book.authorLiteratureID}'">Начать читать</button>
        </a>
    </c:forEach>

</div>
<script src="../JS/Genre.js"></script>
</body>
</html>
