### approach

#### base case
- neither strings can be null, or empty
- `s` and `t` need to be the same length

#### main algorithm
- using the characters in both strings create a frequency table (using 2 arrays/hashmaps)
- compare the values in the frequency tables
  - if they are the same return true
  - else return false

#### tc/sc
- time: $O(2n)$ = $O(n)$
- space: $O(n)$
