/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                exchange(nums, count, i);
                count += 1;
            } 
        }
    }

    public void exchange(int[] nums, int count, int i) {
        int x = nums[count];
        nums[count] = nums[i];
        nums[i] = x;
    }
}
// @lc code=end

