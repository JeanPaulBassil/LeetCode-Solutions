
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i - 1] > 0) nums[i] += nums[i - 1];
            max = Math.max(max, nums[i]);
        }
        return max;
    }
    public static void main(String[] args) {
        MaximumSubarray ms = new MaximumSubarray();
        System.out.println(ms.maxSubArray(new int[]{1, -2, 3, -2}));
        System.out.println(ms.maxSubArray(new int[]{5, -3, 5}));
        System.out.println(ms.maxSubArray(new int[]{-3, -2, -3}));
        System.out.println(ms.maxSubArray(new int[]{-2, -3, -1}));
        System.out.println(ms.maxSubArray(new int[]{2, -2, 2, 7, 8, 0}));

    }
}
