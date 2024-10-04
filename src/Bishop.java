public class Bishop extends Piece {
    public Bishop(String color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public String getType() {
        return "Bishop";
    }

    @Override
    public boolean isValidMove(int newX, int newY) {
        return Math.abs(newX - x) == Math.abs(newY - y);
    }
}