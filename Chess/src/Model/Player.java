package Model;

import java.util.List;

public class Player {
    private String player;
    private int wins;
    private int draws;
    private int losses;
    private Color color;
    private List<Piece> pieces;
//    private List<Piece> capturedPieces;

    public void initializePieces() {
//                Hoe krijgen we de lijst van squares beschikbaar bij Player? Er is geen link met Board.
        if (color == Color.WHITE) {
//        pawns
            for (int i = 0; i < 8; i++) {
                int row = 2;
                char column = (char) (65 + i);
                Square position = new Square(row, column);
                Pawn pawn = new Pawn(color, position);
                pieces.add(pawn);

            }
//        king
//        queen
//        Knights
//        rooks
//        bishops
        } else {
//        pawns
            for (int i = 0; i < 8; i++) {
                int row = 7;
                char column = (char) (65 + i);
                Square position = new Square(row, column);
                Pawn pawn = new Pawn(color, position);
                pieces.add(pawn);

            }
//        king
//        queen
//        Knights
//        rooks
//        bishops
        }
}

    public void setColor(Color color) {
        this.color = color;
    }
}
