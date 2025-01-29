import java.util.Arrays;

public class NextPermutation {

    // Brute Force Approach (Time: O(N!), Space: O(N!))
    public static void nextPermutationBruteForce(int[] nums) {
        Arrays.sort(nums); // Sort to get the first permutation
        while (true) {
            System.out.println(Arrays.toString(nums));
            if (!nextPermutationHelper(nums)) break;
        }
    }

    private static boolean nextPermutationHelper(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        if (i < 0) return false;
        int j = nums.length - 1;
        while (nums[j] <= nums[i]) j--;
        swap(nums, i, j);
        reverse(nums, i + 1, nums.length - 1);
        return true;
    }

    // Better Approach (Time: O(N log N), Space: O(N))
    public static void nextPermutationBetter(int[] nums) {
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        for (int i = 0; i < nums.length; i++) {
            if (Arrays.equals(nums, temp)) {
                nextPermutationHelper(nums);
                break;
            }
        }
    }

    // Optimal Approach (Time: O(N), Space: O(1))
    public static void nextPermutationOptimal(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        nextPermutationOptimal(nums);
        System.out.println(Arrays.toString(nums));
    }
}
