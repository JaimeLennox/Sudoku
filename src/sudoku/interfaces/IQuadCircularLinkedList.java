package sudoku.interfaces;

public interface IQuadCircularLinkedList<T> {
  
  /**
   * Removes a node from the linked list. Since nodes are still available in an
   * array, it is possible to repeatedly cover the same node with no adverse
   * affects. 
   * @param rowIndex The row index of the node to be removed.
   * @param columnIndex The column index of the node to be removed.
   */
  public void coverNode(int rowIndex, int columnIndex);
  
  /**
   * Removes a column from the linked list. Since columns are still available 
   * in an array, it is possible to repeatedly cover the same column with no
   * adverse effects.
   * @param columnIndex The index of the column to remove.
   */
  public void coverColumn(int columnIndex);
  
  /**
   * Removes a row from the linked list. Since rows are still available in an
   * array, it is possible to repeatedly cover the same row with no adverse
   * effects.
   * @param rowIndex The index of the row to remove.
   */
  public void coverRow(int rowIndex);
  
  /**
   * Reinstates a removed node to the linked list. If the node is already in the
   * linked list nothing should happen.
   * @param rowIndex The row index of the node.
   * @param columnIndex The column index of the node.
   */
  public void uncoverNode(int rowIndex, int columnIndex);
  
  /**
   * Reinstates a removed column to the linked list. If the column is already in
   * the linked list nothing should happen.
   * @param columnIndex The index of the column to reinstate.
   */
  public void uncoverColumn(int columnIndex);
  
  /**
   * Reinstates a removed row to the linked list. If the row is already in the
   * linked list nothing should happen.
   * @param rowIndex The index of the row to reinstate.
   */
  public void uncoverRow(int rowIndex);

  /**
   * Updates the specified node with a given value. Can be applied to a covered
   * or uncovered node.
   * @param rowIndex The row index of the node.
   * @param columnIndex The column index of the node.
   * @param newValue The new value for the node.
   */
  public void updateNode(int rowIndex, int columnIndex, T newValue);
  

}


