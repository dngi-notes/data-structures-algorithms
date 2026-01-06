## initial thoughts

convert a string into a 32 bit integer (range $[-2^{31}, 2^{31} - 1]$)
- not guaranteed to have a perfect string to convert:
  - skip whitespaces (by incrementing an index)
  - handle signs (increment index after)
  - skip leading zeroes (increment index)
  - use integer division to calculate result
  - round the result to the nearest limit if it causes overflow

