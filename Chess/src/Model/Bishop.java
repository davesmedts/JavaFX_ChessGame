package Model;

import java.util.List;

/**
 * @author Dave Smedts
 * @version 1.0 9/02/2022 22:38
 */
public class Bishop extends Piece{

    public Bishop(Color color, Square startPosition) {
        super(color, startPosition);
    } //Constructor to create a bishop piece, constructor calls the constructor of the superclass Piece



    public List<Square> getValidMoves(){

        return new Square[0];

    } //We calculate every valid move for the bishop, by doing a constructor overload

}
