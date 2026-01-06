## initial thoughts
- dynamic programming approach
### step 1: recursion
- use a recursive helper function `isPalindrome`
- have a start index and end index
- base case: check if `start >= end` (checks for single character palindromes or if we've reached the end and it's still palindromic) **returns true**
- check if the current [start, end] is a palindrome and recursively check adjacent characters

then in main function we can do simple nested loop to get our start and end indices to check for the longest

### step 2: memoization
introduce a 2d boolean array to cache the results
- the helper should now return based on the array e.g. `return cache[start][end]`

### step 3: tabulation
iteratively handle 3 subproblems:
- palindromes of length 1
- palindromes of length 2
- palindromes of length 3+