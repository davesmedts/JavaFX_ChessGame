package Model.ChessPieces;


import Model.Color;
import Model.Square;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rook extends Piece {
    //Constructor to create a rook piece, constructor calls the constructor of the superclass Piece
    public Rook(Color color, Square startPosition) {
        super(color, startPosition);
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

//        north
        for (int i = 1; i < 8; i++) {
            int newRow = row + i;
            char newColumn = column;
            if (newRow <= 8)
                north.add(new Square(newRow, newColumn));
        }
//        south
        for (int i = 1; i < 8; i++) {
            int newRow = row - i;
            char newColumn = column;
            if (newRow > 0)
                south.add(new Square(newRow, newColumn));
        }
//        east
        for (int i = 1; i < 8; i++) {
            int newRow = row;
            char newColumn = (char) (column + i);
            if (newColumn < 65 + 8)
                east.add(new Square(newRow, newColumn));
        }
//        west
        for (int i = 1; i < 8; i++) {
            int newRow = row;
            char newColumn = (char) (column - i);
            if (newColumn >= 65)
                west.add(new Square(newRow, newColumn));
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
