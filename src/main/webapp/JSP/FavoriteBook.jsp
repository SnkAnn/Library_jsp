<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
  <link rel="stylesheet" href="../CSS/FavoriteBook.css" type ="text/css"/>

</head>
<body>
<h1>Топ моих любимых <br>
  книг</h1>

<div class="books-container">
  <c:forEach var="book" items="${books}">
    <a>
      <img src="${book.image}" onclick="expandImage(this)">
      <p>Название: ${book.title}<br>Дата издания: ${book.addingTime}<br> Автор: ${book.author.login}<br> Жанр: ${book.genre}</p>
       <details>
        <summary>Описание книги</summary>
        <p>${book.text}</p>
      </details>
      <p></p>
      <button style="width: 170pt; height: 30pt; background-color: whitesmoke; font-size: 15px; border-color: lightgrey;" onclick="window.location.href='/TextOfBook?book=${book.title}&authorID=${book.authorLiteratureID}&userID=${userID}'">Начать читать</button>
    </a>
  </c:forEach>

</div>


<%--<a1><button id="toggle-list">Сколько раз прочел: ...</button>--%>
  <script src="../JS/FavoriteBook.js"></script>
</a1>
<a2> ..... </a2>
</body>
</html>
