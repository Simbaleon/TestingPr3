import java.util.Scanner;

public class GameManager implements IGameManager{

    private Cell[][] cells;
    private boolean playerCross = true;
    private boolean gameOver = false;

    public static void main(String[] args) {

        GameManager rG = new GameManager();

        rG.runGame();
    }

    public GameManager() {
        initializeTable();
    }

    public void initializeTable() {
        cells = new Cell[3][3];
        for (int i = 0;  i < 3; i++){
            for (int j = 0; j < 3; j++){
                cells[i][j] = new Cell();
            }
        }
    }

    public void initializeTable(Cell[][] cells) {
        this.cells = new Cell[3][3];
        for (int i = 0;  i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (cells[i][j] == null)
                    this.cells[i][j] = new Cell();
                else
                    this.cells[i][j] = cells[i][j];
            }
        }
    }

    @Override
    public void runGame() {
        int i = 0;
        while(i < 9){
            enterCell();
            printCells();
            if (gameOver) {
                printWinMessage();
                return;
            }
            changeTurn();
            i++;
        }
        printDrawMessage();
    }

    private void changeTurn() {
        playerCross = !playerCross;
    }

    public void printCells() {
        for (int i = 0;  i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (cells[i][j].isEmpty())
                    System.out.print("_");
                else if (cells[i][j].isPlayerCross())
                    System.out.print("x");
                else System.out.print("o");
            }
            System.out.println();
        }
    }

    public void enterCell(){
        Scanner a = new Scanner(System.in);
        System.out.println("Enter X and Y: ");
        int x = a.nextInt();
        int y = a.nextInt();
        if(!nextTurn(x, y))
            enterCell();
    }

    public boolean nextTurn(int x, int y)  {
        try {
            checkValidCell(x, y);
            checkNotEmptyCell(x, y);
            cells[x][y].MarkCell(playerCross);
            gameOver = checkForWin(x, y);
        }catch (NotEmptyCellException | NotValidCellException e)
        {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public void printDrawMessage() {
        System.out.println("The Game ends with Draw!");
    }

    public void printWinMessage() {
        System.out.println(playerCross ? "PLayerA (x) won!" : "PlayerB (o) won!");
    }

    @Override
    public boolean checkForWin(int x, int y) {
        return isWinDiagonal() || isWinRow(x) || isWinColumn(y);
    }

    private boolean isWinRow(int i) {
        if (cells[i][0].isEmpty() || cells[i][1].isEmpty() || cells[i][2].isEmpty())
            return false;
        return cells[i][0].isPlayerCross() == cells[i][1].isPlayerCross()
                && cells[i][2].isPlayerCross() == cells[i][0].isPlayerCross();
    }
    private boolean isWinColumn(int j) {
        if (cells[0][j].isEmpty() || cells[1][j].isEmpty() || cells[2][j].isEmpty())
            return false;
        else return cells[0][j].isPlayerCross() == cells[1][j].isPlayerCross()
                && cells[0][j].isPlayerCross() == cells[2][j].isPlayerCross();
    }

    private boolean isWinDiagonal() {
        if (cells[1][1].isEmpty()) {
            return false;
        }
        else if (cells[0][0].isEmpty() || cells[2][2].isEmpty()){
            return false;
        }
        else if (cells[0][2].isEmpty() || cells[2][0].isEmpty())
            return false;

        return cells[0][0].isPlayerCross() == cells[1][1].isPlayerCross()
                && cells[0][0].isPlayerCross() == cells[2][2].isPlayerCross()
                || cells[0][2].isPlayerCross() == cells[1][1].isPlayerCross()
                && cells[0][2].isPlayerCross() == cells[2][0].isPlayerCross();
    }

    public void checkNotEmptyCell(int x, int y) throws NotEmptyCellException {
        if (!cells[x][y].isEmpty()){
            throw new NotEmptyCellException("This cell is not empty!");
        }
    }

    public void checkValidCell(int x, int y) throws NotValidCellException {
        if (x > 2 || x < 0 || y > 2 || y < 0){
            throw new NotValidCellException("Out of table!");
        }
    }

}
