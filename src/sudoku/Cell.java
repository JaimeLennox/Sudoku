package sudoku;

import java.util.HashSet;
import java.util.Set;

class Cell {
  
  private int value;
  private Set<Candidate> candidates = new HashSet<Candidate>();
  
  public Cell(int value) {
    this.value = value;
  }
  
  public int getValue() {
    return value;
  }
  
  public void setValue(int value) {
    this.value = value;
  }
  
  public Set<Candidate> getCandidates() {
    return candidates;
  }

  public void addCandidate(int value) {
    candidates.add(new Candidate(value));
  }

}
