const comodines = {
  comodin1: {
    nombre: "Comodín Payaso",
    descripcion: "Aumenta el multiplicador por cada carta del mismo palo.",
    sinergias: "Ideal con manos Flush o cartas de un mismo palo."
  },
  comodin2: {
    nombre: "Comodín Multiplicador",
    descripcion: "Duplica la puntuación de la mano si contiene figuras.",
    sinergias: "Mejor con escaleras reales o Full House con figuras."
  },
  comodin3: {
    nombre: "Comodín Caótico",
    descripcion: "Cambia de efecto cada ronda.",
    sinergias: "Difícil de predecir pero poderoso con Lucky Draw."
  }
};

function mostrarInfo(id) {
  const datos = comodines[id];
  if (datos) {
    document.getElementById("nombre-comodin").textContent = datos.nombre;
    document.getElementById("descripcion-comodin").textContent = datos.descripcion;
    document.getElementById("sinergias-comodin").textContent = "Sinergias: " + datos.sinergias;
  }
}
function mostrarTooltip(elemento, texto) {
  const tooltip = document.getElementById("tooltip");
  tooltip.textContent = texto;
  tooltip.style.display = "block";

  document.onmousemove = function(e) {
    tooltip.style.left = e.pageX + 10 + "px";
    tooltip.style.top = e.pageY + 10 + "px";
  };
}

function ocultarTooltip() {
  const tooltip = document.getElementById("tooltip");
  tooltip.style.display = "none";
  document.onmousemove = null;
}
const descripcion = document.getElementById('descripcion');

const descripciones = {
  jokers: "Cartas especiales con habilidades únicas que modifican tu juego.",
  decks: "Diferentes mazos que alteran la experiencia de cada partida.",
  pokerHands: "Combinaciones de cartas que generan puntos.",
  cardModifiers: "Mejoras o efectos que se añaden a cartas individuales.",
  shop: "Lugar donde compras cartas y mejoras.",
  tarot: "Cartas con efectos únicos de un solo uso.",
  planet: "Cartas que refuerzan combinaciones específicas.",
  spectral: "Cartas misteriosas con habilidades raras.",
  vouchers: "Bonificaciones permanentes o eventos especiales."
};

document.querySelectorAll('.card-icon').forEach(card => {
  card.addEventListener('mouseenter', () => {
    const tipo = card.dataset.tipo;
    descripcion.textContent = descripciones[tipo] || '';
    descripcion.classList.add('active');
  });

  card.addEventListener('mouseleave', () => {
    descripcion.textContent = '';
    descripcion.classList.remove('active');
  });
});
