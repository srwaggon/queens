import java.util.List;
import java.util.Optional;

public class Main {

  public static void main(String[] args) {
    Optional<Board> solve = solve(new Board());
    System.out.println(solve.get());
  }

  private static Optional<Board> solve(Board board) {
    boolean valid = isValid(board);
    if (valid && board.getAllQueens().size() == 8) {
      return Optional.of(board);
    }
    if (!valid) {
      return Optional.empty();
    }
    for (int x = 0; x < 8; x++) {
      for (int y = 0; y < 8; y++) {
        Board next = board.placeQueenAt(x, y);
        Optional<Board> maybeSolution = solve(next);
        if (maybeSolution.isPresent()) {
          return maybeSolution;
        }
      }
    }

    return Optional.empty();
  }

  private static boolean isValid(Board board) {
    List<Queen> allQueens = board.getAllQueens();
    return allQueens.stream().noneMatch(queen0 -> allQueens.stream().anyMatch(queen0::canAttack));
  }

}
