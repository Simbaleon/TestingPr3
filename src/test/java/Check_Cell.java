import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Check_Cell {

    @Given("cell {int} {int} is filled")
    public void cellIsFilled(int cell_x, int cell_y) {
    }

    @When("PlayerCross enters cell {int} {int}")
    public void playerEntersCell(int cell_x, int cell_y) {

    }

    @Then("game asks player to enter another cell")
    public void gameAsksPlayerToEnterAnotherCell() {

    }

}
