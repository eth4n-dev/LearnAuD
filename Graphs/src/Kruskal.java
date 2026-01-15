import java.util.Arrays;
import java.util.Comparator;

// Algorithm: Kruskal
// Runtime: O(E log E) or O(E log V)
// usage:
// - find the Minimum Spanning Tree of a graph (MST)
// - find the weight of the Minimum Spanning Tree of a graph (MST)

public class Kruskal {

    public static void main(String[] args) {

        // An edge contains: {source, destination, weight}
        int[][] edges = {
                {0, 1, 10}, {1, 3, 15}, {2, 3, 4}, {2, 0, 6}, {0, 3, 5}
        };

        System.out.println(kruskalMST(4, edges));
    }

    public static int kruskalMST(int V, int[][] edges) {
        Arrays.sort(edges, Comparator.comparingInt(e -> e[2]));

        UnionFind unionFind = new UnionFind(V);
        int cost = 0;
        int count = 0;

        for (int[] edge : edges) {
            int element1 = edge[0];
            int element2 = edge[1];
            int weight = edge[2];

            if (unionFind.find(element1) != unionFind.find(element2)) {
                unionFind.union(element1, element2);
                System.out.println("MST edge: (" + element1 + ") --wt:"+weight+"-- (" + element2 + ")");
                cost += weight;

                if (++count == V - 1)
                    break;
            }
        }
        return cost;
    }
}
