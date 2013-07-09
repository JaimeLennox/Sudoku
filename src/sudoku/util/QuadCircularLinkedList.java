package sudoku.util;

import java.util.ArrayList;
import java.util.List;

import sudoku.interfaces.IQuadCircularLinkedList;

/**
 * 
 * An implementation of a quadruply circular linked list. Every node has a link
 * to the node above, below, left and right, as well as to the column header
 * node. There is a master header node that points to the start of the list.
 * @author Jaime Lennox
 */
public class QuadCircularLinkedList<T> implements IQuadCircularLinkedList {
  
  private Node<T> header;
  private List<List<Node<T>>> grid = new ArrayList<List<Node<T>>>();
 
  /**
   * Creates a new quadruply circular linked list with the specified columns
   * and rows.
   * @param cols The number of columns for the new linked list.
   * @param rows The number of rows for the new linked list.
   */
  public QuadCircularLinkedList(int cols, int rows) {
    
    header = new Node<T>(header, 0, -1);
    
    // Create initial node.
    header.setRight(new Node<T>(header.getRight(), 0, 0));
    header.getRight().setLeft(header);
    
    Node<T> yNode, xNode = header;
    List<Node<T>> previousNodes = new ArrayList<Node<T>>();
    
    for (int i = 0; i < cols; i++) {
      
      // Create new horizontal node and set neighbours
      xNode.setRight(new Node<T>(xNode.getRight(), 0, i));
      xNode.getRight().setLeft(xNode);
      xNode.getRight().setRight(header);
      xNode = xNode.getRight();
      
      grid.add(new ArrayList<Node<T>>());
      grid.get(i).add(xNode);
      
      for (int j = 1; j < rows; j++) {
        
        yNode = xNode;
        
        // Create new vertical node and set neighbours.
        yNode.setDown(new Node<T>(xNode, j, i));
        yNode.getDown().setUp(yNode);
        yNode.getDown().setDown(xNode);
        
        // Only set horizontal neighbours if not first column.
        if (j > 0) {
          
          yNode.setLeft(previousNodes.get(j - 1));
          yNode.getLeft().setRight(yNode);
          
        }
        
        yNode = yNode.getDown();       
        previousNodes.add(yNode);
        grid.get(i).add(yNode);
        
      }
      
      previousNodes.clear();
      
    }
  }

  @Override
  public void removeNode(int rowIndex, int columnIndex) {
    
    Node<T> node = grid.get(columnIndex).get(rowIndex);
    
    if (node != header) {
    
      node.setLeft(node.getRight());
      node.setRight(node.getLeft());
      node.setUp(node.getDown());
      node.setDown(node.getUp());
    
    }
    
  }

  @Override
  public void removeColumn(int columnIndex) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void removeRow(int rowIndex) {
    // TODO Auto-generated method stub
    
  }  
  
  

}
