package sudoku;

import sudoku.util.QuadCircularLinkedList;

public class Sudoku {
  
  private static final int GRID_LENGTH = 10;
  private QuadCircularLinkedList<Cell> grid =
      new QuadCircularLinkedList<Cell>(GRID_LENGTH, GRID_LENGTH);
  
  public Sudoku() {
    
    
    
  }

  public static void main(String[] args) {
    
    Sudoku sudoku = new Sudoku();
    

  }

}
