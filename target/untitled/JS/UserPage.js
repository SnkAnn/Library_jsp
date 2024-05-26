function closeForm() {
    document.querySelector('.success-message').style.display = 'none';
}
function selectProfileImage() {
    document.getElementById('profile-image-input').click();
}

function handleProfileImageChange(event) {
    var file = event.target.files[0];
    var reader = new FileReader();
    reader.onload = function (event) {
        document.getElementById('profile-image').src = event.target.result;
    };
    reader.readAsDataURL(file);
}

function editDescription() {
    var newDescription = prompt("Введите новое описание:");
    if (newDescription !== null) {
        document.querySelector('p1').innerText = newDescription;
        // Добавьте здесь код для сохранения описания
    }
}

function continueReading() {
    window.location.href = 'BookReading.jsp';
}

function uploadFile() {
    document.getElementById('book-file-input').click();
}

function handleFileUpload(event) {
    var file = event.target.files[0];
    var formData = new FormData();
    formData.append('file', file);

    var xhr = new XMLHttpRequest();
    xhr.open('POST', '/upload-file', true);
    xhr.onload = function() {
        if (xhr.status === 200) {
            var response = JSON.parse(xhr.responseText);
            var fileUrl = response.fileUrl;
            alert('Файл успешно загружен: ' + fileUrl);
        } else {
            alert('Ошибка при загрузке файла.');
        }
    };
    xhr.send(formData);

}
function AddBook() {
    window.location.href = 'BookAdding.jsp';
}