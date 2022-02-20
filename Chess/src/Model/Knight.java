package Model;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {
    public Knight(Color color, Square startPosition) {
        super(color, startPosition);
    }

    public List<Square> getValidMoves() {
        List<Square> validSquares = new ArrayList<>();
//        get the current row and column of the piece that has to move
        char column = super.getPosition().getColumnLetter();
        int row = super.getPosition().getRowNumber();
//        A knight always first moves 2 squares and the takes a turn of one square. You need to read the comments below as"move <2squares> <1square>"
//        move up left
        if (row + 2 <= 8 || column - 1 >= 65) { // check if target is whithin the scope of the board.
            int newRow = row + 2;
            char newColumn = (char) ((char) column - 1);
            validSquares.add(new Square(newRow, newColumn));
        }
//         move up right
        if (row + 2 <= 8 || column + 1 < 65 + 8) {
            int newRow = row + 2;
            char newColumn = (char) ((char) column + 1);
            validSquares.add(new Square(newRow, newColumn));
        }
//         move down left
        if (row - 2 >= 1 || column - 1 >= 65) {
            int newRow = row - 2;
            char newColumn = (char) ((char) column - 1);
            validSquares.add(new Square(newRow, newColumn));
        }
//         move down right
        if (row - 2 >= 1 || column + 1 < 65 + 8) {
            int newRow = row - 2;
            char newColumn = (char) ((char) column + 1);
            validSquares.add(new Square(newRow, newColumn));
        }
//        move left up
        if (row + 1 <= 8 || column - 2 >= 65) {
            int newRow = row + 1;
            char newColumn = (char) ((char) column - 2);
            validSquares.add(new Square(newRow, newColumn));
        }
//        move left down
        if (row - 1 >= 1 || column - 2 >= 65) {
            int newRow = row - 1;
            char newColumn = (char) ((char) column - 2);
            validSquares.add(new Square(newRow, newColumn));
        }
//        move right up
        if (row + 1 <= 8 || column + 2 < 65 + 8) {
            int newRow = row + 1;
            char newColumn = (char) ((char) column + 2);
            validSquares.add(new Square(newRow, newColumn));
        }
//        move right down
        if (row - 1 >= 1 || column + 2 < 65 + 8) {
            int newRow = row - 1;
            char newColumn = (char) ((char) column + 2);
            validSquares.add(new Square(newRow, newColumn));
        }
        return validSquares;
    }

}
