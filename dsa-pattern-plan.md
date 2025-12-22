# Coding Interview Pattern Checklist (Micro-Patterns)

Use this as a rapid recall checklist.
Goal: identify the pattern + invariant in under 10 seconds.

---

## BFS / DFS — Graphs & Grids

### Traversal Basics
- [ ] Maintain visited set / in-place marking
- [ ] Recursive DFS vs iterative stack
- [ ] Grid directions array (4 / 8)
- [ ] Boundary & obstacle checks

### Shortest Path (Unweighted)
- [ ] Layered BFS
- [ ] Distance array / map
- [ ] Early exit on target
- [ ] Multi-source BFS

### Connected Components
- [ ] Count components
- [ ] Flood fill
- [ ] Grid ↔ graph mapping
- [ ] Mark-and-expand

### Cycle Detection
- [ ] Visited vs visiting (3-color)
- [ ] Parent tracking (undirected)
- [ ] Back-edge detection
- [ ] Revisit active path

### Topological Sort
- [ ] In-degree array
- [ ] Queue init (0 in-degree)
- [ ] Process count == nodes
- [ ] DFS postorder topo

---

## Trees

### Traversals
- [ ] Preorder (process first)
- [ ] Inorder (BST sorted)
- [ ] Postorder (bottom-up)
- [ ] Level-order (BFS by level)

### DFS + Path State
- [ ] Carry path value
- [ ] Backtrack state
- [ ] Root-to-leaf vs any-node
- [ ] Prefix sum technique

### Lowest Common Ancestor
- [ ] Postorder returns
- [ ] Bubble-up matches
- [ ] BST value comparison
- [ ] Binary lifting (optional)

### Small Tree DP
- [ ] Return multiple values
- [ ] Include / exclude node
- [ ] Parent-child dependency
- [ ] Memo via recursion

---

## Dynamic Programming

### 1D DP
- [ ] Take vs skip
- [ ] dp[i-1], dp[i-2] dependency
- [ ] Rolling variables
- [ ] State compression

### Knapsack / Subset Sum
- [ ] Capacity dimension
- [ ] 0/1 vs unbounded
- [ ] Boolean vs numeric DP
- [ ] Reverse iteration (0/1)

### Grid DP
- [ ] Top-left dependencies
- [ ] Obstacle blocking
- [ ] Row-by-row DP
- [ ] Space optimization

### LCS / LIS / Edit Distance
- [ ] 2D table meaning
- [ ] Match vs mismatch
- [ ] Max/min of neighbors
- [ ] Optional reconstruction

---

## Sliding Window

### Window Control
- [ ] Expand right pointer
- [ ] Shrink left pointer
- [ ] Validity condition
- [ ] Update answer timing

### Variants
- [ ] Fixed-size window
- [ ] At most K
- [ ] Exactly K = atMost(K) − atMost(K−1)
- [ ] Frequency diff map

---

## Two Pointers

- [ ] Opposite ends (sorted)
- [ ] Fast / slow pointers
- [ ] Write index (in-place)
- [ ] Partition around pivot
- [ ] Skip duplicates logic

---

## Binary Search

### Classic
- [ ] Left ≤ right loop
- [ ] Mid calculation
- [ ] Boundary return logic

### Search on Answer
- [ ] Answer is search space
- [ ] Feasibility function
- [ ] Monotonic true/false
- [ ] Min true / max false

---

## Greedy

- [ ] Sort first
- [ ] Local choice definition
- [ ] Exchange argument
- [ ] Earliest finish time
- [ ] Maximize slack

### Intervals
- [ ] Merge intervals
- [ ] Interval scheduling
- [ ] Overlap detection

---

## Backtracking

- [ ] Choose
- [ ] Explore
- [ ] Unchoose
- [ ] Index-based recursion
- [ ] Start index vs reuse
- [ ] Pruning conditions
- [ ] Path vs result separation

---

## Hashing / Strings

- [ ] Frequency maps
- [ ] Set for dedupe
- [ ] Index mapping
- [ ] Sliding window + map
- [ ] Canonical representation

---

## Heap / Priority Queue

- [ ] Maintain size K
- [ ] Push then pop
- [ ] Min-heap as max
- [ ] Two-heap balancing
- [ ] Heap + greedy

---

## Trie

- [ ] Char-by-char traversal
- [ ] End-of-word flag
- [ ] Insert vs search
- [ ] Prefix validation
- [ ] DFS on trie
- [ ] Trie + backtracking

---

## Union-Find

- [ ] Parent initialization
- [ ] Path compression
- [ ] Union by rank / size
- [ ] Cycle detection
- [ ] Count components
- [ ] Offline queries

---

## Math / Bit Manipulation

- [ ] XOR cancels duplicates
- [ ] Bitmask as state
- [ ] Subset iteration
- [ ] Lowest set bit trick
- [ ] Prefix products
- [ ] Overflow awareness

---

## Final Mental Checks (Before Coding)

- [ ] What is the invariant?
- [ ] What state must be preserved?
- [ ] Can this be simplified?
- [ ] Can space be optimized?
- [ ] What breaks this approach?

---