<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <meta charset="UTF-8">
    <title>Library</title>
    <link rel="stylesheet" href="../CSS/UserPage.css">
</head>
<body>

<div class="hamburger-menu">
    <input id="menu__toggle" type="checkbox"/>
    <label class="menu__btn" for="menu__toggle">
        <span></span>
    </label>
    <ul class="menu__box">
        <li><a class= "menu__item_1" href="<c:url value='/Library?userID=${userID}'/>">Вернуться на главную</a> </li>
        <li><a class="menu__item_1" href="<c:url value='/FavoriteBook?userID=${userID}'/>">Прочтенные мной книги</a></li>

    </ul>
</div>
<div class="person">
    <a>
        <div class="profile-image">
            <img id="profile-img" width="200px" height="220px" src="<%= request.getAttribute("userImage") %>">
        </div>
        <p1><%= request.getAttribute("userDescription") %>
        </p1>
    </a>
    <a1>
        <button onclick="AddBook()">Книги моего авторства</button>
        <br>
        <button onclick="selectProfileImage()">Сменить фотографию<br> профиля</button>
    </a1>
    <a2>
        <button onclick="continueReading()">Продолжить прочтение<br>последней книги</button>
        <br>
        <button onclick="editDescription()">Изменить описание</button>
    </a2>
    <a3></a3>
</div>
<input type="file" id="profile-image-input" style="display: none;" onchange="handleProfileImageChange(event)">
<script>
    function editDescription() {
        var newDescription = prompt("Введите новое описание:");
        if (newDescription !== null) {
            document.querySelector('p1').innerText = newDescription;
            sendDescriptionToServlet(newDescription);
        }
    }

    function sendDescriptionToServlet(description) {
        var userId = "<%= request.getAttribute("userID") %>";
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "/User", true);
        xhr.setRequestHeader("Content-Type", "application/json");

        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                console.log("Описание успешно сохранено в базе данных");
            } else if (xhr.readyState === 4) {
                console.error("Ошибка при сохранении описания: " + xhr.statusText);
            }
        };

        xhr.send(JSON.stringify({userID: userId, description: description}));
    }

    function continueReading() {
            window.location.href = '/TextOfBook?userID=${userID}&book=${lastBook}&authorID=${authorID}';

    }

        function AddBook() {
            window.location.href = '/UserPersonBooks?userID=${userID}';
        }

        function selectProfileImage() {
            document.getElementById('profile-image-input').click();
        }

        function handleProfileImageChange(event) {
            var input = event.target;
            var reader = new FileReader();

            reader.onload = function () {
                var dataURL = reader.result;
                var imgElement = document.getElementById('profile-img');
                imgElement.src = dataURL;
                sendImageUrlToServlet(dataURL);
            };

            reader.readAsDataURL(input.files[0]);
        }

        function sendImageUrlToServlet(imageUrl) {
            var userId = "<%= request.getAttribute("userID") %>";
            var xhr = new XMLHttpRequest();
            xhr.open("POST", "/User", true);
            xhr.setRequestHeader("Content-Type", "application/json");

            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    console.log("URL успешно отправлен на сервер");
                } else if (xhr.readyState === 4) {
                    console.error("Ошибка при отправке URL: " + xhr.statusText);
                }
            };

            xhr.send(JSON.stringify({userID: userId, imageUrl: imageUrl}));
        }
</script>
</body>
</html>
