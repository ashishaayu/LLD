//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        TicTacToe ticTacToe = new TicTacToe(3);
        Player player1 = new Player(1,"Ashish", new Symbol('X'));
        Player player2 = new Player(1,"Ankita", new Symbol('O'));

        ticTacToe.addPlayer(player1);
        ticTacToe.addPlayer(player2);

        ticTacToe.play();
    }
}