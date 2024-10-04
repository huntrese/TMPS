public class Rook extends Piece {
    public Rook(String color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public String getType() {
        return "Rook";
    }

    @Override
    public boolean isValidMove(int newX, int newY) {
        return (newX == x) || (newY == y);
    }
}