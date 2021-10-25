import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class Check_Draw {
    GameManager gM = new GameManager();

    private int x, y;

    @Given("table with probable draw")
    public void tableWithProbableDraw(DataTable table) {
        List<Map<String, Integer>> cell_table = table.asMaps(String.class, Integer.class);

        Cell[][] cells = new Cell[3][3];
        for (Map<String, Integer> cell:
                cell_table) {
            cells[cell.get("x")][cell.get("y")] = new Cell(false, cell.get("player_cross") == 1);
        }
        gM.initializeTable(cells);
    }

    @When("PlayerCross enters last cell {int} {int}")
    public void playerEntersCell(int cell_x, int cell_y) {
        gM.nextTurn(cell_x, cell_y);
        x = cell_x;
        y = cell_y;
    }


    @Then("game ends with draw message")
    public void gameEndsWithDrawMessage() {
        if (!gM.checkForWin(x, y)) {
            gM.printCells();
            gM.printDrawMessage();
        }
    }


}
