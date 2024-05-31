<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Publish Your Book</title>
  <link rel="stylesheet" href="../CSS/BookAdding.css">
</head>
<body>
<header>

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