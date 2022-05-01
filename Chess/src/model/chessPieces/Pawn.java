package model.chessPieces;

import model.Board;
import model.Color;
import model.Player;
import model.Square;

import java.util.*;

public class Pawn extends Piece {
    public Pawn(Color color, Square startPosition) {
        super(color, startPosition);
    }

    @Override
    public List<Square> getValidMoves(Board gameBoard, Player opponent) {
        List<Square> possibleSquares = new ArrayList<>();

        if (super.getPosition() == null) {
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
                Square moveSquare = gameBoard.lookupSquare(newColumn, newRow);
                Piece moveSquareContent = moveSquare.getSquareContent();
                if (moveSquareContent == null) {
                    possibleSquares.add(moveSquare);
                } else if (moveSquareContent.getColor() != super.getColor()) {
                    possibleSquares.add(moveSquare);
                }
            }
//        north-east + right enPassant
            if (row + 1 <= 8 && column + 1 < 65 + 8) { // check if target is within the scope of the board.
                int newRow = row + 1;
                char newColumn = (char) (column + 1);
                Square moveSquare = gameBoard.lookupSquare(newColumn, newRow);
                Piece moveSquareContent = moveSquare.getSquareContent();

                Piece enPassantPiece = gameBoard.lookupSquare(newColumn, row).getSquareContent();
                Square lastMoveOpponent = null;
                if (enPassantPiece != null && enPassantPiece.getColor() != this.getColor()) {
                    lastMoveOpponent = opponent.getLastMove();
                }

                if (moveSquareContent != null && moveSquareContent.getColor() != super.getColor()) {
                    possibleSquares.add(moveSquare);
                } else if (enPassantPiece instanceof Pawn
                        && enPassantPiece.getColor() != super.getColor() // check if we are dealing with an enemy pawn
                        && super.getPosition().getRowNumber() == 5 // for white pieces en passant can only occur on row 5
                        && lastMoveOpponent != null
                        && lastMoveOpponent == enPassantPiece.getPosition()) { // here we check if enPassant piece is the last move of the opponent, only then enPassant is valid.
                    possibleSquares.add(moveSquare);
                }
            }
//        north-west + left enPassant
            if (row + 1 <= 8 && column - 1 >= 65) { // check if target is within the scope of the board.
                int newRow = row + 1;
                char newColumn = (char) (column - 1);
                Square moveSquare = gameBoard.lookupSquare(newColumn, newRow);
                Piece moveSquareContent = moveSquare.getSquareContent();

                Piece enPassantPiece = gameBoard.lookupSquare(newColumn, row).getSquareContent();
                Square lastMoveOpponent = null;
                if (enPassantPiece != null) {
                    lastMoveOpponent = opponent.getLastMove();
                }

                if (moveSquareContent != null && moveSquareContent.getColor() != super.getColor()) {
                    possibleSquares.add(moveSquare);
                } else if (enPassantPiece instanceof Pawn
                        && enPassantPiece.getColor() != super.getColor() // check if we are dealing with an enemy pawn
                        && super.getPosition().getRowNumber() == 5 // for white pieces en passant can only occur on row 5
                        && lastMoveOpponent != null
                        && lastMoveOpponent.equals(enPassantPiece.getPosition())) { // here we check if enPassant piece is the last move of the opponent, only then enPassant is valid.
                    possibleSquares.add(moveSquare);
                }
            }

//          only on the first move a pawn can move 2 squares
            if (super.getMoves().size() == 0) {
                int newRow = row + 2;
                char newColumn = column;

                int rowPlusOne = row + 1;
                Square rowPlusOneSquare = gameBoard.lookupSquare(newColumn, rowPlusOne);
                Square moveSquare = gameBoard.lookupSquare(newColumn, newRow);
                Piece rowPlusOneContent = rowPlusOneSquare.getSquareContent();
                Piece moveSquareContent = moveSquare.getSquareContent();
                if (moveSquareContent != null && moveSquareContent.getColor() != super.getColor() && rowPlusOneContent == null) {
                    possibleSquares.add(moveSquare);
                } else if (moveSquareContent == null && rowPlusOneContent == null) {
                    possibleSquares.add(moveSquare);
                }
            }


        } else if (super.getColor() == Color.BLACK) {

//        south
            if (row - 1 > 0) { // check if target is within the scope of the board.
                int newRow = row - 1;
                char newColumn = column;
                Square moveSquare = gameBoard.lookupSquare(newColumn, newRow);
                Piece moveSquareContent = moveSquare.getSquareContent();
                if (moveSquareContent == null) {
                    possibleSquares.add(moveSquare);
                } else if (moveSquareContent.getColor() != super.getColor()) {
                    possibleSquares.add(moveSquare);
                }
            }
//        south-west
            if (row - 1 >= 1 && column - 1 >= 65) { // check if target is within the scope of the board.
                int newRow = row - 1;
                char newColumn = (char) (column - 1);
                Square moveSquare = gameBoard.lookupSquare(newColumn, newRow);
                Piece moveSquareContent = moveSquare.getSquareContent();
                Piece enPassantPiece = gameBoard.lookupSquare(newColumn, row).getSquareContent();
                Square lastMoveOpponent = null;
                if (enPassantPiece != null) {
                    lastMoveOpponent = opponent.getLastMove();
                }

                if (moveSquareContent != null && moveSquareContent.getColor() != super.getColor()) {
                    possibleSquares.add(moveSquare);
                } else if (enPassantPiece instanceof Pawn
                        && enPassantPiece.getColor() != super.getColor() // check if we are dealing with an enemy pawn
                        && super.getPosition().getRowNumber() == 5 // for white pieces en passant can only occur on row 5
                        && lastMoveOpponent.equals(enPassantPiece.getPosition())) { // here we check if enPassant piece is the last move of the opponent, only then enPassant is valid.
                    possibleSquares.add(moveSquare);
                }
            }
//        south-east
            if (row - 1 >= 1 && column + 1 < 65 + 8) { // check if target is whithin the scope of the board.
                int newRow = row - 1;
                char newColumn = (char) (column + 1);
                Square moveSquare = gameBoard.lookupSquare(newColumn, newRow);
                Piece moveSquareContent = moveSquare.getSquareContent();
                Piece enPassantPiece = gameBoard.lookupSquare(newColumn, row).getSquareContent();
                Square lastMoveOpponent = null;
                if (enPassantPiece != null) {
                    lastMoveOpponent = opponent.getLastMove();
                }

                if (moveSquareContent != null && moveSquareContent.getColor() != super.getColor()) {
                    possibleSquares.add(moveSquare);
                } else if (enPassantPiece instanceof Pawn
                        && enPassantPiece.getColor() != super.getColor() // check if we are dealing with an enemy pawn
                        && super.getPosition().getRowNumber() == 5 // for white pieces en passant can only occur on row 5
                        && lastMoveOpponent.equals(enPassantPiece.getPosition())) { // here we check if enPassant piece is the last move of the opponent, only then enPassant is valid.
                    possibleSquares.add(moveSquare);
                }
            }


            if (super.getMoves().size() == 0) { //only on the first move a pawn can move 2 squares
                int newRow = row - 2;
                char newColumn = column;
                int rowMinusOne = row - 1;
                Square rowPlusMinusSquare = gameBoard.lookupSquare(newColumn, rowMinusOne);
                Square moveSquare = gameBoard.lookupSquare(newColumn, newRow);
                Piece rowPlusMinusOneContent = rowPlusMinusSquare.getSquareContent();
                Piece moveSquareContent = moveSquare.getSquareContent();
                if (moveSquareContent != null && moveSquareContent.getColor() != super.getColor() && rowPlusMinusOneContent == null) {
                    possibleSquares.add(moveSquare);
                } else if (moveSquareContent == null && rowPlusMinusOneContent == null) {
                    possibleSquares.add(moveSquare);
                }
            }
        }
        return possibleSquares;
    }

    public void enPassantCapture(Square targetSquare, Board gameBoard) {
        Piece enPassantPawn;
        if (this.getColor() == Color.WHITE) {
            enPassantPawn = gameBoard.lookupSquare(targetSquare.getColumnLetter(), targetSquare.getRowNumber() - 1).getSquareContent();
        } else {
            enPassantPawn = gameBoard.lookupSquare(targetSquare.getColumnLetter(), targetSquare.getRowNumber() + 1).getSquareContent();
        }
        enPassantPawn.getPosition().setSquareContent(null);
        enPassantPawn.capturePiece();
    }

    public void promotePiece(String desiredPieceLetter, Piece selectedPiece) {
        Square promotedPiecePosition = selectedPiece.getPosition(); // set the pawn content to null because the piece is promoted
        promotedPiecePosition.setSquareContent(null); // Welke value gaan we dit juist geven, want nu komt dat in de lijst met captured pieces wat niet de bedoeling is
        Color promotedPieceColor = selectedPiece.getColor();

        switch (desiredPieceLetter) {
            case "Q":
                Piece promotedPiece = new Queen(promotedPieceColor, promotedPiecePosition);
                promotedPiecePosition.setSquareContent(promotedPiece);

                break;
            case "K":
                promotedPiece = new King(promotedPieceColor, promotedPiecePosition);
                promotedPiecePosition.setSquareContent(promotedPiece);

                break;
            case "B":
                promotedPiece = new Bishop(promotedPieceColor, promotedPiecePosition);
                promotedPiecePosition.setSquareContent(promotedPiece);

                break;
            case "R":
                promotedPiece = new Rook(promotedPieceColor, promotedPiecePosition);
                promotedPiecePosition.setSquareContent(promotedPiece);

                break;
        }
    }
    @Override
    public String log() {
        return String.format("%s-%s", this.getClass().getSimpleName(), super.getColor());
    }

}

