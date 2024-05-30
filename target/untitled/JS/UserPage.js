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
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/User", true);
    xhr.setRequestHeader("Content-Type", "application/json");

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            // Обработка успешного ответа от сервера (если необходимо)
            console.log("URL успешно отправлен на сервер");
        }
    };

    xhr.send(JSON.stringify({ imageUrl: imageUrl }));
}


