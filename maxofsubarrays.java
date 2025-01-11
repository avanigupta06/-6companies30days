import java.util.*;

class Solution {
    // Function to find maximum of each subarray of size k.
    public ArrayList<Integer> max_of_subarrays(int arr[], int k) {
        // Your code here
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i <= n - k; i++) {
            // Find maximum of subarray beginning with arr[i]
            int max = arr[i];
            for (int j = 1; j < k; j++) {
                if (arr[i + j] > max) {
                    max = arr[i + j];
                }
            }
            res.add(max);
        }

        return res;
    }
}
//Time Complexity: O(n*k) 
//Space Complexity: O(n)