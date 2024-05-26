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
<a>
  <img src="../Images/book1.jpeg " onclick="expandImage(this)"><p1> Дата издания: <br> Автор:  <br> Жанр: </p1>
  <p2><details>
    <summary>Описание книги</summary>
    <p>.............................................................................................................................................</p>
  </details></p2>
</a>

<a1><button id="toggle-list">Сколько раз прочел: ...</button>
  <ul id="my-list" style="display: none;">
    <li>дата 1 = 78%</li>
    <li>дата 2 = 100%</li>
    <li>дата 3 = 100%</li>
  </ul>
  <script src="../JS/FavoriteBook.js"></script>
</a1>
<a2> ..... </a2>
</body>
</html>
