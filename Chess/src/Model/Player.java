package Model;

import Model.ChessPieces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private String player;
    private int wins;
    private int draws;
    private int losses;
    private Color color;
    private List<Piece> pieces;
    private Board gameBoard;
    private MovesValidator movesValidator;

    public void setMovesValidator(MovesValidator movesValidator) {
        this.movesValidator = movesValidator;
    }

    public List<Piece> getPieces() {
        return pieces;
    }
//    private List<Piece> capturedPieces;


    public Player(String player) {
        this.player = player;
        this.pieces = new ArrayList<>();
    }

    public void initializePieces() {
//  Hoe krijgen we de lijst van squares beschikbaar bij Player? Er is geen link met Board.
//        Ik heb het toegevoegd. Kan niet anders denk ik (Dave)
        if (color == Color.WHITE) {
//        pawns
            for (int i = 0; i < 8; i++) {
                int pawnRow = 2;
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

//        queen
            char queenColumn = 'D';
            int queenRow = 1;
            startPosition = lookupSquare(queenColumn, queenRow);
            pieces.add(new Queen(Color.WHITE, startPosition));
            startPosition.setSquareContent(pieces.get(pieces.size() - 1));


//        Knights
            char knightOneColumn = 'B';
            char knightTwoColumn = 'G';
            int knightRow = 1;
            startPosition = lookupSquare(knightOneColumn, knightRow);
            pieces.add(new Knight(Color.WHITE, startPosition));
            startPosition.setSquareContent(pieces.get(pieces.size() - 1));
            startPosition = lookupSquare(knightTwoColumn, knightRow);
            pieces.add(new Knight(Color.WHITE, startPosition));
            startPosition.setSquareContent(pieces.get(pieces.size() - 1));

//        rooks
            char rookOneColumn = 'A';
            char rookTwoColumn = 'H';
            int rookRow = 1;
            startPosition = lookupSquare(rookOneColumn, rookRow);
            pieces.add(new Rook(Color.WHITE, startPosition));
            startPosition.setSquareContent(pieces.get(pieces.size() - 1));

            startPosition = lookupSquare(rookTwoColumn, rookRow);
            pieces.add(new Rook(Color.WHITE, startPosition));
            startPosition.setSquareContent(pieces.get(pieces.size() - 1));

//        bishops
            char bishopOneColumn = 'C';
            char bishopTwoColumn = 'F';
            int bishopRow = 1;
            startPosition = lookupSquare(bishopOneColumn, bishopRow);
            pieces.add(new Bishop(Color.WHITE, startPosition));
            startPosition.setSquareContent(pieces.get(pieces.size() - 1));

            startPosition = lookupSquare(bishopTwoColumn, bishopRow);
            pieces.add(new Bishop(Color.WHITE, startPosition));
            startPosition.setSquareContent(pieces.get(pieces.size() - 1));


        } else { // for the black Pieces we do the same as above.
//        pawns
            for (int i = 0; i < 8; i++) {
                int pawnRow = 7;
                char pawnColumn = (char) (65 + i);
                Square startPosition = lookupSquare(pawnColumn, pawnRow);
                pieces.add(new Pawn(Color.BLACK, startPosition));
                startPosition.setSquareContent(pieces.get(pieces.size() - 1));

            }
//        king
            char kingColumn = 'E';
            int kingRow = 8;
            Square startPosition = lookupSquare(kingColumn, kingRow);
            pieces.add(new King(Color.BLACK, startPosition));
            startPosition.setSquareContent(pieces.get(pieces.size() - 1));


//        queen
            char queenColumn = 'D';
            int queenRow = 8;
            startPosition = lookupSquare(queenColumn, queenRow);
            pieces.add(new Queen(Color.BLACK, startPosition));
            startPosition.setSquareContent(pieces.get(pieces.size() - 1));


//        Knights
            char knightOneColumn = 'B';
            char knightTwoColumn = 'G';
            int knightRow = 8;
            startPosition = lookupSquare(knightOneColumn, knightRow);
            pieces.add(new Knight(Color.BLACK, startPosition));
            startPosition.setSquareContent(pieces.get(pieces.size() - 1));

            startPosition = lookupSquare(knightTwoColumn, knightRow);
            pieces.add(new Knight(Color.BLACK, startPosition));
            startPosition.setSquareContent(pieces.get(pieces.size() - 1));


//        rooks
            char rookOneColumn = 'A';
            char rookTwoColumn = 'H';
            int rookRow = 8;
            startPosition = lookupSquare(rookOneColumn, rookRow);
            pieces.add(new Rook(Color.BLACK, startPosition));
            startPosition.setSquareContent(pieces.get(pieces.size() - 1));

            startPosition = lookupSquare(rookTwoColumn, rookRow);
            pieces.add(new Rook(Color.BLACK, startPosition));
            startPosition.setSquareContent(pieces.get(pieces.size() - 1));


//        bishops
            char bishopOneColumn = 'C';
            char bishopTwoColumn = 'F';
            int bishopRow = 8;
            startPosition = lookupSquare(bishopOneColumn, bishopRow);
            pieces.add(new Bishop(Color.BLACK, startPosition));
            startPosition.setSquareContent(pieces.get(pieces.size() - 1));

            startPosition = lookupSquare(bishopTwoColumn, bishopRow);
            pieces.add(new Bishop(Color.BLACK, startPosition));
            startPosition.setSquareContent(pieces.get(pieces.size() - 1));

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

    public Piece lookupPiece(char columnLetter, int rowNumber) {
        List<Square> squares = gameBoard.getSquares();
        Piece matchedPiece = null;
        for (Square square : squares) {
            if (columnLetter == square.getColumnLetter() && rowNumber == square.getRowNumber()) {
                matchedPiece = square.getSquareContent();
            }
        }
        return matchedPiece;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setGameBoard(Board gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void selectPiece() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("start: please enter column and row of the piece:");
        String startSquare = keyboard.nextLine().toUpperCase();
        char[] startSquareArray = startSquare.toCharArray();
        char columnLetter = startSquareArray[0];
//        Exception handling still to do! What if no piece is found. values must match board!
        int rowNumber = startSquareArray[1];
//        Exception handling still to do! What if no piece is found. values must match the board

        Piece selectedPiece = lookupPiece(columnLetter, rowNumber);
//        Exception handling still to do! What if no piece is found.

        List<Square> validMoveSquares = movesValidator.getValidMoveSquares(selectedPiece); // we put all the valid square values in a list

        System.out.println("end: please enter column and row of where you want to move the piece:");
        String targetSquare = keyboard.nextLine().toUpperCase();

    }


}
