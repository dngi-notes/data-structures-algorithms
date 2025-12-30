## Topological Sort (dfs)

for topological sort a directed graph is needed

### problem:
given:
- a directed graph
- represented as an adjacency list
- nodes labeled `0..n-1`

return:
- a **topological ordering** of the nodes
- OR an empty list if a cycle exists

### IMPORTANT TO MEMORIZE:
a topological order is a linear ordering of nodes such that
for every directed edge `u -> v`, `u` appears before `v`

only possible if the graph is a DAG (Directed Acyclic Graph) i.e no cycles

### Two Approaches
1. dfs (post-order + reverse)
2. **bfs (kahn's algorithm, indegree)**

### core idea
- nodes with indegree 0 (0 nodes coming into it), have no prerequisites
- they can be processed immediately