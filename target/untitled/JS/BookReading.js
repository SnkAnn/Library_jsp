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