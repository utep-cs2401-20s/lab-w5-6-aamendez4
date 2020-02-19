public class SnakeGame {
    private boolean[][] game;
    private int[] headPosition;
    private static int exhaustiveChecks;
    private static int recursiveChecks;

    public SnakeGame() {
        game = new boolean[1][1];
    }

    public SnakeGame(boolean[][] arr, int x, int y) {
        headPosition[0] = x;
        headPosition[1] = y;
        game = new boolean[][];
    }

    public int[] findTailExhaustive(boolean[][] game){
        //reset counter first
        int count = 0;
        int neighborCount = 0;

        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                exhaustiveChecks++;
                if (game[i][j] == true){
                    count++;
                    // up
                    if((game[i - 1][j] == true) && (i - 1 > 0)) {
                        neighborCount++;
                    }
                    //down
                    if((game[i + 1][j] == true) && (i + 1 < game[i].length)) {
                        neighborCount++;
                    }
                    //left
                    if((game[i][j - 1] == true) && (j - 1 > 0)) {
                        neighborCount++;
                    }
                    //right
                    if((game[i][j + 1] == true) && (j + 1 > game[i].length)) {
                        neighborCount++;
                    }

                    if((neighborCount == 1) && ((i != headPosition[0]) && (j != headPosition[1]))) {
                        int[] tailPosition = new int[3];
                        tailPosition[1] = i;
                        tailPosition[2] = j;
                        tailPosition[3] = count;
                        return tailPosition;
                    }
                }
            }
        }
    }
}
