### initial thoughts

given a linked list `head` and an int `n`:
- remove the `n`^th node from the end

### approach thoughts
- use 2 pointers (lead, follow)
- iterate n spaces forward with lead
- then iterate with both lead and follow until lead is null
- the current pos of follow will be the node before the node we delete
- set that node's next node to the one after it. e.g `node.next = node.next.next;


return the head

```
(F)ollow - (L)ead
 0, 1, 2, 3, 4, 5
    1, 2, 3, 4, 5 null
F         ^
L                 ^
```