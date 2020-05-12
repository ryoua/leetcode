/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        return solution2(height);
    }

    // 暴力枚举, O(n^2), 两次循环
    public int solution1(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                if (area > max) max = area;
            }
        }
        return max;
    }

    // O(n), 从左和右往内收缩, 此时宽度是最大的, i和j哪个高度低,
    // 就往那边的里面缩, 如果往内缩了, 高度反而变小了那么面积肯定会更小
    // 一直缩到i = j就行了
    public int solution2(int[] height) {
        int max = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            max = height[i] < height[j] ? 
                Math.max(max, (j - i) * height[i++]) : 
                Math.max(max, (j - i) * height[j--]);
        }
        return max;
    }
}

// @lc code=end

