/**
 * Westmont College Spring 2025
 * CS 030 Project A (Calcudoku Solver)
 *
 * @author Assistant Professor Mike Ryu mryu@westmont.edu
 *
 * DO NOT MODIFY ANYTHING IN THIS FILE!
 */

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcudokuPuzzleTest {
  private static final CalcudokuCage cage0 = new CalcudokuCage(5, new int[]{0, 5});
  private static final CalcudokuCage cage1 = new CalcudokuCage(8, new int[]{1, 2, 6});
  private static final CalcudokuCage cage2 = new CalcudokuCage(8, new int[]{3, 8});
  private static final CalcudokuCage cage3 = new CalcudokuCage(6, new int[]{4, 9, 14});
  private static final CalcudokuCage cage4 = new CalcudokuCage(13, new int[]{7, 12, 13});
  private static final CalcudokuCage cage5 = new CalcudokuCage(5, new int[]{10, 15});
  private static final CalcudokuCage cage6 = new CalcudokuCage(14, new int[]{11, 16, 20, 21});
  private static final CalcudokuCage cage7 = new CalcudokuCage(6, new int[]{17, 18, 22});
  private static final CalcudokuCage cage8 = new CalcudokuCage(10, new int[]{19, 23, 24});

  private static final CalcudokuCage[] cages = {cage0, cage1, cage2, cage3, cage4, cage5, cage6, cage7, cage8};

  private static final CalcudokuPuzzle initialPuzzle = new CalcudokuPuzzle(cages);

  private static final CalcudokuPuzzle singleCellPopulated = new CalcudokuPuzzle(cages);
  private static final CalcudokuPuzzle twoCellsPopulated = new CalcudokuPuzzle(cages);

  private static final CalcudokuPuzzle singleRowPopulated = new CalcudokuPuzzle(cages);
  private static final CalcudokuPuzzle twoRowsPopulated = new CalcudokuPuzzle(cages);

  private static final CalcudokuPuzzle singleColumnPopulated = new CalcudokuPuzzle(cages);
  private static final CalcudokuPuzzle twoColumnsPopulated = new CalcudokuPuzzle(cages);

  private static final CalcudokuPuzzle fullyPopulatedInvalid = new CalcudokuPuzzle(cages);
  private static final CalcudokuPuzzle fullyPopulatedOneOff = new CalcudokuPuzzle(cages);
  private static final CalcudokuPuzzle fullyPopulatedValid = new CalcudokuPuzzle(cages);

  private static final CalcudokuPuzzle partialValidCage = new CalcudokuPuzzle(cages);
  private static final CalcudokuPuzzle partialInvalidCage = new CalcudokuPuzzle(cages);

  private static final CalcudokuPuzzle completeValidCage = new CalcudokuPuzzle(cages);
  private static final CalcudokuPuzzle completeInvalidCage = new CalcudokuPuzzle(cages);

  @BeforeAll
  static void setUp() {
    singleCellPopulated.board[0][0] = 1;
    twoCellsPopulated.board[0][0] = 1;
    twoCellsPopulated.board[0][1] = 2;

    singleRowPopulated.board[0] = new int[]{4, 1, 2, 5, 3};
    singleColumnPopulated.board[0][0] = 4;
    singleColumnPopulated.board[1][0] = 1;
    singleColumnPopulated.board[2][0] = 2;
    singleColumnPopulated.board[3][0] = 3;
    singleColumnPopulated.board[4][0] = 5;

    twoRowsPopulated.board[0] = new int[]{4, 1, 2, 5, 3};
    twoRowsPopulated.board[1] = new int[]{1, 5, 4, 3, 2};
    twoColumnsPopulated.board[0][0] = 4;
    twoColumnsPopulated.board[1][0] = 1;
    twoColumnsPopulated.board[2][0] = 2;
    twoColumnsPopulated.board[3][0] = 3;
    twoColumnsPopulated.board[4][0] = 5;
    twoColumnsPopulated.board[0][1] = 1;
    twoColumnsPopulated.board[1][1] = 5;
    twoColumnsPopulated.board[2][1] = 3;
    twoColumnsPopulated.board[3][1] = 4;
    twoColumnsPopulated.board[4][1] = 2;

    fullyPopulatedInvalid.board = new int[][]{
        {4, 1, 2, 5, 3},
        {1, 5, 4, 3, 2},
        {2, 5, 4, 3, 2},
        {3, 5, 4, 3, 2},
        {4, 1, 2, 5, 3}
    };

    fullyPopulatedOneOff.board = new int[][]{
        {4, 1, 2, 5, 3},
        {1, 5, 4, 3, 2},
        {2, 3, 5, 4, 1},
        {3, 4, 1, 2, 5},
        {5, 2, 3, 4, 1}
    };

    fullyPopulatedValid.board = new int[][]{
        {4, 1, 2, 5, 3},
        {1, 5, 4, 3, 2},
        {2, 3, 5, 4, 1},
        {3, 4, 1, 2, 5},
        {5, 2, 3, 1, 4}
    };

    partialValidCage.board[0][1] = 1;
    partialInvalidCage.board[0][1] = 5;
    partialInvalidCage.board[0][2] = 3;

    completeValidCage.board[0][1] = 1;
    completeValidCage.board[0][2] = 2;
    completeValidCage.board[1][1] = 5;
    completeInvalidCage.board[0][1] = 1;
    completeInvalidCage.board[0][2] = 3;
    completeInvalidCage.board[1][1] = 5;

  }

  @Test
  void constructorTest() {
    CalcudokuCage[] tempCages = null;
    CalcudokuPuzzle puzzle = new CalcudokuPuzzle(tempCages);
    assertNull(puzzle.cages);

    tempCages = cages;
    puzzle = new CalcudokuPuzzle(tempCages);
    assertNotNull(puzzle.cages);

    for (int row = 0; row < CalcudokuPuzzle.BOARD_DIM; row++) {
      for (int col = 0; col < CalcudokuPuzzle.BOARD_DIM; col++) {
        assertEquals(0, puzzle.board[row][col]);
      }
    }
  }

  @Test
  void simpleGetCellValueByID() {
    assertEquals(4, fullyPopulatedValid.getCellValueByID(0));
    assertEquals(1, fullyPopulatedValid.getCellValueByID(1));
    assertEquals(3, fullyPopulatedValid.getCellValueByID(4));
    assertEquals(1, fullyPopulatedValid.getCellValueByID(5));
    assertEquals(2, fullyPopulatedValid.getCellValueByID(10));
    assertEquals(5, fullyPopulatedValid.getCellValueByID(12));
    assertEquals(1, fullyPopulatedValid.getCellValueByID(14));
    assertEquals(5, fullyPopulatedValid.getCellValueByID(19));
    assertEquals(5, fullyPopulatedValid.getCellValueByID(20));
    assertEquals(4, fullyPopulatedValid.getCellValueByID(24));
  }

  @Test
  void completeGetAndSetCellValueByID() {
    CalcudokuPuzzle puzzle = new CalcudokuPuzzle(cages);
    int id = 0;

    for (int row = 0; row < CalcudokuPuzzle.BOARD_DIM; row++) {
      for (int col = 0; col < CalcudokuPuzzle.BOARD_DIM; col++) {
        puzzle.setCellValueByID(id, id * id);
        assertEquals(id * id, puzzle.getCellValueByID(id));
        id++;
      }
    }
  }

  @Test
  void isValidEmptyCase() {
    assertTrue(initialPuzzle.isValid());
  }

  @Test
  void isValidSmallCases() {
    assertTrue(singleCellPopulated.isValid());
    assertTrue(twoCellsPopulated.isValid());
  }

  @Test
  void isValidPartialRowCases() {
    assertTrue(singleRowPopulated.isValid());
    assertTrue(twoRowsPopulated.isValid());
  }

  @Test
  void isValidPartialColumnCases() {
    assertTrue(singleColumnPopulated.isValid());
    assertTrue(twoColumnsPopulated.isValid());
  }

  @Test
  void isValidFullyPopulatedCases() {
    assertFalse(fullyPopulatedInvalid.isValid());
    assertFalse(fullyPopulatedOneOff.isValid());
    assertTrue(fullyPopulatedValid.isValid());
  }

  @Test
  void checkCagesValidEmptyCase() {
    assertTrue(initialPuzzle.checkCagesValid());
  }

  @Test
  void checkCagesValidSmallCases() {
    assertTrue(singleCellPopulated.checkCagesValid());
    assertTrue(twoCellsPopulated.checkCagesValid());
  }

  @Test
  void checkCagesValidPartialRowCases() {
    assertTrue(singleRowPopulated.checkCagesValid());
    assertTrue(twoRowsPopulated.checkCagesValid());
  }

  @Test
  void checkCagesValidPartialColumnCases() {
    assertTrue(singleColumnPopulated.checkCagesValid());
    assertTrue(twoColumnsPopulated.checkCagesValid());
  }

  @Test
  void checkCagesValidFullyPopulatedCases() {
    assertFalse(fullyPopulatedInvalid.checkCagesValid());
    assertTrue(fullyPopulatedOneOff.checkCagesValid());
    assertTrue(fullyPopulatedValid.checkCagesValid());
  }

  @Test
  void checkColumnsValidEmptyCase() {
    assertTrue(initialPuzzle.checkColumnsValid());
  }

  @Test
  void checkColumnsValidSmallCases() {
    assertTrue(singleCellPopulated.checkColumnsValid());
    assertTrue(twoCellsPopulated.checkColumnsValid());
  }

  @Test
  void checkColumnsValidPartialRowCases() {
    assertTrue(singleRowPopulated.checkColumnsValid());
    assertTrue(twoRowsPopulated.checkColumnsValid());
  }

  @Test
  void checkColumnsValidPartialColumnCases() {
    assertTrue(singleColumnPopulated.checkColumnsValid());
    assertTrue(twoColumnsPopulated.checkColumnsValid());
  }

  @Test
  void checkColumnsValidFullyPopulatedCases() {
    assertFalse(fullyPopulatedInvalid.checkColumnsValid());
    assertFalse(fullyPopulatedOneOff.checkColumnsValid());
    assertTrue(fullyPopulatedValid.checkColumnsValid());
  }

  @Test
  void checkRowsValidEmptyCase() {
    assertTrue(initialPuzzle.checkRowsValid());
  }

  @Test
  void checkRowsValidSmallCases() {
    assertTrue(singleCellPopulated.checkRowsValid());
    assertTrue(twoCellsPopulated.checkRowsValid());
  }

  @Test
  void checkRowsValidPartialRowCases() {
    assertTrue(singleRowPopulated.checkRowsValid());
    assertTrue(twoRowsPopulated.checkRowsValid());
  }

  @Test
  void checkRowsValidPartialColumnCases() {
    assertTrue(singleColumnPopulated.checkRowsValid());
    assertTrue(twoColumnsPopulated.checkRowsValid());
  }

  @Test
  void checkRowsValidFullyPopulatedCases() {
    assertFalse(fullyPopulatedInvalid.checkRowsValid());
    assertTrue(fullyPopulatedOneOff.checkRowsValid());
    assertTrue(fullyPopulatedValid.checkRowsValid());
  }

  @Test
  void checkPartialCagesCase() {
    assertTrue(partialValidCage.checkCagesValid());
    assertFalse(partialInvalidCage.checkCagesValid());
  }

  @Test
  void checkCompleteCagesCase() {
    assertTrue(completeValidCage.checkCagesValid());
    assertFalse(completeInvalidCage.checkCagesValid());
  }

}
