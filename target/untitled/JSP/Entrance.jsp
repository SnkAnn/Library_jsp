<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Entrance</title>
    <link rel="stylesheet" href="../CSS/Entrance.css">
</head>
<body>
<div id="ent_header">Вход</div>
<div id="entrance-form">
    <form action="/login" method="post">
        <label for="username">Имя автора:</label>
        <input type="text" id="username" name="username">
        <label for="password">Пароль:</label>
        <input type="password" id="password" name="password">
        <input type="submit" value="Войти">
        <input onclick="location.href='${pageContext.request.contextPath}/JSP/Registration.jsp'" type="button" value="Зарегистрироваться" class="register-button">
    </form>
</div>
<c:if test="${param.error != null}">
    <div class="error-message">
        <img src="../Images/red-cross.gif" alt="Error"  width="300" height=auto top="30%" left="50%">
        <button class="close-button" onclick="closeForm()">×</button>
        <p class="text-of-error">Login or password is not valid</p>
    </div>
</c:if>
<script src="../JS/Entrance.js"></script>
</body>
</html>

