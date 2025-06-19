export const TETROMINOS = {
  I: {
    color: 'cyan',
    shape: [
      [0, 0, 0, 0],
      [1, 1, 1, 1],
      [0, 0, 0, 0],
      [0, 0, 0, 0]
    ]
  },
  O: {
    color: 'yellow',
    shape: [
      [1, 1],
      [1, 1]
    ]
  },
  T: {
    color: 'magenta',
    shape: [
      [0, 1, 0],
      [1, 1, 1],
      [0, 0, 0]
    ]
  },
  S: {
    color: 'lime',
    shape: [
      [0, 1, 1],
      [1, 1, 0],
      [0, 0, 0]
    ]
  },
  Z: {
    color: 'red',
    shape: [
      [1, 1, 0],
      [0, 1, 1],
      [0, 0, 0]
    ]
  },
  J: {
    color: 'blue',
    shape: [
      [1, 0, 0],
      [1, 1, 1],
      [0, 0, 0]
    ]
  },
  L: {
    color: 'orange',
    shape: [
      [0, 0, 1],
      [1, 1, 1],
      [0, 0, 0]
    ]
  }
};

export function rotate(matrix) {
  const N = matrix.length;
  const result = [];
  for(let i = 0; i < N; i++) {
    result.push(new Array(N).fill(0));
  }
  for(let y = 0; y < N; y++) {
    for(let x = 0; x < N; x++) {
      result[x][N - 1 - y] = matrix[y][x];
    }
  }
  return result;
}

export function randomTetromino() {
  const keys = Object.keys(TETROMINOS);
  const key = keys[Math.floor(Math.random() * keys.length)];
  const tet = TETROMINOS[key];
  return {
    shape: tet.shape,
    color: tet.color,
    name: key
  };
}
