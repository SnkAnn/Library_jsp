
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<div class="hamburger-menu-1">
  <input id="menu__toggle_1" type="checkbox" />
  <label class="menu__btn_1" for="menu__toggle_1">
    <span></span>
  </label>
  <ul class="menu__box_1">
    <li><a class="menu__item_1" href="Genre.jsp ">Сказки</a></li>
    <li><a class="menu__item_1" href="Genre.jsp ">Романы</a></li>
    <li><a class="menu__item_1" href="Genre.jsp  ">Поэмы</a></li>
    <li><a class="menu__item_1" href="Genre.jsp  ">Стихи</a></li>
    <li><a class="menu__item_1" href="Genre.jsp  ">Ужасы</a></li>
    <li><a class="menu__item_1" href="Genre.jsp ">Приключения</a></li>
  </ul>
</div>
<form class="Search">
  <textarea placeholder="Поиск"></textarea>
</form>
<form class="button_for_author">
  <!-- <button onclick="location.href='reg.html'">Стать автором</button> -->
  <button onclick="window.open('Entrance.jsp')">Стать автором</button>
</form>
<form class="button_for_reading">
  <!-- Без создания новой вкладки -->
  <!-- <button onclick="location.href='read.html'">Продолжить прочтение</button> -->
  <!-- Новая вкладка -->
  <button onclick="window.open('BookReading.jsp ')">Продолжить прочтение</button>
</form>
<a1><button class="menu__item_button" onclick="window.location.href='Genre.jsp  '" >Сказки</button></a1>
<a2><button class="menu__item_button" onclick="window.location.href='Genre.jsp '">Романы</button></a2>
<a3><button class="menu__item_button" onclick="window.location.href='Genre.jsp  '">Поэмы</button></a3>
<a4><button class="menu__item_button" onclick="window.location.href='Genre.jsp  '">Стихи</button></a4>
<a5><button class="menu__item_button" onclick="window.location.href='Genre.jsp  '">Ужасы</button></a5>
<a6><button class="menu__item_button" onclick="window.location.href='Genre.jsp '">Приключения</button></a6>
<a7> ..... </a7>
<script src="../JS/Library.js"></script>
</body>
</html>

