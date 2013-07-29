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
public class QuadCircularLinkedList<T> implements IQuadCircularLinkedList<T> {
  
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
        
      }
      
      previousNodes.clear();
      
    }
  }

  @Override
  public void coverNode(int rowIndex, int columnIndex) {
    
    if (rowIndex != 0) {
    
      Node<T> node = grid.get(columnIndex).get(rowIndex);
      
      assert node.getLeft() != null;
      assert node.getRight() != null;
      assert node.getUp() != null;
      assert node.getDown() != null;
      
      node.setLeft(node.getRight());
      node.setRight(node.getLeft());
      node.setUp(node.getDown());
      node.setDown(node.getUp());
      
    }
    
  }

  @Override
  public void coverColumn(int columnIndex) {
    
    List<Node<T>> column = grid.get(columnIndex);

    for (Node<T> node : column) {
      
      node.setLeft(node.getRight());
      node.setRight(node.getLeft());
      
    }
    
  }

  @Override
  public void coverRow(int rowIndex) {
    
    if (rowIndex != 0) {
    
      Node<T> currentNode = grid.get(0).get(rowIndex);
      
      for (int i = 0; i < grid.size(); i++) {
        
        currentNode.setUp(currentNode.getDown());
        currentNode.setDown(currentNode.getUp());
       
      }
      
    }
    
  }
  
  @Override
  public void uncoverNode(int rowIndex, int columnIndex) {
    
    if (rowIndex != 0) {
      
      Node<T> node = grid.get(columnIndex).get(rowIndex);
      
      assert node.getLeft() != null;
      assert node.getRight() != null;
      assert node.getUp() != null;
      assert node.getDown() != null;
      
      node.getLeft().setRight(node);
      node.getRight().setLeft(node);
      node.getUp().setDown(node);
      node.getDown().setUp(node);
        
    }
    
  } 

  @Override
  public void uncoverColumn(int columnIndex) {
    
    List<Node<T>> column = grid.get(columnIndex);

    for (Node<T> node : column) {
      
      node.getLeft().setRight(node);
      node.getRight().setLeft(node);
      
    }
    
  }

  @Override
  public void uncoverRow(int rowIndex) {
    
    if (rowIndex != 0) {
      
      Node<T> currentNode = grid.get(0).get(rowIndex);
      
      for (int i = 0; i < grid.size(); i++) {
        
        currentNode.getUp().setDown(currentNode);
        currentNode.getDown().setUp(currentNode);
       
      }
      
    }
    
  }

  @Override
  public void updateNode(int rowIndex, int columnIndex, T newValue) {
    grid.get(columnIndex).get(rowIndex).setValue(newValue);
  }

}
