import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class TicTacToe {

    Board board;
    Rule rule;
    Deque<Player> players;
    boolean gameOver;

    public TicTacToe(int boardSize) {
        this.gameOver = false;
        this.board = new Board(boardSize);
        this.players = new ArrayDeque<>();
        this.rule = new Rule();
    }

    void addPlayer(Player player) {

        players.push(player);
    }

    void play() {

        if(players.size()<0)
        {
            System.out.println("Need atleast 2 players");
            return;
        }

        System.out.println(players.peekFirst().name);
        System.out.println(players.peekLast().name);

        System.out.println("Game started");

        while(!gameOver) {
            board.display();

            Player currentPlayer = players.peekFirst();
            System.out.println("Player name" + currentPlayer.getName());

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter row and column: ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if(rule.isValidMove(board,row,col)){
                board.placeMark(row,col,currentPlayer.getSymbol());
                if(rule.checkWinCondition(board, currentPlayer.getSymbol())) {
                    board.display();
                    System.out.println("Winner is "+currentPlayer.getName());
                    gameOver=true;
                }
                else if (rule.checkDraw(board)) {
                    board.display();
                    System.out.println("Match is draw "+currentPlayer.getName());
                    gameOver=true;
                }
                else {
                    players.pop();
                    players.addLast(currentPlayer);
                }

            }
            else {
                System.out.print("Invalid Move");
            }
        }
    }

}
