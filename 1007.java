class Solution {
  public int minDominoRotations(int[] tops, int[] bottoms) {
    int numOfDice = tops.length;

    // the value at each index represents the number of dice that have that value
    // face.
    int[] count = new int[6];

    int[] topct = new int[6];
    int[] botct = new int[6];

    for (int i = 0; i < numOfDice; i++) {
      count[tops[i] - 1]++;
      topct[tops[i] - 1]++;
      botct[bottoms[i] - 1]++;
      if (tops[i] != bottoms[i]) {
        count[bottoms[i] - 1]++;
      }
    }
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < 6; i++) {
      if (count[i] == numOfDice) {
        int topflips = numOfDice - topct[i];
        int botflips = numOfDice - botct[i];
        min = Math.min(Math.min(topflips, botflips), min);
      }
    }
    if (min == Integer.MAX_VALUE) {
      return -1;
    }
    return min;
  }
}