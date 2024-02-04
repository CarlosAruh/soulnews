document.addEventListener('DOMContentLoaded', function () {
    const BurgerBtns = document.querySelectorAll('.burger_btn');
  
    BurgerBtns.forEach(function (BurgerBtn) {
      BurgerBtn.addEventListener('click', function () {
        const BurgerMenu = this.closest('.navbar').querySelector('.burger_menu');
        const BurgerBtnIcon = this.querySelector('i');
  
        BurgerMenu.classList.toggle('open');
        const isOpen = BurgerMenu.classList.contains('open');
        BurgerBtnIcon.classList.toggle('fa-bars', !isOpen);
        BurgerBtnIcon.classList.toggle('fa-xmark', isOpen);
      });
    });
  });

document.getElementById('imagemInput').addEventListener('change', function(event) {
        var fileName = event.target.value.split('\\').pop();
        document.getElementById('caminhoImagem').value = 'img/' + fileName;
    });
    
const form = document.getElementById("contactForm");
const statusMessage = document.getElementById("status");

form.addEventListener("submit", async (e) => {
    e.preventDefault();
    const formData = new FormData(form);
    try {
        await new Promise((resolve) => setTimeout(resolve, 1000));
        statusMessage.textContent = "Mensagem enviada com sucesso!";
        statusMessage.style.color = "green";
    } catch (error) {
        statusMessage.textContent = "Erro ao enviar a mensagem. Tente novamente mais tarde.";
        statusMessage.style.color = "red";
    }
});

function handleEnter(event, formId) {
    if (event.key === "Enter") {
        event.preventDefault(); 
        document.getElementById(formId).submit();
        return false;
    }
    return true;
}