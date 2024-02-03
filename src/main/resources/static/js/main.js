document.getElementById('imagemInput').addEventListener('change', function(event) {
        var fileName = event.target.value.split('\\').pop();
        document.getElementById('caminhoImagem').value = 'img/' + fileName;
    });
    

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

const form = document.getElementById("contactForm");
const statusMessage = document.getElementById("status");

form.addEventListener("submit", async (e) => {
    e.preventDefault();
    const formData = new FormData(form);
    try {
        // Simulate sending data to server (you can replace this with an actual API call)
        await new Promise((resolve) => setTimeout(resolve, 1000));
        statusMessage.textContent = "Mensagem enviada com sucesso!";
        statusMessage.style.color = "green";
    } catch (error) {
        statusMessage.textContent = "Erro ao enviar a mensagem. Tente novamente mais tarde.";
        statusMessage.style.color = "red";
    }
});