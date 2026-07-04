class Solution {
    public int longestConsecutive(int[] nums) {
        int last_smaller = Integer.MIN_VALUE;
        int cnt = 0;
        int longest = 1;
        if (nums.length == 0)
            return 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 == last_smaller) {
                cnt++;
                last_smaller = nums[i];
            } else if (nums[i] != last_smaller) {
                cnt = 1;
                last_smaller = nums[i];
            }

            longest = Math.max(longest, cnt);
        }

        return longest;
    }
}
