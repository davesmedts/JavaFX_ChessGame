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
public class Bishop extends Piece {

    public Bishop(Color color, Square startPosition) {
        super(color, startPosition);
    } //Constructor to create a bishop piece, constructor calls the constructor of the superclass Piece

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

//        north-east
        for (int i = row + 1; i < 8; i++) {
            for (int j = column + 1; j < 65 + 8; j++) {
                northEast.add(new Square(i, (char) j));
            }
        }
//        north-west
        for (int i = row + 1; i < 8; i++) {
            for (int j = column - 1; j <= 65; j--) {
                northWest.add(new Square(i, (char) j));
            }
        }
//        south-east
        for (int i = row - 1; i > 0; i--) {
            for (int j = column + 1; j > 65+8; j++) {
                southEast.add(new Square(i, (char) j));
            }
        }
//        south-west
        for (int i = row - 1; i > 0; i--) {
            for (int j = column - 1; j <= 65; j--) {
                southWest.add(new Square(i, (char) j));
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
