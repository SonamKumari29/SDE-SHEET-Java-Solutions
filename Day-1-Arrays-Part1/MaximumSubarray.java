public class MaximumSubarray {

    // Brute Force Approach (Time: O(N^3), Space: O(1))
    public static int maxSubarrayBruteForce(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    // Better Approach (Time: O(N^2), Space: O(1))
    public static int maxSubarrayBetter(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    // Optimal Approach - Kadane's Algorithm (Time: O(N), Space: O(1))
    public static int maxSubarrayOptimal(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int num : nums) {
            currentSum += num;
            maxSum = Math.max(maxSum, currentSum);
            if (currentSum < 0) currentSum = 0;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Brute Force: " + maxSubarrayBruteForce(nums));
        System.out.println("Better Approach: " + maxSubarrayBetter(nums));
        System.out.println("Optimal Approach: " + maxSubarrayOptimal(nums));
    }
}