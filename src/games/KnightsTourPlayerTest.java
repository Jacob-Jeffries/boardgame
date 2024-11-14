package games;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.util.List;

public class KnightsTourPlayerTest {

  private Knight knight = new Knight();
  private Coordinate a1 = new Coordinate('a', 1);
  private Coordinate b3 = new Coordinate('b',3);
  private Coordinate c2 = new Coordinate('c', 2);
  private KnightsTourPlayer player;
  private Board board;

  @BeforeEach
  public void setUp(){
    board = new Board(6, Color.BLACK, Color.WHITE);
    player = new KnightsTourPlayer(board, a1); // This presents less objects to the user. Less coupling makes making changes later.
  }

  @AfterEach
  public void tearDown(){
    board = null;
    player = null;
  }

  @Test
  public void testHasSolvedPuzzle() {
    // We are going to have to add a group of moves.
    // This will add a knight 36x in one square.
    // When we creating the KTP, we added one move for piece placement.
    Move phonyMove = new Move(knight, null, a1);
    for( int i=1; i < (board.size()*board.size()); ++i){
      assertFalse(player.hasSolvedPuzzle());
      player.getMoves().add(phonyMove);
    }
    assertTrue(player.hasSolvedPuzzle());
  }

  @Test
  public void testNextLegalMoves() {
    List<Move> nextMoves = player.nextLegalMoves();
    assertEquals(2, nextMoves.size());
    assertEquals(b3, findMove(nextMoves, b3).after);
    assertEquals(c2, findMove(nextMoves, c2).after);
    player.make(findMove(nextMoves, c2));
    nextMoves = player.nextLegalMoves();
    assertEquals(5, nextMoves.size());
    assertNull(findMove(nextMoves, a1));
    Coordinate d4 = new Coordinate('d', 3);
    Coordinate e3 = new Coordinate('e', 3);
    assertEquals(d4, findMove(nextMoves, d4).after);
    assertEquals(e3, findMove(nextMoves, e3).after);
  }

  @Test
  public void testNextKnightCoordinates(){
    List<Coordinate> nextCoords = player.nextKnightCoordinates();
    assertEquals(2, nextCoords.size());
    Move nextMove = new Move(new Knight(), a1, c2);
    player.make(nextMove);
    nextCoords = player.nextKnightCoordinates();
    assertEquals(6, nextCoords.size());
  }

  @Test
  public void testSolve(){
    assertTrue(player.solve());
  }

  public Move findMove(List<Move> moves, Coordinate aCoordinate){
    for(Move eachMove : moves){
      if(eachMove.after.equals(aCoordinate)){
        return eachMove;
      }
    }
    return null;
  }
}
