## initial thoughts
- we can just get the char frequency while storing each character in a queue
- then while we poll from the queue:
  - check if the character is in our map and if it's frequency is 1 we return the index of the character in the string

this works because queues are FIFO, so the first characters we encounter will come out first
and also the `String.indexOf(ch)` function will return the first occurrence of a char in a string