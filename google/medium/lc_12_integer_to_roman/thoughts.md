## initial thoughts
turn an given integer to its representation in roman numerals

e.g. $3749$ -> `MMMDCCXLIX`

3700

use 2 arrays:
- one with int values
- one with corresponding roman values

keep subtracting the largest possible, while adding it to string as long as its possible