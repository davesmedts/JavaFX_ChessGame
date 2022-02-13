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
//        pawns
        if (color == Color.WHITE) {

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
