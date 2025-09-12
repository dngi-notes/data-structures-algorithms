## initial thoughts
need to perform a range binary search to find:
- the first occurrence of the target
- the last occurrence of the he
- store both indexes in the result array

e.g. nums = `5, 7, 7, 8, 8, 10`, target = `8`

## approach
- create a helper method to search for the lower bound result given the target
- then use the helper to find two integers:
- `start` - the index first occurrence of the target
- `end` - the index of the last occurrence (the index of the first occurrence of `(target + 1) - 1`)
