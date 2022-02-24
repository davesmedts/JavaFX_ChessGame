package Model.ChessPieces;

import Model.Color;
import Model.Square;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dave Smedts
 * @version 1.0 9/02/2022 22:38
 */
public class Queen extends Piece{
    public Queen(Color color, Square startPosition) {
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
//        south
//        east
//        west

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

//        north-east
        for (int i = 1; i < 8; i++) {
            int newRow = row + i;
            char newColumn = (char) (column + i);
            if(newRow <= 8 && newColumn < 65+8)
                northEast.add(new Square(newRow, newColumn));
        }
//        north-west
        for (int i = 1; i < 8; i++) {
            int newRow = row + i;
            char newColumn = (char) (column - i);
            if(newRow <= 8 && newColumn >= 65)
                northWest.add(new Square(newRow, newColumn));
        }
//        south-east
        for (int i = 1; i < 8; i++) {
            int newRow = row - i;
            char newColumn = (char) (column + i);
            if(newRow >0 && newColumn <65+8)
                southEast.add(new Square(newRow, newColumn));
        }
//        south-west
        for (int i = 1; i < 8; i++) {
            int newRow = row - i;
            char newColumn = (char) (column - i);
            if(newRow > 0 && newColumn >= 65)
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
