package games;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class CoordinateTest {

  private Coordinate a1;
  private Coordinate d2;

  @BeforeEach
  public void setUp() {
    a1 = new Coordinate(0, 0);
    d2 = new Coordinate('d', 2);
  }

  @AfterEach
  public void tearDown() {
    a1 = null;
    d2 = null;
  }

  @Test
  public void testConstructor() {
    assertEquals('a', a1.getFile());
    assertEquals(1, a1.getRank());
    assertEquals(0, a1.fileIndex);
    assertEquals(0, a1.rankIndex);
    assertEquals('d', d2.getFile());
    assertEquals(2, d2.getRank());
    assertEquals(3, d2.fileIndex);
    assertEquals(1, d2.rankIndex);
  }

  @Test
  public void testToString() {
    assertEquals("a1", a1.toString());
    assertEquals("d2", d2.toString());
  }

  @Test
  public void testEquals() {
    Coordinate anotherA1 = new Coordinate(0, 0);
    assertEquals(a1, anotherA1);
    assertEquals(a1.hashCode(), anotherA1.hashCode());
  }
}
