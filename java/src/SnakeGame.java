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

        int size = arr.length;
        game = new boolean[size][size];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++){
                game[i][j] = arr[i][j];
            }
        }
    }

    public int[] findTailExhaustive(boolean[][] game){
        //reset counter first
        resetCounters();

        int count = 0;
        int neighborCount = 0;
        int[] tailPosition = new int[3];

        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                exhaustiveChecks++;
                if (game[i][j]){
                    count++;
                    // up
                    if((game[i - 1][j]) && (i - 1 > 0)) {
                        neighborCount++;
                    }
                    //down
                    if((game[i + 1][j]) && (i + 1 < game[i].length)) {
                        neighborCount++;
                    }
                    //left
                    if((game[i][j - 1]) && (j - 1 > 0)) {
                        neighborCount++;
                    }
                    //right
                    if((game[i][j + 1]) && (j + 1 > game[i].length)) {
                        neighborCount++;
                    }

                    if((neighborCount == 1) && ((i != headPosition[0]) && (j != headPosition[1]))) {
                        tailPosition[0] = i;
                        tailPosition[1] = j;
                        tailPosition[2] = count;
                        return tailPosition;
                    }
                }
            }
        }
        return tailPosition;
    }

    public int[] findTailRecursive(){
        resetCounters();

        return findTailRecursive(headPosition, headPosition);
    }

    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition){
        int count = 0;
        int neighborCount = 0;
        int[] tailPosition = new int[3];

        // Base Case
        // up
        if((game[currentPosition[0] - 1][currentPosition[1]]) && (currentPosition[0] - 1 > 0)) {
            neighborCount++;
        }
        //down
        if((game[currentPosition[0] + 1][currentPosition[1]]) && (currentPosition[0] + 1 < game[currentPosition[0]].length)) {
            neighborCount++;
        }
        //left
        if((game[currentPosition[0]][currentPosition[1] - 1]) && (currentPosition[1] - 1 > 0)) {
            neighborCount++;
        }
        //right
        if((game[currentPosition[0]][currentPosition[1] + 1]) && (currentPosition[1] + 1 > game[currentPosition[0]].length)) {
            neighborCount++;
        }

        if((neighborCount == 1) && ((currentPosition[0] != headPosition[0]) && (currentPosition[1] != headPosition[1]))) {
            tailPosition[0] = currentPosition[0];
            tailPosition[1] = currentPosition[1];
            tailPosition[2] = count;
            return tailPosition;
        }

        // Recursive Call

    }

    private void resetCounters(){
        exhaustiveChecks = 0;
        recursiveChecks = 0;
    }

    private static int getRecursiveChecks(){
        return recursiveChecks;
    }

    private static int getExhaustiveChecks(){
        return exhaustiveChecks;
    }
}
