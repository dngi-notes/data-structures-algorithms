## initial thoughts
find the next greatest permutation lexicographically

e.g. [1, 2, 3] &rightarrow; [1, 3, 2]

nums = [1, 1, 5]
> step 1: start index i at `nums.length - 2` i.e. index `1`\

`[1, 2, 3]`\
i =  ...^
> we dont move it because it immediately violates the condition `nums[i] >= nums[i + 1]` as 2 &lt; 3\
> now on to step 2. since i >= 0, we introduce j at `nums.length - 1`

[1, 2, 3]\
....^\
..........^

> we dont move j either since the value at i is &lt; the value at j

now we swap the values at i and j
[1, 2, 3] -> [1, 3, 2]

we reverse from i + 1 (reversing from index 2 causes no change)\
final result = `1, 3, 2`