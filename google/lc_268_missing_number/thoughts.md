# LC268 - Missing Number
### initial thoughts
- we can sort our input to make sure we're in order.
- since we iterate from 0, we can just use our for loop to return
- e.g. 
- ```java
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != i) return i;
    }
  ```
- default to returning -1 if it fails (it shouldnt fail, this is just for safety)
- **time complexity**: $(O(n\space\log n))$
- **space complexity**: $O(log n)$

## Possible Optimizations
### Binary Search
- perform a binary search on a range
- find the first index where nums[i] > i
- if it's outside the bounds of our search we can still catch it
- **time complexity** $O(n\space\log n)$ 
- **space complexity** $O(n)$

### Bit manipulation
- using the XOR operator, if we xor a number by itself it should cancel out
- so if the number if the number at the index isnt equal to the index the xor will find it so we can just remove that
- e.g. 
```java
int xor = 0;
for (int i = 0; i < nums.length; i++) {
    xor ^= nums[i];
}

for (int i = 0; i <= nums.length; i++) {
    xor ^= i
}

return xor
```
- **time complexity**: $O(n)$
- **space complexity**: $O(1)$