package sudoku;

import sudoku.util.Difficulty;

interface ISudoku {
  
  /**
   * Solves a given sudoku puzzle.
   * @param sudokuGrid The sudoku puzzle to be solved.
   * @return The solved sudoku puzzle.
   */
  public Cell[][] solve(Cell[][] sudokuGrid);
  
  /**
   * Generates a sudoku puzzle with the specified difficulty
   * @return The newly generated Sudoku puzzle.
   */
  public Cell[][] generate(Difficulty difficutly);

}
