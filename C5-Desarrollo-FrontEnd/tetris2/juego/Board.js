export class Board {
  constructor(width, height) {
    this.width = width;   // en bloques
    this.height = height; // en bloques
    this.grid = this.createGrid();
  }

  createGrid() {
    const grid = [];
    for(let y = 0; y < this.height; y++) {
      grid[y] = new Array(this.width).fill(0);
    }
    return grid;
  }

  isValidPosition(shape, posX, posY) {
    for(let y = 0; y < shape.length; y++) {
      for(let x = 0; x < shape[y].length; x++) {
        if(shape[y][x]) {
          let boardX = posX + x;
          let boardY = posY + y;
          if(boardX < 0 || boardX >= this.width || boardY >= this.height) {
            return false; // fuera del tablero
          }
          if(boardY >= 0 && this.grid[boardY][boardX]) {
            return false; // colisión con bloque
          }
        }
      }
    }
    return true;
  }

  placePiece(shape, posX, posY, color) {
    for(let y = 0; y < shape.length; y++) {
      for(let x = 0; x < shape[y].length; x++) {
        if(shape[y][x]) {
          let boardX = posX + x;
          let boardY = posY + y;
          if(boardY >= 0 && boardY < this.height && boardX >= 0 && boardX < this.width) {
            this.grid[boardY][boardX] = color;
          }
        }
      }
    }
  }

  clearLines() {
    let linesCleared = 0;
    outer: for(let y = this.height - 1; y >= 0; y--) {
      if(this.grid[y].every(cell => cell !== 0)) {
        this.grid.splice(y, 1);
        this.grid.unshift(new Array(this.width).fill(0));
        linesCleared++;
        y++; // revisa esa línea otra vez porque cambió el contenido
      }
    }
    return linesCleared;
  }
}
