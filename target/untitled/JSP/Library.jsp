<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
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
<a href="Entrance.jsp" target="_self" class="enter_link">Вход</a>
<a href="Registration.jsp" target="_self" class="reg_link">Регистрация</a>
<%
//    List<String> listOfGenres=new ArrayList<>();
// for(String genre:request.getParameterValues("genres")){
//    listOfGenres.add(genre);
// }
%>
<div class="hamburger-menu-1">
    <input id="menu__toggle_1" type="checkbox" />
    <label class="menu__btn_1" for="menu__toggle_1">
        <span></span>
    </label>
    <ul class="menu__box_1">
        <li><a class="menu__item_1" href="Genre.jsp">Енот</a></li>

        <c:forEach var="genre" items="${genres}">
         <!--   <li><a class="menu__item_1" href="Genre.jsp?genre=${genre.genre_id}">${genre.genre_name}</a></li>-->
            <li><a class="menu__item_1" href="Genre.jsp">${genre.name}</a></li>
        </c:forEach>
    </ul>
</div>
<form class="Search">
    <textarea placeholder="Поиск"></textarea>
</form>
<form class="button_for_author">
    <button onclick="window.open('Entrance.jsp')">Стать автором</button>
</form>
<form class="button_for_reading">
    <button onclick="window.open('BookReading.jsp ')">Продолжить прочтение</button>
</form>
<c:forEach var="genre" items="${genres}">
  <!--  <a><button class="menu__item_button" onclick="window.location.href='Genre.jsp?genre=${genre.id}'">${genre.name}</button></a>-->
    <a><button class="menu__item_button" onclick="window.location.href='Genre.jsp  '" >${genre.genre_name}</button></a>

</c:forEach>
<script src="../JS/Library.js"></script>
</body>
</html>