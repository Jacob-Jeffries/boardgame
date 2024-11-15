package games;

import java.io.StringWriter;

public class Move {
  public Piece piece;
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

  @Override
  public String toString(){
    StringWriter writer = new StringWriter();
    // This is always looking at a string in memory - it will not throw an exception.
    writer.write(piece.toString());
    writer.write(" ");
    if(before != null){
      writer.write(before.toString());
      writer.write(" -> ");
    }
    writer.write(after.toString());
    return writer.toString();
  }

}
