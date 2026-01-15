package graph.structures;

public class UnionFind {

    // Data structures for parent and rank/size
    private int[] parent;
    private int[] rank;

    public UnionFind(int n) {
        // TODO: Initialize sets (initially everyone is their own parent)
    }

    public int find(int i) {
        // TODO: Find representative of set containing i (with Path Compression)
        return -1;
    }

    public void union(int i, int j) {
        // TODO: Join two sets (Union by Rank/Size)
    }
}