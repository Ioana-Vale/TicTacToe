import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static String[] board;
    static String turn;
    static int line;
    static String winner;
    static int cnt;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        board = new String[9];
        turn = "X";
        cnt++;

        for (int a = 0; a <= 8; a++) {
            board[a] = String.valueOf(a + 1);
        }

        printBoard();

        // Instructiuni pentru jucatorul uman
        System.out.println("X will play first. Enter a slot number to place X in:");

        while (winner == null) {
            int input = scanner.nextInt();
            if (input < 1 || input > 9) {
                System.out.println("Invalid input; please enter a number between 1 and 9.");
                continue;
            }
            if (board[input - 1].equals(String.valueOf(input))) {
                board[input - 1] = turn;
                cnt++;
                printBoard();
                winner = checkWinner();
                if (turn.equals("X")) {
                    turn = "O";
                } else {
                    turn = "X";
                }
            } else {
                System.out.println("Slot already taken; please choose another slot.");
                continue;
            }
        }

        if (winner.equalsIgnoreCase("draw")) {
            System.out.println("The game is a draw!");
        } else {
            System.out.println("Congratulations! " + winner + " has won the game!");
        }
    }

    static void printBoard() {
        System.out.println("| " + board[0] + " | "
                + board[1] + " | " + board[2]
                + " |");
        System.out.println("| " + board[3] + " | "
                + board[4] + " | " + board[5]
                + " |");
        System.out.println("| " + board[6] + " | "
                + board[7] + " | " + board[8]
                + " |");
    }

    static String checkWinner() {
        for (int a = 0; a < 8; a++) {
            String line = null;

            switch (a) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            if (line.equals("XXX")) {
                return "X";
            } else if (line.equals("OOO")) {
                return "O";
            }
            if (cnt == 9) {
                return "draw";
            }

        }
        return null;
    }
}

