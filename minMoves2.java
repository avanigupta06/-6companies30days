import java.util.*;

class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int i = 0, sum = 0;
        int mid = nums[(n / 2)];

        while (i < n) {
            sum += Math.abs(nums[i] - mid);
            i++;
        }
        return sum;
    }
}
// Time Complexity : O(nlogn)
// Space Complexity : O(1)