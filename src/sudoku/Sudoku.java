package sudoku;

import sudoku.util.ColumnNode;
import sudoku.util.Difficulty;
import sudoku.util.Node;

/**
 * An implementation of a Sudoku puzzle.
 * @author Jaime Lennox
 * 
 */
public class Sudoku implements ISudoku {
  
  private static final int GRID_COLUMNS = 9;
  private static final int GRID_ROWS    = 9;
  
  private static final int MAX_MATRIX_COLUMNS = 324;
  private static final int MAX_MATRIX_ROWS    = 729;
  
  private static final int MAX_ROW_COLUMN_CONSTRAINT = 81;
  private static final int MAX_ROW_NUMBER_CONSTRAINT = 162;
  private static final int MAX_COLUMN_NUMBER_CONSTRAINT = 243;
  private static final int MAX_BOX_CONSTRAINT = 324; 
  
  private Cell[][] mainGrid = new Cell[9][9];

  
  public Sudoku() {
    
  }
  
  /**
   * Converts a sudoku puzzle into an exact cover problem in dancing links
   * format.
   * @param sudokuGrid The sudoku grid to encode.
   * @return A pointer to the start of the dancing linked list.
   */
  private ColumnNode encodeSudoku(Cell[][] sudokuGrid) {
    
    ColumnNode header = new ColumnNode(-1);
    
    ColumnNode currentColumn = header;
    
    int rowIndex = 0;
    int columnIndex = 0;

    // Create columns for row-column constraint set.
    for (int j = 0; j < MAX_ROW_COLUMN_CONSTRAINT; j++) {
      
      if ((columnIndex = j % 9) == 0) rowIndex++;
      
      currentColumn.setRight(new ColumnNode(j));
      currentColumn.getRight().setLeft(currentColumn);
      currentColumn = (ColumnNode) currentColumn.getRight();
      
      
      // Create row nodes.
      
      // If no value then create the nine possibilities, otherwise pick
      // same value.
      if (sudokuGrid[rowIndex][columnIndex].getValue() == 0) {
        
        Node currentRow = new Node(currentColumn, 0, j);
        
        for (int i = 1; i < 9; i++)
          currentRow.setDown(new Node(currentColumn, i + j * 9, j));
        
      } else currentColumn.setDown(new Node(currentColumn, 0, j));
      
    }
    
    return null;
    
  }
  
  /**
   * Converts a sudoku puzzle in dancing links format back to normal.
   * @param dancingLinks The pointer to the dancing links to decode.
   * @return A pointer to the converted sudoku grid.
   */
  private Cell[][] decodeSudoku(ColumnNode dancingLinks) {
    return null;
    
  }
  
  public ColumnNode algorithmX(ColumnNode dancingLinks) {
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
