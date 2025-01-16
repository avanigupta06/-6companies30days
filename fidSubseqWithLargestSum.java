import java.util.*;

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int[] ans = new int[k];
        int[] index = new int[k];
        int n = nums.length, j = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < n; i++) {
            pq.add(new int[]{nums[i], i});
            if (pq.size() > k) {
                pq.poll();
            }
        }

        HashMap<Integer, Integer> hash = new HashMap<>();
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            hash.put(temp[1], temp[0]);
            index[j++] = temp[1];
        }

        Arrays.sort(index);
        for (int i = 0; i < k; i++) {
            ans[i] = hash.get(index[i]);
        }

        return ans;
    }
}
// Time Complexity: O(nlogk)
// Space Complexity: O(k)