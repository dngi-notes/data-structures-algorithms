## initial thoughts
- need to return a string:
  - in a zigzag pattern

- base cases: 
  - think about what happens when the string is null or empty
  - what happens when the string length is 1 **OR** `numRows` is 1

- need to process each character in the string
- create an array to hold the strings at each row
- a boolean to control direction of placements of chars
- build the return string

time complexity: O(n)
space complexity: O(n)
