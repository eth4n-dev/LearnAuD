package graph.structures;

public class Node implements Comparable<Node> {
    public int id;
    public int cost; // logic: dist for Dijkstra, weight for Prim

    public Node(int id, int cost) {
        this.id = id;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.cost, other.cost);
    }
}