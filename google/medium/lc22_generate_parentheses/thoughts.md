## initial thoughts
generate all combinations of well formed parentheses
- for every opening parenethesis we need a matching close parenthesis
- so we want the number of open parentheses to equal n && the number of closed parentheses to equal open
  - i.e. `open == closed && open == n`
- use a backtracking dfs helper to do this