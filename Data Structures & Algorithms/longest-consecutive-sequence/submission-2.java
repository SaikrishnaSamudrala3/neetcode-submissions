class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        int longest = 1;
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int cnt = 1;
                int x = num;

                while (set.contains(x + 1)) {
                    cnt = cnt + 1;
                    x = x + 1;
                }

                longest = Math.max(cnt, longest);
            }
        }
        return longest;
    }
}
