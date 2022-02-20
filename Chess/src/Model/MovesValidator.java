package Model;

import Model.ChessPieces.Piece;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author Mattia Verreydt
 * @version 1.0 19-2-2022 11:29
 */
public class MovesValidator {
    private List<Square> allBoardSquares;
    private List<Piece> whitePieces;
    private List<Piece> blackPieces;

    public void setSquares(List<Square> squares) {
        this.allBoardSquares = squares;
    }

    public List<Square> getValidMoveSquares(Piece selectedPiece) {
        Map<String, List<Square>> possibleMoves = selectedPiece.getValidMoves();

        for (Square possibleMove : possibleMoves) {
            for (Square square : allBoardSquares) {
                if (possibleMove.equals(square)) {
                    Piece piece = square.getSquareContent();
                    if (piece != null) {
                        possibleMoves.remove(piece.getPosition());
//                        binary search and loop with remove??
                    }
                }
            }
        }
            return null;
        //

//        no own piece can be present on target square
//        only horse can jump over other pieces
//
    }
}


