import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class Check_Win {
    @Given("Cells are full")
    public void cellsAreFull(DataTable table) {
        Map<String, Map<String, Integer>> cells = table.asMap(String.class, Integer.class);

    }

    @When("PlayerCross enters {int} {int}")
    public void playeraEnters(int cell_x, int cell_y) {

    }

    @Then("PlayerCross wins")
    public void playeraWins() {

    }
}
