class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();

        backtrack(0, s, path, res);

        return res;
    }

    private void backtrack(
            int index,
            String s,
            List<String> path,
            List<List<String>> res
    ) {
        // We successfully partitioned the entire string
        if (index == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        // Try every substring starting from index
        for (int end = index; end < s.length(); end++) {

            // Continue only when s[index...end] is a palindrome
            if (isPalindrome(s, index, end)) {

                // Choose the current substring
                path.add(s.substring(index, end + 1));

                // Partition the remaining part of the string
                backtrack(end + 1, s, path, res);

                // Undo the choice
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}