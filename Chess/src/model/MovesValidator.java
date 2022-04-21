package model;

import model.chessPieces.Pawn;
import model.chessPieces.Piece;
import model.chessPieces.King;
import model.chessPieces.Rook;

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

    public List<Piece> getWhitePieces() {
        return whitePieces;
    }

    public List<Piece> getBlackPieces() {
        return blackPieces;
    }

//    public List<Square> getValidMoveSquares(Piece selectedPiece) {
//        List<Square> validMoves = new ArrayList<>(); // list to return
//
//        Map<String, List<Square>> possibleMoves = selectedPiece.getValidMoves(); //possible movements without check on the board
//        Collection<List<Square>> directions = possibleMoves.values(); // Collection of all lists, each list is a direction of movements
//        for (List<Square> direction : directions) { // we take one direction list at a time to loop over each direction
//            boolean pieceFound = false; //flag that shows if a piece has been detected.
//            for (Square possibleMove : direction) { // we take each square from the direction list
//                for (Square boardSquare : allBoardSquares) { // we take all squares on the gameboard to be checked with the squares on of the direction list
//                    if (possibleMove.equals(boardSquare)) {
//                        Piece piece = boardSquare.getSquareContent();
//                        if (piece != null && !pieceFound) { // check if a piece is present on the square and if any other piece were found in earlier iterations.
//                            pieceFound = true;
//                            if ((piece.getColor() != selectedPiece.getColor())) { //only if the piece color is the color of the opponent we are able to move to this position.
//                                validMoves.add(boardSquare);
//                            }
//                        } else if (!pieceFound) {
//                            validMoves.add(boardSquare);
//                        }
//                    }
//                }
//            }
//        }
//        if(selectedPiece instanceof King){
//            validMoves.addAll(getCastlingSquares(selectedPiece));
//        }
//        return validMoves;
//    }

//    public List<Square> getValidMoveSquaresPawn(Piece selectedPiece, Player player) {
//        List<Square> validMoves = new ArrayList<>(); // list to return
//        Map<String, List<Square>> possibleMoves = selectedPiece.getValidMovesPawn(allBoardSquares); //possible movements without check on the board
//        Collection<List<Square>> directions = possibleMoves.values(); // Collection of all lists, each list is a direction of movements
//        for (List<Square> direction : directions) { // we take one direction list at a time to loop over each direction
////            boolean pieceFound = false; //flag that shows if a piece has been detected.
//            for (Square possibleMove : direction) { // we take each square from the direction list
//                for (Square boardSquare : allBoardSquares) { // we take all squares on the gameboard to be checked with the squares on of the direction list
//                    if (possibleMove.equals(boardSquare)) {
//                        Piece piece = boardSquare.getSquareContent();
//                        if (piece != null) { // check if a piece is present on the square and if any other piece were found in earlier iterations.
////                            pieceFound = true;
//                            if (piece.getColor() != selectedPiece.getColor() && selectedPiece.getPosition().getColumnLetter() != piece.getPosition().getColumnLetter()) { //only if the piece color is the color of the opponent we are able to move to this position, The pawn can only capture diagonally so the columnletters can not be the same.
//                                validMoves.add(boardSquare);
//                            }
//                        } else if (selectedPiece.getPosition().getColumnLetter() == boardSquare.getColumnLetter()) {
//                            validMoves.add(boardSquare);
//                        } else if (selectedPiece.getPosition().getRowNumber() == 5 || selectedPiece.getPosition().getRowNumber() == 6) { // columnletters don't match && row is 6 or 5
//                            List<Square> squaresEnemyPlayer = player.getMoves(); // get the last move of the list
//                            int amountSquares = squaresEnemyPlayer.size();
//                            Square lastMoveEnemyPlayer = null;
//                            if (amountSquares != 0) {
//                                lastMoveEnemyPlayer = squaresEnemyPlayer.get(amountSquares - 1); // you need to use this list because you can only do enPassant on the last move from the enemy
//                                int lastMoveEnemyPlayerRownumber = lastMoveEnemyPlayer.getRowNumber();
//                                char lastMoveEnemyPlayerColumnLetter = lastMoveEnemyPlayer.getColumnLetter();
//
//                                if (selectedPiece.getColor().equals(Color.WHITE)) {
//                                    lastMoveEnemyPlayer = new Square(lastMoveEnemyPlayerRownumber + 1, lastMoveEnemyPlayerColumnLetter);
////                                 This calculation is necessary because we only need to do the enPassant method for the
////                                 last move of the enemyPlayer, we need to do this calculation because the enemy Pawn has moved
////                                 two squares instead one. But the selectedPiece can only move oblique and take the pawn on the original position
////                                 if we don't do this calculation then we will add two times the same square to the list because we will run two times the enPassant method
//
//                                } else
//                                    lastMoveEnemyPlayer = new Square(lastMoveEnemyPlayerRownumber - 1, lastMoveEnemyPlayerColumnLetter);
//                            }
//
//                            if (possibleMove.equals(lastMoveEnemyPlayer)) {
//                                validMoves.addAll(enPassant(selectedPiece, lastMoveEnemyPlayer));
//                            }
//                        }
//                    }
//                }
//            }
//
//        }
//        return validMoves;
//    }

//    public Square lookupSquare(char columnLetter, int rowNumber) {
//        Square matchedSquare = null;
//        for (Square square : allBoardSquares) {
//            if (columnLetter == square.getColumnLetter() && rowNumber == square.getRowNumber()) {
//                matchedSquare = square;
//            }
//        }
//        return matchedSquare;
//    }

//    public List<Square> getCastlingSquares(Piece king) {
//        List<Square> castleMoves = new ArrayList<>();
//        if (king.getColor() == Color.WHITE) {
//            Square a1 = lookupSquare('A', 1);
//            Square b1 = lookupSquare('B', 1);
//            Square c1 = lookupSquare('C', 1);
//            Square d1 = lookupSquare('D', 1);
//            Square f1 = lookupSquare('F', 1);
//            Square g1 = lookupSquare('G', 1);
//            Square h1 = lookupSquare('H', 1);
//
//
//            if (a1.getSquareContent() instanceof Rook && a1.getSquareContent().getMoves().size() == 0) {
//                if (b1.getSquareContent() == null && c1.getSquareContent() == null && d1.getSquareContent() == null) {
//
//                    List<Square> leftCastleCheck = new ArrayList<>();
//                    leftCastleCheck.add(king.getPosition()); // we moeten selectedPiece dan ook gaan meegeven
//                    leftCastleCheck.add(d1);
//                    leftCastleCheck.add(c1); // c1 add to the list
//
//                    boolean check = false;
//                    for (Square square : leftCastleCheck) {
//                        if (moveCheckSimulation((King) king, square)) {
//                            check = true; // if the boolean is changed to true, we never change it back within this loop
//                        } else {
//                            break; // if the king is in check on one of the squares then we break out of this loop and go to the next statement
//                        }
//                    }
//                    if (!check) {
//                        castleMoves.add(lookupSquare('C', 1)); // left castling move: kings always moves to C1
//                    }
//                }
//            }
//
//
//            if (h1.getSquareContent() instanceof Rook && h1.getSquareContent().getMoves().size() == 0) {
//                if (f1.getSquareContent() == null && g1.getSquareContent() == null) {
//
//                    List<Square> rightCastleCheck = new ArrayList<>();
//                    rightCastleCheck.add(king.getPosition()); // we moeten selectedPiece dan ook gaan meegeven
//                    rightCastleCheck.add(f1);
//                    rightCastleCheck.add(g1); // c1 add to the list
//                    boolean check = false;
//
//
//                    for (Square square : rightCastleCheck) {
//                        if (moveCheckSimulation((King) king, square)) {
//                            check = true; // if the boolean is changed to true, we never change it back within this loop
//                        } else {
//                            break; // if the king is in check on one of the squares then we break out of this loop and go to the next statement
//                        }
//                    }
//                    if (!check) {
//                        castleMoves.add(lookupSquare('G', 1)); // left castling move: kings always moves to G1
//                    }
//                }
//            }
//        }
//        return castleMoves;
//    }


//    private List<Square> enPassant(Piece selectedPiece, Square lastMoveEnemyPlayer) {
//        List<Square> enPassantSquares = new ArrayList<>();
//        Square selectedPiecePosition = selectedPiece.getPosition();
//
//        if (selectedPiecePosition.getRowNumber() == 5 && selectedPiece.getColor() == Color.WHITE) {
//            for (Square boardSquare : allBoardSquares) {
//                if ((boardSquare.getColumnLetter() == selectedPiecePosition.getColumnLetter() + 1 && (boardSquare.getRowNumber() == 5))) { // we gaan al de squares links en rechts toevoegen
//                    if (lastMoveEnemyPlayer.getColumnLetter() - 1 == selectedPiecePosition.getColumnLetter()) { //niet al de vakken links en rechts toevoegen in de lijst
//                        if (boardSquare.getSquareContent() instanceof Pawn && boardSquare.getSquareContent().getColor() == Color.BLACK && boardSquare.getSquareContent().getMoves().size() == 1) { // drie checks moeten we doen, 1 we checken of we naast een pion staan. De pion moet van de tegenpartij zijn, dus de kleur moet gecontroleerd worden. Ten derde moeten we checken of de lijst van de vijandelijke pion op 0 staat(eerste move vijand)
//                            Square validEnPassant = new Square(6, (char) (selectedPiecePosition.getColumnLetter() + 1));
//                            for (Square square : allBoardSquares) {
//                                if (square.equals(validEnPassant)) {
//                                    enPassantSquares.add(square);
//                                }
//                            }
//                        }
//                    }
//                }
//
//                if ((boardSquare.getColumnLetter() == selectedPiecePosition.getColumnLetter() - 1 && (boardSquare.getRowNumber() == 5))) {
//                    if (lastMoveEnemyPlayer.getColumnLetter() + 1 == selectedPiecePosition.getColumnLetter()) {
//                        if (boardSquare.getSquareContent() instanceof Pawn && boardSquare.getSquareContent().getColor() == Color.BLACK && boardSquare.getSquareContent().getMoves().size() == 1) { // drie checks moeten we doen, 1 we checken of we naast een pion staan. De pion moet van de tegenpartij zijn, dus de kleur moet gecontroleerd worden. Ten derde moeten we checken of de lijst van de vijandelijke pion op 0 staat(eerste move vijand)
//                            Square validEnPassant = new Square(6, (char) (selectedPiecePosition.getColumnLetter() - 1));
//                            for (Square square : allBoardSquares) {
//                                if (square.equals(validEnPassant)) {
//
//                                    enPassantSquares.add(square);
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        if (selectedPiecePosition.getRowNumber() == 6 && selectedPiece.getColor() == Color.BLACK) {
//            for (Square boardSquare : allBoardSquares) {
//                if ((boardSquare.getColumnLetter() == selectedPiecePosition.getColumnLetter() + 1 && (boardSquare.getRowNumber() == 6))) { // we gaan al de squares links en rechts toevoegen
//                    if (lastMoveEnemyPlayer.getColumnLetter() - 1 == selectedPiecePosition.getColumnLetter()) {
//                        if (boardSquare.getSquareContent() instanceof Pawn && boardSquare.getSquareContent().getColor() == Color.WHITE && boardSquare.getSquareContent().getMoves().size() == 1) { // drie checks moeten we doen, 1 we checken of we naast een pion staan. De pion moet van de tegenpartij zijn, dus de kleur moet gecontroleerd worden. Ten derde moeten we checken of de lijst van de vijandelijke pion op 0 staat(eerste move vijand)
//                            Square validEnPassant = new Square(5, (char) (selectedPiecePosition.getColumnLetter() + 1));
//                            for (Square square : allBoardSquares) {
//                                if (square.equals(validEnPassant)) {
//                                    enPassantSquares.add(square);
//                                }
//                            }
//                        }
//                    }
//                }
//
//                if ((boardSquare.getColumnLetter() == selectedPiecePosition.getColumnLetter() - 1 && (boardSquare.getRowNumber() == 6))) {
//                    if (lastMoveEnemyPlayer.getColumnLetter() + 1 == selectedPiecePosition.getColumnLetter()) {
//                        if (boardSquare.getSquareContent() instanceof Pawn && boardSquare.getSquareContent().getColor() == Color.WHITE && boardSquare.getSquareContent().getMoves().size() == 1) { // drie checks moeten we doen, 1 we checken of we naast een pion staan. De pion moet van de tegenpartij zijn, dus de kleur moet gecontroleerd worden. Ten derde moeten we checken of de lijst van de vijandelijke pion op 0 staat(eerste move vijand)
//                            Square validEnPassant = new Square(5, (char) (selectedPiecePosition.getColumnLetter() - 1));
//                            for (Square square : allBoardSquares) {
//                                if (square.equals(validEnPassant)) {
//                                    enPassantSquares.add(square);
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return enPassantSquares;
//    }


//    public List<Square> getValidMoveSquaresPawn(Piece selectedPiece) {
//        List<Square> validMoves = new ArrayList<>(); // list to return
//        Map<String, List<Square>> possibleMoves = selectedPiece.getValidMovesPawn(allBoardSquares); //possible movements without check on the board
//        Collection<List<Square>> directions = possibleMoves.values(); // Collection of all lists, each list is a direction of movements
//        for (List<Square> direction : directions) { // we take one direction list at a time to loop over each direction
////            boolean pieceFound = false; //flag that shows if a piece has been detected.
//            for (Square possibleMove : direction) { // we take each square from the direction list
//                for (Square boardSquare : allBoardSquares) { // we take all squares on the gameboard to be checked with the squares on of the direction list
//                    if (possibleMove.equals(boardSquare)) {
//                        Piece piece = boardSquare.getSquareContent();
//                        if (piece != null) { // check if a piece is present on the square and if any other piece were found in earlier iterations.
////                            pieceFound = true;
//                            if (piece.getColor() != selectedPiece.getColor() && selectedPiece.getPosition().getColumnLetter() != piece.getPosition().getColumnLetter()) { //only if the piece color is the color of the opponent we are able to move to this position, The pawn can only capture diagonally so the columnletters can not be the same.
//                                validMoves.add(boardSquare);
//                            }
//                        } else if (selectedPiece.getPosition().getColumnLetter() == boardSquare.getColumnLetter()) {
//                            validMoves.add(boardSquare);
//                        } else if (selectedPiece.getPosition().getRowNumber() == 5 || selectedPiece.getPosition().getRowNumber() == 4) { // columnletters don't match && row is 4 or 5
//                            validMoves.addAll(enPassant(selectedPiece));
//                        }
//                    }
//                }
//            }
//        }
//        return validMoves;
//    }

//    private List<Square> enPassant(Piece selectedPiece) {
//        List<Square> enPassantSquares = new ArrayList<>();
//        Square selectedPiecePosition = selectedPiece.getPosition();
//
//        if (selectedPiecePosition.getRowNumber() == 5 && selectedPiece.getColor() == Color.WHITE) {
//            for (Square boardSquare : allBoardSquares) {
//                if ((boardSquare.getColumnLetter() == selectedPiecePosition.getColumnLetter() + 1 && (boardSquare.getRowNumber() == 5))) { // we gaan al de squares links en rechts toevoegen
//                    if (boardSquare.getSquareContent() instanceof Pawn && boardSquare.getSquareContent().getColor() == Color.BLACK && boardSquare.getSquareContent().getMoves().size() == 1) { // drie checks moeten we doen, 1 we checken of we naast een pion staan. De pion moet van de tegenpartij zijn, dus de kleur moet gecontroleerd worden. Ten derde moeten we checken of de lijst van de vijandelijke pion op 0 staat(eerste move vijand)
//                        Square validEnPassant = new Square(6, (char) (selectedPiecePosition.getColumnLetter() + 1));
//                        for (Square square : allBoardSquares) {
//                            if (square.equals(validEnPassant)) {
//                                enPassantSquares.add(square);
//                            }
//                        }
//                    }
//                }
//
//                if ((boardSquare.getColumnLetter() == selectedPiecePosition.getColumnLetter() - 1 && (boardSquare.getRowNumber() == 5))) {
//                    if (boardSquare.getSquareContent() instanceof Pawn && boardSquare.getSquareContent().getColor() == Color.BLACK && boardSquare.getSquareContent().getMoves().size() == 1) { // drie checks moeten we doen, 1 we checken of we naast een pion staan. De pion moet van de tegenpartij zijn, dus de kleur moet gecontroleerd worden. Ten derde moeten we checken of de lijst van de vijandelijke pion op 0 staat(eerste move vijand)
//                        Square validEnPassant = new Square(6, (char) (selectedPiecePosition.getColumnLetter() - 1));
//                        for (Square square : allBoardSquares) {
//                            if (square.equals(validEnPassant)) {
//                                enPassantSquares.add(square);
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        return enPassantSquares;
//    }


//    public List<Square> getAllPossibleMoves(Color playerColor) {
//        List<Square> allPossibleMoves = new ArrayList<>();
//        if (playerColor == Color.WHITE) {
//            for (Piece whitePiece : whitePieces) {
//                if (whitePiece instanceof Pawn) {
//                    allPossibleMoves.addAll(getValidMoveSquaresPawn(whitePiece));
//                } else {
//                    allPossibleMoves.addAll(getValidMoveSquares(whitePiece));
//                }
//            }
//        } else {
//            for (Piece blackPiece : blackPieces) {
//                if (blackPiece instanceof Pawn) {
//                    allPossibleMoves.addAll(getValidMoveSquaresPawn(blackPiece));
//                } else {
//                    allPossibleMoves.addAll(getValidMoveSquares(blackPiece));
//                }
//            }
//        }
//        return allPossibleMoves;
//    }
//
//    public boolean defineCheckStatus(King king) {
//        boolean kingIsChecked = false;
//        Square kingPosition = king.getPosition();
//        List<Square> allPossibleMoves;
//        if (king.getColor() == Color.WHITE) {
//            allPossibleMoves = getAllPossibleMoves(Color.BLACK);
//        } else {
//            allPossibleMoves = getAllPossibleMoves(Color.WHITE);
//        }
//
//        for (Square possibleMove : allPossibleMoves) {
//            if (possibleMove.equals(kingPosition)) {
//                kingIsChecked = true;
//                break;
//            }
//        }
//        return kingIsChecked;
//    }

//    public boolean moveCheckSimulation(King ownKing, Square targetSquare) {
//        Square startPosition = ownKing.getPosition(); // set the previous content to null because the piece is moved
//        startPosition.setSquareContent(null);
//
//        ownKing.setPosition(targetSquare); // assigns the new square to the piece
//        targetSquare.setSquareContent(ownKing); // assigns piece to the new square
////                    System.out.println(selectedPiece.getPosition());
//        boolean isChecked = false;
//        List<Piece> opponentPieces = new ArrayList<>();
//        if (ownKing.getColor() == Color.WHITE) {
//            opponentPieces = getBlackPieces();
//        } else {
//            opponentPieces = getWhitePieces();
//        }
//        for (Piece opponentPiece : opponentPieces) {
//            List<Square> validMovesPiece;
//            Square originalPosition = opponentPiece.getPosition();
//            validMovesPiece = opponentPiece.getValidMoveSquares(opponentPiece);
//
//            for (Square validMove : validMovesPiece) {
//                if (validMove.getSquareContent() == null) {
//                    opponentPiece.setPosition(validMove);
//                    validMove.setSquareContent(opponentPiece);
//
//                    isChecked = defineCheckStatus(ownKing);
//
//                    opponentPiece.setPosition(originalPosition);
//                    validMove.setSquareContent(null);
//
//                } else {
//                    Piece originalContent = validMove.getSquareContent();
//                    opponentPiece.setPosition(validMove);
//                    validMove.setSquareContent(opponentPiece);
//                    originalContent.setPosition(null);
//
//                    isChecked = defineCheckStatus(ownKing);
//
//                    validMove.setSquareContent(originalContent);
//                    originalContent.setPosition(validMove);
//                    opponentPiece.setPosition(originalPosition);
//                    originalPosition.setSquareContent(opponentPiece);
//                }
//
//                if (isChecked) {
//                    break;
//                }
//            }
//        }
//        startPosition.setSquareContent(ownKing);
//        ownKing.setPosition(startPosition);
//
//        return isChecked;
//    }
}


