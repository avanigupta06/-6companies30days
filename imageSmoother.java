class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] result = new int[m][n];

        int[] directions = {-1, 0, 1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                int count = 0;
                for (int x : directions) {
                    for (int y : directions) {
                        int newRow = i + x;
                        int newCol = j + y;
                        if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                            sum += img[newRow][newCol];
                            count++;
                        }
                    }
                }
                result[i][j] = sum / count;
            }
        }

        return result;
    }
}
// Time complexity : O(m*n)
// Space complexity : O(m*n)