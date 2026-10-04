public class Rule {

    boolean checkWinCondition(Board board, Symbol symbol) {
        int n = board.grid.size();
        if (n == 0) return false;

        // Check rows
        for (int i = 0; i < n; i++) {
            boolean win = true;

            for (int j = 0; j < n; j++) {
                if (board.getCell(i, j).mark != symbol.mark) {
                    win = false;
                    break;
                }
            }

            if (win) return true;
        }

        // Check columns
        for (int i = 0; i < n; i++) {
            boolean win = true;

            for (int j = 0; j < n; j++) {
                if (board.getCell(j, i).mark != symbol.mark) {
                    win = false;
                    break;
                }
            }

            if (win) return true;
        }

        // Check main diagonal
        boolean win = true;
        for (int i = 0; i < n; i++) {
            if (board.getCell(i, i).mark != symbol.mark) {
                win = false;
                break;
            }
        }

        if (win) return true;

        // Check anti-diagonal
        win = true;
        for (int i = 0; i < n; i++) {
            if (board.getCell(i, n - 1 - i).mark != symbol.mark) {
                win = false;
                break;
            }
        }

        return win;
    }

    boolean checkDraw(Board board){

        int n= board.grid.size();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board.isCellEmpty(i,j))
                {
                    return false;
                }
            }
        }
        return true;
    }

    boolean isValidMove(Board board, int row, int col){

        return board.isCellEmpty(row, col);
    }
}
