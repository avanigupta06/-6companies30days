class Solution {
    int p = 1000000007;
public int numberOfWays(int a, int b, int k) {
    if ((a - b - k) % 2 != 0) return 0;
    if (Math.abs(a - b) > k) return 0;
    long res = 1L;
    for (int i = 0; i < (b - a + k) / 2; ++i) {
        res = res * (k - i) % p;
        res = res * inv(i + 1) % p;
    }
    return (int)res;
}

private long inv(long a) {
    if (a == 1) return 1;
    return (p - p / a) * inv(p % a) % p;
}
}
// Time Complexity: O(klogk)
// Space Complexity: O(1)