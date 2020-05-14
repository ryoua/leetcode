import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        return solution4(n);
    }

    // 递归O(2^n), 很容易超时
    public int solution1(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    // 递归 + 备忘录O(n) + O(n)
    public int solution2(int n) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        if (n < 1)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (map.containsKey(n))
            return map.get(n);
        int sum = solution2(n - 1) + solution2(n - 2);
        map.put(n, sum);
        return sum;
    }   

    // DP,  O(n) O(n)
    public int solution3(int n) {
        if (n < 1)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
            return 2;
        int sum[] = new int [n];
        sum[0] = 1;
        sum[1] = 2;
        for (int i = 2; i < n; i++) {
            sum[i] = sum[i - 1] + sum[i - 2];
        }   
        return sum[n - 1]; 
    }

    // DP O(n), O(1)
    public int solution4(int n) {
		if (n < 1)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		int sum = 0, sum1, sum2;
		sum1 = 1;
		sum2 = 2;
		for (int i = 2; i < n; i++) {
			sum = sum1 + sum2;
			sum1 = sum2;
			sum2 = sum;
		}
		return sum;
	}
}
// @lc code=end

