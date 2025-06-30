let destacados = document.getElementsByClassName('destacado');
let titulo = document.getElementsByClassName('titulo');
let ocultos = document.getElementsByClassName('ocultar');

for (let i = 0; i < destacados.length; i++) {
    destacados[i].style.color = 'red';
}
for (let i = 0; i < titulo.length; i++) {
    titulo[i].style.fontSize = '5em';
}
for (let i = 0; i < ocultos.length; i++) {
    ocultos[i].style.display = 'none';
}