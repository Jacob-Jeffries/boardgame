package games;

import java.util.List;

public class KnightsTourPlayer extends Player{

  public KnightsTourPlayer(Board aBoard, Coordinate aCoordinate){
    super(aBoard);
    Move firstMove = new Move(new Knight(), null, aCoordinate);
    make(firstMove);
  }

  @Override
  public boolean hasSolvedPuzzle(){
    return(moves.size() == board.size()*board.size());
  }

  @Override
  public List<Move> nextLegalMoves(){
    List<Move> nextMoves;
    return null;
  }

}
