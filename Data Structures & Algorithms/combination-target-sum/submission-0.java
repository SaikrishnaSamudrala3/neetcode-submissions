class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        dfs(0, nums, target, 0, new ArrayList<>(), res);

        return res;
    }

    private void dfs(int index, int[] nums, int target, int total,
                     List<Integer> cur, List<List<Integer>> res) {

        if (total == target) {
            res.add(new ArrayList<>(cur));
            return;
        }

        if (index >= nums.length || total > target) {
            return;
        }

        cur.add(nums[index]);
        dfs(index, nums, target, total + nums[index], cur, res);

        cur.remove(cur.size() - 1);

        dfs(index + 1, nums, target, total, cur, res);
    }
}