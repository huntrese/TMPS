import java.util.ArrayList;
import java.util.List;

// Abstract base class for all pieces
public abstract class Piece {
    protected String color;
    protected int x;
    protected int y;

    public Piece(String color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public abstract String getType();

    public List<int[]> getCoords() {
        return List.of(new int[]{this.x, this.y});
    }

    public void setCoords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Abstract method for move validation
    public abstract boolean isValidMove(int newX, int newY);
}
