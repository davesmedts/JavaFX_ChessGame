package Model;

/**
 * @author Dave Smedts
 * @version 1.0 9/02/2022 22:38
 */
public class Rook extends Piece {

    public Rook(Color color, Square startPosition) {
        super(color, startPosition);
    } //Constructor to create a rook piece, constructor calls the constructor of the superclass Piece


    public Square[] getValidMoves(Square startPosition, Square endPosition) {


        // er mag geen eigen piece op de plek staan waar we heen willen

        boolean possiblePiece = getPiece(endPosition, this.getColor());

        //code schrijven om de rook horizontaal en verticaal te laten bewegn

//code schrijven om rook niet over eigen pieces te laten springen

        return new Square[0];

    } //We calculate every valid move for the rook, by doing a constructor overload
}
