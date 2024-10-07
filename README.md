# Topic: *SOLID Principles*
## Author: *Polisciuc Vlad*
------
## Objectives:
__1. Study and understand the The SOLID principles.__



## Some Theory:

In object-oriented design, the SOLID principles are five design principles that aim to make software designs more understandable, flexible, and maintainable. These principles address different aspects of object-oriented design and help developers create more robust and scalable systems.

The principles are:

* S ingle Responsibility Principle (SRP)
* O pen-Closed Principle (OCP)
* L iskov Substitution Principle (LSP)
* I nterface Segregation Principle (ISP)
* D ependency Inversion Principle (DIP)
   
## Main tasks:
__1. Choose an OO programming language and a suitable IDE or Editor (No frameworks/libs/engines allowed).__

__2. Write a program in a language of choice that implements 2 of the SOLID letters.__

__3. Upload everything to Github.__


## Implementation
For this Lab I decided to use Java, and Implement the First 2 SOLID Principles:
Single Responsibility and Open Closed.

For this purpose I have created a very rudimentary and not ideal version of chess.

First of all I created an Abstract Class that sets a contract that all chess pieces later must follow.
```java
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
```

Then I created a few Concrete pieces which inherit from this abstract class:

Bishop.
```java
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
```

Knight
```java
public class Knight extends Piece {
    public Knight(String color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public String getType() {
        return "Knight";
    }

    @Override
    public boolean isValidMove(int newX, int newY) {
        int dx = Math.abs(newX - x);
        int dy = Math.abs(newY - y);
        return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
    }
}
```

Rook
```java
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
```


This has effectively created 3 classes that have the sole responsibility of defining the valid moves of a certain type of piece.

Then I created a ChessBoard
```java
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
```
It implements the necessary methods for a chessboard to function at a basic level


Then we have the actual chess game
```java
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
```


* Visualization

![image](https://github.com/user-attachments/assets/1299e3ef-a61e-43dc-b333-f45ddc27ae6b)

![image](https://github.com/user-attachments/assets/a63debb3-63f3-4336-a8f5-0faac58fd81b)


## Conclusions / Screenshots / Results
In conclusion we have studied and understood the SOLID principles of OOP. More concretely, in this lab we had impelmented 2 of the SOLID Principles SRP and OCP, technically speaking, other principles were also followed in the end, but 2 were the requirements of the task, so 2 were reported. This lab helped further our understanding of OOP, and HOW by implementing SOLID we can write better code, that will make future software design easier and much more efficient
