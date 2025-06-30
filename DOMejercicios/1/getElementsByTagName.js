let parrafo = document.getElementsByTagName('p');
let imagenes = document.getElementsByTagName('img');
let botones = document.getElementsByTagName('button');
for (let i = 0; i < parrafo.length; i++) {
parrafo[i].style.color = 'blue';
}
for (let i = 0; i < imagenes.length; i++) {
console.log(imagenes[i].src);
}
for (let i = 0; i < botones.length; i++) {
botones[i].innerText = '¡Clic aquí!';
}