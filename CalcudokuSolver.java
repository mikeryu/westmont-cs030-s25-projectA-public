/**
 * Westmont College Spring 2025
 * CS 030 Project A (Calcudoku Solver)
 *
 * @author Assistant Professor Mike Ryu mryu@westmont.edu
 * @author Boaty McBoatface bmcboatface@westmont.edu
 */

/**
 * The main driver for the Calcudoku Puzzle solver; contains the solution constructing algorithm.
 */
public class CalcudokuSolver {

  /**
   * Reference to the {@link CalcudokuPuzzle} to solve.
   */
  private static CalcudokuPuzzle puzzle;

  /**
   * Total number of {@link CalcudokuPuzzle#isValid()} checks that were performed in reaching the solution.
   */
  private static int numChecks;

  /**
   * Total number of {@code backtracks} that occurred in reaching the solution.
   */
  private static int numBacktracks;

  /**
   * Gets the user input for cages, runs the solution algorithm, and displays the final result to the console.
   * <p>
   * Example run:
   * <pre>
   * {@code
   * Number of cages: 9
   * Cage number 0: 9 3 0 5 6
   * Cage number 1: 7 2 1 2
   * Cage number 2: 10 3 3 8 13
   * Cage number 3: 14 4 4 9 14 19
   * Cage number 4: 3 1 7
   * Cage number 5: 8 3 10 11 16
   * Cage number 6: 13 4 12 17 21 22
   * Cage number 7: 5 2 15 20
   * Cage number 8: 6 3 18 23 24
   *
   * --Solution--
   *
   * 3 5 2 1 4
   * 5 1 3 4 2
   * 2 4 1 5 3
   * 1 2 4 3 5
   * 4 3 5 2 1
   *
   * checks: 2745 backtracks: 534}
   * </pre>
   *
   * @param args not used
   */
  public static void main(String[] args) {
    // TODO: get the cage definitions from the user,
    //       call `solve` method to solve the puzzle,
    //       then print the solution to the console.
  }

  /* ===== WRITE ANY PRIVATE HELPER METHODS BELOW ===== */

  private static void solve() {
    numChecks = 0;
    numBacktracks = 0;

    // TODO: Implement this method to solve (and store the solution to) `puzzle`.

  }
}
