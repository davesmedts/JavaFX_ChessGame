package Model.ChessPieces;

import Model.Color;
import Model.Square;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public boolean isChecked() {
        return isChecked;
    }

    public boolean isCheckmate() {
        return isCheckmate;
    }

    public boolean isHasCastled() {
        return HasCastled;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }



    public void setCheckmate(boolean checkmate) {
        isCheckmate = checkmate;
    }

    public void setHasCastled(boolean hasCastled) {
        HasCastled = hasCastled;
    }

    @Override
    public Map<String, List<Square>> getValidMoves() {
        Map<String, List<Square>> possibleSquares = new HashMap<>();

        List<Square> north = new ArrayList<>();
        List<Square> south = new ArrayList<>();
        List<Square> west = new ArrayList<>();
        List<Square> east = new ArrayList<>();
        List<Square> northEast = new ArrayList<>();
        List<Square> northWest = new ArrayList<>();
        List<Square> southEast = new ArrayList<>();
        List<Square> southWest = new ArrayList<>();

//        get the current row and column of the piece that has to move
        char column = super.getPosition().getColumnLetter();
        int row = super.getPosition().getRowNumber();

//        a King can move in any direction but is limited to the square next to it.
//        north
        if (row + 1 <= 8) { // check if target is whithin the scope of the board.
            int newRow = row + 1;
            char newColumn = column;
            north.add(new Square(newRow, newColumn));
        }
//        south
        if (row - 1 >= 1) { // check if target is whithin the scope of the board.
            int newRow = row - 1;
            char newColumn = column;
            south.add(new Square(newRow, newColumn));
        }
//        west
        if (column - 1 >= 65) { // check if target is whithin the scope of the board.
            int newRow = row;
            char newColumn = (char) (column - 1);
            west.add(new Square(newRow, newColumn));
        }
//        east
        if (column + 1 < 65 + 8) { // check if target is whithin the scope of the board.
            int newRow = row;
            char newColumn = (char) (column + 1);
            east.add(new Square(newRow, newColumn));
        }
//        north-east
        if (row + 1 <= 8 && column + 1 < 65 + 8) { // check if target is whithin the scope of the board.
            int newRow = row + 1;
            char newColumn = (char) (column + 1);
            northEast.add(new Square(newRow, newColumn));
        }
//        south-east
        if (row - 1 >= 1 && column + 1 < 65 + 8) { // check if target is whithin the scope of the board.
            int newRow = row - 1;
            char newColumn = (char) (column + 1);
            southEast.add(new Square(newRow, newColumn));
        }
//        north-west
        if (row + 1 <= 8 && column - 1 >= 65) { // check if target is whithin the scope of the board.
            int newRow = row + 1;
            char newColumn = (char) (column - 1);
            northWest.add(new Square(newRow, newColumn));
        }
//        south-west
        if (row - 1 >= 1 && column - 1 >= 65) { // check if target is whithin the scope of the board.
            int newRow = row - 1;
            char newColumn = (char) (column - 1);
            southWest.add(new Square(newRow, newColumn));
        }

        possibleSquares.put("north", north);
        possibleSquares.put("east", east);
        possibleSquares.put("south", south);
        possibleSquares.put("west", west);
        possibleSquares.put("northEast", northEast);
        possibleSquares.put("northWest", northWest);
        possibleSquares.put("southEast", southEast);
        possibleSquares.put("southWest", southWest);

        return possibleSquares;
    }
}
