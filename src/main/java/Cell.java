public class Cell {
    private boolean empty;
    private boolean playerCross;

    public boolean isEmpty() {
        return empty;
    }

    public void MarkCell(boolean playerCross) {
        this.empty = false;
        this.playerCross = playerCross;
    }

    public boolean isPlayerCross() {
        return playerCross;
    }

    public Cell() {
        empty = true;
        playerCross = true;
    }

    public Cell(boolean empty, boolean playerCross) {
        this.empty = empty;
        this.playerCross = playerCross;
    }
}
