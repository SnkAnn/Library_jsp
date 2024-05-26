<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <meta charset="UTF-8">
    <title>Library</title>
    <link rel="stylesheet" href="../CSS/UserPage.css">
</head>
<body>
<%
    String prevPage = request.getHeader("Referer");
    String user = (String) request.getAttribute("user");
%>
<div class="success-message">
    <button class="close-button"  onclick="closeForm()" >×</button>
    <p class="text-of-success">Привет <%= user %></p>
</div>
<%--<%--%>
<%--    if(prevPage != null && prevPage.endsWith("Registration.jsp")){--%>
<%--%>--%>
<%--<div class="success-message">--%>
<%--    <img class="im_success" src="../Images/green-tick.gif" alt="Success"  width="300" height=auto top="30%" left="50%">--%>
<%--    <button class="close-button"  onclick="closeForm()" >×</button>--%>
<%--    <p class="text-of-success">Регистрация выполнена успешно!</p>--%>
<%--</div>--%>
<%--<%--%>
<%--    }--%>
<%--%>--%>
<!--<a href="javascript:history.back()"><img src="ctrelka.png"> </a>-->
<div class="hamburger-menu">
    <input id="menu__toggle" type="checkbox" />
    <label class="menu__btn" for="menu__toggle">
        <span></span>
    </label>
    <ul class="menu__box">
        <li><a class="menu__item" href="Favorite_Book.jsp">Топ моих книг</a></li>
        <li><a class="menu__item" href="#">Проекты</a></li>
        <li><a class="menu__item" href="#">Команда</a></li>
        <li><a class="menu__item" href="#">Блог</a></li>
        <li><a class="menu__item" href="#">Контакты</a></li>
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

