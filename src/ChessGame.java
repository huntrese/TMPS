public class ChessGame {
    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();

        // Create some pieces
        Knight whiteKnight = new Knight("white", 1, 0);
        Bishop whiteBishop = new Bishop("white", 2, 0);
        Rook whiteRook = new Rook("white", 0, 0);

        // Place pieces on the board
        board.placePiece(whiteKnight, 1, 0);
        board.placePiece(whiteBishop, 2, 0);
        board.placePiece(whiteRook, 0, 0);

        System.out.println("Initial board state:");
        board.printBoard();

        // Move the knight
        System.out.println("Moving knight to (2,2):");
        if (board.movePiece(whiteKnight, 2, 2)) {
            System.out.println("Knight moved successfully.");
        } else {
            System.out.println("Invalid move for Knight.");
        }
        board.printBoard();

        // Try an invalid move for the bishop
        System.out.println("Attempting to move bishop to (3,2):");
        if (board.movePiece(whiteBishop, 3, 2)) {
            System.out.println("Bishop moved successfully.");
        } else {
            System.out.println("Invalid move for Bishop.");
        }
        board.printBoard();

        // Move the bishop correctly
        System.out.println("Moving bishop to (0,2):");
        if (board.movePiece(whiteBishop, 0, 2)) {
            System.out.println("Bishop moved successfully.");
        } else {
            System.out.println("Invalid move for Bishop.");
        }
        board.printBoard();

        // Move the rook
        System.out.println("Moving rook to (0,4):");
        if (board.movePiece(whiteRook, 0, 4)) {
            System.out.println("Rook moved successfully.");
        } else {
            System.out.println("Invalid move for Rook.");
        }
        board.printBoard();
    }
}