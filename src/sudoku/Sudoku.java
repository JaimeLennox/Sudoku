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
  
  private static final int MAX_MATRIX_ROWS    = 729;
  private static final int MAX_MATRIX_COLUMNS = 324;
  
  private static final int MAX_ROW_COLUMN_CONSTRAINT = 81;
  private static final int MAX_ROW_NUMBER_CONSTRAINT = 162;
  private static final int MAX_COLUMN_NUMBER_CONSTRAINT = 243;
  private static final int MAX_BOX_CONSTRAINT = 324; 
  
  private Cell[][] mainGrid = new Cell[GRID_ROWS][GRID_COLUMNS];

  
  public Sudoku(int[][] sudoku) {
    
    for (int i = 0; i < GRID_ROWS; i++) {
      for (int j = 0; j < GRID_COLUMNS; j++) {
        mainGrid[GRID_ROWS][GRID_COLUMNS] = new Cell(sudoku[GRID_ROWS][GRID_COLUMNS]);
      }
    }
    
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
    
    int rowIndex = -1;
    int columnIndex = 0;

    // Create columns for row-column constraint set.
    for (int j = 0; j < MAX_ROW_COLUMN_CONSTRAINT; j++) {
      
      if ((columnIndex = j % 9) == 0) rowIndex++;
      
      currentColumn.setRight(new ColumnNode(j));
      currentColumn.getRight().setLeft(currentColumn);
      currentColumn = (ColumnNode) currentColumn.getRight();
      
      // Create row nodes.
      
      int value = sudokuGrid[rowIndex][columnIndex].getValue();
      
      // If no value then create the nine possibilities, otherwise pick
      // same value.
      if (value == 0) {
        
        Node currentRow = new Node(currentColumn, j * 9, j);
        
        for (int i = 1; i < 9; i++) {
          
          currentRow.setDown(new Node(currentColumn, i + j * 9, j));
          currentRow.getDown().setUp(currentRow);
          currentRow.getDown().setDown(currentColumn);
        }
        
      } else {
        
        currentColumn.setDown(new Node(currentColumn, value + j * 9, j));
        currentColumn.getDown().setUp(currentColumn);
        currentColumn.getDown().setDown(currentColumn);
        
      }
      
    }
    
    // Reset row index for use in next constraint set.
    rowIndex = -1;
        
    // Create columns for row-number constraint set.
    for (int j = MAX_ROW_COLUMN_CONSTRAINT + 1; j < MAX_ROW_NUMBER_CONSTRAINT; j++) {
      
      if ((columnIndex = j % 9) == 0) rowIndex++;
      
      currentColumn.setRight(new ColumnNode(j));
      currentColumn.getRight().setLeft(currentColumn);
      currentColumn = (ColumnNode) currentColumn.getRight();
      
      // Create row nodes.
      
      for (int i = 0; i < 9; i++) {
        
        if (sudokuGrid[rowIndex][i].getValue() == columnIndex) {
          
          currentColumn.setDown(new Node(currentColumn, columnIndex * rowIndex, j));
          currentColumn.getDown().setUp(currentColumn);
          currentColumn.getDown().setDown(currentColumn);
          
        } else {
          
          Node currentRow = new Node(currentColumn, j * rowIndex, j);
          
          for (int k = 1; k < GRID_ROWS * GRID_ROWS; k++) {
            
            currentRow.setDown(new Node(currentColumn,9 * k + j * rowIndex, j));
            currentRow.getDown().setUp(currentRow);
            currentRow.getDown().setDown(currentColumn);
            currentRow = currentRow.getDown();
            
            
          }
          
        }
      }
      
    }
    
    // Reset row index for use in next constraint set.
    rowIndex = -1;
        
    // Create columns for column-number constraint set.
    for (int j = MAX_ROW_COLUMN_CONSTRAINT + 1; j < MAX_ROW_NUMBER_CONSTRAINT; j++) {
      
      if ((columnIndex = j % 9) == 0) rowIndex++;
      
      currentColumn.setRight(new ColumnNode(j));
      currentColumn.getRight().setLeft(currentColumn);
      currentColumn = (ColumnNode) currentColumn.getRight();
      
      // Create row nodes.
      
      for (int i = 0; i < 9; i++) {
        
        if (sudokuGrid[i][columnIndex].getValue() == columnIndex) {
          
          currentColumn.setDown(new Node(currentColumn, columnIndex * rowIndex, j));
          currentColumn.getDown().setUp(currentColumn);
          currentColumn.getDown().setDown(currentColumn);          
          
        } else {
          
          Node currentRow = new Node(currentColumn, j * rowIndex, j);
          
          int limit = GRID_ROWS * GRID_ROWS;
          
          for (int k = 1; k < limit; k++) {
            
            currentRow.setDown(new Node(currentColumn, limit * k + j * rowIndex, j));
            currentRow.getDown().setUp(currentRow);
            currentRow.getDown().setDown(currentColumn);
            currentRow = currentRow.getDown();
            
          }
          
        }
      }
      
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
    
  }
  
}
