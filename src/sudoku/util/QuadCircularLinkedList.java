package sudoku.util;

import java.util.ArrayList;
import java.util.List;

public class QuadCircularLinkedList<T> {
  
  private Node<T> header;
  
  public QuadCircularLinkedList(int width, int height) {
    header = new Node<T>(header, 0, -1);
    
    // Create initial node.
    header.setRight(new Node<T>(header.getRight(), 0, 0));
    header.getRight().setLeft(header);
    
    Node<T> xNode = header.getRight(), yNode = header.getRight();
    List<Node<T>> previousNodes = new ArrayList<Node<T>>();
    
    for (int i = 0; i < width; i++) {
      
      // Create new horizontal node and set neighbours
      xNode.setRight(new Node<T>(xNode.getRight(), 0, i));
      xNode.getRight().setLeft(xNode);
      xNode.getRight().setRight(header);
      xNode = xNode.getRight();
      
      for (int j = 1; j < height; j++) {
        
        // Create new vertical node and set neighbours.
        yNode.setDown(new Node<T>(xNode, j, i));
        yNode.getDown().setUp(yNode);
        yNode.getDown().setDown(header.getRight());
        
        // Only set horizontal neighbours if not first column.
        if (j > 0) {
          
          yNode.setLeft(previousNodes.get(j));
          yNode.getLeft().setRight(yNode);
          
        }
        
        yNode = yNode.getDown();       
        previousNodes.add(yNode);
        
      }
      
      previousNodes.clear();
      
    }
  }  
  
  

}
