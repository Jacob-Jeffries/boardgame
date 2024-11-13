package games;

public class Move {
  private Piece piece;
  public Coordinate before;
  public Coordinate after;

  public Move(Piece aPiece, Coordinate beforeLocation, Coordinate afterLocation) {
    piece = aPiece;
    before = beforeLocation;
    after = afterLocation;
  }

  public void makeOn(Board aBoard) {
    // Take out of before location and place in after location.
    if (before != null) {
      aBoard.takePiece(before);
    }
    aBoard.putPiece(after, piece);
  }

  public void unmakeOn(Board aBoard) {
    aBoard.takePiece(after);
    if (before != null) {
      aBoard.putPiece(before, piece);
    }
  }

}
