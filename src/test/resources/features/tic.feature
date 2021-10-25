Feature: TicTacToe Game

  Scenario: Check Win
    Given Cells are full
      |       | x | y |  player_cross   |
      | C1    | 0 | 0 |  1          |
      | C2    | 2 | 1 |  0          |
      | C3    | 1 | 0 |  1          |
      | C4    | 2 | 2 |  0          |
    When PlayerCross enters 3 1
    Then PlayerCross wins


  Scenario: Check cell information input
    Given cell 1 1 is filled
    When PlayerCross enters cell 1 1
    Then game asks player to enter another cell

  Scenario: Check Draw
    Given table with probable draw
      |       | x | y |  player_cross   |
      | C1    | 0 | 0 |  1          |
      | C2    | 0 | 1 |  0          |
      | C3    | 0 | 2 |  1          |
      | C4    | 1 | 0 |  1          |
      | C5    | 1 | 1 |  0          |
      | C6    | 1 | 2 |  0          |
      | C7    | 2 | 0 |  0          |
      | C9    | 2 | 2 |  1          |
    When PlayerCross enters cell 2 1
    Then game ends with draw message

