package sudoku.util;

public class ColumnNode<T> extends Node<T> {
  
  public ColumnNode(int columnIndex) {
    super.setColumnIndex(columnIndex);
  }

}
