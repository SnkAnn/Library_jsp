<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Registration</title>
    <link rel="stylesheet" href="../CSS/Registration.css">
</head>
<body>
<div id="reg_header">Регистрация</div>
<div id="registration-form">
    <form action="/registration" method="post">
        <label for="username">Имя пользователя:</label>
        <input type="text" id="username" name="username">
        <label for="email">Электронная почта:</label>
        <input type="text" id="email" name="email">
        <label for="password">Пароль:</label>
        <input type="password" id="password" name="password">
        <label for="confirm-password">Подтвердите пароль:</label>
        <input type="password" id="confirm-password" name="confirm-password">
        <input type="submit" value="Зарегистрироваться">

    </form>
</div>
<c:if test="${not empty requestScope.errors}">
    <div class="error-message">
        <img src="../Images/red-cross.gif" alt="Error"  width="300" height=auto top="30%" left="50%">
        <button class="close-button" onclick="closeForm()">×</button>
        <div style="color: red">
            <c:forEach var="error" items="${requestScope.errors}">
                <span>${error.message}</span><br>
            </c:forEach>
        </div>
    </div>
</c:if>
<script src="../JS/Entrance.js"></script>
</body>
</html>
