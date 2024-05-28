<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Book Reading</title>
  <link rel="stylesheet" href="../CSS/BookReading.css">
</head>
<body>
<a href="#" id="bookmark-button">Add Bookmark</a>

<div id="search-container">
  <input type="text" id="search-input" placeholder="Search">
  <button id="search-button">Search</button>
</div>

<div id="book-content">
  <div id="book-page">
    <p id="book-text">
      <!-- Текст книги будет загружен здесь -->
      <%= request.getAttribute("bookText") %>
    </p>
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

<script src="../JS/BookReading.js"></script>
</body>
</html>
