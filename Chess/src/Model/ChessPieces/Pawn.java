package Model.ChessPieces;

import Model.Color;
import Model.Square;

import java.util.*;

public class Pawn extends Piece {
    public Pawn(Color color, Square startPosition) {
        super(color, startPosition);
    }

    @Override
    public Map<String, List<Square>> getValidMovesPawn(List<Square> allBoardSquares) {
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

        if (super.getColor() == Color.WHITE) {
//        north
            if (row + 1 <= 8) { // check if target is within the scope of the board.
                int newRow = row + 1;
                char newColumn = column;
                north.add(new Square(newRow, newColumn));
            }
//        north-east
            if (row + 1 <= 8 && column + 1 < 65 + 8) { // check if target is within the scope of the board.
                int newRow = row + 1;
                char newColumn = (char) (column + 1);
                northEast.add(new Square(newRow, newColumn));
            }
//        north-west
            if (row + 1 <= 8 && column - 1 >= 65) { // check if target is within the scope of the board.
                int newRow = row + 1;
                char newColumn = (char) (column - 1);
                northWest.add(new Square(newRow, newColumn));
            }


            if (super.getMoves().size() == 0) { //only on the first move a pawn can move 2 squares
                int newRow = row + 2;
                char newColumn = column;
                north.add(new Square(newRow, newColumn));

            }

        } else if (super.getColor() == Color.BLACK) {

            //        north
            if (row - 1 > 0) { // check if target is within the scope of the board.
                int newRow = row - 1;
                char newColumn = column;
                south.add(new Square(newRow, newColumn));

            }
//        south-west
            if (row - 1 >= 1 && column - 1 >= 65) { // check if target is whithin the scope of the board.
                int newRow = row - 1;
                char newColumn = (char) (column - 1);
                southWest.add(new Square(newRow, newColumn));
            }
//        south-east
            if (row - 1 >= 1 && column + 1 < 65 + 8) { // check if target is whithin the scope of the board.
                int newRow = row - 1;
                char newColumn = (char) (column + 1);
                southEast.add(new Square(newRow, newColumn));
            }



            if (super.getMoves().size() == 0) { //only on the first move a pawn can move 2 squares
                int newRow = row - 2;
                char newColumn = column;
                south.add(new Square(newRow, newColumn));
            }
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

