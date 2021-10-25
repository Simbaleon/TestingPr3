import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Check_Cell {

    GameManager gM = new GameManager();
    @Given("cell {int} {int} is filled")
    public void cellIsFilled(int cell_x, int cell_y) {
        gM.nextTurn(cell_x, cell_y);
    }



    @Then("game asks player to enter another cell")
    public void gameAsksPlayerToEnterAnotherCell() {

    }

}
