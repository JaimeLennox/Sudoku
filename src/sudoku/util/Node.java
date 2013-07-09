package sudoku.util;

class Node<T> {
  
  private Node<T> header;
  private Node<T> up;
  private Node<T> down;
  private Node<T> left;
  private Node<T> right;
  
  private T value;
  private int rowIndex;
  private int columnIndex;

  /**
   * 
   * Creates a new node for a quadruply linked list.
   * @param header The column header to point to.
   * @param rowIndex The node's current row index.
   * @param columnIndex The node's current column index.
   */
  public Node(Node<T> header, int rowIndex, int columnIndex) {
    this.header = header;    
    this.rowIndex = rowIndex;
    this.columnIndex = columnIndex;
  }
  
  public Node<T> getHeader() {
    return header;
  }

  public Node<T> getUp() {
    return up;
  }

  public void setUp(Node<T> up) {
    this.up = up;
  }

  public Node<T> getDown() {
    return down;
  }

  public void setDown(Node<T> down) {
    this.down = down;
  }

  public Node<T> getLeft() {
    return left;
  }

  public void setLeft(Node<T> left) {
    this.left = left;
  }

  public Node<T> getRight() {
    return right;
  }

  public void setRight(Node<T> right) {
    this.right = right;
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public int getRowIndex() {
    return rowIndex;
  }

  public void setRowIndex(int rowIndex) {
    this.rowIndex = rowIndex;
  }

  public int getColumnIndex() {
    return columnIndex;
  }

  public void setColumnIndex(int columnIndex) {
    this.columnIndex = columnIndex;
  }

}
