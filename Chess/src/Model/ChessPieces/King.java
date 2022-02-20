package Model.ChessPieces;

import Model.Color;
import Model.Square;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dave Smedts
 * @version 1.0 9/02/2022 22:37
 */
public class King extends Piece {
    private boolean isChecked;
    private boolean isCheckmate;
    private boolean HasCastled;

    public King(Color color, Square startPosition) {
        super(color, startPosition);
        this.isChecked = false;
        this.isCheckmate = false;
        HasCastled = false;
    }

    @Override
    public List<Square> getValidMoves() {
        List<Square> validSquares = new ArrayList<>();
//        get the current row and column of the piece that has to move
        char column = super.getPosition().getColumnLetter();
        int row = super.getPosition().getRowNumber();

//        a King can move in any direction but is limited to the square next to it.
//        move up
        if (row + 1 <= 8) { // check if target is whithin the scope of the board.
            int newRow = row + 1;
            char newColumn = column;
            validSquares.add(new Square(newRow, newColumn));
        }
//        move down
        if (row - 1 >= 1) { // check if target is whithin the scope of the board.
            int newRow = row - 1;
            char newColumn = column;
            validSquares.add(new Square(newRow, newColumn));
        }
//        move left
        if (column - 1 >= 65) { // check if target is whithin the scope of the board.
            int newRow = row;
            char newColumn = (char) (column - 1);
            validSquares.add(new Square(newRow, newColumn));
        }
//        move right
        if (column + 1 < 65 + 8) { // check if target is whithin the scope of the board.
            int newRow = row;
            char newColumn = (char) (column + 1);
            validSquares.add(new Square(newRow, newColumn));
        }
//        move right-up
        if (row + 1 <= 8 && column + 1 < 65 + 8) { // check if target is whithin the scope of the board.
            int newRow = row + 1;
            char newColumn = (char) (column + 1);
            validSquares.add(new Square(newRow, newColumn));
        }
//        move right-down
        if (row - 1 >= 1 && column + 1 < 65 + 8) { // check if target is whithin the scope of the board.
            int newRow = row - 1;
            char newColumn = (char) (column + 1);
            validSquares.add(new Square(newRow, newColumn));
        }
//        move left-up
        if (row + 1 <= 8 && column - 1 >= 65) { // check if target is whithin the scope of the board.
            int newRow = row + 1;
            char newColumn = (char) (column - 1);
            validSquares.add(new Square(newRow, newColumn));
        }
//        move left-down
        if (row - 1 <= 1 && column - 1 >= 65) { // check if target is whithin the scope of the board.
            int newRow = row - 1;
            char newColumn = (char) (column - 1);
            validSquares.add(new Square(newRow, newColumn));
        }
        return validSquares;
    }
}
