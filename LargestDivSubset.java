class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLength = 1, endIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                endIndex = i;
            }
        }

        List<Integer> result = new ArrayList<>();
        int currentLength = maxLength, currentEnd = nums[endIndex];
        for (int i = endIndex; i >= 0; i--) {
            if (currentLength > 0 && currentEnd % nums[i] == 0 && dp[i] == currentLength) {
                result.add(nums[i]);
                currentEnd = nums[i];
                currentLength--;
            }
        }

        return result;
    }
}
// Time Complexity: O(n^2)
// Space Complexity: O(n)