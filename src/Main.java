import java.util.LinkedList;

public class Main {

  public static void main(String[] args) {
    LinkedList<Board> boards = new LinkedList<>();
    boards.add(new Board());

    for (int queen = 0; queen < 8; queen++) {
      for (int y = 0; y < 8; y++) {
        for (int x = 0; x < 8; x++) {
          Board next = boards.getLast().placeQueenAt(x, y);
          if (next.isValid()) {
            boards.add(next);
          }
        }
      }
    }


    System.out.println(boards.getLast());
  }

}
