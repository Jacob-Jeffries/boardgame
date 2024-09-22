package games;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.awt.Color;

public class BoardTest {
  private Board board;
  private Coordinate a1 = new Coordinate('a', 1);
  private Coordinate a2 = new Coordinate('a', 2);
  private Coordinate a4 = new Coordinate('a', 4);
  private Coordinate c2 = new Coordinate('c', 2);
  private Coordinate d1 = new Coordinate('d', 1);

  @BeforeEach
  public void setUp() {
    board = new Board(8, Color.BLACK, Color.WHITE);
  }

  @AfterEach
  public void tearDown() {
    board = null;
  }

  @Test
  public void testConstructor() {
    assertEquals(8, board.size());
    Tile aTile = board.getTile(a1);
    assertEquals(Color.BLACK, aTile.getColor());
    assertEquals(Color.BLACK, board.getColor(a1));
    assertEquals(Color.WHITE, board.getColor(a2));
    assertEquals(Color.WHITE, board.getColor(a4));
    assertEquals(Color.WHITE, board.getColor(c2));
    assertEquals(Color.WHITE, board.getColor(d1));
  }

  @Test
  public void testBoardPiece() {
    assertTrue(board.isEmpty(a1));
    assertTrue(board.isEmpty(c2));
    Piece aPiece = new Knight();
    board.putPiece(a1, aPiece);
    assertFalse(board.isEmpty(a1));
    assertTrue(board.isEmpty(c2));
    assertEquals(aPiece, board.getPiece(a1));
    assertNull(board.getPiece(c2));
    assertEquals(aPiece, board.takePiece(a1));
    assertTrue(board.isEmpty(a1));
    board.putPiece(c2, aPiece);
    assertFalse(board.isEmpty(c2));
    assertEquals(aPiece, board.getPiece(c2));
  }
}
