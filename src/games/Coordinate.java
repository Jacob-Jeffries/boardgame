package games;

public class Coordinate {
  public int fileIndex;
  public int rankIndex;

  /**
   * This is the Coordinate constructor that takes in coords in a Human-Readable
   * format.
   *
   * @param aChar
   *              This parameter is the File of the board, converted to a 0-based
   *              index.
   * @param rank
   *              This parameter is the Rank of the board, converted to a 0-based
   *              index.
   */
  public Coordinate(char aChar, int rank) {
    this.fileIndex = aChar - 'a';
    this.rankIndex = rank - 1;
  }

  /**
   * This is the Coordinate constructor that takes in a 0-Based coordinate.
   *
   * @param fileIndex
   *                  0-based file index value.
   * @param rankIndex
   *                  0-based rank index value.
   */
  public Coordinate(int fileIndex, int rankIndex) {
    // Matches the closest variable - here it is the parameter.
    this.fileIndex = fileIndex;
    this.rankIndex = rankIndex;
  }

  @Override
  public boolean equals(Object other) {

    if (this.getClass() != other.getClass()) {
      return false;
    }

    Coordinate otherCoord = (Coordinate) other;
    return fileIndex == otherCoord.fileIndex && rankIndex == otherCoord.rankIndex;
  }

  @Override
  public int hashCode() {
    return fileIndex ^ (rankIndex + 13);
  }

  public int getFileIndex() {
    return fileIndex;
  }

  public int getRankIndex() {
    return rankIndex;
  }

  public char getFile() {
    return (char) (fileIndex + 97);
  }

  public int getRank() {
    return rankIndex + 1;
  }

  public String toString() {
    String file = "" + getFile();
    String rank = "" + (char) (getRank() + 48);
    return file + rank;
  }

}
