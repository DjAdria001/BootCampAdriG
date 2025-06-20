const canvas = document.getElementById('tetris');
const ctx = canvas.getContext('2d');

const nextCanvas = document.getElementById('next');
const nextCtx = nextCanvas.getContext('2d');

const holdCanvas = document.getElementById('hold');
const holdCtx = holdCanvas.getContext('2d');

const ROWS = 20;
const COLS = 12;
const BLOCK_SIZE = 20; // pixels per block (canvas scaled 240x400 for 12x20)

ctx.scale(BLOCK_SIZE, BLOCK_SIZE);
nextCtx.scale(20, 20);
holdCtx.scale(20, 20);

let dropCounter = 0;
let dropInterval = 1000; // initial drop speed in ms
let lastTime = 0;
let level = 1;
let storedPiece = null;
let canStore = true;
let nextPiece = null;
let gameOver = false;

const colors = [
  null,
  '#800080', // T - púrpura
  '#FFFF00', // O - amarillo
  '#FFA500', // L - naranja
  '#0000FF', // J - azul
  '#00FFFF', // I - cyan
  '#00FF00', // S - verde
  '#FF0000'  // Z - rojo
];

// Tablero vacío
function createMatrix(w, h) {
  const matrix = [];
  while (h--) {
    matrix.push(new Array(w).fill(0));
  }
  return matrix;
}

const arena = createMatrix(COLS, ROWS);

function createPiece(type) {
  switch (type) {
    case 'T': return [
      [0, 1, 0],
      [1, 1, 1],
      [0, 0, 0],
    ];
    case 'O': return [
      [2, 2],
      [2, 2],
    ];
    case 'L': return [
      [0, 0, 3],
      [3, 3, 3],
      [0, 0, 0],
    ];
    case 'J': return [
      [4, 0, 0],
      [4, 4, 4],
      [0, 0, 0],
    ];
    case 'I': return [
      [0, 0, 0, 0],
      [5, 5, 5, 5],
      [0, 0, 0, 0],
      [0, 0, 0, 0],
    ];
    case 'S': return [
      [0, 6, 6],
      [6, 6, 0],
      [0, 0, 0],
    ];
    case 'Z': return [
      [7, 7, 0],
      [0, 7, 7],
      [0, 0, 0],
    ];
  }
}

function randomPiece() {
  const pieces = 'TJLOSZI';
  return pieces[(pieces.length * Math.random()) | 0];
}

const player = {
  pos: {x: 0, y: 0},
  matrix: null,
  score: 0,
};

function collide(arena, player) {
  const m = player.matrix;
  const o = player.pos;
  for (let y = 0; y < m.length; ++y) {
    for (let x = 0; x < m[y].length; ++x) {
      if (
        m[y][x] !== 0 &&
        (arena[y + o.y] && arena[y + o.y][x + o.x]) !== 0
      ) {
        return true;
      }
    }
  }
  return false;
}

function merge(arena, player) {
  player.matrix.forEach((row, y) => {
    row.forEach((value, x) => {
      if (value !== 0) {
        arena[y + player.pos.y][x + player.pos.x] = value;
      }
    });
  });
}

function rotate(matrix, dir) {
  for (let y = 0; y < matrix.length; ++y) {
    for (let x = 0; x < y; ++x) {
      [matrix[x][y], matrix[y][x]] = [matrix[y][x], matrix[x][y]];
    }
  }
  if (dir > 0) matrix.forEach(row => row.reverse());
  else matrix.reverse();
}

function playerReset() {
  if (!nextPiece) nextPiece = createPiece(randomPiece());
  player.matrix = nextPiece;
  nextPiece = createPiece(randomPiece());
  player.pos.y = 0;
  player.pos.x = (arena[0].length / 2 | 0) - (player.matrix[0].length / 2 | 0);
  canStore = true;

  if (collide(arena, player)) {
    showGameOver();
  }

  updateScore();
}

function playerMove(dir) {
  player.pos.x += dir;
  if (collide(arena, player)) {
    player.pos.x -= dir;
  }
}

function playerDrop() {
  player.pos.y++;
  if (collide(arena, player)) {
    player.pos.y--;
    merge(arena, player);
    arenaSweep();
    playerReset();
    canStore = true;
  }
  // Puntos por bajar una casilla con flecha ↓
  player.score += 1;
  updateScore();
  dropCounter = 0;
}

function playerInstantDrop() {
  let distance = 0;
  while (!collide(arena, player)) {
    player.pos.y++;
    distance++;
  }
  player.pos.y--;

  // Puntos por caída rápida
  const instantPoints = distance * 2;
  player.score += instantPoints;

  merge(arena, player);
  playerReset();
  arenaSweep();
  canStore = true;
  updateScore();
}

function playerRotate(dir) {
  rotate(player.matrix, dir);
  if (collide(arena, player)) {
    rotate(player.matrix, -dir);
  }
}

function arenaSweep() {
  let rows = 0;
  outer: for (let y = arena.length -1; y >= 0; --y) {
    for (let x = 0; x < arena[y].length; ++x) {
      if (arena[y][x] === 0) continue outer;
    }
    const row = arena.splice(y, 1)[0].fill(0);
    arena.unshift(row);
    y++;
    rows++;
  }
  if (rows > 0) {
    const basePoints = rows * 100;
    let multiplier = 1;
    if (rows === 2) multiplier = 1.35;
    else if (rows === 3) multiplier = 1.75;
    else if (rows >= 4) multiplier = 2;

    player.score += Math.floor(basePoints * multiplier);
    updateScore();
  }
}

function drawMatrix(matrix, offset, context) {
  matrix.forEach((row, y) => {
    row.forEach((value, x) => {
      if (value !== 0) {
        context.fillStyle = colors[value];
        context.fillRect(x + offset.x, y + offset.y, 1, 1);

        // Añadimos borde neón
        context.strokeStyle = '#0ff';
        context.lineWidth = 0.05;
        context.strokeRect(x + offset.x + 0.03, y + offset.y + 0.03, 0.94, 0.94);
      }
    });
  });
}

function drawGrid(context, w, h) {
  context.strokeStyle = '#055';
  context.lineWidth = 0.03;
  for (let x = 0; x <= w; ++x) {
    context.beginPath();
    context.moveTo(x, 0);
    context.lineTo(x, h);
    context.stroke();
  }
  for (let y = 0; y <= h; ++y) {
    context.beginPath();
    context.moveTo(0, y);
    context.lineTo(w, y);
    context.stroke();
  }
}

function draw() {
  ctx.fillStyle = '#000';
  ctx.fillRect(0, 0, COLS, ROWS);

  drawMatrix(arena, {x: 0, y: 0}, ctx);
  drawMatrix(player.matrix, player.pos, ctx);
  drawGrid(ctx, COLS, ROWS);

  // siguiente pieza
  nextCtx.fillStyle = '#000';
  nextCtx.fillRect(0, 0, 4, 4);
  drawGrid(nextCtx, 4, 4);
  drawMatrix(nextPiece, {x: 0, y: 0}, nextCtx);

  // pieza guardada
  holdCtx.fillStyle = '#000';
  holdCtx.fillRect(0, 0, 4, 4);
  drawGrid(holdCtx, 4, 4);
  if (storedPiece) drawMatrix(storedPiece, {x: 0, y: 0}, holdCtx);
}

function updateScore() {
  document.getElementById('score').textContent = player.score;
  document.getElementById('level').textContent = level;

  const savedRecord = localStorage.getItem('tetris-record') || 0;
  if (player.score > savedRecord) {
    localStorage.setItem('tetris-record', player.score);
  }
  document.getElementById('record').textContent = Math.max(player.score, savedRecord);

  // Subir nivel por puntuación
  const nextLevelScore = level * 1000;
  if (player.score >= nextLevelScore) {
    level++;
    dropInterval *= 0.92;
  }

  // Barra progreso nivel
  const prevLevelScore = (level - 1) * 1000;
  let progress = (player.score - prevLevelScore) / 1000;
  progress = Math.min(Math.max(progress, 0), 1);
  document.getElementById('level-bar').style.width = (progress * 100) + '%';
}

function storePiece() {
  if (!canStore) return;
  if (storedPiece === null) {
    storedPiece = player.matrix;
    playerReset();
  } else {
    const temp = player.matrix;
    player.matrix = storedPiece;
    storedPiece = temp;
    player.pos.x = (arena[0].length / 2 | 0) - (player.matrix[0].length / 2 | 0);
    player.pos.y = 0;
  }
  canStore = false;
}

// Game Over y reinicio
function showGameOver() {
  gameOver = true;
  const goDiv = document.getElementById('game-over');
  document.getElementById('final-score').textContent = `Puntuación final: ${player.score}`;
  goDiv.style.visibility = 'visible';
  goDiv.style.opacity = '1';
}

function restartGame() {
  gameOver = false;
  const goDiv = document.getElementById('game-over');
  goDiv.style.opacity = '0';
  setTimeout(() => {
    goDiv.style.visibility = 'hidden';
  }, 300);

  arena.forEach(row => row.fill(0));
  player.score = 0;
  level = 1;
  dropInterval = 1000;
  storedPiece = null;
  nextPiece = null;
  canStore = true;
  playerReset();
  updateScore();
  lastTime = 0;
  dropCounter = 0;
  update();
}

function backToMenu() {
  window.location.href = '../MainMenu.html';
}

// Resetear récord
function resetRecord() {
  localStorage.setItem('tetris-record', 0);
  document.getElementById('record').textContent = 0;
}

// Control teclado
document.addEventListener('keydown', event => {
  if (gameOver) return;
  switch (event.key) {
    case 'ArrowLeft':
      playerMove(-1);
      break;
    case 'ArrowRight':
      playerMove(1);
      break;
    case 'ArrowDown':
      playerDrop();
      break;
    case 'ArrowUp':
      playerRotate(1);
      break;
    case 'c':
    case 'C':
      storePiece();
      break;
    case ' ':
      event.preventDefault();
      playerInstantDrop();
      break;
  }
});

document.getElementById('retry-btn').addEventListener('click', restartGame);
document.getElementById('menu-btn').addEventListener('click', backToMenu);

// Loop principal
function update(time = 0) {
  if (gameOver) return;
  const deltaTime = time - lastTime;
  lastTime = time;

  dropCounter += deltaTime;
  if (dropCounter > dropInterval) {
    playerDrop();
  }

  draw();
  requestAnimationFrame(update);
}

playerReset();
update();

