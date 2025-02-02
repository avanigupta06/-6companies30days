class Solution {
    static int mod = (int) 1e9 + 7;
    static int[] map = new int[31];
    static {
        int[] prime = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        for (int i = 2; i <= 30; ++i) {
            if (i % 4 == 0 || i % 9 == 0 || i == 25) continue;
            int mask = 0;
            for (int j = 0; j < 10; ++j) {
                if (i % prime[j] == 0) mask |= 1 << j;
            }
            map[i] = mask;
        }
    }
    public int numberOfGoodSubsets(int[] nums) {
        int n = nums.length, one = 0;
        int[] dp = new int[1024], cnt = new int[31];
        dp[0] = 1;
        for (int i : nums) {
            if (i == 1) one++;
            else if (map[i] != 0) cnt[i]++;
        }
        for (int i = 2; i <= 30; ++i) {
            if (cnt[i] == 0) continue;
            for (int j = 0; j < 1024; ++j) {
                if ((j & map[i]) != 0) continue;
                dp[j | map[i]] = (int) ((dp[j | map[i]] + dp[j] * (long) cnt[i]) % mod); 
            }
        }
        long res = 0;
        for (int i = 1; i < 1024; ++i) res = (res + dp[i]) % mod; 
        if (one != 0) res = res * pow(one) % mod; 
        return (int) res;
    }
    private long pow(int n) {
        long res = 1, m = 2;
        while (n != 0) {
            if ((n & 1) == 1) res = (res * m) % mod;
            m = m * m % mod;
            n >>= 1;
        }
        return res;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(n)