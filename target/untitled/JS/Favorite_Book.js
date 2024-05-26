const toggleList = document.getElementById('toggle-list');
const myList = document.getElementById('my-list');

toggleList.addEventListener('click', function() {
    if (myList.style.display === 'none') {
        myList.style.display = 'block';
        toggleList.textContent = 'Даты чтения:';
    } else {
        myList.style.display = 'none';
        toggleList.textContent = 'Сколько раз прочел: ...';
    }
});
function expandImage(img) {
    img.classList.toggle("expanded");
}