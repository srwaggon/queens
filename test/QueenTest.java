import org.junit.Test;

import static org.junit.Assert.*;

public class QueenTest {

  @Test
  public void canAttack_FalseWhenQueensAreNotNearby() {
    Queen queen1 = new Queen(0, 0);
    Queen queen2 = new Queen(1, 2);

    assertFalse(queen1.canAttack(queen2));
    assertFalse(queen2.canAttack(queen1));
  }

  @Test
  public void canAttack_ReturnsTrue_WhenQueensAreHorizontallyAcross() {
    Queen queen1 = new Queen(0, 0);
    Queen queen2 = new Queen(7, 0);

    assertTrue(queen1.canAttack(queen2));
    assertTrue(queen2.canAttack(queen1));
  }

  @Test
  public void canAttack_ReturnsTrue_WhenQueensAreVerticallyAcross() {
    Queen queen1 = new Queen(0, 0);
    Queen queen2 = new Queen(0, 7);

    assertTrue(queen1.canAttack(queen2));
    assertTrue(queen2.canAttack(queen1));
  }

  @Test
  public void canAttack_ReturnsTrue_WhenQueensAreDiagonallyAcross() {
    Queen queen1 = new Queen(0, 0);
    Queen queen2 = new Queen(7, 7);

    assertTrue(queen1.canAttack(queen2));
    assertTrue(queen2.canAttack(queen1));

    Queen queen3 = new Queen(7, 0);
    Queen queen4 = new Queen(0, 7);

    assertTrue(queen3.canAttack(queen4));
    assertTrue(queen4.canAttack(queen3));
  }
}