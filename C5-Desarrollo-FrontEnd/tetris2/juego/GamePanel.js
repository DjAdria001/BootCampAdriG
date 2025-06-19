// GamePanel.js
export class GamePanel {
  constructor(gameCanvas, nextCanvas, holdCanvas) {
    this.gameCtx = gameCanvas.getContext('2d');
    this.nextCtx = nextCanvas.getContext('2d');
    this.holdCtx = holdCanvas.getContext('2d');

    this.cols = 10;
    this.rows = 20;
    this.blockSize = 30;

    this.board = this.createBoard(this.rows, this.cols);

    // Piezas definidas con matrices
    this.pieces = {
      I: [[1,1,1,1]],
      O: [[1,1],[1,1]],
      T: [[0,1,0],[1,1,1]],
      S: [[0,1,1],[1,1,0]],
      Z: [[1,1,0],[0,1,1]],
      J: [[1,0,0],[1,1,1]],
      L: [[0,0,1],[1,1,1]],
    };

    this.colors = {
      I: 'cyan',
      O: 'yellow',
      T: 'magenta',
      S: 'lime',
      Z: 'red',
      J: 'blue',
      L: 'orange',
    };

    this.currentPiece = this.randomPiece();
    this.nextPiece = this.randomPiece();
    this.holdPiece = null;
    this.canHold = true;

    this.pos = {x: 3, y: 0};  // Posición inicial de la pieza

    this.initControls();

    this.draw();
    this.dropInterval = 1000;
    this.lastTime = 0;

    requestAnimationFrame(this.update.bind(this));
  }

  createBoard(rows, cols) {
    const board = [];
    for (let r=0; r<rows; r++) {
      board.push(new Array(cols).fill(0));
    }
    return board;
  }

  randomPiece() {
    const keys = Object.keys(this.pieces);
    const key = keys[Math.floor(Math.random()*keys.length)];
    return {shape: this.pieces[key], color: this.colors[key], type: key};
  }

  drawBlock(ctx, x, y, color, size=this.blockSize) {
    ctx.fillStyle = color;
    ctx.fillRect(x*size, y*size, size, size);
    ctx.strokeStyle = '#000';
    ctx.lineWidth = 2;
    ctx.strokeRect(x*size, y*size, size, size);
  }

  drawMatrix(ctx, matrix, offsetX, offsetY) {
    matrix.forEach((row, y) => {
      row.forEach((value, x) => {
        if (value) {
          this.drawBlock(ctx, x + offsetX, y + offsetY, this.currentPiece.color);
        }
      });
    });
  }

  draw() {
    this.clearCanvas(this.gameCtx, this.cols*this.blockSize, this.rows*this.blockSize);
    this.drawBoard();
    this.drawPiece(this.currentPiece.shape, this.pos.x, this.pos.y, this.currentPiece.color);

    this.drawNext();
    this.drawHold();
  }

  clearCanvas(ctx, width, height) {
    ctx.clearRect(0, 0, width, height);
  }

  drawBoard() {
    for (let y=0; y<this.rows; y++) {
      for (let x=0; x<this.cols; x++) {
        if (this.board[y][x]) {
          this.drawBlock(this.gameCtx, x, y, this.board[y][x]);
        } else {
          this.gameCtx.fillStyle = '#111';
          this.gameCtx.fillRect(x*this.blockSize, y*this.blockSize, this.blockSize, this.blockSize);
          this.gameCtx.strokeStyle = '#222';
          this.gameCtx.strokeRect(x*this.blockSize, y*this.blockSize, this.blockSize, this.blockSize);
        }
      }
    }
  }

  drawPiece(shape, posX, posY, color) {
    shape.forEach((row, y) => {
      row.forEach((value, x) => {
        if (value) {
          this.drawBlock(this.gameCtx, posX + x, posY + y, color);
        }
      });
    });
  }

  drawNext() {
    this.clearCanvas(this.nextCtx, 120, 120);
    const matrix = this.nextPiece.shape;
    const color = this.nextPiece.color;

    // Centro en canvas 120x120, calcula offset para centrar la pieza
    const offsetX = Math.floor((4 - matrix[0].length) / 2);
    const offsetY = Math.floor((4 - matrix.length) / 2);

    matrix.forEach((row, y) => {
      row.forEach((value, x) => {
        if (value) {
          this.drawBlock(this.nextCtx, x + offsetX, y + offsetY, color, 30);
        }
      });
    });
  }

  drawHold() {
    this.clearCanvas(this.holdCtx, 120, 120);
    if (!this.holdPiece) return;

    const matrix = this.holdPiece.shape;
    const color = this.holdPiece.color;

    // Centro en canvas 120x120, calcula offset para centrar la pieza
    const offsetX = Math.floor((4 - matrix[0].length) / 2);
    const offsetY = Math.floor((4 - matrix.length) / 2);

    matrix.forEach((row, y) => {
      row.forEach((value, x) => {
        if (value) {
          this.drawBlock(this.holdCtx, x + offsetX, y + offsetY, color, 30);
        }
      });
    });
  }

  rotate(matrix) {
    // rota matriz 90° a la derecha
    return matrix[0].map((_, i) => matrix.map(row => row[i]).reverse());
  }

  collision(pos, shape) {
    for(let y=0; y<shape.length; y++) {
      for(let x=0; x<shape[y].length; x++) {
        if (shape[y][x]) {
          let px = pos.x + x;
          let py = pos.y + y;
          if (px < 0 || px >= this.cols || py >= this.rows) return true;
          if (py >= 0 && this.board[py][px]) return true;
        }
      }
    }
    return false;
  }

  merge() {
    this.currentPiece.shape.forEach((row, y) => {
      row.forEach((value, x) => {
        if(value && this.pos.y + y >= 0) {
          this.board[this.pos.y + y][this.pos.x + x] = this.currentPiece.color;
        }
      });
    });
  }

  clearLines() {
    let linesCleared = 0;
    outer: for (let y = this.rows -1; y >=0; y--) {
      for (let x=0; x < this.cols; x++) {
        if (!this.board[y][x]) continue outer;
      }
      const row = this.board.splice(y, 1)[0].fill(0);
      this.board.unshift(row);
      linesCleared++;
      y++; // Revisa la fila nueva que se acaba de subir
    }
    return linesCleared;
  }

  hold() {
    if (!this.canHold) return;
    if (!this.holdPiece) {
      this.holdPiece = {...this.currentPiece};
      this.currentPiece = this.nextPiece;
      this.nextPiece = this.randomPiece();
    } else {
      const temp = this.currentPiece;
      this.currentPiece = this.holdPiece;
      this.holdPiece = temp;
    }
    this.pos = {x:3, y:0};
    this.canHold = false;
    this.draw();
  }

  drop() {
    this.pos.y++;
    if (this.collision(this.pos, this.currentPiece.shape)) {
      this.pos.y--;
      this.merge();
      this.clearLines();
      this.currentPiece = this.nextPiece;
      this.nextPiece = this.randomPiece();
      this.pos = {x:3, y:0};
      this.canHold = true;
      if (this.collision(this.pos, this.currentPiece.shape)) {
        alert("Game Over");
        this.board = this.createBoard(this.rows, this.cols);
      }
    }
  }

  move(dir) {
    this.pos.x += dir;
    if (this.collision(this.pos, this.currentPiece.shape)) {
      this.pos.x -= dir;
    }
  }

  rotatePiece() {
    const rotated = this.rotate(this.currentPiece.shape);
    if (!this.collision(this.pos, rotated)) {
      this.currentPiece.shape = rotated;
    }
  }

  initControls() {
    window.addEventListener('keydown', e => {
      switch(e.key) {
        case 'ArrowLeft':
          this.move(-1);
          break;
        case 'ArrowRight':
          this.move(1);
          break;
        case 'ArrowDown':
          this.drop();
          break;
        case 'ArrowUp':
          this.rotatePiece();
          break;
        case 'c':
        case 'C':
          this.hold();
          break;
      }
      this.draw();
    });
  }

  update(time=0) {
    const delta = time - this.lastTime;
    if (delta > this.dropInterval) {
      this.drop();
      this.draw();
      this.lastTime = time;
    }
    requestAnimationFrame(this.update.bind(this));
  }
}
