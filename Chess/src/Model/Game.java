package Model;

import java.time.LocalDateTime;

/**
 * @author Dave Smedts
 * @version 1.0 2/02/2022 16:58
 */
public class Game {
    private Player blackPlayer;
    private Player whitePlayer;
    private Board gameBoard;
    private Color turn;
    private LocalDateTime startTijd;
    private LocalDateTime stopTijd;
    private Player winner;

}
