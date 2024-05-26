<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../CSS/Genre.css" type ="text/css"/>
</head>
<body>
<a1><button class="menu__item_button" onclick="window.location.href='SubGenre.jsp '" >Волшебные сказки</button></a1>
<a2><button class="menu__item_button" onclick="window.location.href='SubGenre.jsp '">Бельгийские сказки</button></a2>
<a3><button class="menu__item_button" onclick="window.location.href='SubGenre.jsp  '">Русские народные сказки</button></a3>
<a4><button class="menu__item_button" onclick="window.location.href='SubGenre.jsp '">Итальянские сказки</button></a4>
<a5><button class="menu__item_button" onclick="window.location.href='SubGenre.jsp '">Сказки для самых маленьких</button></a5>
<a6><button class="menu__item_button" onclick="window.location.href='SubGenre.jsp  '">Сказки о животных</button></a6>
<a7> ..... </a7>
<div class="hamburger-menu">
    <input id="menu__toggle" type="checkbox" />
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
<a>
    <img src="../Images/image_book.jfif " onclick="expandImage(this)"><p1> Дата издания: <br> Автор:  <br> Жанр: </p1>
    <p2><details>
        <summary>Описание книги</summary>
        <p>.............................................................................................................................................</p>
    </details></p2>
    <p3><button style=" width: 170pt; height: 30pt; background-color: whitesmoke;font-size: 15px; border-color: lightgrey;"
    >Начать читать</button></p3>
</a>
<script src="../JS/Genre.js"></script>
<a8> ..... </a8>
</body>
</html>
