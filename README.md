# General

This repository is meant as contribution to studying data structures and algorithms basics. For now all the code is made in Java.
<br /> <br />
Codes are taken from many resources and collected here. Mostly the code comes from the [geeksforgeeks.org](https://www.geeksforgeeks.org/) and [W3school](https://www.w3schools.com/). 
<br /> <br />
**Recommended further resources to study:** <br />
https://www.w3schools.com/dsa/index.php <br />
https://www.geeksforgeeks.org/dsa/dsa-tutorial-learn-data-structures-and-algorithms/ <br />
Amazing playlist about all algorithms under ~5 minutes: https://youtube.com/playlist?list=PL9xmBV_5YoZPKwb4XPB1sG7S6kNpN9JJo&si=efVetsNVzbKFsFcd <br />
Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest, and Clifford Stein - Introduction to Algorithms (book)

# Runtime tables

## Algorithms
### Search 

| Algorithm                                     | Time          |
|-----------------------------------------------|---------------|
| [Linear Search](Search/src/LinearSearch.java) | $O(n)$        |
| [Binary Search](Search/src/BinarySearch.java) | $O(\log \ n)$ |

### Sort 

| Algorithm                                         | Time                                                              | Swaps             | Memory | In-place |
|---------------------------------------------------|-------------------------------------------------------------------|-------------------|--------|----------|
| [Bubble Sort](Sorting/src/BubbleSort.java)        | $O(n^2)$                                                          | $O(n^2)$          | $O(1)$ | Yes      |
| [Selection sort](Sorting/src/SelectionSort.java)  | $O(n^2)$                                                          | $O(n)$            | $O(1)$ | Yes      |
| [Insertion Sort](Sorting/src/InsertionSort.java)  | $O(n^2)$                                                 | $O(n^2)$          | $O(1)$ | Yes      |
| [Merge Sort](Sorting/src/MergeSort.java)          | $O(n \ \log \ n)$                                                 | $O(n \ \log \ n)$ | $O(n)$ | No       |
| [Quicksort](Sorting/src/Quicksort.java)           | $O(n^2)$ - sorted input<br><br>$O(n \ log \ n)$ - rand. input     |                   | $O(1)$ | Yes      |
| [Heapsort](Sorting/src/Heapsort.java)             | $O (n \ \log \ n)$                                                |                   | $O(1)$ | Yes      |

### Dynamic Programming
$n$ - input array length

| Algorithm / Problem                                                                                                                            | Time                                | Memory                                                               |
|------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------|----------------------------------------------------------------------|
| [Maximum Subarray Sum](DynamicProgramming/src/MaximumSubarraySum.java)                                                                         | $O(n)$                              |                                                                      |
| [Fibonacci Numbers](DynamicProgramming/src/FibonacciNumbers.java)                                                                              | $O(n)$                              | $O(n)$<br><br>Optimised: <br>$O(1)$                                  |
| [Jump Game](DynamicProgramming/src/JumpGame.java)                                                                                              | $O(n)$                              |                                                                      |
| [Longest Common Subsequence](DynamicProgramming/src/LongestCommonSubsequence.java)<br>($m$ - length of string 1)<br>($n$ - length of string 2) | $O(m\cdot n)$                       |                                                                      |
| [Edit distance](DynamicProgramming/src/EditDistance.java)<br>($m$ - length of string 1)<br>($n$ - length of string 2)                          | $O(m\cdot n)$<br>                   |                                                                      |
| [Subset sum](DynamicProgramming/src/SubsetSum.java)                                                                                            | $O(n \cdot sum)$ (pseudopolynomial) | $\Theta(m\cdot n)$<br><br>Optimised: <br>$\Theta(n)$  or $\Theta(m)$ |
| [Knapsack 0-1 (2D)](DynamicProgramming/src/Knapsack2D.java)<br>($W$ - knapsack capacity)                                                       | $O(n\cdot W)$<br>                   | $O(n\cdot W)$<br><br>Optimised: <br> $O(n\cdot W/K)$                 |
| [Longest Ascending Subsequence](DynamicProgramming/src/LongestAscendingSubsequence.java)                                                       | $O(n^2)$                            |                                                                      |
| [Matrix Chain Multiplication](DynamicProgramming/src/MatrixChainMultiplication.java)                                                           | $O(n^3)$                            |                                                                      |


### Graphs
$V = n$ (number of vertices $\lvert V \rvert$) <br>
$E = m$ (number of edges $\lvert E \rvert$)

| Algorithm                                                 | Time                                                                                                                               |
|-----------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------|
| [DFS](Graphs/src/DFS.java)                                | $O(V + E)$                                                                                                                         |
| [BFS](Graphs/src/BFS.java)                                | $O(V + E)$                                                                                                                         |
| [Topological Sort](Graphs/src/TopologicalSort.java)       | $O(V + E)$                                                                                                                         |
| [Dijsktra](Graphs/src/Dijkstra.java)                      | $O((E+V)\log V)$                                                                                                                   |
| Borůvka (MST)                                             | $O(E \ \log \ V)$                                                                                                                  |
| [Kruskal (MST)](Graphs/src/Kruskal.java)                  | $O(E \ \log \ E)$ or $O(E \ \log \ V)$                                                                                             |
| Prim (MST)                                                | Binary heap: <br>$O(E \ \log \ V)$<br><br>Fibonacci heap: <br>$O(E + V \log \ V)$<br><br>Matrix: <br>$O(V^2)$                      |
| [Bellman-Ford](Graphs/src/BellmanFord.java)               | $O(V\cdot E)$                                                                                                                      |
| [Floyd-Warshall](Graphs/src/FloydWarshall.java)           | $O(V^3)$                                                                                                                           |
| Johnson                                                   | Using binary-heap Dijkstra:<br>$O(V(E+V)\log V)$                                                                                   |
| Matrix multiplication                                     | Standard:<br>$O(n^3)$<br><br>It. squaring:<br>$O(n^3 \ \log \ n)$<br><br>With Strassen:<br>$O(n^{\log_2 7})\approx O(n^{2.807})$   |

### Selection

| Algorithm         | Runtime |
|-------------------|---------|
| Median-of-medians | $O(n)$  |


## Datastructures
ADT - Abstract Data Types <br>
$n$ - length of input

### ADT List
$l$ - length

| Implementation      | $\text{insert}(k,L)$ (at end)  | $\text{get}(i,L)$ | $\text{insertAfter}(k,k',L)$ | $\text{delete}(k,L)$ |
|---------------------|--------------------------------|-------------------|------------------------------|----------------------|
| Array               | $O(1)$                         | $O(1)$            | $O(l)$                       | $O(l)$               |
| Singly Linked List  | $O(1)$<br>(w. ptr to last el.) | $O(l)$            | $O(1)$                       | $O(l)$               |
| Double Linked List  | $O(1)$                         | $O(l)$            | $O(1)$                       | $O(1)$               |

### Stacks, Queues, and Priority Queues

| ADT            | Typical Implementation                     | Opertions              | Runtime       |
|----------------|--------------------------------------------|------------------------|---------------|
| Stack (LIFO)   | Singly Linked List                         | `push`, `pop`, `top`   | $O(1)$        |
| Queue (FIFO)   | Singly Linked List <br>(with tail pointer) | `enqueue`, `dequeue`   | $O(1)$        |
| Priority Queue | (Max-)heap                                 | `insert`, `extractMax` | $O(\log \ n)$ |

### ADT Dictionary
$x$ - key, $W$ - dictionary 

| Implementation                                     | $\text{search}(x, W)$                    | $\text{insert}(x, W)$ | $\text{delete}(x, W)$ |
|----------------------------------------------------|------------------------------------------|-----------------------|-----------------------|
| Unsorted Array                                     | $O(n)$                                   | $O(1)$                | $O(n)$                |
| Sorted Array                                       | $O(\log n)$                              | $O(n)$                | $O(n)$                |
| Doubly Linked List                                 | $O(n)$                                   | $O(1)$                | $O(n)$                |
| Naive Binary Search Tree<br>($h$ - height of tree) | $O(h)$ <br>(up to $O(n)$ if unbalanced)  | $O(h)$                | $O(h)$                |
| 2-3 Tree                                           | $O(\log \ n)$                            | $O(\log \ n)$         | $O(\log \ n)$         |
| AVL Tree                                           | $O(\log \ n)$                            | $O(\log \ n)$         | $O(\log \ n)$         |

### [ADT Union-find](Datastructures/src/UnionFind.java)

| Operation   | Naive Union–Find  | Optimized Union–Find (rank + path compression)    |
|-------------|-------------------|---------------------------------------------------|
| make-set    | O(n)              | O(n)                                              |
| find / same | O(1)              | O(α(n)) amortized                                 |
| union       | O(n)              | O(α(n)) amortized                                 |
| Space       | O(n)              | O(n)                                              |
