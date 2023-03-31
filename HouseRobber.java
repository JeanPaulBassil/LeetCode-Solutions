import java.util.Arrays;

public class HouseRobber {
    public int helper(int[] nums) {
        int len = nums.length;
        for(int i = 0; i < len; i++){
            if (i == 0) nums[0] = nums[i];
            else if (i == 1) nums[i] = Math.max(nums[0], nums[1]);
            else nums[i] = Math.max(nums[i - 2] + nums[i], nums[i - 1]);
        }
        return nums[len - 1];
    }
    public int rob(int[] nums) {
        int len = nums.length - 1;
        int[] firstArr = new int[len];
        int[] secondArr = new int[len];
        System.arraycopy(nums, 0, firstArr, 0, len);
        System.arraycopy(nums, 1, secondArr, 0, len);
        return Math.max(helper(firstArr), helper(secondArr));
    }



    public static void main (String[] args){
        HouseRobber hr = new HouseRobber();
        System.out.println(hr.rob(new int[]{2,7,9,3,1}));
    }
}
