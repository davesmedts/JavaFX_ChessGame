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

    public List<Piece> getWhitePieces() {
        return whitePieces;
    }

    public List<Piece> getBlackPieces() {
        return blackPieces;
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
                            if ((piece.getColor() != selectedPiece.getColor())) { //only if the piece color is the color of the opponent we are able to move to this position.
                                validMoves.add(boardSquare);
                            }
                        } else if (!pieceFound) {
                            validMoves.add(boardSquare);
                        }
                    }
                }
            }
        }
        return validMoves;
    }

    public List<Square> getValidMoveSquaresPawn(Piece selectedPiece, Player player) {
        List<Square> validMoves = new ArrayList<>(); // list to return
        Map<String, List<Square>> possibleMoves = selectedPiece.getValidMovesPawn(allBoardSquares); //possible movements without check on the board
        Collection<List<Square>> directions = possibleMoves.values(); // Collection of all lists, each list is a direction of movements
        for (List<Square> direction : directions) { // we take one direction list at a time to loop over each direction
//            boolean pieceFound = false; //flag that shows if a piece has been detected.
            for (Square possibleMove : direction) { // we take each square from the direction list
                for (Square boardSquare : allBoardSquares) { // we take all squares on the gameboard to be checked with the squares on of the direction list
                    if (possibleMove.equals(boardSquare)) {
                        Piece piece = boardSquare.getSquareContent();
                        if (piece != null) { // check if a piece is present on the square and if any other piece were found in earlier iterations.
//                            pieceFound = true;
                            if (piece.getColor() != selectedPiece.getColor() && selectedPiece.getPosition().getColumnLetter() != piece.getPosition().getColumnLetter()) { //only if the piece color is the color of the opponent we are able to move to this position, The pawn can only capture diagonally so the columnletters can not be the same.
                                validMoves.add(boardSquare);
                            }
                        } else if (selectedPiece.getPosition().getColumnLetter() == boardSquare.getColumnLetter()) {
                            validMoves.add(boardSquare);
                        } else if (selectedPiece.getPosition().getRowNumber() == 5 || selectedPiece.getPosition().getRowNumber() == 6) { // columnletters don't match && row is 4 or 5
                            List<Square> squaresEnemyPlayer = player.getMoves(); // get the last move of the list
                            int amountSquares = squaresEnemyPlayer.size();
                            Square lastMoveEnemyPlayer = null;
                            if (amountSquares != 0) {
                                lastMoveEnemyPlayer = squaresEnemyPlayer.get(amountSquares - 1);
                                int lastMoveEnemyPlayerRownumber = lastMoveEnemyPlayer.getRowNumber();
                                char lastMoveEnemyPlayerColumnLetter = lastMoveEnemyPlayer.getColumnLetter();

                                if (selectedPiece.getColor().equals(Color.WHITE)) {
                                    lastMoveEnemyPlayer = new Square(lastMoveEnemyPlayerRownumber + 1, lastMoveEnemyPlayerColumnLetter); // the last move of the enemy is to row 5 , but you need to capture by going to row 6
                                } else
                                    lastMoveEnemyPlayer = new Square(lastMoveEnemyPlayerRownumber -1 , lastMoveEnemyPlayerColumnLetter);
                            }

                            if (possibleMove.equals(lastMoveEnemyPlayer)) {
                                validMoves.addAll(enPassant(selectedPiece, lastMoveEnemyPlayer));

                            }
                        }
                    }
                }
            }

        }
        return validMoves;
    }


    private List<Square> enPassant(Piece selectedPiece, Square lastMoveEnemyPlayer) {
        List<Square> enPassantSquares = new ArrayList<>();
        Square selectedPiecePosition = selectedPiece.getPosition();


        if (selectedPiecePosition.getRowNumber() == 5 && selectedPiece.getColor() == Color.WHITE) {
            for (Square boardSquare : allBoardSquares) {
                if ((boardSquare.getColumnLetter() == selectedPiecePosition.getColumnLetter() + 1 && (boardSquare.getRowNumber() == 5))) { // we gaan al de squares links en rechts toevoegen
                    if (lastMoveEnemyPlayer.getColumnLetter() - 1 == selectedPiecePosition.getColumnLetter()) { //niet al de vakken links en rechts toevoegen
                        if (boardSquare.getSquareContent() instanceof Pawn && boardSquare.getSquareContent().getColor() == Color.BLACK && boardSquare.getSquareContent().getMoves().size() == 1) { // drie checks moeten we doen, 1 we checken of we naast een pion staan. De pion moet van de tegenpartij zijn, dus de kleur moet gecontroleerd worden. Ten derde moeten we checken of de lijst van de vijandelijke pion op 0 staat(eerste move vijand)
                            Square validEnPassant = new Square(6, (char) (selectedPiecePosition.getColumnLetter() + 1));
                            for (Square square : allBoardSquares) {
                                if (square.equals(validEnPassant)) {
                                    enPassantSquares.add(square);
                                }
                            }
                        }
                    }
                }

                if ((boardSquare.getColumnLetter() == selectedPiecePosition.getColumnLetter() - 1 && (boardSquare.getRowNumber() == 5))) {
                    if (lastMoveEnemyPlayer.getColumnLetter() + 1 == selectedPiecePosition.getColumnLetter()) {
                        if (boardSquare.getSquareContent() instanceof Pawn && boardSquare.getSquareContent().getColor() == Color.BLACK && boardSquare.getSquareContent().getMoves().size() == 1) { // drie checks moeten we doen, 1 we checken of we naast een pion staan. De pion moet van de tegenpartij zijn, dus de kleur moet gecontroleerd worden. Ten derde moeten we checken of de lijst van de vijandelijke pion op 0 staat(eerste move vijand)
                            Square validEnPassant = new Square(6, (char) (selectedPiecePosition.getColumnLetter() - 1));
                            for (Square square : allBoardSquares) {
                                if (square.equals(validEnPassant)) {

                                    enPassantSquares.add(square);
                                }
                            }
                        }
                    }
                }
            }
        }


        if (selectedPiecePosition.getRowNumber() == 6 && selectedPiece.getColor() == Color.BLACK) {
            for (Square boardSquare : allBoardSquares) {
                if ((boardSquare.getColumnLetter() == selectedPiecePosition.getColumnLetter() + 1 && (boardSquare.getRowNumber() == 6))) { // we gaan al de squares links en rechts toevoegen
                    if (lastMoveEnemyPlayer.getColumnLetter() - 1 == selectedPiecePosition.getColumnLetter()) {
                        if (boardSquare.getSquareContent() instanceof Pawn && boardSquare.getSquareContent().getColor() == Color.WHITE && boardSquare.getSquareContent().getMoves().size() == 1) { // drie checks moeten we doen, 1 we checken of we naast een pion staan. De pion moet van de tegenpartij zijn, dus de kleur moet gecontroleerd worden. Ten derde moeten we checken of de lijst van de vijandelijke pion op 0 staat(eerste move vijand)
                            Square validEnPassant = new Square(5, (char) (selectedPiecePosition.getColumnLetter() + 1));
                            for (Square square : allBoardSquares) {
                                if (square.equals(validEnPassant)) {
                                    enPassantSquares.add(square);
                                }
                            }
                        }
                    }
                }

                if ((boardSquare.getColumnLetter() == selectedPiecePosition.getColumnLetter() - 1 && (boardSquare.getRowNumber() == 6))) {
                    if (lastMoveEnemyPlayer.getColumnLetter() + 1 == selectedPiecePosition.getColumnLetter()) {
                        if (boardSquare.getSquareContent() instanceof Pawn && boardSquare.getSquareContent().getColor() == Color.WHITE && boardSquare.getSquareContent().getMoves().size() == 1) { // drie checks moeten we doen, 1 we checken of we naast een pion staan. De pion moet van de tegenpartij zijn, dus de kleur moet gecontroleerd worden. Ten derde moeten we checken of de lijst van de vijandelijke pion op 0 staat(eerste move vijand)
                            Square validEnPassant = new Square(5, (char) (selectedPiecePosition.getColumnLetter() - 1));
                            for (Square square : allBoardSquares) {
                                if (square.equals(validEnPassant)) {
                                    enPassantSquares.add(square);
                                }
                            }
                        }
                    }
                }
            }
        }
        return enPassantSquares;
    }


    public List<Square> getValidMoveSquaresPawn(Piece selectedPiece) {
        List<Square> validMoves = new ArrayList<>(); // list to return
        Map<String, List<Square>> possibleMoves = selectedPiece.getValidMovesPawn(allBoardSquares); //possible movements without check on the board
        Collection<List<Square>> directions = possibleMoves.values(); // Collection of all lists, each list is a direction of movements
        for (List<Square> direction : directions) { // we take one direction list at a time to loop over each direction
//            boolean pieceFound = false; //flag that shows if a piece has been detected.
            for (Square possibleMove : direction) { // we take each square from the direction list
                for (Square boardSquare : allBoardSquares) { // we take all squares on the gameboard to be checked with the squares on of the direction list
                    if (possibleMove.equals(boardSquare)) {
                        Piece piece = boardSquare.getSquareContent();
                        if (piece != null) { // check if a piece is present on the square and if any other piece were found in earlier iterations.
//                            pieceFound = true;
                            if (piece.getColor() != selectedPiece.getColor() && selectedPiece.getPosition().getColumnLetter() != piece.getPosition().getColumnLetter()) { //only if the piece color is the color of the opponent we are able to move to this position, The pawn can only capture diagonally so the columnletters can not be the same.
                                validMoves.add(boardSquare);
                            }
                        } else if (selectedPiece.getPosition().getColumnLetter() == boardSquare.getColumnLetter()) {
                            validMoves.add(boardSquare);
                        } else if (selectedPiece.getPosition().getRowNumber() == 5 || selectedPiece.getPosition().getRowNumber() == 4) { // columnletters don't match && row is 4 or 5
                            validMoves.addAll(enPassant(selectedPiece));
                        }
                    }
                }
            }
        }
        return validMoves;
    }

    private List<Square> enPassant(Piece selectedPiece) {
        List<Square> enPassantSquares = new ArrayList<>();
        Square selectedPiecePosition = selectedPiece.getPosition();

        if (selectedPiecePosition.getRowNumber() == 5 && selectedPiece.getColor() == Color.WHITE) {
            for (Square boardSquare : allBoardSquares) {
                if ((boardSquare.getColumnLetter() == selectedPiecePosition.getColumnLetter() + 1 && (boardSquare.getRowNumber() == 5))) { // we gaan al de squares links en rechts toevoegen
                    if (boardSquare.getSquareContent() instanceof Pawn && boardSquare.getSquareContent().getColor() == Color.BLACK && boardSquare.getSquareContent().getMoves().size() == 1) { // drie checks moeten we doen, 1 we checken of we naast een pion staan. De pion moet van de tegenpartij zijn, dus de kleur moet gecontroleerd worden. Ten derde moeten we checken of de lijst van de vijandelijke pion op 0 staat(eerste move vijand)
                        Square validEnPassant = new Square(6, (char) (selectedPiecePosition.getColumnLetter() + 1));
                        for (Square square : allBoardSquares) {
                            if (square.equals(validEnPassant)) {
                                enPassantSquares.add(square);
                            }
                        }
                    }
                }

                if ((boardSquare.getColumnLetter() == selectedPiecePosition.getColumnLetter() - 1 && (boardSquare.getRowNumber() == 5))) {
                    if (boardSquare.getSquareContent() instanceof Pawn && boardSquare.getSquareContent().getColor() == Color.BLACK && boardSquare.getSquareContent().getMoves().size() == 1) { // drie checks moeten we doen, 1 we checken of we naast een pion staan. De pion moet van de tegenpartij zijn, dus de kleur moet gecontroleerd worden. Ten derde moeten we checken of de lijst van de vijandelijke pion op 0 staat(eerste move vijand)
                        Square validEnPassant = new Square(6, (char) (selectedPiecePosition.getColumnLetter() - 1));
                        for (Square square : allBoardSquares) {
                            if (square.equals(validEnPassant)) {
                                enPassantSquares.add(square);
                            }
                        }
                    }
                }
            }
        }

        return enPassantSquares;
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


