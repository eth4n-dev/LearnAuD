// Algorithm: Floyd-Warshall
// Runtime: O(|V|^3)
// usage:
// - find shortest path between each pair of nodes (vertices)

public class FloydWarshall {

    static void floydWarshall(int[][] distances) {
        int vertices = distances.length;

        // pick "intermediate" vertex and update distances according to it
        for (int k = 0; k < vertices; k++){
            // start from vertex i
            for (int i = 0; i < vertices; i++){
                // to vertex j
                for (int j = 0; j < vertices; j++){

                    // check that distances over intermediate vertex
                    // are not infinite (to prevent overflow)
                    if (distances[i][k] != 1e8 && distances[k][j] != 1e8) {

                        // if the current i,j-distance is bigger then the distances
                        // over the intermediate vertex, then update it to
                        // the shorter path distance over the current intermediate vertex (k)
                        if (distances[i][j] > distances[i][k] + distances[k][j])
                            distances[i][j] = distances[i][k] + distances[k][j];
                    }
                }
            }
        }
    }


    public static void main(String[] args)
    {
        // infinity for the initial distances of unreachable directly vertices (no direct edges)
        int INF = (int)1e8;

        // initial array with minimum distances (just direct paths)
        // between vertices i, j (distances[i][j])
        // it will keep track of the shortest path, which will be updated in the algorithm
        int[][] distances = { { 0, 4, INF, 5, INF },
                              { INF, 0, 1, INF, 6 },
                              { 2, INF, 0, 3, INF },
                              { INF, INF, 1, 0, 2 },
                              { 1, INF, INF, 4, 0 } };

        // proceed with the algorithm
        floydWarshall(distances);

        // print the result
        for (int i = 0; i < distances.length; i++) {
            for (int j = 0; j < distances.length; j++) {
                System.out.print(distances[i][j] + " ");
            }
            System.out.println();
        }
    }
}
