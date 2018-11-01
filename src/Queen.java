class Queen {

  private int x;
  private int y;

  Queen(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public boolean equals(Object o) {
    if (!(o instanceof Queen)) {
      return false;
    }

    Queen that = (Queen) o;
    return this.x == that.x && this.y == that.x;

  }

  boolean canAttack(Queen other) {
    return this.x == other.x || this.y == other.y || Math.abs(this.x - other.x) == Math.abs(this.y - other.y);
  }

  int getX() {
    return x;
  }

  int getY() {
    return y;
  }
}
