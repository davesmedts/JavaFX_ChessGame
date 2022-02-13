package Model;

import java.util.List;

public class Player {
    private String player;
    private int wins;
    private int draws;
    private int losses;
    private Color color;
    private List<Piece> activePieces;
    private List<Piece> capturedPieces;

    public void initializePieces(){
//        pawns
//        for (int i = 0; i < 8; i++) {
//
//        }
//        king
//        queen
//        Knights
//        rooks
//        bishops
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
