class Solution{
    static String printMinNumberForPattern(String S){
        // code here
        int n = s.length();
        int[] ans = new int[n + 1];
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        HashMap<Integer, Integer> in = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                if (!adj.containsKey(i)) {
                    adj.put(i, new ArrayList<>());
                }
                adj.get(i).add(i + 1);
                
                in.put(i + 1, in.getOrDefault(i + 1, 0) + 1);
            } else {
                if (!adj.containsKey(i + 1)) {
                    adj.put(i + 1, new ArrayList<>());
                }
                adj.get(i + 1).add(i);
                
                in.put(i, in.getOrDefault(i, 0) + 1);
            }
        }
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i <= n; i++) {
            if (!in.containsKey(i) || in.get(i) == 0) {
                q.offer(i);
            }
        }
        
        int val = 1;
        while (!q.isEmpty()) {
            int curr = q.poll();
            ans[curr] = val++;
            
            if (adj.containsKey(curr)) {
                for (int child : adj.get(curr)) {
                    in.put(child, in.get(child) - 1);
                    if (in.get(child) == 0) {
                        q.offer(child);
                    }
                }
            }
        }
        
        StringBuilder answer = new StringBuilder();
        for (int t : ans) {
            answer.append((char) (t + '0'));
        }
        
        return answer.toString();
    }
}
// Time Complexity: O(n)
// Space Complexity: O(n)