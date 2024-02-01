const BurgerBtn = document.querySelector('.burger_btn');
const BurgerBtnIcon = document.querySelector('.burger_btn i');
const BurgerMenu = document.querySelector('.burger_menu');

BurgerBtn.onclick = function () {
    BurgerMenu.classList.toggle('open');
    const isOpen = BurgerMenu.classList.contains('open');
    BurgerBtnIcon.classList = isOpen
        ? 'fa-solid fa-xmark'
        : 'fa-solid fa-bars'
}