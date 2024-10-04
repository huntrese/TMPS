public class ChessBoard {
    private Piece[][] board;

    public ChessBoard() {
        board = new Piece[8][8];
    }

    public boolean movePiece(Piece piece, int newX, int newY) {
        if (piece.isValidMove(newX, newY) && MovementValidator.isPathClear(piece, newX, newY, board)) {

            int oldX = piece.getCoords().get(0)[0];
            int oldY = piece.getCoords().get(0)[1];
            board[oldY][oldX] = null;
            board[newY][newX] = piece;
            piece.setCoords(newX, newY);
            return true;
        }
        return false;
    }

    public void placePiece(Piece piece, int x, int y) {
        board[y][x] = piece;
        piece.setCoords(x, y);
    }

    public void printBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print("- ");
                } else {
                    System.out.print(board[i][j].getType().charAt(0) + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}