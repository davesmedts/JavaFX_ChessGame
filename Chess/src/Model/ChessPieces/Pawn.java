package Model.ChessPieces;

import Model.Color;
import Model.Square;

import java.util.*;

public class Pawn extends Piece {
    public Pawn(Color color, Square startPosition) {
        super(color, startPosition);
    }

    @Override
    public Map<String, List<Square>> getValidMovesPawn(List<Square> allBoardSquares) {
        Map<String, List<Square>> possibleSquares = new HashMap<>();

        List<Square> north = new ArrayList<>();
        List<Square> south = new ArrayList<>();
        List<Square> west = new ArrayList<>();
        List<Square> east = new ArrayList<>();
        List<Square> northEast = new ArrayList<>();
        List<Square> northWest = new ArrayList<>();
        List<Square> southEast = new ArrayList<>();
        List<Square> southWest = new ArrayList<>();

        //        get the current row and column of the piece that has to move
        char column = super.getPosition().getColumnLetter();
        int row = super.getPosition().getRowNumber();

        if (super.getColor() == Color.WHITE) {
//        north
            if (row + 1 <= 8) { // check if target is whithin the scope of the board.
                int newRow = row + 1;
                char newColumn = column;
                north.add(new Square(newRow, newColumn));

                for (Square boardSquare : allBoardSquares) { //loop over all the board squares and check if there is a piece on it. we can add the square to the list if the piece is oblique
                    Piece piece = boardSquare.getSquareContent();
                    if (piece != null) {
                        char pieceColumnLetter = piece.getPosition().getColumnLetter();
                        int pieceRowNumber = piece.getPosition().getRowNumber();

                        char selectedPieceCurrentColumnLetter = super.getPosition().getColumnLetter();
                        int selectedPieceCurrentRow = super.getPosition().getRowNumber();

                        if (pieceRowNumber == selectedPieceCurrentRow + 1 && (pieceColumnLetter == selectedPieceCurrentColumnLetter + 1 || pieceColumnLetter == selectedPieceCurrentColumnLetter - 1)) {
                            north.add(new Square(pieceRowNumber, pieceColumnLetter));
                        }

                    }
                }
//                List<Square> enPassantSquares = enPassant(allBoardSquares);
//                north.addAll(enPassantSquares);
            }
            if (super.getMoves().size() == 0) { //only on the first move a pawn can move 2 squares
                int newRow = row + 2;
                char newColumn = column;
                north.add(new Square(newRow, newColumn));

                for (Square boardSquare : allBoardSquares) { //loop over all the board squares and check if there is a piece on it. we can add the square to the list if the piece is oblique
                    Piece piece = boardSquare.getSquareContent();
                    if (piece != null) {
                        char pieceColumnLetter = piece.getPosition().getColumnLetter();
                        char selectedPieceCurrentColumnLetter = super.getPosition().getColumnLetter();
                        int pieceRowNumber = piece.getPosition().getRowNumber();
                        int selectedPieceCurrentRow = super.getPosition().getRowNumber();
                        if (pieceRowNumber == selectedPieceCurrentRow + 1 && (pieceColumnLetter == selectedPieceCurrentColumnLetter + 1 || pieceColumnLetter == selectedPieceCurrentColumnLetter - 1)) {
                            north.add(new Square(pieceRowNumber, pieceColumnLetter));
                        }

                    }
                }
            }
        } else if (super.getColor() == Color.BLACK) {
            //        north
            if (row - 1 > 0) { // check if target is whithin the scope of the board.
                int newRow = row - 1;
                char newColumn = column;
                south.add(new Square(newRow, newColumn));

                for (Square boardSquare : allBoardSquares) { //loop over all the board squares and check if there is a piece on it. we can add the square to the list if the piece is oblique
                    Piece piece = boardSquare.getSquareContent();
                    if (piece != null) {
                        char pieceColumnLetter = piece.getPosition().getColumnLetter();
                        char selectedPieceCurrentColumnLetter = super.getPosition().getColumnLetter();
                        int pieceRowNumber = piece.getPosition().getRowNumber();
                        int selectedPieceCurrentRow = super.getPosition().getRowNumber();
                        if (pieceRowNumber == selectedPieceCurrentRow - 1 && (pieceColumnLetter == selectedPieceCurrentColumnLetter + 1 || pieceColumnLetter == selectedPieceCurrentColumnLetter - 1)) {
                            south.add(new Square(pieceRowNumber, pieceColumnLetter));
                        }
                    }
                }
            }

            if (super.getMoves().size() == 0) { //only on the first move a pawn can move 2 squares
                int newRow = row - 2;
                char newColumn = column;
                south.add(new Square(newRow, newColumn));

                for (Square boardSquare : allBoardSquares) { //loop over all the board squares and check if there is a piece on it. we can add the square to the list if the piece is oblique
                    Piece piece = boardSquare.getSquareContent();
                    if (piece != null) {
                        char pieceColumnLetter = piece.getPosition().getColumnLetter();
                        char selectedPieceCurrentColumnLetter = super.getPosition().getColumnLetter();
                        int pieceRowNumber = piece.getPosition().getRowNumber();
                        int selectedPieceCurrentRow = super.getPosition().getRowNumber();
                        if (pieceRowNumber == selectedPieceCurrentRow - 1 && (pieceColumnLetter == selectedPieceCurrentColumnLetter + 1 || pieceColumnLetter == selectedPieceCurrentColumnLetter - 1)) {
                            south.add(new Square(pieceRowNumber, pieceColumnLetter));
                        }
                    }

                }

            }

        }

        possibleSquares.put("north", north);
        possibleSquares.put("east", east);
        possibleSquares.put("south", south);
        possibleSquares.put("west", west);
        possibleSquares.put("northEast", northEast);
        possibleSquares.put("northWest", northWest);
        possibleSquares.put("southEast", southEast);
        possibleSquares.put("southWest", southWest);

        return possibleSquares;
    }

    public List<Square> enPassant(List<Square> allBoardSquares) {
        List<Square> enPassantSquares = new ArrayList<>();

        if (super.getPosition().getRowNumber() == 5 && super.getColor() == Color.WHITE) {
            for (Square boardSquare : allBoardSquares) {
                if ((boardSquare.getColumnLetter() == super.getPosition().getColumnLetter() + 1 && (boardSquare.getRowNumber() == 5))) { // we gaan al de squares links en rechts toevoegen
                    if (boardSquare.getSquareContent() instanceof Pawn && boardSquare.getSquareContent().getColor() == Color.BLACK && boardSquare.getSquareContent().getMoves().size() == 1) { // drie checks moeten we doen, 1 we checken of we naast een pion staan. De pion moet van de tegenpartij zijn, dus de kleur moet gecontroleerd worden. Ten derde moeten we checken of de lijst van de vijandelijke pion op 0 staat(eerste move vijand)
                        enPassantSquares.add(new Square(6, (char) (super.getPosition().getColumnLetter() + 1)));
                    }
                }

                if ((boardSquare.getColumnLetter() == super.getPosition().getColumnLetter() - 1 && (boardSquare.getRowNumber() == 5))) {
                    if (boardSquare.getSquareContent() instanceof Pawn && boardSquare.getSquareContent().getColor() == Color.BLACK && boardSquare.getSquareContent().getMoves().size() == 1) { // drie checks moeten we doen, 1 we checken of we naast een pion staan. De pion moet van de tegenpartij zijn, dus de kleur moet gecontroleerd worden. Ten derde moeten we checken of de lijst van de vijandelijke pion op 0 staat(eerste move vijand)
                        enPassantSquares.add(new Square(6, (char) (super.getPosition().getColumnLetter() - 1)));
                    }
                }
            }


            if (super.getPosition().getRowNumber() == 4 && super.getColor() == Color.BLACK) {
                for (Square boardSquare : allBoardSquares) {

                }
            }

        }
        return enPassantSquares;

    }
}

