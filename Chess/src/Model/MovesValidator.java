package Model;

import Model.ChessPieces.Piece;

import java.util.*;

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
        List<Square> validMoves = new ArrayList<>(); // list to return
        Map<String, List<Square>> possibleMoves = selectedPiece.getValidMoves(); //possible movements without check on the board
        Collection<List<Square>> directions = possibleMoves.values(); // Collection of all lists, each list is a direction of movements
        for (List<Square> direction : directions) { // we take one direction list at a time to loop over each direction
            for (Square possibleMove : direction) { // we take each square from the direction list
                for (Square boardSquare : allBoardSquares) { // we take al squares on the gameboard to be checked with the squares on of the direction list
                    if (possibleMove.equals(boardSquare)) {
                        Piece piece = boardSquare.getSquareContent();
                        if (piece != null) { // check if a piece is present on the square
                            int index = Collections.binarySearch(direction, possibleMove);
                            if (piece.getColor() == selectedPiece.getColor()) {
                                for (int i = 0; i < index; i++) {
                                    for (Square boardSquareAgain : allBoardSquares) { // we take al squares on the gameboard to be checked with the squares on of the direction list
                                        if (direction.get(i).equals(boardSquare)) {
                                            validMoves.add(boardSquareAgain);
                                        }
                                    }
                                }
                            } else {
                                for (int i = 0; i <= index; i++) {
                                    for (Square boardSquareAgain : allBoardSquares) { // we take al squares on the gameboard to be checked with the squares on of the direction list
                                        if (direction.get(i).equals(boardSquare)) {
                                            validMoves.add(boardSquareAgain);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return validMoves;
    }
}


