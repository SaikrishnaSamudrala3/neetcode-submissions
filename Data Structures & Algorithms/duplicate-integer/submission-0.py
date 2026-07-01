class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        n = len(nums)
        nums.sort()
        if n < 2:
            return False

        for i in range(1, n):
            if nums[i] == nums[i-1]:
                return True

        return False





        