package games;

import java.awt.Color;

public class Board {
  private Tile[][] tiles;

  /**
   * The Board is organized as tiles[fileIndex][rankIndex].
   *
   * @param aSize
   *                   This parameter defines the square size of the board.
   * @param darkColor
   *                   This parameter defines the dark color for the board.
   * @param lightColor
   *                   This parameter defines the light color for the board.
   */
  public Board(int aSize, Color darkColor, Color lightColor) {
    tiles = new Tile[(aSize)][(aSize)];
    for (int i = 0; i < aSize; ++i) {
      for (int j = 0; j < aSize; ++j) {
        Color[] colors = { darkColor, lightColor };
        tiles[i][j] = new Tile(colors[((i + j) % 2)]);
      }
    }
  }

  public int size() {
    return tiles.length;
  }

  public Tile getTile(Coordinate aCoordinate) {
    return tiles[aCoordinate.getFileIndex()][aCoordinate.getRankIndex()];
  }

  public Color getColor(Coordinate aCoordinate) {
    Tile aTile = getTile(aCoordinate);
    return aTile.getColor();
  }

  public boolean isEmpty(Coordinate aCoordinate) {
    Tile aTile = getTile(aCoordinate);
    return aTile.isEmpty();
  }

  public void putPiece(Coordinate aCoordinate, Piece aPiece) {
    Tile aTile = getTile(aCoordinate);
    aTile.putPiece(aPiece);
    return;
  }

  public Piece getPiece(Coordinate aCoordinate) {
    Tile aTile = getTile(aCoordinate);
    return aTile.getPiece();
  }

  public Piece takePiece(Coordinate aCoordinate) {
    Tile aTile = getTile(aCoordinate);
    return aTile.takePiece();
  }
}
