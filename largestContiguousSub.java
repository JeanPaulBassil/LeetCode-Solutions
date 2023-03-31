import java.util.Arrays;

public class largestContiguousSub {
    public int maxSubArray(int[] nums) {
        int maxCurrent = nums[0];
        int maxGlobal = nums[0];
        int start = 0;
        int end = 0;
        int tempStart = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > maxCurrent + nums[i]) {
                maxCurrent = nums[i];
                tempStart = i;
            } else {
                maxCurrent = maxCurrent + nums[i];
            }

            if (maxCurrent > maxGlobal) {
                maxGlobal = maxCurrent;
                start = tempStart;
                end = i;
            }
        }
        System.out.println("Array: " + Arrays.toString(nums));
        System.out.print("Maximum subarray: ");
        for (int i = start; i <= end; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        return maxGlobal;
    }

    public static void main(String[] args){
        largestContiguousSub lc = new largestContiguousSub();
        System.out.println(lc.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(lc.maxSubArray(new int[]{1}));
        System.out.println(lc.maxSubArray(new int[]{5,4,-1,7,8}));
    }
}


