package games;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class NQueensPlayerTest {

  private Board board;
  private NQueensPlayer player;
  private Queen queen = new Queen();
  private Coordinate a1 = new Coordinate('a', 1);
  private Coordinate d2 = new Coordinate('d', 2);
  private Move a1Move = new Move(new Queen(), null, a1);
  private Move d2Move = new Move(new Queen(), null, d2);

  @BeforeEach
  public void setUp(){
    board = new Board(8, Color.BLACK, Color.WHITE);
    player = new NQueensPlayer(board);
  }

  @AfterEach
  public void tearDown(){
    board = null;
    player = null;
  }


  @Test
  void testHasSolvedPuzzle() {
    List<Move> moves = player.getMoves();
    for ( int i= 0; i < (board.size()); ++i){
      assertFalse(player.hasSolvedPuzzle());
      moves.add(a1Move);
    };
  }

  @Test
  void testNextLegalMoves() {
    Coordinate b3 = new Coordinate('b', 3);
    Coordinate f3 = new Coordinate('f', 3);
    Coordinate g3 = new Coordinate('g', 3);
    Coordinate h3 = new Coordinate('h', 3);
    player.make(a1Move);
    player.make(d2Move);
    // Good Coordinates: b3, f3, g3, h3
    List<Move> nextMoves = player.nextLegalMoves();
    assertEquals(4, nextMoves.size());
    assertTrue(findMove(nextMoves, b3) != null);
    assertTrue(findMove(nextMoves, f3) != null);
    assertTrue(findMove(nextMoves, g3) != null);
    assertTrue(findMove(nextMoves, h3) != null);
  }

  @Test
  public void testSolve(){
    assertTrue(player.solve());
    System.out.println("The problem has been solved");
    for (Move eachMove : player.moves) {
      System.out.println(eachMove.toString());
    }
  }

  public Move findMove(List<Move> moves, Coordinate aCoordinate) {
    for (Move eachMove : moves) {
      if (eachMove.after.equals(aCoordinate)) {
        return eachMove;
      }
    }
    return null;
  }
}
