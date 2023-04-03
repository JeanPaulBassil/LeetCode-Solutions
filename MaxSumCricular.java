import java.util.Arrays;

public class MaxSumCricular {

    private int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i - 1] > 0) nums[i] += nums[i - 1];
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public int minSubArray(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int min = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i - 1] < 0) nums[i] += nums[i - 1];
            min = Math.min(min, nums[i]);
        }
        return min;
    }

    public int maxSubarraySumCircular(int[] nums) {
        int max = maxSubArray(nums.clone());
        int min = minSubArray(nums.clone());
        int total = Arrays.stream(nums).sum();
        return max < 0 ? max : Math.max(max, total - min);
    }

    public static void main(String[] args) {
        MaxSumCricular mx = new MaxSumCricular();
//        System.out.println(mx.maxSubarraySumCircular(new int[]{1, -2, 3, -2}));
//        System.out.println(mx.maxSubarraySumCircular(new int[]{5, -3, 5}));
        System.out.println(mx.maxSubarraySumCircular(new int[]{-3, -2, -3}));
    }
}
