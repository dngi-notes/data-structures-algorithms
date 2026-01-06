## initial thoughts

given an `int[] nums`:
- find a triplet `nums[i]`, `nums[j]`, `nums[k]` where they sum to zero but arent at the same index

## approach
- sort the array so all the lowest values are at the end
- if our first value isnt $< 1$ then we cant find a valid triplet, so we cant return an empty arraylist
- use 3 pointers:
  - one at the start to be moved by for loop
  - one directly after that (left)
  - one at the end (right)
  - adjust the pointers until we find the value