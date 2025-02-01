class Solution {
    public static String encode(String s) {
        // code here
        StringBuilder dest = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            dest.append(s.charAt(i));

            int cnt = 1;

            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {

                cnt++;

                i++;
            }

            dest.append(cnt);
        }

        return dest.toString();
    }
}
// Time Complexity: O(n)
// Space Complexity: O(n)