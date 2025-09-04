### initial thoughts

given an array of integers `nums`, and an int `target`
return an array of all unique quadruplets such that:
- 0 <= a, b, c, d < n
- a, b, c, d are distinct
- nums at a, b, c, d, summed up should equal our `target`

### approach thoughts
- use 4 pointers:
  - one at the start (`i`)
  - one after that (`j`)
  - one after `j` (`left`)
  - one at the end of the array nums (`right`)

- using the quadruplet sum we can then add to the array if the sum equals to target
- the array might need to be sorted at the beginning to account for the use of the left, right pointers, since they need to be adjusted based on the sum (e.g. `if (sum < target) left++`)
- then if we find the correct sums, add them to a list
- finally return that list