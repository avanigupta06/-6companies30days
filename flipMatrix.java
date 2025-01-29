import java.util.*;

class Solution {
    private int totalZeros;
    private int numRows, numCols;
    private Map<Integer, Integer> zeroIndices;
    private Random random;

    public Solution(int m, int n) {
        numRows = m;
        numCols = n;
        totalZeros = m * n;
        zeroIndices = new HashMap<>();
        random = new Random();
    }

    public int[] flip() {
        if (totalZeros == 0) {
            return new int[]{-1, -1}; // No more zeros to flip
        }

        int randomIndex = random.nextInt(totalZeros);
        int originalIndex = zeroIndices.getOrDefault(randomIndex, randomIndex);

        // Swap the chosen index with the last remaining zero
        int lastIndex = totalZeros - 1;
        int[] originalCoords = getCoordinates(originalIndex);
        int[] lastCoords = getCoordinates(lastIndex);

        zeroIndices.put(randomIndex, zeroIndices.getOrDefault(lastIndex, lastIndex));
        zeroIndices.put(lastIndex, originalIndex);

        totalZeros--;

        return originalCoords;
    }

    public void reset() {
        zeroIndices.clear();
        totalZeros = numRows * numCols;
    }

    private int[] getCoordinates(int index) {
        int row = index / numCols;
        int col = index % numCols;
        return new int[]{row, col};
    }
}
// Time Complexity: O(1)
// Space Complexity: O(m*n)