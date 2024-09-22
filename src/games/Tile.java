package games;

import java.awt.Color;

public class Tile {

  private Color color;
  private Piece piece;

  public Tile(Color aColor) {
    this.color = aColor;
    this.piece = null;
  }

  public Color getColor() {
    return this.color;
  }

  public boolean isEmpty() {
    return (piece == null);
  }

  public Piece getPiece() {
    return piece;
  }

  public Piece putPiece(Piece aPiece) {
    this.piece = aPiece;
    return piece;
  }

  public Piece takePiece() {
    Piece tempPiece = piece;
    this.piece = null;
    return tempPiece;
  }
}