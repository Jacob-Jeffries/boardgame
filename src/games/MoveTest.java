package games;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

public class MoveTest {

  private Piece piece;
  private Coordinate a1;
  private Coordinate b3;
  private Move placePieceMove;
  private Move movePieceMove;
  private Board board;

  @BeforeEach
  public void setUp(){
    piece = new Knight();
    a1 = new Coordinate('a', 1);
    b3 = new Coordinate('b', 3);
    placePieceMove = new Move(piece, null, a1);
    movePieceMove = new Move(piece, a1, b3);
    board = new Board(6, Color.BLACK, Color.WHITE);
  }


  @Test
  public void testPlacePiece(){
    placePieceMove.makeOn(board);
    assertFalse(board.isEmpty(a1));
    assertEquals(piece, board.getPiece(a1));
    placePieceMove.unmakeOn(board);
    assertTrue(board.isEmpty(a1));
  }

  @Test
  public void testMovePiece(){
    placePieceMove.makeOn(board);
    movePieceMove.makeOn(board);
    assertTrue(board.isEmpty(a1));
    assertFalse(board.isEmpty(b3));
    assertEquals(piece, board.getPiece(b3));
    movePieceMove.unmakeOn(board);
    assertFalse(board.isEmpty(a1));
    assertTrue(board.isEmpty(b3));
    assertEquals(piece, board.getPiece(a1));
  }
}
