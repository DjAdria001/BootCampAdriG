function mostrarGenero() {
  const genero = document.getElementsByName("genero");
  for (let i = 0; i < genero.length; i++) {
    if (genero[i].checked) {
      document.getElementById("resultado1").textContent = `Campo seleccionado: ${genero[i].value}`;
    }
  }
}

function contarLenguajes() {
  const checks = document.getElementsByName("lenguajes");
  let contador = 0;
  checks.forEach((check) => {
    if (check.checked) contador++;
  });
  if (contador === 0) {
    document.getElementById("resultado2").textContent = `No has seleccionado ningún lenguaje`;
  } else if (contador === 1) {
    document.getElementById("resultado2").textContent = `Has seleccionado ${contador} lenguaje`;
  } else {
  document.getElementById("resultado2").textContent = `Has seleccionado ${contador} lenguajes`;
}
}

function sumarNotas() {
  const notas = document.getElementsByName("nota");
  let suma = 0;
  for (let i = 0; i < notas.length; i++) {
    suma += Number(notas[i].value);
  }
  document.getElementById("resultado3").textContent = `Suma total: ${suma}`;
}


