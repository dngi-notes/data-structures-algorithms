### Thoughts on LC225

### approach
to use 2 queues on for pushing and the other for popping (cheap push, costly pop)

##### push
- `void push(int x)` - pushes element x to the top of the stack
- using a single queue to do that
  - need to add the element to the front of the queue every time
  - time complexity: $O(1)$

##### pop
- `int pop()` - removes the element at the top of the stack and returns it 
- using our queues:
  - using the queue with all the values, add those values to the other queue until one is remaining
  - store that polled value
  - swap the queues
  - return the value
  - time complexity: $O(n)$

##### top
- `int top()` - returns the element on top of the stack
- using our queues:
  - using the queue with all the values, add those values to the other queue until one is remaining
  - store that value
  - add it to the pop queue, because it's the new push queue so the value isnt lost
  - swap the queues
  - return the value
  - time complexity: $O(n)$

##### empty
- `boolean empty()` - returns true if the stack is empty, else false
- using our queue
  - check if `q.size() == 0`