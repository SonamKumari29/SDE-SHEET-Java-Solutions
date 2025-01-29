import java.util.Arrays;

public class SortColors {

    // Brute Force Approach (Time: O(N log N), Space: O(1))
    public static void sortColorsBruteForce(int[] nums) {
        Arrays.sort(nums);
    }

    // Better Approach - Counting Sort (Time: O(N), Space: O(1))
    public static void sortColorsBetter(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0;
        for (int num : nums) {
            if (num == 0) count0++;
            else if (num == 1) count1++;
            else count2++;
        }
        int index = 0;
        while (count0-- > 0) nums[index++] = 0;
        while (count1-- > 0) nums[index++] = 1;
        while (count2-- > 0) nums[index++] = 2;
    }

    // Optimal Approach - Dutch National Flag Algorithm (Time: O(N), Space: O(1))
    public static void sortColorsOptimal(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low++, mid++);
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high--);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColorsOptimal(nums);
        System.out.println(Arrays.toString(nums));
    }
}