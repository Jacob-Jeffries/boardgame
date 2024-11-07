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
  }
}
