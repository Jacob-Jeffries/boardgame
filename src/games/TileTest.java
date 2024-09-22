package games;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import java.awt.Color;

public class TileTest {

  private Tile darkTile;
  private Tile lightTile;

  @BeforeEach
  public void setUp() {
    darkTile = new Tile(Color.BLACK);
    lightTile = new Tile(Color.WHITE);
  }

  @AfterEach
  public void tearDown() {
    darkTile = null;
    lightTile = null;
  }

  @Test
  public void testConstructor() {
    assertEquals(Color.BLACK, darkTile.getColor());
    assertEquals(Color.WHITE, lightTile.getColor());
    assertTrue(darkTile.isEmpty());
    assertTrue(lightTile.isEmpty());
  }

  @Test
  public void testTilePiece() {
    Queen aQueen = new Queen();
    assertNull(darkTile.getPiece());
    darkTile.putPiece(aQueen);
    assertFalse(darkTile.isEmpty());
    assertEquals(aQueen, darkTile.getPiece());
    assertEquals(aQueen, darkTile.takePiece());
    assertTrue(darkTile.isEmpty());
  }
}
