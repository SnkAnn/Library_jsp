<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Book Reading Page</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
    }

    header {
      background-color: #f2f2f2;
      padding: 10px;
    }

    #back-button {
      display: inline-block;
      padding: 5px;
      background-color: transparent;
      border: none;
      text-decoration: none;
      cursor: pointer;
    }

    #back-button img {
      width: 20px;
      height: 20px;
    }

    #book-container {
      display: flex;
      align-items: flex-start;
    }

    #book-image {
      margin-top: 20px;
      margin-right: 20px;
      width: 200px;
      height: 300px;
      border: 1px solid #ccc;
    }

    #start-button {
      display: inline-block;
      padding: 10px 20px;
      background-color: #4caf50;
      color: #fff;
      text-decoration: none;
      margin-top: 40px;
    }

    #book-description {
      margin-top: 20px;
      width: 60%;
    }

    #reviews-form {
      margin-top: 20px;
      width: 80%;
    }

    #reviews-list {
      margin-top: 20px;
      list-style-type: none;
      padding: 0;
    }

    .review {
      margin-bottom: 10px;
      padding: 10px;
      background-color: #f2f2f2;
      border: 1px solid #ccc;
    }

    .review h4 {
      margin-top: 0;
    }

    .review p {
      margin-bottom: 0;
    }

    .leave-review-button {
      padding: 10px 20px;
      background-color: #4caf50;
      color: #fff;
      text-decoration: none;
    }
  </style>
</head>
<body>
<header>
  <button id="back-button">
    <img src="ctrelka.png" alt="Back">
  </button>
</header>

<div id="book-container">
  <div id="book-image">
    <img src="book.jpg" alt="Book">
  </div>

  <div id="book-description">
    <h2>Book Title</h2>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed tristique, nisi id hendrerit fringilla, leo erat efficitur turpis, sed pharetra dolor nisi in turpis.</p>
  </div>

  <div>
    <a id="start-button" href="BookReading.jsp">Start Reading</a>
  </div>
</div>

<div id="reviews-form">
  <h3>Reviews</h3>
  <ul id="reviews-list">
    <!-- Reviews should be listed here -->
    <li class="review">
      <h4>Review Title</h4>
      <p>Review Text</p>
    </li>
  </ul>
  <a class="leave-review-button" href="#" onclick="showReviewForm()">Leave a Review</a>
</div>

<div id="review-form" style="display: none;">
  <h3>Write a Review</h3>
  <form onsubmit="saveReview(event)">
    <label for="review-title">Title:</label>
    <input type="text" id="review-title" required><br>
    <label for="review-text">Text:</label>
    <textarea id="review-text" rows="4" required></textarea><br>
    <button type="submit">Save</button>
  </form>
</div>

<script>
  function showReviewForm() {
    var reviewForm = document.getElementById('review-form');
    reviewForm.style.display = 'block';
  }

  function saveReview(event) {
    event.preventDefault();
    var reviewTitle = document.getElementById('review-title').value;
    var reviewText = document.getElementById('review-text').value;

    var reviewList = document.getElementById('reviews-list');
    var reviewItem = document.createElement('li');
    reviewItem.classList.add('review');
    var reviewTitleElement = document.createElement('h4');
    reviewTitleElement.textContent = reviewTitle;
    var reviewTextElement = document.createElement('p');
    reviewTextElement.textContent = reviewText;

    reviewItem.appendChild(reviewTitleElement);
    reviewItem.appendChild(reviewTextElement);
    reviewList.appendChild(reviewItem);

    var reviewForm = document.getElementById('review-form');
    reviewForm.style.display = 'none';
  }
</script>

</body>
</html>