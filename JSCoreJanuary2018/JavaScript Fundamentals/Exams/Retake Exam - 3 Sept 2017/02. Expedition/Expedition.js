function solve(primary, secondary, overlayCoordinates, startingCoordinates) {
    let primaryMatrix = fillMatrix(primary);
    let secondaryMatrix = fillMatrix(secondary);

    for (let arr of overlayCoordinates) {
        let row = arr[0];
        let column = arr[1];

        for (let i = row; i < row + secondaryMatrix.length; i++) {
            if (i < primaryMatrix.length) {
                for (let j = column; j < column + secondaryMatrix[0].length; j++) {
                    if (j < primaryMatrix[0].length) {
                        if (secondaryMatrix[i - row][j - column] === 1) {
                            if (primaryMatrix[i][j] === 0) {
                                primaryMatrix[i][j] = 1;
                            } else {
                                primaryMatrix[i][j] = 0;
                            }
                        }
                    }
                }
            }
        }
    }

    let finalResult = moveIsPossible(primaryMatrix, Number(startingCoordinates[0]), Number(startingCoordinates[1]), 1);
    let endRow = finalResult[0];
    let endCol = finalResult[1];
    let moves = finalResult[2];

    if (endRow === primaryMatrix.length - 1) {
        console.log(moves);
        console.log('Bottom')
    } else if (endRow === 0) {
        console.log(moves);
        console.log('Top')
    } else if (endCol === primaryMatrix[0].length - 1) {
        console.log(moves);
        console.log('Right')
    } else if (endCol === 0) {
        console.log(moves);
        console.log('Left')
    } else {
        console.log(moves);
        if (endRow < primaryMatrix.length / 2 && endCol < primaryMatrix[0].length / 2){
            console.log('Dead end 2');
        } else if (endRow >= primaryMatrix.length / 2 && endCol < primaryMatrix[0].length / 2) {
            console.log('Dead end 3');
        } else if (endRow >= primaryMatrix.length / 2 && endCol >= primaryMatrix[0].length / 2) {
            console.log('Dead end 4');
        } else if (endRow < primaryMatrix.length / 2 && endCol >= primaryMatrix[0].length / 2){
            console.log('Dead end 1');
        }
    }


    function fillMatrix(arr) {
        let matrixLength = arr.length;
        let matrixWidth = arr[0].length;
        let matrix = [];
        for (let i = 0; i < matrixLength; i++) {
            matrix[i] = [];
            for (let j = 0; j < matrixWidth; j++) {
                matrix[i][j] = Number(arr[i][j]);
            }
        }
        return matrix;
    }

    function moveIsPossible(matrix, startingRow, startingCol, moves) {
        let letsMove = true;
        while (letsMove) {
            if (startingRow + 1 < matrix.length && matrix[startingRow + 1][startingCol] === 0) {
                matrix[startingRow][startingCol] = -1;
                startingRow += 1;
                moves++;
                return moveIsPossible(matrix, startingRow, startingCol, moves);
            } else if (startingCol + 1 < matrix[0].length && matrix[startingRow][startingCol + 1] === 0) {
                matrix[startingRow][startingCol] = -1;
                startingCol += 1;
                moves++;
                return moveIsPossible(matrix, startingRow, startingCol, moves);
            } else if (startingRow - 1 >= 0 && matrix[startingRow - 1][startingCol] === 0) {
                matrix[startingRow][startingCol] = -1;
                startingRow -= 1;
                moves++;
                return moveIsPossible(matrix, startingRow, startingCol, moves);
            } else if (startingCol - 1 >= 0 && matrix[startingRow][startingCol - 1] === 0) {
                matrix[startingRow][startingCol] = -1;
                startingCol -= 1;
                moves++;
                return moveIsPossible(matrix, startingRow, startingCol, moves);
            } else {
                letsMove = false;
            }
        }
        return [startingRow, startingCol, moves];
    }
}

solve([[1, 0, 1, 0],
        [1, 0, 1, 1],
        [1, 1, 1, 0],
        [1, 0, 0, 1],
        [1, 1, 0, 1],
        [1, 1, 0, 1],
        [0, 0, 1, 1],
        [0, 1, 1, 0],
        [0, 0, 1, 0],
        [0, 1, 0, 0]],
    [[1, 1, 1, 0],
        [1, 0, 1, 1]],
    [[1, 1],
        [0, 1],
        [6, 0],
        [8, 0]],
    [8, 3]
)