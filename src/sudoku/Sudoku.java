package sudoku;

import sudoku.util.ColumnNode;

/**
 * An implementation of a Sudoku puzzle.
 * @author Jaime Lennox
 * 
 */
public class Sudoku {
  
  private static final int GRID_COLUMNS = 9;
  private static final int GRID_ROWS    = 9;
  
  private Cell[][] mainGrid = new Cell[9][9];

  
  public Sudoku() {
    
  }
  
  /**
   * Converts a sudoku puzzle into an exact cover problem in dancing links
   * format.
   * @param sudokuGrid The sudoku grid to encode.
   * @return A pointer to the start of the dancing linked list.
   */
  private ColumnNode<Short> encodeSudoku(Cell[][] sudokuGrid) {
    return null;
    
  }
  
  /**
   * Converts a sudoku puzzle in dancing links format back to normal.
   * @param dancingLinks The pointer to the dancing links to decode.
   * @return The converted sudoku grid.
   */
  private Cell[][] decodeSudoku(ColumnNode<Short> dancingLinks) {
    return null;
    
  }
  
  /**
   * Solves a given sudoku puzzle using Algorithm X.
   * @param sudokuGrid The sudoku puzzle to be solved.
   * @return The solved sudoku puzzle.
   */
  public Cell[][] solve(Cell[][] sudokuGrid) {
    return null;
  }
  
  
  public Cell[][] loadText() {
    return null;    
  }
  
  /**
   * Displays a text output of a sudoku puzzle.
   */
  public void displayText(Cell[][] sudokuGrid) {

  }
  
  public static void main(String[] args) {
    
    Sudoku sudoku = new Sudoku();

  }
  
}
