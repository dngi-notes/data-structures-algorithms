## initial thoughts
dividing a number without using multiplication, division, or mod

## final solution approach
- use bit manipulation:
  - use xor to determine if the final result should be negative or positive (e.g. `negative = (dividend < 0) ^ (divisor < 0)`)
  - long division handling:
    - think in powers of 2:
      - find the largest power of 2 that is a multiple of the divisor &le; dividend (e.g. dividend: 10, divisor=3)
      - i.e. try 3x1, 3x2, 3x4... but in this case 3x2 is the largest: 6
  - handle overflow