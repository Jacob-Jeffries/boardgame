package games;

import java.util.List;

public abstract class Player {
  protected Board board;
  protected List<Move> moves;

  public abstract boolean hasSolvedPuzzle();
  public abstract List<Move> nextLegalMoves();

  public boolean solve() {
    if(hasSolvedPuzzle()){
      return true;
    }
    List<Move> nextMoves = nextLegalMoves();
    for(Move eachMove : nextMoves){
      make(eachMove);
      if(solve()){return true;};
      unmake();
    }
    return false;
  }

  public void make(Move aMove){
    aMove.makeOn(board);
    moves.add(aMove);
  }

  public void unmake(){
    Move lastMove = moves.remove(moves.size()-1);
    lastMove.unmakeOn(board);
  }

}
