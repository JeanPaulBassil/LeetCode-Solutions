import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i])) return new int[]{map.get(target - nums[i]), i};
            else map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args){
        TwoSum ts = new TwoSum();
        int[] nums = new int[]{3, 3};
        int target = 6;
        System.out.println(Arrays.toString(ts.twoSum(nums, target)));
    }
}
