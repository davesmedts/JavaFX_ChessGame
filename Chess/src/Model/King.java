package Model;

/**
 * @author Dave Smedts
 * @version 1.0 9/02/2022 22:37
 */
public class King extends Piece{
    private boolean isChecked;
    private boolean isCheckmate;
    private boolean HasCastled;

    public King(Color color, Square startPosition) {
        super(color, startPosition);
        this.isChecked = false;
        this.isCheckmate = false;
        HasCastled = false;
    }
}
