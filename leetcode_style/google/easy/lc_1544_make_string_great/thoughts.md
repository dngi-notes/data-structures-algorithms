### initial thoughts
- using a stack:
  - iterate over every character in s:
    - if the stack isn't empty and there is an uppercase-lowercase match pop from the stack
    - otherwise add the character to the stack
  - create a stringbuilder and use the characters in the stack to build the final string
  - return the String

tc/sc: $O(n)$