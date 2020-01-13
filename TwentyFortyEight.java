import java.lang.Math;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

enum Move {
  R, D, L, U; }


class Board {
  private int[] board = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

  public Board() {
    this.fillRandomSpot();
    this.fillRandomSpot();
    System.out.println("initialized board to: \n" + this); }

  public String toString() {
    String retVal = "";
    for (int i=0; i < this.width(); i++) {
      for (int k=0; k < this.width(); k++) {
        retVal += String.format("%2s", this.board[i*this.width()+k]) + " "; }
      if (i < this.width() - 1) {
        retVal += "\n"; } }
    return retVal; }

  public int width() {
    return (int) Math.sqrt(this.board.length); }

  // Pick a random spot that is currently 0, put a 2 (90% prob) or 4 (10% prob) in it.
  public void fillRandomSpot() {
    Integer[] indicesArray = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
    List<Integer> indicesList = Arrays.asList(indicesArray);
    Collections.shuffle(indicesList);
    for (int i=0; i < indicesArray.length; i++) {
      if (this.board[indicesList.get(i)] == 0) {
        if (Math.random() < 0.9) {
          this.board[indicesList.get(i)] = 2;
        } else {
          this.board[indicesList.get(i)] = 4; }
        break; } } }

  int[] move(Move move) {
    System.out.println("board accepted move " + move);
    // TODO: implement me
    return this.board; } }


class TwentyFortyEight {
  public static void main(String[] args) {
    Board board = new Board();
    while(true) {
      System.out.println("type x to end game; type reset to start over.");
      String move = System.console().readLine();
      if (move.equals("x") || move.equals("X")) {
        break; }
      if (move.equals("reset")) {
        board = new Board(); }
      if (move.equals("R")) {
        System.out.println(Arrays.toString(board.move(Move.R)));
      } else if (move.equals("D")) {
        System.out.println(Arrays.toString(board.move(Move.D)));
      } else if (move.equals("L")) {
        System.out.println(Arrays.toString(board.move(Move.L)));
      } else if (move.equals("U")) {
        System.out.println(Arrays.toString(board.move(Move.U)));
      } else {
        System.out.println("invalid input. enter one of R, D, L, U, or 'exit'." + move);
      } } } }


