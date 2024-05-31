<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Library</title>
    <link rel="stylesheet" href="../CSS/Library.css">
</head>
<body>
<div id="header"></div>
<a href="/login" target="_self" class="enter_link">Вход</a>
<a href="/registration" target="_self" class="reg_link">Регистрация</a>


<div class="hamburger-menu-1">
    <input id="menu__toggle_1" type="checkbox" />
    <label class="menu__btn_1" for="menu__toggle_1">
        <span></span>
    </label>
    <ul class="menu__box_1">
        <c:forEach var="genre" items="${genres}">
            <li><a class="menu__item_1" href="<c:url value='/Genre?genre=${genre}'/>">${genre}</a></li>
        </c:forEach>
    </ul>
</div>

<form class="Search">
    <textarea placeholder="Поиск"></textarea>
</form>
<div class="buttons-container">
    <form class="button_for_author">
        <button onclick="window.open('/JSP/Entrance.jsp')">Стать автором</button>
    </form>
    <form class="button_for_reading">
        <button onclick="window.open('/JSP/BookReading.jsp')">Продолжить прочтение</button>
    </form>
</div>
<div class="genres-container">
    <c:forEach var="genre" items="${genres}">
        <a href="<c:url value='/Genre?genre=${genre}'/>">
            <button class="menu__item_button">${genre}</button>
        </a>
    </c:forEach>
</div>

<script src="../JS/Library.js"></script>
</body>
</html>
