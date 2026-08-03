class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder current = new StringBuilder();

        backtrack(0, 0, n, current, res);

        return res;
    }

    private void backtrack(int open, int close, int n,
                           StringBuilder current, List<String> res) {

        if (open == n && close == n) {
            res.add(current.toString());
            return;
        }

        if (open < n) {
            current.append('(');
            backtrack(open + 1, close, n, current, res);
            current.deleteCharAt(current.length() - 1); 
        }

        if (close < open) {
            current.append(')');
            backtrack(open, close + 1, n, current, res);
            current.deleteCharAt(current.length() - 1); 
        }
    }
}