package games;

public class KnightsTourPlayer extends Player{

  public KnightsTourPlayer(){
    super();
  }

  @Override
  public boolean hasSolvedPuzzle(){
    return(moves.size() == board.size()*board.size());
  }

  @Override
  public List<Move> nextLegalMoves(){}
  List<Move> nextMoves;

}
