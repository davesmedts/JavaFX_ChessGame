package Model.ChessPieces;

import Model.Color;
import Model.Square;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Knight extends Piece {
    public Knight(Color color, Square startPosition) {
        super(color, startPosition);
    }

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

        if(super.getPosition() == null){
            return possibleSquares;
        }
//        get the current row and column of the piece that has to move
        char column = super.getPosition().getColumnLetter();
        int row = super.getPosition().getRowNumber();
//        A knight always first moves 2 squares and the takes a turn of one square. You need to read the comments below as"move <2squares> <1square>"
//        move north-west
        if (row + 2 <= 8 && column - 1 >= 65) { // check if target is whithin the scope of the board.
            int newRow = row + 2;
            char newColumn = (char) ((char) column - 1);
            northWest.add(new Square(newRow, newColumn));
        }
//         move north-east
        if (row + 2 <= 8 && column + 1 < 65 + 8) {
            int newRow = row + 2;
            char newColumn = (char) ((char) column + 1);
            northEast.add(new Square(newRow, newColumn));
        }
//         move southWest
        if (row - 2 >= 1 && column - 1 >= 65) {
            int newRow = row - 2;
            char newColumn = (char) ((char) column - 1);
            southWest.add(new Square(newRow, newColumn));
        }
//         move southEast
        if (row - 2 >= 1 && column + 1 < 65 + 8) {
            int newRow = row - 2;
            char newColumn = (char) ((char) column + 1);
            southEast.add(new Square(newRow, newColumn));
        }
//        move nortEast (left up)
        if (row + 1 <= 8 && column - 2 >= 65) {
            int newRow = row + 1;
            char newColumn = (char) ((char) column - 2);
            northWest.add(new Square(newRow, newColumn));
        }
//        move SouthEast(left down)
        if (row - 1 >= 1 && column - 2 >= 65) {
            int newRow = row - 1;
            char newColumn = (char) ((char) column - 2);
            southWest.add(new Square(newRow, newColumn));
        }
//        move north east (right up)
        if (row + 1 <= 8 && column + 2 < 65 + 8) {
            int newRow = row + 1;
            char newColumn = (char) ((char) column + 2);
            northEast.add(new Square(newRow, newColumn));
        }
//        move southEast(right down)
        if (row - 1 >= 1 && column + 2 < 65 + 8) {
            int newRow = row - 1;
            char newColumn = (char) ((char) column + 2);
            southEast.add(new Square(newRow, newColumn));
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
