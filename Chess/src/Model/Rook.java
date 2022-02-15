package Model;

/**
 * @author Dave Smedts
 * @version 1.0 9/02/2022 22:38
 */
public class Rook extends Piece {

    public Rook(Color color, Square startPosition) {
        super(color, startPosition);
    } //Constructor to create a rook piece, constructor calls the constructor of the superclass Piece


    public Square[] getValidMoves(Square startPosition, Square endPosition, Piece piece) {


        // er mag geen eigen piece op de plek staan waar we heen willen
        Boolean possiblePiece = getPiece(endPosition, piece.getColor());
        if (possiblePiece){
            System.out.println("No valid move, already a piece of your color is on that space"); // kunnen dit mss cleaner oplossen met een exception?
        }

            //code schrijven om de rook horizontaal en verticaal te laten bewegn


//code schrijven om rook niet over eigen pieces te laten springen

            return new Square[0];

    } //We calculate every valid move for the rook, by doing a constructor overload
}
