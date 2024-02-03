document.getElementById('imagemInput').addEventListener('change', function(event) {
        var fileName = event.target.value.split('\\').pop();
        document.getElementById('caminhoImagem').value = 'img/' + fileName;
    });