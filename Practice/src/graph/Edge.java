package graph;

public class Edge implements Comparable<Edge> {
    public int from; // New field for Kruskal
    public int to;
    public int weight;

    // Constructor 1: For Adjacency Lists (Prim, Dijkstra, BFS, DFS)
    // The 'from' node is implied by the index in the list, so we don't need it here.
    public Edge(int to, int weight) {
        this.from = -1; // Placeholder
        this.to = to;
        this.weight = weight;
    }

    // Constructor 2: For Edge Lists (Kruskal)
    // We need to know both ends of the edge to connect them.
    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    // Useful for Kruskal's: Allows Collections.sort(edges) to work automatically
    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}