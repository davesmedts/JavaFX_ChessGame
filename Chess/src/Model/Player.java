package Model;

import java.util.List;

/**
 * @author Dave Smedts
 * @version 1.0 2/02/2022 16:57
 */
public class Player {
    private String player;
    private int wins;
    private int draws;
    private int losses;
    private Color color;
    private List<Move> moves;
    private List<Piece> activePieces;
    private List<Piece> capturedPieces;

}
