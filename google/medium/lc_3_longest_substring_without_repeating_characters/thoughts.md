## initial thoughts
typical case for a sliding window approach
- keep track of substring start and end
- as long as character hasnt been seen yet (use hash set):
  - keep adding to set
  - else while the character is seen, remove it and shorten the substring

tc: $O(n)$ because of the for loop \
sc: $O(n)$ due to the use of a hash set to check for seen characters

> notes: when reducing substring size &mdash; remove the character first before moving start index forward to ensure consistent results