import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

class Board {

  private Optional<Board> board = Optional.empty();
  private Queen queen;

  Board() {
  }

  private Board(Board board, Queen queen) {
    this.board = Optional.of(board);
    this.queen = queen;
  }

  public Board placeQueenAt(int x, int y) {
    if (x < 0 || 7 < x) {
      return this;
    }

    if (y < 0 || 7 < y) {
      return this;
    }

    return new Board(this, new Queen(x, y));
  }

  private List<Queen> getAllQueens() {
    List<Queen> acc = new LinkedList<>();
    Board next = this;
    while (next.board.isPresent()) {
      acc.add(next.queen);
    }
    return acc;
  }

  @Override
  public String toString() {

    StringBuilder result = new StringBuilder();

    for (int y = 0; y < 8; y++) {
      for (int x = 0; x < 8; x++) {
        result.append(isOccupied(x, y) ? "[Q]" : "[ ]");
      }
      result.append("\n");
    }
    return result.toString();
  }

  private boolean isOccupied(int x, int y) {
    return getAllQueens().stream()
        .anyMatch(queen -> queen.getX() == x && queen.getY() == y);
  }
}
