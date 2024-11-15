package games;

import java.util.ArrayList;
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
  public List<Move> nextLegalMoves() {
    Coordinate knightCoordinate = moves.get(moves.size() - 1).after;
    Knight knight = (Knight) moves.get(moves.size() - 1).piece;
    List<Move> nextMoves = new ArrayList<Move>();
    List<Coordinate> nextKnightCoordinates = new ArrayList<Coordinate>();
    List<Coordinate> nextCoords = nextKnightCoordinates();
    for (Coordinate eachCoordinate : nextCoords) {
      if (!hasVisited(eachCoordinate)) {
        Move aMove = new Move(knight, knightCoordinate, eachCoordinate);
        nextMoves.add(aMove);
      }
    }
    return nextMoves;
  }

  public boolean hasVisited(Coordinate aCoord){
    for(Move eachMove : moves){
      if(eachMove.after.equals(aCoord)){
        return true;
      }
    }
    return false;
  }

  public List<Coordinate> nextKnightCoordinates(){
    Coordinate knightCoordinate = moves.get(moves.size()-1).after;
    List<Coordinate> nextCoords = new ArrayList<Coordinate>();
    int[] fileOffsets = {1,2,2,1,-1,-2,-2,-1};
    int[] rankOffsets = {2,1,-1,-2,-2,-1,1,2};
    for(int i = 0; i < fileOffsets.length; ++i){
      int newFileIndex = knightCoordinate.fileIndex + fileOffsets[i];
      int newRankIndex = knightCoordinate.rankIndex + rankOffsets[i];
      if (newFileIndex >= 0 && newFileIndex < board.size()
            && newRankIndex >=0 && newRankIndex < board.size()){
              nextCoords.add(new Coordinate(newFileIndex, newRankIndex));
      }
    }
    return nextCoords;
  }

}
