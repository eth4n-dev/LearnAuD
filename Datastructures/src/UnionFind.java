// Data structure: Union-Find (optimised with path compression and rank)
// Runtime (over many operations): O(α(n))
// α(n) - inverse Ackermann function, which grows extremely slow, making find and union almost constant time
// Space: O(n)

public class UnionFind {

    private int[] parent, rank;

    // Runtime: O(n)
    public UnionFind(int vertices) {
        parent = new int[vertices];
        rank = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    // Runtime: O(α(n)) amortized
    public int find(int element) {
        if (parent[element] != element) { // if the element is not its own representative
            // recursively traverse to the representative of the given element
            parent[element] = find(parent[element]);
        }
        return parent[element];
    }

    // Runtime: O(α(n)) amortized
    public void union(int element1, int element2) {
        int representative1 = find(element1);
        int representative2 = find(element2);

        // if two elements have different representatives - start unification
        if (representative1 != representative2) {
            // if the rank (of a tree) of the first representative is
            // smaller than the rank of the second one, make the representative
            // of the first to be the second one
            if (rank[representative1] < rank[representative2]) {
                parent[representative1] = representative2;
            }
            // as above but reversely
            else if (rank[representative1] > rank[representative2]) {
                parent[representative2] = representative1;
            }
            // if ranks are the same - assign one representative to another
            // (doesn't matter which) and increase the rank by one
            // for the representative of the new (resulting) tree
            else {
                parent[representative2] = representative1;
                rank[representative1]++;
            }
        }
    }

}
