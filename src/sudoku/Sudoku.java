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
  
  private static final int GRID_COLUMNS   = 9;
  private static final int GRID_ROWS      = 9;
  private static final int MAX_GRID_VALUE = 9;
  
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
    
    // Create matrix to record node locations.
    int[][] nodeMatrix = new int[MAX_MATRIX_ROWS][MAX_MATRIX_COLUMNS];
    int calculationStore = 0;
    
    ColumnNode header = new ColumnNode(-1);
    ColumnNode currentColumn = header;
    
    // Initialise indexes.
    int rowIndex = -1;
    int columnIndex = 0;

    // Create columns for the row-column constraint set.
    for (int j = 0; j < MAX_ROW_COLUMN_CONSTRAINT; j++) {
      
      if ((columnIndex = j % GRID_COLUMNS) == 0) rowIndex++;
      
      currentColumn.setRight(new ColumnNode(j));
      currentColumn.getRight().setLeft(currentColumn);
      currentColumn = (ColumnNode) currentColumn.getRight();
      
      // Create row nodes:
      
      int value = sudokuGrid[rowIndex][columnIndex].getValue();
      
      // If no value then create nodes for the nine possibilities, otherwise 
      // only create a node for the same value.
      if (value == 0) {
        
        calculationStore = j * MAX_GRID_VALUE;
        Node currentRow = new Node(currentColumn, calculationStore, j);
        nodeMatrix[calculationStore][j] = 1;
        
        for (int i = 1; i < MAX_GRID_VALUE; i++) {
          
          calculationStore++; // Shortened from i + j * MAX_GRID_VALUE
          nodeMatrix[calculationStore][j] = 1;
          currentRow.setDown(new Node(currentColumn, calculationStore, j));
          currentRow.getDown().setUp(currentRow);
          currentRow.getDown().setDown(currentColumn);
          
        }
        
      } else {
        
        calculationStore = value - 1 + j * MAX_GRID_VALUE;
        nodeMatrix[calculationStore][j] = 1;
        currentColumn.setDown(new Node(currentColumn, calculationStore, j));
        currentColumn.getDown().setUp(currentColumn);
        currentColumn.getDown().setDown(currentColumn);
        
      }
      
    }
    
    // Reset row index for use in next constraint set.
    rowIndex = -1;
        
    // Create columns for row-number constraint set.
    for (int j = MAX_ROW_COLUMN_CONSTRAINT; j < MAX_ROW_NUMBER_CONSTRAINT; j++) {
      
      if ((columnIndex = j % GRID_COLUMNS) == 0) rowIndex++;
      
      currentColumn.setRight(new ColumnNode(j));
      currentColumn.getRight().setLeft(currentColumn);
      currentColumn = (ColumnNode) currentColumn.getRight();
      
      // Create row nodes.
      
      for (int i = 0; i < MAX_GRID_VALUE; i++) {
        
        int value = sudokuGrid[rowIndex][i].getValue();
        
        if (value == columnIndex + 1) {
          
          //currentColumn.setDown(new Node(currentColumn, columnIndex * rowIndex, j));
          calculationStore = columnIndex + 1 + (j - MAX_ROW_COLUMN_CONSTRAINT) * MAX_GRID_VALUE;
          currentColumn.setDown(new Node(currentColumn, calculationStore, j));
          currentColumn.getDown().setUp(currentColumn);
          currentColumn.getDown().setDown(currentColumn);
          
        } else {
          
          Node currentRow = new Node(currentColumn, j * rowIndex, j);
          
          for (int k = 1; k < GRID_ROWS * GRID_ROWS; k++) {
            
            currentRow.setDown(new Node(currentColumn, MAX_GRID_VALUE * k + j * rowIndex, j));
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
    for (int j = MAX_ROW_COLUMN_CONSTRAINT; j < MAX_ROW_NUMBER_CONSTRAINT; j++) {
      
      if ((columnIndex = j % GRID_COLUMNS) == 0) rowIndex++;
      
      currentColumn.setRight(new ColumnNode(j));
      currentColumn.getRight().setLeft(currentColumn);
      currentColumn = (ColumnNode) currentColumn.getRight();
      
      // Create row nodes.
      
      for (int i = 0; i < GRID_COLUMNS; i++) {
        
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
   * Converts a Sudoku puzzle in dancing links format back to normal.
   * @param dancingLinks The pointer to the dancing links to decode.
   * @return A pointer to the converted Sudoku grid.
   */
  private Cell[][] decodeSudoku(ColumnNode dancingLinks) {
    // TODO: Not yet implemented.
    return null;
    
  }
  
  public ColumnNode algorithmX(ColumnNode dancingLinks) {
    // TODO: Not yet implemented.
    return null;
  }
  
  @Override
  public Cell[][] solve(Cell[][] sudokuGrid) {
    return decodeSudoku(algorithmX(encodeSudoku(sudokuGrid)));
    
  }
  
  public Cell[][] loadText() {
    // TODO: Not yet implemented.
    return null;    
  }
  
  /**
   * Displays a text output of a Sudoku puzzle.
   * @param sudokuGrid The Sudoku puzzle to be displayed.
   */
  public void displayText(Cell[][] sudokuGrid) {
    // TODO: Not yet implemented.
  }
  
  @Override
  public Cell[][] generate(Difficulty difficulty) {
    // TODO: Not yet implemented.
    return null;
  }
  
  public static void main(String[] args) {
    
  }
  
}
