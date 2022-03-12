package Model;

import Model.ChessPieces.Pawn;
import Model.ChessPieces.Piece;

import java.util.*;

public class MovesValidator {
    private List<Square> allBoardSquares;
    private List<Piece> whitePieces;
    private List<Piece> blackPieces;

    public void setSquares(List<Square> squares) {
        this.allBoardSquares = squares;
    }

    public void setWhitePieces(List<Piece> whitePieces) {
        this.whitePieces = whitePieces;
    }

    public void setBlackPieces(List<Piece> blackPieces) {
        this.blackPieces = blackPieces;
    }


    public List<Square> getValidMoveSquares(Piece selectedPiece) {
        List<Square> validMoves = new ArrayList<>(); // list to return

        Map<String, List<Square>> possibleMoves = selectedPiece.getValidMoves(); //possible movements without check on the board
        Collection<List<Square>> directions = possibleMoves.values(); // Collection of all lists, each list is a direction of movements
        for (List<Square> direction : directions) { // we take one direction list at a time to loop over each direction
            boolean pieceFound = false; //flag that shows if a piece has been detected.
            for (Square possibleMove : direction) { // we take each square from the direction list
                for (Square boardSquare : allBoardSquares) { // we take all squares on the gameboard to be checked with the squares on of the direction list
                    if (possibleMove.equals(boardSquare)) {
                        Piece piece = boardSquare.getSquareContent();
                        if (piece != null && !pieceFound) { // check if a piece is present on the square and if any other piece were found in earlier iterations.
                            pieceFound = true;
                            if (piece.getColor() != selectedPiece.getColor()) { //only if the piece color is the color of the opponent we are able to move to this position.
                                validMoves.add(boardSquare);
                            }
                        } else if (!pieceFound) {
                            validMoves.add(boardSquare);
                        }
                    }
                }
            }
        }
        System.out.println(validMoves);
        return validMoves;
    }

    public List<Square> getValidMoveSquaresPawn(Piece selectedPiece) {
        List<Square> validMoves = new ArrayList<>(); // list to return
        Map<String, List<Square>> possibleMoves = selectedPiece.getValidMovesPawn(allBoardSquares); //possible movements without check on the board
        Collection<List<Square>> directions = possibleMoves.values(); // Collection of all lists, each list is a direction of movements
        for (List<Square> direction : directions) { // we take one direction list at a time to loop over each direction
            boolean pieceFound = false; //flag that shows if a piece has been detected.
            for (Square possibleMove : direction) { // we take each square from the direction list
                for (Square boardSquare : allBoardSquares) { // we take all squares on the gameboard to be checked with the squares on of the direction list
                    if (possibleMove.equals(boardSquare)) {
                        Piece piece = boardSquare.getSquareContent();
                        if (piece != null && !pieceFound) { // check if a piece is present on the square and if any other piece were found in earlier iterations.
                            pieceFound = true;
                            if (piece.getColor() != selectedPiece.getColor()) { //only if the piece color is the color of the opponent we are able to move to this position.
                                validMoves.add(boardSquare);
                            }
                        } else if (!pieceFound) {
                            validMoves.add(boardSquare);
                        }
                    }
                }
            }
        }
        System.out.println(validMoves);
        return validMoves;
    }

    public List<Square> getAllPossibleMoves(Color playerColor) {
        List<Square> allPossibleMoves = new ArrayList<>();
        if (playerColor == Color.WHITE) {
            for (Piece whitePiece : whitePieces) {
                if (whitePiece instanceof Pawn) {
                    allPossibleMoves.addAll(getValidMoveSquaresPawn(whitePiece));
                } else {
                    allPossibleMoves.addAll(getValidMoveSquares(whitePiece));
                }
            }
        } else {
            for (Piece blackPiece : blackPieces) {
                if (blackPiece instanceof Pawn) {
                    allPossibleMoves.addAll(getValidMoveSquaresPawn(blackPiece));
                } else {
                    allPossibleMoves.addAll(getValidMoveSquares(blackPiece));
                }
            }
        }
        return allPossibleMoves;
    }
}


