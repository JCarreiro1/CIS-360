import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        // Initialize adjacent matrices
        // Since it's impossible to set something equal to infinity, I will be using 100 when two nodes are not connected
        int[][] WDense = new int[][] {{0, 2, 7, 100},
                {1, 0, 4, 3},
                {5, 100, 0, 100},
                {3, 2, 6, 0}};

        int[][] WSparse = new int[][] {{0, 3, 2, 2},
                                       {3, 0, 100, 1},
                                       {2, 100, 0, 5},
                                       {2, 1, 5, 0}};

        int[][] WHomework = {{0, 4, 100, 100, 100, 10, 100},
                             {3, 0, 100, 18, 100, 100, 100},
                             {100, 6, 0, 100, 100, 100, 100},
                             {100, 5, 15, 0, 2, 19, 5},
                             {100, 100, 12, 1, 0, 100, 100},
                             {100, 100, 100, 100, 100, 0, 10},
                             {100, 100, 100, 8, 100, 100, 0}};

        int[][] Distance;
        int[][] P = new int[4][4];

//        Distance = WDense;
        Distance = WSparse;
//        Distance = WHomework;

        // Testing for dense, directed graph
//        System.out.println("Weights:\n" + Arrays.deepToString(WDense) + "\n");
//        floyd(WDense, Distance, P);
//        System.out.println("Shortest Distances:\n" + Arrays.deepToString(Distance) + "\n");
//        System.out.println("Highest Intermediaries:\n" + Arrays.deepToString(P) + "\n");
//        printPath(2, 1, P);

        // Testing for sparce, undirected graph
        System.out.println("Weights:\n" + Arrays.deepToString(WSparse) + "\n");
        floyd(WSparse, Distance, P);
        System.out.println("Shortest Distances:\n" + Arrays.deepToString(Distance) + "\n");
        System.out.println("Highest Intermediaries:\n" + Arrays.deepToString(P) + "\n");
        printPath(2, 3, P);

        // Testing for homework problem
//        System.out.println("Weights:\n" + Arrays.deepToString(WHomework) + "\n");
//        floyd(WHomework, Distance, P);
//        System.out.println("Shortest Distances:\n" + Arrays.deepToString(Distance) + "\n");
//        System.out.println("Highest Intermediaries:\n" + Arrays.deepToString(P) + "\n");
//        printPath(5, 0, P);
    }

    public static void floyd(int[][] W, int[][] D, int[][] P){

        for(int i = 0; i < W.length; i++)
            for (int j = 0; j < W.length; j++)
                P[i][j] = 0;

        for(int k = 0; k < W.length; k++)
            for(int i = 0; i < W.length; i++) {
                for (int j = 0; j < W.length; j++) {
                    // Checks if path using intermediary node is shorter than current shortest path
                    if (D[i][k] + D[k][j] < D[i][j]) {
                        // k + 1 is used instead of k to get the actual vertex # instead of the index
                        P[i][j] = k + 1;
                        D[i][j] = D[i][k] + D[k][j];
                    }
                }
            }
    }

    public static void printPath(int start, int end, int[][] P){
        // Checks for intermediary node
        if(P[start][end] != 0){
            // P[start][end] - 1 is used to convert from node # to index
            printPath(start, (P[start][end] - 1), P);
            System.out.print("v" + P[start][end] + " ");
            printPath((P[start][end] - 1), end, P);
        }
    }
}
