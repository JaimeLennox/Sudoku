package sudoku;

import sudoku.util.ColumnNode;
import sudoku.util.Difficulty;

/**
 * An implementation of a Sudoku puzzle.
 * @author Jaime Lennox
 * 
 */
public class Sudoku implements ISudoku {
  
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
  
  public ColumnNode<Short> algorithmX(ColumnNode<Short> dancingLinks) {
    return null;
  }
  
  @Override
  public Cell[][] solve(Cell[][] sudokuGrid) {
    return decodeSudoku(algorithmX(encodeSudoku(sudokuGrid)));
    
  }
  
  public Cell[][] loadText() {
    return null;    
  }
  
  /**
   * Displays a text output of a sudoku puzzle.
   * @param sudokuGrid The Sudoku puzzle to be displayed.
   */
  public void displayText(Cell[][] sudokuGrid) {

  }
  
  @Override
  public Cell[][] generate(Difficulty difficulty) {
    return null;
  }
  
  public static void main(String[] args) {
    
    Sudoku sudoku = new Sudoku();

  }
  
}
