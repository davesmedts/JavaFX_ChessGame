package model;

import exceptions.*;
import model.chessPieces.*;

import java.util.*;

public class Player {
    private String player;
    private int wins;
    private int draws;
    private int losses;
    private Color color;
    private List<Piece> pieces;
    private Board gameBoard;
    private MovesValidator movesValidator;
    private List<Square> moves;
    private boolean isWinner;

    public Player(String player) {
        this.player = player;
        this.pieces = new ArrayList<>();
        this.moves = new ArrayList<>();
        this.isWinner = false;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public List<Square> getMoves() {
        return moves;
    }

    public Square getLastMove() {
        if (moves.isEmpty()) {
            return null;
        } else {
            return moves.get(moves.size() - 1);
        }
    }


    public void setMovesValidator(MovesValidator movesValidator) {
        this.movesValidator = movesValidator;
    }

    public List<Piece> getPieces() {
        return pieces;
    }
//    private List<Piece> capturedPieces;


    public void initializePieces() {
        if (color == Color.WHITE) {
//        pawns
            for (int i = 0; i < 5; i++) {
                int pawnRow = 4;
                char pawnColumn = (char) (65 + i);
//              Hier moeten we de juiste squares ophalen om positie van Piece te linken aan de juiste square op het bord.
                Square startPosition = lookupSquare(pawnColumn, pawnRow);
                pieces.add(new Pawn(Color.WHITE, startPosition));
                startPosition.setSquareContent(pieces.get(pieces.size() - 1));
            }
//        king
            char kingColumn = 'E';
            int kingRow = 1;
            Square startPosition = lookupSquare(kingColumn, kingRow); // look for matching square in squares list
            pieces.add(new King(Color.WHITE, startPosition)); // create new piece with looked up square
            startPosition.setSquareContent(pieces.get(pieces.size() - 1)); // take the last added Piece and assign the piece to the square.
//          This generic way of working will come back for all the other pieces as well.

////        queen
//            char queenColumn = 'D';
//            int queenRow = 1;
//            startPosition = lookupSquare(queenColumn, queenRow);
//            pieces.add(new Queen(Color.WHITE, startPosition));
//            startPosition.setSquareContent(pieces.get(pieces.size() - 1));
//
//
////        Knights
//            char knightOneColumn = 'B';
//            char knightTwoColumn = 'G';
//            int knightRow = 1;
//            startPosition = lookupSquare(knightOneColumn, knightRow);
//            pieces.add(new Knight(Color.WHITE, startPosition));
//            startPosition.setSquareContent(pieces.get(pieces.size() - 1));
//            startPosition = lookupSquare(knightTwoColumn, knightRow);
//            pieces.add(new Knight(Color.WHITE, startPosition));
//            startPosition.setSquareContent(pieces.get(pieces.size() - 1));
//
////        rooks
            char rookOneColumn = 'A';
            char rookTwoColumn = 'H';
            int rookRow = 1;
            startPosition = lookupSquare(rookOneColumn, rookRow);
            pieces.add(new Rook(Color.WHITE, startPosition));
            startPosition.setSquareContent(pieces.get(pieces.size() - 1));

            startPosition = lookupSquare(rookTwoColumn, rookRow);
            pieces.add(new Rook(Color.WHITE, startPosition));
            startPosition.setSquareContent(pieces.get(pieces.size() - 1));

////        bishops
//            char bishopOneColumn = 'C';
//            char bishopTwoColumn = 'F';
//            int bishopRow = 1;
//            startPosition = lookupSquare(bishopOneColumn, bishopRow);
//            pieces.add(new Bishop(Color.WHITE, startPosition));
//            startPosition.setSquareContent(pieces.get(pieces.size() - 1));
//
//            startPosition = lookupSquare(bishopTwoColumn, bishopRow);
//            pieces.add(new Bishop(Color.WHITE, startPosition));
//            startPosition.setSquareContent(pieces.get(pieces.size() - 1));
//

        } else { // for the black Pieces we do the same as above.
//            //        pawns
//            for (int i = 0; i < 5; i++) {
//                int pawnRow = 7;
//                char pawnColumn = (char) (65 + i);
////              Hier moeten we de juiste squares ophalen om positie van Piece te linken aan de juiste square op het bord.
//                Square startPosition = lookupSquare(pawnColumn, pawnRow);
//                pieces.add(new Pawn(Color.BLACK, startPosition));
//                startPosition.setSquareContent(pieces.get(pieces.size() - 1));
//            }

//        king
            char kingColumn = 'E';
            int kingRow = 8;
            Square startPosition = lookupSquare(kingColumn, kingRow);
            pieces.add(new King(Color.BLACK, startPosition));
            startPosition.setSquareContent(pieces.get(pieces.size() - 1));


////        queen
//            char queenColumn = 'D';
//            int queenRow = 8;
//            startPosition = lookupSquare(queenColumn, queenRow);
//            pieces.add(new Queen(Color.BLACK, startPosition));
//            startPosition.setSquareContent(pieces.get(pieces.size() - 1));
//
//
////        Knights
//            char knightOneColumn = 'B';
//            char knightTwoColumn = 'G';
//            int knightRow = 8;
//            startPosition = lookupSquare(knightOneColumn, knightRow);
//            pieces.add(new Knight(Color.BLACK, startPosition));
//            startPosition.setSquareContent(pieces.get(pieces.size() - 1));
//
//            startPosition = lookupSquare(knightTwoColumn, knightRow);
//            pieces.add(new Knight(Color.BLACK, startPosition));
//            startPosition.setSquareContent(pieces.get(pieces.size() - 1));
//
//
////        rooks
//            char rookOneColumn = 'A';
//            char rookTwoColumn = 'H';
//            int rookRow = 8;
//            startPosition = lookupSquare(rookOneColumn, rookRow);
//            pieces.add(new Rook(Color.BLACK, startPosition));
//            startPosition.setSquareContent(pieces.get(pieces.size() - 1));
//
//            startPosition = lookupSquare(rookTwoColumn, rookRow);
//            pieces.add(new Rook(Color.BLACK, startPosition));
//            startPosition.setSquareContent(pieces.get(pieces.size() - 1));
//
//
////        bishops
//            char bishopOneColumn = 'C';
//            char bishopTwoColumn = 'F';
//            int bishopRow = 8;
//            startPosition = lookupSquare(bishopOneColumn, bishopRow);
//            pieces.add(new Bishop(Color.BLACK, startPosition));
//            startPosition.setSquareContent(pieces.get(pieces.size() - 1));
//
//            startPosition = lookupSquare(bishopTwoColumn, bishopRow);
//            pieces.add(new Bishop(Color.BLACK, startPosition));
//            startPosition.setSquareContent(pieces.get(pieces.size() - 1));

        }

        if (color == Color.WHITE) {
            movesValidator.setWhitePieces(pieces);
        } else {
            movesValidator.setBlackPieces(pieces);
        }
    }

    //    this method can be used to find a square that matches the column and row arguments
    public Square lookupSquare(char columnLetter, int rowNumber) {
        List<Square> squares = gameBoard.getSquares();
        Square matchedSquare = null;
        for (Square square : squares) {
            if (columnLetter == square.getColumnLetter() && rowNumber == square.getRowNumber()) {
                matchedSquare = square;
            }
        }
        return matchedSquare;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setGameBoard(Board gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void selectPiece(Player player, Player opponent) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(this.player + ": Voer de kolomletter en het rijnummer in van het stuk dat je wil verplaatsen:");
        String startSquare = keyboard.nextLine().toUpperCase();

        try {
            char[] startSquareArray = startSquare.toCharArray();
            if (startSquareArray.length != 2) {
                throw new IllegalPieceSelectionException("Gelieve exact 2 characters in te voeren, eerst de kolomletter en nadien het rijnummer. Probeer opnieuw.");
            }
            char columnLetter = startSquareArray[0];
            int rowNumber = Character.getNumericValue(startSquareArray[1]);

            Piece selectedPiece = gameBoard.lookupSquare(columnLetter, rowNumber).getSquareContent();
            if (selectedPiece.getColor() == color) {
                List<Square> validMoveSquares = selectedPiece.getValidMoves(gameBoard, opponent); // we put all the valid square values in a list
                if (validMoveSquares.isEmpty()) {
                    throw new IllegalPieceSelectionException("Er zijn geen mogelijke zetten beschikbaar, probeer opnieuw");
                }
                System.out.println(validMoveSquares);
                movePiece(validMoveSquares, selectedPiece, opponent);
//                }
            } else {
                throw new IllegalPieceSelectionException("niet de juiste kleur");
            }
        } catch (IllegalPieceSelectionException ex) {
            System.out.println(ex.getMessage());
            selectPiece(player, opponent);
        } catch (NullPointerException ex) {
            System.out.println("Kolom of rij staat niet op het bord of bevat geen eigen piece, Probeer opnieuw iets te selecteren");
            selectPiece(player, opponent);
        }
    }

    public void movePiece(List<Square> validMoveSquares, Piece selectedPiece, Player opponent) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(player + ": please enter column and row of where you want to move the piece:");
        String targetSquare = keyboard.nextLine().toUpperCase();
        char[] targetSquareArray = targetSquare.toCharArray();
        char columnLetter = targetSquareArray[0];
//        Exception handling still to do! What if no piece is found. values must match board!
        int rowNumber = Character.getNumericValue(targetSquareArray[1]); // the getNumericValue method transforms the character to a numeric value.
//        Exception handling still to do! What if no piece is found. values must match the board
        King king = null;
        try {
            Square targetSquareObject = lookupSquare(columnLetter, rowNumber);
            Piece targetSquareContent = targetSquareObject.getSquareContent();

            if (targetSquareObject == null) {
                throw new IllegalMoveException("Invoer niet gevonden op het bord, probeer opnieuw: ");
            }

            boolean isFound = false;
            Square startPosition = selectedPiece.getPosition(); // set the previous content to null because the piece is moved
            for (Square validMoveSquare : validMoveSquares) {
                if (validMoveSquare == targetSquareObject) {
                    isFound = true;
                    startPosition.setSquareContent(null);
                    if (targetSquareObject.getSquareContent() != null && targetSquareObject.getSquareContent().getColor() != selectedPiece.getColor()) {
                        targetSquareObject.getSquareContent().capturePiece();
                    }
                    selectedPiece.setPosition(targetSquareObject); // assigns the new square to the piece
                    targetSquareObject.setSquareContent(selectedPiece); // assigns piece to the new square

                    if (selectedPiece instanceof King
                            && selectedPiece.getMoves().size() == 0
                            && (targetSquareObject.equals(new Square(1, 'C'))
                            || targetSquareObject.equals(new Square(1, 'G'))
                            || targetSquareObject.equals(new Square(8, 'C'))
                            || targetSquareObject.equals(new Square(8, 'G')))) {
                        ((King) selectedPiece).castlingMove(targetSquareObject, gameBoard);
                    }

                    if (selectedPiece instanceof Pawn && targetSquareContent == null && targetSquareObject.getColumnLetter() != startPosition.getColumnLetter()) {
                        ((Pawn) selectedPiece).enPassantCapture(targetSquareObject, gameBoard);
                    }
                }
            }
            if (!isFound) {
                throw new IllegalMoveException("Invoer behoort niet tot de mogelijke zetten, probeer opnieuw: ");
            }
//            king = kingLookup(color);
//            boolean kingIsChecked = king.defineCheckStatus(gameBoard, opponent);
//            if (kingIsChecked) {
//                selectedPiece.setPosition(startPosition);
//                startPosition.setSquareContent(selectedPiece);
//                targetSquareObject.setSquareContent(targetSquareContent);
//                if (targetSquareContent != null) {
//                    targetSquareContent.setPosition(targetSquareObject);
//                }
//                throw new IllegalMoveException("Je kan deze zet niet doen omdat je jezelf dan in check gaat zetten. Probeer opnieuw: ");
//            } else {
//                king.setChecked(false);
//            }
            moves.add(targetSquareObject); // add move to moves list in the player
            selectedPiece.addMove(targetSquareObject); // add the move to the move list in piece

        } catch (IllegalMoveException ime) {
            System.out.println(ime.getMessage());
            selectPiece(this, opponent);
        }
//        Exception handling still to do! What if no piece is found.
//        isChecked - check
//        King lookup
        Color opponentColor;
        if (color == Color.WHITE) {
            opponentColor = Color.BLACK;
        } else {
            opponentColor = Color.WHITE;
        }

//        King opponentKing = kingLookup(opponentColor);
//        boolean opponentIsChecked = opponentKing.defineCheckStatus(gameBoard, this);
//        if (opponentIsChecked) {
//            opponentKing.setChecked(true);
//        } else {
//            opponentKing.setChecked(false);
//        }
//
////        isCheckMate - check
//        if (opponentKing.isChecked()) {
//            boolean isCheckMate = opponentKing.defineCheckMateStatus(gameBoard, this);
//            if (isCheckMate) {
//                opponentKing.setCheckmate(true);
//                isWinner = true;
//            }
//        }
//
//        if (opponentIsChecked && !opponentKing.isCheckmate()) {
//            System.out.println(opponentColor + " staat schaak");
//        } else if (opponentKing.isCheckmate()) {
//            System.out.println("Schaakmat!");
//        }

        if (selectedPiece instanceof Pawn && selectedPiece.getPosition().getRowNumber() == 8 && selectedPiece.getColor() == Color.WHITE) {
            System.out.println("U kan uw pion promoveren. Geef de letter van het stuk in (Q,K,B,R):");
            String desiredPiece = keyboard.nextLine().toUpperCase();
            ((Pawn) selectedPiece).promotePiece(desiredPiece, selectedPiece);
        }
    }

    public King kingLookup(Color playerColor) {
        Piece king = null;
        for (Square square : gameBoard.getSquares()) {
            if (square.getSquareContent() instanceof King && square.getSquareContent().getColor() == playerColor) {
                king = square.getSquareContent();
            }
        }
        return (King) king;
    }

    @Override
    public String toString() {
        return player;
    }

    public String log(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("\"%s\"",player)).append(String.format(",%s", moves));
        return builder.toString();
    }
}