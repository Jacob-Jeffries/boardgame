package games;

import java.util.List;

public class NQueensPlayer extends Player{

  public NQueensPlayer(Board aBoard){
    super(aBoard);
  }

  @Override
  public boolean hasSolvedPuzzle() {
    return (moves.size() == board.size());
  }

  @Override
  public List<Move> nextLegalMoves() {
    return null;
  }

}
