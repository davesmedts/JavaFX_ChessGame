package Model;


import static java.awt.Color.white;

public class Rook extends Piece {
    //Constructor to create a rook piece, constructor calls the constructor of the superclass Piece
    public Rook(Color color, Square startPosition) {
        super(color, startPosition);
    }


    public Square[] getPossibleMoves(Square endPosition) {


        // er mag geen eigen piece op de plek staan waar we heen willen
//        Boolean possiblePiece = getPiece(endPosition);
//        if (possiblePiece) {
//            System.out.println("No valid move, already a piece of your color is on that space"); // kunnen dit mss cleaner oplossen met een exception?
//        } else if (possiblePiece){
//
//            Boolean possiblePieceBetween = getPiece(startPosition,endPosition, piece.getColor());
//
//        }
        //code schrijven om de rook horizontaal en verticaal te laten bewegen
        //code schrijven om rook niet over eigen pieces te laten springen


        return new Square[0];

    } //We calculate every valid move for the rook, by doing a constructor overload
}
