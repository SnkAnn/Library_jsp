<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
  <meta charset="UTF-8">
  <title>Library</title>
  <link rel="stylesheet" href="../CSS/UserPage.css">
</head>
<body>
<div class="hamburger-menu">
  <input id="menu__toggle" type="checkbox" />
  <label class="menu__btn" for="menu__toggle">
    <span></span>
  </label>
  <ul class="menu__box">
    <li><a class="menu__item" href="/JSP/Favorite_Book.jsp">Мои прочтенные книги</a></li>
  </ul>
</div>
<div class="person">

  <a><div class="profile-image"><img  width="200px" height=" 220px", src="../Images/person.gif "></div><p1>Описание какой я красивый...........................................................................</p1></a>
  <a1>
    <button onclick="AddBook()">Мои книги</button>
    <br>
    <button onclick="selectProfileImage()">Выбрать фотографию</button>

  </a1>
  <a2> <button onclick="continueReading()">Продолжить прочтение</button>
    <br>
    <button onclick="editDescription()">Изменить</button>
  </a2>
  <a3> ..... </a3>
</div>
<script src="../JS/UserPage.js"></script>
<input type="file" id="profile-image-input" style="display: none;" onchange="handleProfileImageChange(event)">
</body>
</html>

