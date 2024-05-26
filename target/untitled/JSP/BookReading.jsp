<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <header>
    <button id="back-button">
      <img src="ctrelka.png" alt="Back">
    </button>
  </header>
  <title>Book Reading</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
    }

    #back-button {
      display: inline-block;
      padding: 5px;
      background-color: transparent;
      border: none;
      text-decoration: none;
      cursor: pointer;
    }

    #bookmark-button {
      position: absolute;
      top: 40px;
      right: 40px;
      padding: 10px;
      background-color: #4caf50;
      color: #fff;
      text-decoration: none;
    }

    #return-button {
      display: block;
      margin: 20px auto;
      padding: 10px;
      background-color: #4caf50;
      color: #fff;
      text-decoration: none;
      text-align: center;
      width: 120px;
    }

    #book-content {
      margin: 50px auto;
      max-width: 800px;
      padding: 20px;
      background-color: #f2f2f2;
    }

    #book-page {
      margin-bottom: 20px;
      text-align: center; /* Добавлено для центрирования */
    }

    #book-page iframe {
      margin: 0 auto; /* Добавлено для центрирования */
    }

    #next-page {
      text-align: center;
      margin-bottom: 20px;
    }

    #bookmarks-button {
      display: block;
      margin: 0 auto;
      padding: 10px 20px;
      background-color: #4caf50;
      color: #fff;
      text-decoration: none;
    }

    .bookmark-list {
      display: none;
      position: absolute;
      top: 60px;
      right: 20px;
      padding: 10px;
      background-color: #f2f2f2;
      border: 1px solid #ccc;
    }

    .bookmark-list.active {
      display: block;
    }

    .bookmark-list li {
      margin-bottom: 10px;
    }

    #search-container {
      text-align: center;
      margin-bottom: 20px;
    }

    #search-input {
      margin-right: 10px;
    }

    #search-button {
      padding: 5px 10px;
      background-color: #4caf50;
      color: #fff;
      border: none;
      cursor: pointer;
    }
  </style>
</head>
<body>
<a href="#" id="back-button"></a>
<a href="#" id="bookmark-button">Add Bookmark</a>

<div id="search-container">
  <input type="text" id="search-input" placeholder="Search">
  <button id="search-button">Search</button>
</div>

<div id="book-content">
  <div id="book-page">
    <iframe src="https://drive.google.com/file/d/1wBA8D9MEf-8_J2i0TnShbM1V8I9Fwwea/preview" width="640" height="480" allow="autoplay"></iframe>
  </div>

  <div id="next-page">
    <a href="#" id="next-page-link">Next Page</a>
  </div>

  <a href="#" id="bookmarks-button">My Bookmarks</a>

  <ul class="bookmark-list">
    <!-- Bookmarks should be listed here -->
    <li><a href="#">Bookmark 1</a></li>
    <li><a href="#">Bookmark 2</a></li>
    <li><a href="#">Bookmark 3</a></li>
  </ul>
</div>

<a href="#" id="return-button">Return</a>

<script>
  var backLink = document.getElementById('back-button');
  var bookmarkButton = document.getElementById('bookmark-button');
  var bookmarksButton = document.getElementById('bookmarks-button');
  var bookmarkList = document.querySelector('.bookmark-list');
  var returnButton = document.getElementById('return-button');
  var searchButton = document.getElementById('search-button');

  backLink.addEventListener('click', function(e) {
    e.preventDefault();
    window.history.back();
  });

  bookmarkButton.addEventListener('click', function() {
    alert('Bookmark added!');
  });

  bookmarksButton.addEventListener('click', function(e) {
    e.preventDefault();
    bookmarkList.classList.toggle('active');
  });

  returnButton.addEventListener('click', function(e) {
    e.preventDefault();
    // Replace "k" with the page number you want to return to
    window.location.href = 'BookReading.jsp?page=k';
  });

  searchButton.addEventListener('click', function(e) {
    e.preventDefault();
    var searchInput = document.getElementById('search-input').value;
    var bookPage = document.getElementById('book-page');
    var bookPages = bookPage.getElementsByTagName('p');
    var foundPage = null;

    for (var i = 0; i < bookPages.length; i++) {
      if (bookPages[i].textContent.toLowerCase().includes(searchInput.toLowerCase())) {
        foundPage = bookPages[i];
        break;
      }
    }

    if (foundPage) {
      foundPage.scrollIntoView({ behavior: 'smooth', block: 'start' });
      foundPage.style.backgroundColor = 'yellow';
      setTimeout(function() {
        foundPage.style.backgroundColor = '';
      }, 3000);
    } else {
      alert('Page not found.');
    }
  });
</script>
</body>
</html>