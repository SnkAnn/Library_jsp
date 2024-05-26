<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Publish Your Book</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        header {
            position: absolute;
            top: 10px;
            left: 10px;
        }

        #publish-button {
            position: absolute;
            top: 10px;
            right: 10px;
            padding: 10px;
            background-color: #4caf50;
            color: #fff;
            text-decoration: none;
        }

        #book-form {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            margin-bottom: 20px;
            width: 600px;
            height: 400px;
            border: 1px solid #ccc;
            padding: 20px;
        }

        #search-input {
            margin-bottom: 10px;
            width: 200px;
            padding: 5px;
            border: 1px solid #ccc;
        }

        #page-number {
            margin-top: 20px;
            font-weight: bold;
        }

        #bookmarks-button {
            position: absolute;
            bottom: 20px;
            left: 20px;
            padding: 10px;
            background-color: #4caf50;
            color: #fff;
            text-decoration: none;
        }

        #return-button {
            position: absolute;
            bottom: 20px;
            left: 140px;
            padding: 10px;
            background-color: #4caf50;
            color: #fff;
            text-decoration: none;
        }

        #publish-file-button {
            display: block;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #4caf50;
            color: #fff;
            text-decoration: none;
        }

        .bookmark-list {
            position: absolute;
            bottom: 60px;
            right: 20px;
            padding: 10px;
            background-color: #f2f2f2;
            border: 1px solid #ccc;
        }

        .bookmark-list li {
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<header>
    <button id="back-button">
        <img src="ctrelka.png" alt="Back">
    </button>
</header>

<button id="publish-button">Publish</button>

<div id="book-container">
    <form id="book-form">
        <input type="text" id="search-input" placeholder="Search page...">
        <textarea rows="15" cols="70"></textarea>
        <div id="page-number">Page 1</div>
        <button id="continue-button">Continue</button>
        <input type="file" id="book-file-input" style="display: none;">
        <label for="book-file-input" id="publish-file-button">Publish File</label>
    </form>

    <ul class="bookmark-list">
        <li>Bookmark 1</li>
        <li>Bookmark 2</li>
        <li>Bookmark 3</li>
    </ul>
</div>

<a href="#" id="bookmarks-button">Bookmarks</a>
<a href="#" id="return-button">Return</a>

<script>
    var backButton = document.getElementById('back-button');
    var publishButton = document.getElementById('publish-button');
    var continueButton = document.getElementById('continue-button');
    var bookmarksButton = document.getElementById('bookmarks-button');
    var returnButton = document.getElementById('return-button');
    var bookFileInput = document.getElementById('book-file-input');

    backButton.addEventListener('click', function() {
        // Go back to the previous page
        history.back();
    });

    publishButton.addEventListener('click', function() {
        alert('Book published!');
    });

    continueButton.addEventListener('click', function() {
        // Increment the page number and update the display
        var pageNumber = parseInt(document.getElementById('page-number').textContent.replace('Page ', ''));
        pageNumber++;
        document.getElementById('page-number').textContent = 'Page ' + pageNumber;
    });

    bookmarksButton.addEventListener('click', function(e) {
        e.preventDefault();
        alert('Bookmarks');
    });

    returnButton.addEventListener('click', function(e) {
        e.preventDefault();
        // Return to the previous page
        history.back();
    });

    publishFileButton.addEventListener('click', function() {
        bookFileInput.click();
    });

    bookFileInput.addEventListener('change', function(e) {
        var file = e.target.files[0];
        var reader = new FileReader();

        reader.onload = function(e) {
            var content = e.target.result;
            // Perform actions with the file content
            console.log(content);
        };

        reader.readAsText(file);
    });
</script>
</body>
</html>