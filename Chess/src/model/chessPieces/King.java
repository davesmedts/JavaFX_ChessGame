package model.chessPieces;

import model.Board;
import model.Color;
import model.Player;
import model.Square;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    private boolean isChecked;
    private boolean isCheckmate;
    private boolean HasCastled;

    public King(Color color, Square startPosition) {
        super(color, startPosition);
        this.isChecked = false;
        this.isCheckmate = false;
        HasCastled = false;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public boolean isCheckmate() {
        return isCheckmate;
    }

    public boolean isHasCastled() {
        return HasCastled;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }



    public void setCheckmate(boolean checkmate) {
        isCheckmate = checkmate;
    }

    public void setHasCastled(boolean hasCastled) {
        HasCastled = hasCastled;
    }

    @Override
    public List<Square> getValidMoves(Board gameBoard, Player opponent) {
        List<Square> possibleSquares = new ArrayList<>();

        if(super.getPosition() == null){
            return possibleSquares;
        }

//        get the current row and column of the piece that has to move
        char column = super.getPosition().getColumnLetter();
        int row = super.getPosition().getRowNumber();

//        a King can move in any direction but is limited to the square next to it.
//        north
        if (row + 1 <= 8) { // check if target is whithin the scope of the board.
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
//        south
        if (row - 1 >= 1) { // check if target is whithin the scope of the board.
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
//        west
        if (column - 1 >= 65) { // check if target is whithin the scope of the board.
            int newRow = row;
            char newColumn = (char) (column - 1);
            Square moveSquare = gameBoard.lookupSquare(newColumn, newRow);
            Piece moveSquareContent = moveSquare.getSquareContent();
            if (moveSquareContent == null) {
                possibleSquares.add(moveSquare);
            } else if (moveSquareContent.getColor() != super.getColor()) {
                possibleSquares.add(moveSquare);
            }
        }
//        east
        if (column + 1 < 65 + 8) { // check if target is whithin the scope of the board.
            int newRow = row;
            char newColumn = (char) (column + 1);
            Square moveSquare = gameBoard.lookupSquare(newColumn, newRow);
            Piece moveSquareContent = moveSquare.getSquareContent();
            if (moveSquareContent == null) {
                possibleSquares.add(moveSquare);
            } else if (moveSquareContent.getColor() != super.getColor()) {
                possibleSquares.add(moveSquare);
            }
        }
//        north-east
        if (row + 1 <= 8 && column + 1 < 65 + 8) { // check if target is whithin the scope of the board.
            int newRow = row + 1;
            char newColumn = (char) (column + 1);
            Square moveSquare = gameBoard.lookupSquare(newColumn, newRow);
            Piece moveSquareContent = moveSquare.getSquareContent();
            if (moveSquareContent == null) {
                possibleSquares.add(moveSquare);
            } else if (moveSquareContent.getColor() != super.getColor()) {
                possibleSquares.add(moveSquare);
            }
        }
//        south-east
        if (row - 1 >= 1 && column + 1 < 65 + 8) { // check if target is whithin the scope of the board.
            int newRow = row - 1;
            char newColumn = (char) (column + 1);
            Square moveSquare = gameBoard.lookupSquare(newColumn, newRow);
            Piece moveSquareContent = moveSquare.getSquareContent();
            if (moveSquareContent == null) {
                possibleSquares.add(moveSquare);
            } else if (moveSquareContent.getColor() != super.getColor()) {
                possibleSquares.add(moveSquare);
            }
        }
//        north-west
        if (row + 1 <= 8 && column - 1 >= 65) { // check if target is whithin the scope of the board.
            int newRow = row + 1;
            char newColumn = (char) (column - 1);
            Square moveSquare = gameBoard.lookupSquare(newColumn, newRow);
            Piece moveSquareContent = moveSquare.getSquareContent();
            if (moveSquareContent == null) {
                possibleSquares.add(moveSquare);
            } else if (moveSquareContent.getColor() != super.getColor()) {
                possibleSquares.add(moveSquare);
            }
        }
//        south-west
        if (row - 1 >= 1 && column - 1 >= 65) { // check if target is whithin the scope of the board.
            int newRow = row - 1;
            char newColumn = (char) (column - 1);
            Square moveSquare = gameBoard.lookupSquare(newColumn, newRow);
            Piece moveSquareContent = moveSquare.getSquareContent();
            if (moveSquareContent == null) {
                possibleSquares.add(moveSquare);
            } else if (moveSquareContent.getColor() != super.getColor()) {
                possibleSquares.add(moveSquare);
            }
        }

//        get the castlingSquares
        List<Square> castlingSquares = getCastlingSquares(gameBoard, opponent);
        possibleSquares.addAll(castlingSquares);

        return possibleSquares;
    }

    public boolean defineCheckStatus(Board gameBoard, Player opponent){
        boolean kingIsChecked = false;
        List<Square> allPossibleMoves = new ArrayList<>();
        for (Square square : gameBoard.getSquares()) {
            if (square.getSquareContent() != null && square.getSquareContent().getColor() != getColor()){
                Piece opponentPiece = square.getSquareContent();
                allPossibleMoves.addAll(opponentPiece.getValidMoves(gameBoard, opponent));
            }
        }

        for (Square possibleMove : allPossibleMoves) {
            if (possibleMove.equals(getPosition())) {
                kingIsChecked = true;
                break;
            }
        }
        return kingIsChecked;
    }

    public boolean defineCheckMateStatus(Board gameBoard, Player opponent) {
        boolean checkMate = true;
        List<Piece> playerPieces = new ArrayList<>();
        for (Square square : gameBoard.getSquares()) {
            if (square.getSquareContent() != null && square.getSquareContent().getColor() == getColor()){
                playerPieces.add(square.getSquareContent());
            }
        }

        for (Piece playerPiece : playerPieces) {
            List<Square> validMovesPiece;
            Square originalPosition = playerPiece.getPosition();
            validMovesPiece = playerPiece.getValidMoves(gameBoard, opponent);

            for (Square validMove : validMovesPiece) {
                boolean isChecked;
                if (validMove.getSquareContent() == null) {
                    playerPiece.setPosition(validMove);
                    validMove.setSquareContent(playerPiece);

                    isChecked = defineCheckStatus(gameBoard, opponent);

                    playerPiece.setPosition(originalPosition);
                    validMove.setSquareContent(null);

                } else {
                    Piece originalContent = validMove.getSquareContent();
                    playerPiece.setPosition(validMove);
                    validMove.setSquareContent(playerPiece);
                    originalContent.setPosition(null);

                    isChecked = defineCheckStatus(gameBoard, opponent);

                    validMove.setSquareContent(originalContent);
                    originalContent.setPosition(validMove);
                    playerPiece.setPosition(originalPosition);
                    originalPosition.setSquareContent(playerPiece);
                }

                if (!isChecked) {
                    checkMate = false;
                    break;
                }
            }
            if(!checkMate){
                break;
            }
        }
        return checkMate;
    }


    public List<Square> getCastlingSquares(Board gameBoard, Player opponent) {
        List<Square> castleMoves = new ArrayList<>();
        if (getColor() == Color.WHITE) {
            Square a1 = gameBoard.lookupSquare('A', 1);
            Square b1 = gameBoard.lookupSquare('B', 1);
            Square c1 = gameBoard.lookupSquare('C', 1);
            Square d1 = gameBoard.lookupSquare('D', 1);
            Square f1 = gameBoard.lookupSquare('F', 1);
            Square g1 = gameBoard.lookupSquare('G', 1);
            Square h1 = gameBoard.lookupSquare('H', 1);

            if (a1.getSquareContent() instanceof Rook && a1.getSquareContent().getMoves().size() == 0) {
                if (b1.getSquareContent() == null && c1.getSquareContent() == null && d1.getSquareContent() == null) {

                    List<Square> leftCastleCheck = new ArrayList<>();
                    leftCastleCheck.add(getPosition()); // we moeten selectedPiece dan ook gaan meegeven
                    leftCastleCheck.add(d1);
                    leftCastleCheck.add(c1); // c1 add to the list

                    boolean check = false;
                    for (Square square : leftCastleCheck) {
                        if (moveCheckSimulation(square, gameBoard, opponent)) {
                            check = true; // if the boolean is changed to true, we never change it back within this loop
                            break; // if the king is in check on one of the squares then we break out of this loop and go to the next statement
                        }
                    }
                    if (!check) {
                        castleMoves.add(gameBoard.lookupSquare('C', 1)); // left castling move: kings always moves to C1
                    }
                }
            }

            if (h1.getSquareContent() instanceof Rook && h1.getSquareContent().getMoves().size() == 0) {
                if (f1.getSquareContent() == null && g1.getSquareContent() == null) {

                    List<Square> rightCastleCheck = new ArrayList<>();
                    rightCastleCheck.add(getPosition()); // we moeten selectedPiece dan ook gaan meegeven
                    rightCastleCheck.add(f1);
                    rightCastleCheck.add(g1); // c1 add to the list
                    boolean check = false;

                    for (Square square : rightCastleCheck) {
                        if (moveCheckSimulation(square, gameBoard, opponent)) {
                            check = true; // if the boolean is changed to true, we never change it back within this loop
                            break; // if the king is in check on one of the squares then we break out of this loop and go to the next statement
                        }
                    }
                    if (!check) {
                        castleMoves.add(gameBoard.lookupSquare('G', 1)); // left castling move: kings always moves to G1
                    }
                }
            }
        }
        return castleMoves;
    }

    public boolean moveCheckSimulation(Square targetSquare, Board gameBoard, Player opponent) {
        Square startPosition = this.getPosition(); // set the previous content to null because the piece is moved
        startPosition.setSquareContent(null);

        setPosition(targetSquare); // assigns the new square to the piece
        targetSquare.setSquareContent(this); // assigns piece to the new square
//                    System.out.println(selectedPiece.getPosition());
        boolean isChecked = false;
        List<Piece> opponentPieces = new ArrayList<>();
        for (Square square : gameBoard.getSquares()) {
            if (square.getSquareContent() != null && square.getSquareContent().getColor() != getColor()){
                opponentPieces.add(square.getSquareContent());
            }
        }

        for (Piece opponentPiece : opponentPieces) {
            List<Square> validMovesPiece;
            Square originalPosition = opponentPiece.getPosition();
            validMovesPiece = opponentPiece.getValidMoves(gameBoard, opponent);

            for (Square validMove : validMovesPiece) {
                if (validMove.getSquareContent() == null) {
                    opponentPiece.setPosition(validMove);
                    validMove.setSquareContent(opponentPiece);

                    isChecked = defineCheckStatus(gameBoard, opponent);

                    opponentPiece.setPosition(originalPosition);
                    validMove.setSquareContent(null);

                } else {
                    Piece originalContent = validMove.getSquareContent();
                    opponentPiece.setPosition(validMove);
                    validMove.setSquareContent(opponentPiece);
                    originalContent.setPosition(null);

                    isChecked = defineCheckStatus(gameBoard, opponent);

                    validMove.setSquareContent(originalContent);
                    originalContent.setPosition(validMove);
                    opponentPiece.setPosition(originalPosition);
                    originalPosition.setSquareContent(opponentPiece);
                }

                if (isChecked) {
                    break;
                }
            }
        }
        startPosition.setSquareContent(this);
        this.setPosition(startPosition);
        targetSquare.setSquareContent(null);

        return isChecked;
    }

    public void castlingMove(Square targetSquare , Board gameBoard){
        if (targetSquare.equals(new Square(1, 'C'))) {
            Piece rook = gameBoard.lookupSquare('A', 1).getSquareContent();
            rook.getPosition().setSquareContent(null);
            rook.setPosition(gameBoard.lookupSquare('D', 1));
            gameBoard.lookupSquare('D', 1).setSquareContent(rook);
        }

        if (targetSquare.equals(new Square(1, 'G'))) {
            Piece rook = gameBoard.lookupSquare('H', 1).getSquareContent();
            rook.getPosition().setSquareContent(null);
            rook.setPosition(gameBoard.lookupSquare('F', 1));
            gameBoard.lookupSquare('F', 1).setSquareContent(rook);
        }

        if (targetSquare.equals(new Square(8, 'C'))) {
            Piece rook = gameBoard.lookupSquare('A', 8).getSquareContent();
            rook.getPosition().setSquareContent(null);
            rook.setPosition(gameBoard.lookupSquare('C', 8));
            gameBoard.lookupSquare('C', 8).setSquareContent(rook);
        }

        if (targetSquare.equals(new Square(8, 'F'))) {
            Piece rook = gameBoard.lookupSquare('H', 8).getSquareContent();
            rook.getPosition().setSquareContent(null);
            rook.setPosition(gameBoard.lookupSquare('F', 8));
            gameBoard.lookupSquare('F', 8).setSquareContent(rook);
        }
    }

    @Override
    public String log() {
        return String.format("%s-%s", this.getClass().getSimpleName(), super.getColor());
    }
}
