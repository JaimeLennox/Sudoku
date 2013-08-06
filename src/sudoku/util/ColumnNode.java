package sudoku.util;

public class ColumnNode<T> extends Node<T> {

  public ColumnNode(Node<T> header, int rowIndex, int columnIndex) {
    super(header, rowIndex, columnIndex);
  }

}
