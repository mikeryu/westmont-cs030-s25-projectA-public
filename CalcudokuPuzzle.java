/**
 * Westmont College Spring 2025
 * CS 030 Project A (Calcudoku Solver)
 *
 * @author Assistant Professor Mike Ryu mryu@westmont.edu
 * @author Boaty McBoatface bmcboatface@westmont.edu  // TODO: Use your name and email.
 */

/**
 * Represents a Calcudoku Puzzle Board, cage definitions, and encapsulates all validation logic.
 */
public class CalcudokuPuzzle {

  /**
   * Number of cells in a single dimension for the puzzle board; also the max. valid value for a cell.
   */
  // TODO: Declare and set the integer constant `BOARD_DIM` to 5; make it `public static final`.

  /**
   * Two-dimensional integer array representing the puzzle board.
   */
  // TODO: Declare (and optionally initialize) `board`, a 2D array of BOARD_DIM x BOARD_DIM size; make it `public`.

  /**
   * Array of cage definitions.
   */
  // TODO: Declare (but NOT initialize) an array of CalcudokuCages, named `cages`; make it `public`.

  /**
   * Initializes the Calcudoku Puzzle board to all 0s and sets the cage definitions using the given array of cages.
   *
   * @param cages array of {@link CalcudokuCage}s containing the cage definitions
   */
  // TODO: Write the parameterized constructor per the description above.

  /**
   * Sets the value of the cell indicated by its {@code cellID} number to the given {@code cellValue}.
   * <p>
   * In a 5x5 Calcudoku Puzzle board, cell ID {@code 0} (first cell) corresponds to the top left corner cell,
   * and the cell ID {@code 24} (last cell) corresponds to the bottom right corner cell.
   *
   * @param cellID    ID number of the cell to set value to
   * @param cellValue value to store in the identified cell
   */
  public void setCellValueByID(int cellID, int cellValue) {
    // TODO: Implement this method.
  }

  /**
   * Returns the value currently stored in the cell indicated by its {@code cellID} number.
   * <p>
   * In a 5x5 Calcudoku Puzzle board, cell ID {@code 0} (first cell) corresponds to the top left corner cell,
   * and the cell ID {@code 24} (last cell) corresponds to the bottom right corner cell.
   *
   * @param cellID ID number of the cell to retrieve the currently stored value from
   */
  public int getCellValueByID(int cellID) {
    return -1;  // TODO: Implement this method to return the valid cell value.
  }

  /**
   * Determines whether the Calcudoku Puzzle board is currently in a valid state (either completed
   * or under construction) or not.
   *
   * @return {@code true} if the Puzzle is in a valid (complete or incomplete) state, {@code false} otherwise.
   */
  public boolean isValid() {
    return false;  // TODO: Implement this method to return the correct boolean value.
  }

  /**
   * Determines whether the current state of the Calcudoku Puzzle is valid per the cage definitions only.
   *
   * @return {@code true} if valid (complete or incomplete), {@code false} otherwise.
   */
  public boolean checkCagesValid() {
    return false;  // TODO: Implement this method to return the correct boolean value.
  }

  /**
   * Determines whether the current state of the Calcudoku Puzzle is valid per the column restrictions only.
   *
   * @return {@code true} if valid (complete or incomplete), {@code false} otherwise.
   */
  public boolean checkColumnsValid() {
    return false;  // TODO: Implement this method to return the correct boolean value.
  }

  /**
   * Determines whether the current state of the Calcudoku Puzzle is valid per the row restrictions only.
   *
   * @return {@code true} if valid (complete or incomplete), {@code false} otherwise.
   */
  public boolean checkRowsValid() {
    return false;  // TODO: Implement this method to return the correct boolean value.
  }

  /**
   * Returns the text representation of the current state of this Calcudoku Puzzle,
   * only containing the numerical values stored in the cells but not the cages.
   *
   * @return {@code String} representation of the puzzle, cell values only
   */
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int row = 0; row < BOARD_DIM; row++) {
      for (int col = 0; col < BOARD_DIM; col++) {
        sb.append(this.board[row][col]).append(" ");
      }
      sb.append("\n");
    }
    return sb.toString();
  }

  /* ===== WRITE ANY PRIVATE HELPER METHODS BELOW ===== */

  // TODO: Write `private` helper methods (optional) and delete this TODO comment (required).
}
