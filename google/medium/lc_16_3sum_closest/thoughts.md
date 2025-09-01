## initial thoughts
like original 3 sum but we need to find number closest to `target`, not 0

sort the array like in 3 sum so we can reliably adjust the left and right pointers

the result will probably be based on this:\
closest can start off as the sum of the first three elements
then we can say if `Math.abs(tripletSum - target) < closest` update closest to the sum

then return sum :)