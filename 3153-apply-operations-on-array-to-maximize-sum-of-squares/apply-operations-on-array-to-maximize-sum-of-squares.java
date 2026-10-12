
class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int MOD = 1_000_000_007;
        int[] bitCount = new int[31];

        // Step 1: Count how many numbers contain each bit
        for (int num : nums) {
            for (int bit = 0; bit < 31; bit++) {
                if ((num & (1 << bit)) != 0) {
                    bitCount[bit]++;
                }
            }
        }

        long answer = 0;

        // Step 2: Construct k maximum numbers
        for (int i = 0; i < k; i++) {
            long x = 0;

            for (int bit = 0; bit < 31; bit++) {
                if (bitCount[bit] > 0) {
                    x |= (1L << bit);
                    bitCount[bit]--;
                }
            }

            // Step 3: Add the square of this number
            answer = (answer + x * x) % MOD;
        }

        return (int) answer;
    }
}
