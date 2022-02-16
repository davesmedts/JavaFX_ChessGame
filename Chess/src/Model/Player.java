package Model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String player;
    private int wins;
    private int draws;
    private int losses;
    private Color color;
    private List<Piece> pieces;
    private Board gameBoard;
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
            }
//        king
            char kingColumn = 'E';
            int kingRow = 1;
            Square startPosition = lookupSquare(kingColumn, kingRow);
            pieces.add(new King(Color.WHITE, startPosition));

//        queen
            char queenColumn = 'D';
            int queenRow = 1;
            startPosition = lookupSquare(queenColumn, queenRow);
            pieces.add(new Queen(Color.WHITE, startPosition));

//        Knights
            char knightOneColumn = 'B';
            char knightTwoColumn = 'G';
            int knightRow = 1;
            startPosition = lookupSquare(knightOneColumn, knightRow);
            pieces.add(new Knight(Color.WHITE, startPosition));
            startPosition = lookupSquare(knightTwoColumn, knightRow);
            pieces.add(new Knight(Color.WHITE, startPosition));

//        rooks
            char rookOneColumn = 'A';
            char rookTwoColumn = 'H';
            int rookRow = 1;
            startPosition = lookupSquare(rookOneColumn, rookRow);
            pieces.add(new Knight(Color.WHITE, startPosition));
            startPosition = lookupSquare(rookTwoColumn, rookRow);
            pieces.add(new Knight(Color.WHITE, startPosition));

//        bishops
            char bishopOneColumn = 'C';
            char bishopTwoColumn = 'F';
            int bishopRow = 1;
            startPosition = lookupSquare(bishopOneColumn, bishopRow);
            pieces.add(new Knight(Color.WHITE, startPosition));
            startPosition = lookupSquare(bishopTwoColumn, bishopRow);
            pieces.add(new Knight(Color.WHITE, startPosition));

        } else { // for the black Pieces we do the same as above.
//        pawns
            for (int i = 0; i < 8; i++) {
                int pawnRow = 7;
                char pawnColumn = (char) (65 + i);
                Square startPosition = lookupSquare(pawnColumn, pawnRow);
                pieces.add(new Pawn(Color.BLACK, startPosition));
            }
//        king
            char kingColumn = 'E';
            int kingRow = 8;
            Square startPosition = lookupSquare(kingColumn, kingRow);
            pieces.add(new King(Color.BLACK, startPosition));

//        queen
            char queenColumn = 'D';
            int queenRow = 8;
            startPosition = lookupSquare(queenColumn, queenRow);
            pieces.add(new Queen(Color.BLACK, startPosition));

//        Knights
            char knightOneColumn = 'B';
            char knightTwoColumn = 'G';
            int knightRow = 8;
            startPosition = lookupSquare(knightOneColumn, knightRow);
            pieces.add(new Knight(Color.BLACK, startPosition));
            startPosition = lookupSquare(knightTwoColumn, knightRow);
            pieces.add(new Knight(Color.BLACK, startPosition));

//        rooks
            char rookOneColumn = 'A';
            char rookTwoColumn = 'H';
            int rookRow = 8;
            startPosition = lookupSquare(rookOneColumn, rookRow);
            pieces.add(new Knight(Color.BLACK, startPosition));
            startPosition = lookupSquare(rookTwoColumn, rookRow);
            pieces.add(new Knight(Color.BLACK, startPosition));

//        bishops
            char bishopOneColumn = 'C';
            char bishopTwoColumn = 'F';
            int bishopRow = 8;
            startPosition = lookupSquare(bishopOneColumn, bishopRow);
            pieces.add(new Knight(Color.BLACK, startPosition));
            startPosition = lookupSquare(bishopTwoColumn, bishopRow);
            pieces.add(new Knight(Color.BLACK, startPosition));
        }
    }

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

    public void setColor(Color color) {
        this.color = color;
    }

    public void setGameBoard(Board gameBoard) {
        this.gameBoard = gameBoard;
    }
}
