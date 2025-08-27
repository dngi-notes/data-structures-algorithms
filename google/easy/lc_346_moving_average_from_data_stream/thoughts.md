### initial thoughts
- we are told we have a sliding window
- we can store the elements in a queue and keep a running sum of their values, 
  - keep an average as well, update on every insert (whenever `next()` is called)
  - whenever `q.size() == size`, take the head value from our sum
  - e.g. `m.next(1)` = 1.00000, because 1/1 = 1
  - `m.next(10) = 5.50000, because 1 + 10 = 11 and 11/2 = 5.5