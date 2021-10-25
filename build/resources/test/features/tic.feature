Feature: TicTacToe Game

  Scenario: Check Win
    Given Cells are full
      | x | y |  player_cross|
      | 0 | 0 |  1           |
      | 2 | 1 |  0           |
      | 1 | 0 |  1           |
      | 2 | 2 |  0           |
    When PlayerCross enters cell 2 0
    Then PlayerCross wins


  Scenario: Check cell information input
    Given cell 1 1 is filled
    When PlayerCross enters existing cell 1 1
    Then game asks player to enter another cell

  Scenario: Check Draw
    Given table with probable draw
      | x | y |  player_cross   |
      | 0 | 0 |  1          |
      | 0 | 1 |  0          |
      | 0 | 2 |  1          |
      | 1 | 0 |  1          |
      | 1 | 1 |  0          |
      | 1 | 2 |  0          |
      | 2 | 0 |  0          |
      | 2 | 2 |  1          |
    When PlayerCross enters last cell 2 1
    Then game ends with draw message

