let parrafo = document.querySelectorAll('p');
let imagenes = document.querySelectorAll('img');
let botones = document.querySelectorAll('button');
parrafo.forEach(item => {
    item.style.color = 'blue';
});
imagenes.forEach(item => {
    console.log(item.src);
});
botones.forEach(item => {
        item.innerText = '¡Clic aquí!';
});