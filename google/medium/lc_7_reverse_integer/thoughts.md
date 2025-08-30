## initial thoughts
want to reverse an integer

e.g. 10 -> 1

10 % 10 = 0
10 / 10 = 1

01 = 1

??

123

digit = extracted_num % 10 `e.g. 123 % 10 = 3`\
currRes *= 10 `0 * 10 = 0`\
currentRes += digit `0 + 3 = 3`\
**remeber to update original number `x`** `e.g. extracted /= 10`

digit = extracted_num % 10 `12 % 10 = 2`\
currentRes *= 10 `3 * 10 = 30`\
currentRes += digit `30 + 2 = 32`\
original = `12 / 10 = 1`

digit = extracted_num % 10 `1 % 10 = 1`\
currentRes *= 10 `32 * 10 = 320`
currentRes += digit `320 + 1 = 321`
original = `1 / 10 = 0`

*loop terminates here, result = 321*


