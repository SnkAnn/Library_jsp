<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Entrance</title>
    <link rel="stylesheet" href="../CSS/Entrance.css">
</head>
<body>
<div id="ent_header">Вход</div>
<div id="entrance-form">
    <form action="#" method="post">
        <label for="username">Имя автора:</label>
        <input type="text" id="username" name="username">
        <label for="password">Пароль:</label>
        <input type="password" id="password" name="password">
        <input type="submit" value="Войти" onclick="window.open('UserPage.jsp')">
        <input type="submit" value="Зарегистрироваться" class="register-button" onclick="window.open('Registration.jsp')">
    </form>
</div>
</body>
</html>

