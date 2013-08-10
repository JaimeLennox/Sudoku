package sudoku.util;


public class Node {
  
  private Node header;
  private Node up;
  private Node down;
  private Node left;
  private Node right;
  
  private int rowIndex;
  private int columnIndex;

  
  /* Default constructor. */
  public Node() {}
  
  /**
   * 
   * Creates a new node for a quadruply linked list.
   * @param header The column header to point to.
   * @param rowIndex The node's current row index.
   * @param columnIndex The node's current column index.
   */
  public Node(Node header, int rowIndex, int columnIndex) {
    this.header = header;    
    this.rowIndex = rowIndex;
    this.columnIndex = columnIndex;
  }
  
  public Node getHeader() {
    return header;
  }

  public Node getUp() {
    return up;
  }

  public void setUp(Node up) {
    this.up = up;
  }

  public Node getDown() {
    return down;
  }

  public void setDown(Node down) {
    this.down = down;
  }

  public Node getLeft() {
    return left;
  }

  public void setLeft(Node left) {
    this.left = left;
  }

  public Node getRight() {
    return right;
  }

  public void setRight(Node right) {
    this.right = right;
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
