
function buscarJoker() {
  const jokers = [
    "Greedy Joker", "D6 Joker", "Brainstorm", "Hack", "Ride the Bus",
    "Sock and Buskin", "Throwback", "Swashbuckler", "Mime", "Hologram",
    "Eraser", "Madness", "Burglar", "Seeing Double", "Space Joker"
  ];
  const input = document.getElementById("buscador").value.toLowerCase();
  const resultados = jokers.filter(j => j.toLowerCase().includes(input));
  const ul = document.getElementById("resultados");
  ul.innerHTML = "";
  resultados.forEach(j => {
    const li = document.createElement("li");
    li.textContent = j;
    ul.appendChild(li);
  });
}

function mostrarDescripcion() {
  const p = document.getElementById("descripcion");
  p.style.display = (p.style.display === "none") ? "block" : "none";
}

function mostrarInfo(element) {
  if (!element.dataset.originalText) {
    element.dataset.originalText = element.textContent;
  }
  element.textContent = element.dataset.originalText + " - Joker especial";
  element.style.color = 'yellow';
}

function validarNombre() {
  const nombre = document.getElementById("nombre").value;
  alert("Hola, " + nombre.toUpperCase() + "!");
}

function validarEmail() {
  const email = document.getElementById("email").value;
  if (!email.includes("@")) {
    alert("Email inválido");
  }
}
