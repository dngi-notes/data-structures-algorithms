## initial thoughts

performing a binary search on a rotated array
- the array could be in its original position
- even if it's not in the original position, it's technically still sorted

e.g. `[4, 5, 6, 7, 0, 1, 2]`, target = 0
```java
initial mid = left + (right - left) / 2 = 3 
```