<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Genre</title>
    <link rel="stylesheet" href="../CSS/Genre.css" type="text/css"/>
</head>
<body>
<div class="subGenres-container">
    <c:forEach var="subGenre" items="${subGenres}">
        <a href="<c:url value='/JSP/SubGenre.jsp?genre=${subGenre}'/>">
            <button class="menu__item_button">${subGenre}</button>
        </a>
    </c:forEach>

</div>
<div class="hamburger-menu">
    <input id="menu__toggle" type="checkbox"/>
    <label class="menu__btn" for="menu__toggle">
        <span></span>
    </label>
    <ul class="menu__box">
        <li><a class="menu__item" href="">Pейтинг</a></li>
        <li><a class="menu__item" href="#">Популярность</a></li>
        <li><a class="menu__item" href="#">Недавно выложенные</a></li>
        <li><a class="menu__item" href="#">Давно выложенные</a></li>
    </ul>
</div>

<div class="books-container">
    <%-- Здесь будут отображаться книги выбранного жанра --%>
    <c:forEach var="book" items="${books}">
        <a>
            <img src="${book.image}" onclick="expandImage(this)">
            <p>Название: ${book.title}<br>Дата издания: ${book.addingTime}<br> Автор: ${book.author.login}<br> Жанр: ${book.genre}</p>
            <details>
                <summary>Описание книги</summary>
                <p>${book.text}</p>
            </details>
            <button style="width: 170pt; height: 30pt; background-color: whitesmoke; font-size: 15px; border-color: lightgrey;" onclick="window.location.href='/JSP/BookReading.jsp'">Начать читать</button>
        </a>
    </c:forEach>
</div>

<script src="../JS/Genre.js"></script>
</body>
</html>
