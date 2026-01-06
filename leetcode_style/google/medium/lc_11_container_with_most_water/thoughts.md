## initial thoughts

- get the maximum possible area of a container based on two heights in the array heights
- using area formula $(l \times w)$ the length will be the shortest of pair of heights we pick:
  - e.g. `Math.min(heights[left], heights[right])`
- then we can store the max height
- and adjust based on the values of our heights (heights[i]) - two pointer adjustment
