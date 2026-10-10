
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {

        long operations = (long) k1 + k2;
        int n = nums1.length;
        int maxDiff = 0;

        int[] freq = new int[100001];

        // Step 1: Calculate absolute differences
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            freq[diff]++;
            maxDiff = Math.max(maxDiff, diff);
        }

        // Step 2: If all differences can become zero
        long totalDiff = 0;
        for (int d = 1; d <= maxDiff; d++) {
            totalDiff += (long) d * freq[d];
        }

        if (operations >= totalDiff) {
            return 0;
        }

        // Step 3: Reduce the largest differences first
        while (operations > 0 && maxDiff > 0) {

            int count = freq[maxDiff];

            if (operations >= count) {
                // Reduce all differences at this level by 1
                freq[maxDiff] = 0;
                freq[maxDiff - 1] += count;
                operations -= count;
                maxDiff--;
            } else {
                // Not enough operations for every element
                freq[maxDiff] -= (int) operations;
                freq[maxDiff - 1] += (int) operations;
                operations = 0;
            }
        }

        // Step 4: Calculate the final sum of squares
        long result = 0;

        for (int d = 1; d <= 100000; d++) {
            result += (long) d * d * freq[d];
        }

        return result;
    }
}
