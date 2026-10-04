import java.util.ArrayList;
import java.util.List;

public class Board {

    int size;
    List<List<Symbol>> grid;
    Symbol emptyCell;

    public Board(int size) {
        this.size = size;
        this.emptyCell = new Symbol('_');
        this.grid = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            List<Symbol> row = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                row.add(this.emptyCell);
            }
            this.grid.add(row);
        }
    }

    boolean isCellEmpty(int row, int col) {
        if(row<0 || col<0 || row>=size || col>=size)
            return false;

        return grid.get(row).get(col)==emptyCell;
    }

    boolean placeMark(int row, int col, Symbol symbol) {
        if(isCellEmpty(row,col)){
            grid.get(row).set(col, symbol);
            return true;
        }
        return false;
    }

    Symbol getCell(int row, int col) {
        if(row<0 || col<0 || row>=size || col>=size) {
            return emptyCell;
        }
        return grid.get(row).get(col);
    }

    public void display() {

        int n = grid.size();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(" " + getCell(i, j).mark);
            }
            System.out.println();
        }
    }
}
